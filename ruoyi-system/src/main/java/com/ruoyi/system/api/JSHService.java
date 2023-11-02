package com.ruoyi.system.api;


import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.ruoyi.system.request.ConnectRequest;
import com.ruoyi.system.request.ConnectType;
import com.ruoyi.system.request.ExecuteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author tjq
 * @since 30/10/2023
 */
@Service
public class JSHService implements JSHApi {

    private Logger log = LoggerFactory.getLogger(JSHService.class);

    private static final Map<String, Session> ipMap = new HashMap<>();
    private static final Map<Session, String> sessionMap = new HashMap<>();

    @Override
    public Session connect(ConnectRequest request) {
        Session oldSession = ipMap.get(request.getIpAddress());
        if (null != oldSession) {
            return oldSession;
        }
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(request.getUserName(), request.getIpAddress(), request.getPort());
            if (Objects.equals(request.getConnectType(), ConnectType.PRIVATEKEY)) {
                session.setConfig("PreferredAuthentications", "publickey");
                session.setConfig("userauth.gssapi-with-mic", "no");
                session.setConfig("StrictHostKeyChecking", "no");

                URL url = new URL(request.getPrivateKey());
                File tempFile = File.createTempFile("temp", ".pem");
                Files.copy(url.openStream(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                jsch.addIdentity(tempFile.getPath());
            } else {
                session.setConfig("PreferredAuthentications", "password");
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(request.getPassword());
            }
            session.connect(request.getTimeout());
            ipMap.put(request.getIpAddress(), session);
            sessionMap.put(session, request.getIpAddress());
            return session;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public ExecuteResponse execute(Session session, String command) {
        ExecuteResponse response = new ExecuteResponse();
        int returnCode = 0;
        ChannelShell channel = null;
        PrintWriter printWriter = null;
        BufferedReader input = null;
        Vector<String> stdout = new Vector<>();
        try {
            channel = (ChannelShell) session.openChannel("shell");
            channel.connect();
            input = new BufferedReader(new InputStreamReader(channel.getInputStream()));
            printWriter = new PrintWriter(channel.getOutputStream());
            printWriter.println(command);
            printWriter.println("exit");
            printWriter.flush();
            log.info("The remote command is: ");
            String line;
            while ((line = input.readLine()) != null) {
                stdout.add(line);
                log.info(line);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response.setCode(-1);
            String msg = getMsg(stdout);
            response.setMsg(msg);
            return response;
        } finally {
            close(printWriter);
            close(input);
            if (channel != null) {
                channel.disconnect();
            }
        }
        String msg = getMsg(stdout);
        response.setCode(returnCode);
        response.setMsg(msg);
        return response;
    }

    private static String getMsg(Vector<String> stdout) {
        String msg = stdout.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            StringBuilder sb = new StringBuilder();
                            list.forEach(sb::append);
                            return sb.toString();
                        }
                ));
        return msg;
    }

    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception var2) {
            }
        }

    }

    @Override
    public void close(Session session) {
        String ip = sessionMap.get(session);
        sessionMap.remove(session);
        ipMap.remove(ip);
        if (session != null) {
            session.disconnect();
        }
    }
}

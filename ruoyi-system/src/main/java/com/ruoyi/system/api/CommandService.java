package com.ruoyi.system.api;

import org.springframework.stereotype.Service;

/**
 * @author tjq
 * @since 30/10/2023
 */
@Service
public class CommandService implements CommandApi {
    @Override
    public String stopApp(int port) {
        String command = String.format("lsof -i :%d|grep -v \"PID\"|awk '{print \"kill -9\",$2}'|sh", port);
        return command;
    }

    @Override
    public String checkIsRunningStatus(int port) {
        return String.format("fuser -n tcp %d", port);
    }
}

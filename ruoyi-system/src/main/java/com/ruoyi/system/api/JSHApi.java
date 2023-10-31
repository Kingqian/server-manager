package com.ruoyi.system.api;

import com.jcraft.jsch.Session;
import com.ruoyi.system.request.ConnectRequest;
import com.ruoyi.system.request.ExecuteResponse;


/**
 * @author tjq
 * @since 30/10/2023
 */
public interface JSHApi {

    /**
     * 创建连接
     *
     * @param request
     */
    Session connect(ConnectRequest request);


    /**
     * 执行命令
     *
     * @param command
     * @return
     */
    ExecuteResponse execute(Session session, final String command);


    /**
     * 关闭连接
     *
     * @param session
     */
    void close(Session session);



}

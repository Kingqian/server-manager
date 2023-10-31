package com.ruoyi.system.api;

/**
 * @author tjq
 * @since 30/10/2023
 */
public interface CommandApi {


    String stopApp(int port);

    String checkIsRunningStatus(int port);
}

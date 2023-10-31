package com.ruoyi.system.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tjq
 * @since 30/10/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectRequest {

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 超时时间
     */
    private Integer timeout = 15000;

    /**
     * 连接类型
     */
    private String connectType;

    /**
     * 密码
     */
    private String password;

    /**
     * 私钥地址
     */
    private String privateKey;

}

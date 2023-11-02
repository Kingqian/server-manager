package com.ruoyi.system.request;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("ip地址")
    private String ipAddress;

    /**
     * 端口
     */
    @ApiModelProperty("连接端口号")
    private Integer port = 22;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 超时时间
     */
    @ApiModelProperty("超时时间（毫秒）")
    private Integer timeout = 15000;

    /**
     * 连接类型
     */
    @ApiModelProperty("连接类型 PWD PRIVATEKEY")
    private ConnectType connectType;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 私钥地址
     */
    @ApiModelProperty("私钥地址")
    private String privateKey;

}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务器管理对象 link_server
 * 
 * @author tjq
 * @date 2023-10-31
 */
public class LinkServer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long serverId;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ip;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 端口 */
    @Excel(name = "端口")
    private Long port;

    /** 超时时间 */
    @Excel(name = "超时时间")
    private Long timeout;

    /** 公钥地址 */
    @Excel(name = "公钥地址")
    private String privateKey;

    /** 连接类型 */
    @Excel(name = "连接类型")
    private String connectType;

    /** 部署环境 */
    @Excel(name = "部署环境")
    private String deployEnv;

    public void setServerId(Long serverId) 
    {
        this.serverId = serverId;
    }

    public Long getServerId() 
    {
        return serverId;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPort(Long port) 
    {
        this.port = port;
    }

    public Long getPort() 
    {
        return port;
    }
    public void setTimeout(Long timeout) 
    {
        this.timeout = timeout;
    }

    public Long getTimeout() 
    {
        return timeout;
    }
    public void setPrivateKey(String privateKey) 
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() 
    {
        return privateKey;
    }
    public void setConnectType(String connectType) 
    {
        this.connectType = connectType;
    }

    public String getConnectType() 
    {
        return connectType;
    }
    public void setDeployEnv(String deployEnv) 
    {
        this.deployEnv = deployEnv;
    }

    public String getDeployEnv() 
    {
        return deployEnv;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("serverId", getServerId())
            .append("account", getAccount())
            .append("ip", getIp())
            .append("name", getName())
            .append("password", getPassword())
            .append("port", getPort())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("timeout", getTimeout())
            .append("privateKey", getPrivateKey())
            .append("connectType", getConnectType())
            .append("deployEnv", getDeployEnv())
            .toString();
    }
}

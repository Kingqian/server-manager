package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应用管理对象 link_app
 * 
 * @author tjq
 * @date 2023-10-31
 */
public class LinkApp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long appId;

    /** 应用名称 */
    @Excel(name = "应用名称")
    private String name;

    /** 上传目录 */
    @Excel(name = "上传目录")
    private String uploadPath;

    /** 部署路径 */
    @Excel(name = "部署路径")
    private String deployPath;

    /** 备份路径 */
    @Excel(name = "备份路径")
    private String backupPath;

    /** 应用端口 */
    @Excel(name = "应用端口")
    private Long port;

    /** 启动脚本 */
    @Excel(name = "启动脚本")
    private String startScript;

    /** 停止脚本 */
    @Excel(name = "停止脚本")
    private String stopScript;

    /** 部署脚本 */
    @Excel(name = "部署脚本")
    private String deployScript;

    public void setAppId(Long appId) 
    {
        this.appId = appId;
    }

    public Long getAppId() 
    {
        return appId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUploadPath(String uploadPath) 
    {
        this.uploadPath = uploadPath;
    }

    public String getUploadPath() 
    {
        return uploadPath;
    }
    public void setDeployPath(String deployPath) 
    {
        this.deployPath = deployPath;
    }

    public String getDeployPath() 
    {
        return deployPath;
    }
    public void setBackupPath(String backupPath) 
    {
        this.backupPath = backupPath;
    }

    public String getBackupPath() 
    {
        return backupPath;
    }
    public void setPort(Long port) 
    {
        this.port = port;
    }

    public Long getPort() 
    {
        return port;
    }
    public void setStartScript(String startScript) 
    {
        this.startScript = startScript;
    }

    public String getStartScript() 
    {
        return startScript;
    }
    public void setStopScript(String stopScript) 
    {
        this.stopScript = stopScript;
    }

    public String getStopScript() 
    {
        return stopScript;
    }
    public void setDeployScript(String deployScript) 
    {
        this.deployScript = deployScript;
    }

    public String getDeployScript() 
    {
        return deployScript;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appId", getAppId())
            .append("name", getName())
            .append("uploadPath", getUploadPath())
            .append("deployPath", getDeployPath())
            .append("backupPath", getBackupPath())
            .append("port", getPort())
            .append("startScript", getStartScript())
            .append("stopScript", getStopScript())
            .append("deployScript", getDeployScript())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

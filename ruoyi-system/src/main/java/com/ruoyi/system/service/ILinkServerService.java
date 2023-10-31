package com.ruoyi.system.service;

import com.ruoyi.system.domain.LinkServer;

import java.util.List;

/**
 * 服务器管理Service接口
 * 
 * @author tjq
 * @date 2023-10-31
 */
public interface ILinkServerService 
{
    /**
     * 查询服务器管理
     * 
     * @param serverId 服务器管理主键
     * @return 服务器管理
     */
    public LinkServer selectLinkServerByServerId(Long serverId);

    /**
     * 查询服务器管理列表
     * 
     * @param linkServer 服务器管理
     * @return 服务器管理集合
     */
    public List<LinkServer> selectLinkServerList(LinkServer linkServer);

    /**
     * 新增服务器管理
     * 
     * @param linkServer 服务器管理
     * @return 结果
     */
    public int insertLinkServer(LinkServer linkServer);

    /**
     * 修改服务器管理
     * 
     * @param linkServer 服务器管理
     * @return 结果
     */
    public int updateLinkServer(LinkServer linkServer);

    /**
     * 批量删除服务器管理
     * 
     * @param serverIds 需要删除的服务器管理主键集合
     * @return 结果
     */
    public int deleteLinkServerByServerIds(String serverIds);

    /**
     * 删除服务器管理信息
     * 
     * @param serverId 服务器管理主键
     * @return 结果
     */
    public int deleteLinkServerByServerId(Long serverId);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LinkServer;
import com.ruoyi.system.mapper.LinkServerMapper;
import com.ruoyi.system.service.ILinkServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 服务器管理Service业务层处理
 * 
 * @author tjq
 * @date 2023-10-31
 */
@Service
public class LinkServerServiceImpl implements ILinkServerService
{
    @Autowired
    private LinkServerMapper linkServerMapper;

    /**
     * 查询服务器管理
     * 
     * @param serverId 服务器管理主键
     * @return 服务器管理
     */
    @Override
    public LinkServer selectLinkServerByServerId(Long serverId)
    {
        return linkServerMapper.selectLinkServerByServerId(serverId);
    }

    /**
     * 查询服务器管理列表
     * 
     * @param linkServer 服务器管理
     * @return 服务器管理
     */
    @Override
    public List<LinkServer> selectLinkServerList(LinkServer linkServer)
    {
        return linkServerMapper.selectLinkServerList(linkServer);
    }

    /**
     * 新增服务器管理
     * 
     * @param linkServer 服务器管理
     * @return 结果
     */
    @Override
    public int insertLinkServer(LinkServer linkServer)
    {
        linkServer.setCreateTime(DateUtils.getNowDate());
        return linkServerMapper.insertLinkServer(linkServer);
    }

    /**
     * 修改服务器管理
     * 
     * @param linkServer 服务器管理
     * @return 结果
     */
    @Override
    public int updateLinkServer(LinkServer linkServer)
    {
        linkServer.setUpdateTime(DateUtils.getNowDate());
        return linkServerMapper.updateLinkServer(linkServer);
    }

    /**
     * 批量删除服务器管理
     * 
     * @param serverIds 需要删除的服务器管理主键
     * @return 结果
     */
    @Override
    public int deleteLinkServerByServerIds(String serverIds)
    {
        return linkServerMapper.deleteLinkServerByServerIds(Convert.toStrArray(serverIds));
    }

    /**
     * 删除服务器管理信息
     * 
     * @param serverId 服务器管理主键
     * @return 结果
     */
    @Override
    public int deleteLinkServerByServerId(Long serverId)
    {
        return linkServerMapper.deleteLinkServerByServerId(serverId);
    }
}

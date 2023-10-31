package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LinkApp;

/**
 * 应用管理Service接口
 * 
 * @author tjq
 * @date 2023-10-31
 */
public interface ILinkAppService 
{
    /**
     * 查询应用管理
     * 
     * @param appId 应用管理主键
     * @return 应用管理
     */
    public LinkApp selectLinkAppByAppId(Long appId);

    /**
     * 查询应用管理列表
     * 
     * @param linkApp 应用管理
     * @return 应用管理集合
     */
    public List<LinkApp> selectLinkAppList(LinkApp linkApp);

    /**
     * 新增应用管理
     * 
     * @param linkApp 应用管理
     * @return 结果
     */
    public int insertLinkApp(LinkApp linkApp);

    /**
     * 修改应用管理
     * 
     * @param linkApp 应用管理
     * @return 结果
     */
    public int updateLinkApp(LinkApp linkApp);

    /**
     * 批量删除应用管理
     * 
     * @param appIds 需要删除的应用管理主键集合
     * @return 结果
     */
    public int deleteLinkAppByAppIds(String appIds);

    /**
     * 删除应用管理信息
     * 
     * @param appId 应用管理主键
     * @return 结果
     */
    public int deleteLinkAppByAppId(Long appId);
}

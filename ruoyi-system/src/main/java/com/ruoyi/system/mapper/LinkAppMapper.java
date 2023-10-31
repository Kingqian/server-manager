package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LinkApp;

/**
 * 应用管理Mapper接口
 * 
 * @author tjq
 * @date 2023-10-31
 */
public interface LinkAppMapper 
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
     * 删除应用管理
     * 
     * @param appId 应用管理主键
     * @return 结果
     */
    public int deleteLinkAppByAppId(Long appId);

    /**
     * 批量删除应用管理
     * 
     * @param appIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLinkAppByAppIds(String[] appIds);
}

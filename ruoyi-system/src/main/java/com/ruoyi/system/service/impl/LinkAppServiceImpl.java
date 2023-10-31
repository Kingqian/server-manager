package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LinkAppMapper;
import com.ruoyi.system.domain.LinkApp;
import com.ruoyi.system.service.ILinkAppService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应用管理Service业务层处理
 * 
 * @author tjq
 * @date 2023-10-31
 */
@Service
public class LinkAppServiceImpl implements ILinkAppService 
{
    @Autowired
    private LinkAppMapper linkAppMapper;

    /**
     * 查询应用管理
     * 
     * @param appId 应用管理主键
     * @return 应用管理
     */
    @Override
    public LinkApp selectLinkAppByAppId(Long appId)
    {
        return linkAppMapper.selectLinkAppByAppId(appId);
    }

    /**
     * 查询应用管理列表
     * 
     * @param linkApp 应用管理
     * @return 应用管理
     */
    @Override
    public List<LinkApp> selectLinkAppList(LinkApp linkApp)
    {
        return linkAppMapper.selectLinkAppList(linkApp);
    }

    /**
     * 新增应用管理
     * 
     * @param linkApp 应用管理
     * @return 结果
     */
    @Override
    public int insertLinkApp(LinkApp linkApp)
    {
        linkApp.setCreateTime(DateUtils.getNowDate());
        return linkAppMapper.insertLinkApp(linkApp);
    }

    /**
     * 修改应用管理
     * 
     * @param linkApp 应用管理
     * @return 结果
     */
    @Override
    public int updateLinkApp(LinkApp linkApp)
    {
        linkApp.setUpdateTime(DateUtils.getNowDate());
        return linkAppMapper.updateLinkApp(linkApp);
    }

    /**
     * 批量删除应用管理
     * 
     * @param appIds 需要删除的应用管理主键
     * @return 结果
     */
    @Override
    public int deleteLinkAppByAppIds(String appIds)
    {
        return linkAppMapper.deleteLinkAppByAppIds(Convert.toStrArray(appIds));
    }

    /**
     * 删除应用管理信息
     * 
     * @param appId 应用管理主键
     * @return 结果
     */
    @Override
    public int deleteLinkAppByAppId(Long appId)
    {
        return linkAppMapper.deleteLinkAppByAppId(appId);
    }
}

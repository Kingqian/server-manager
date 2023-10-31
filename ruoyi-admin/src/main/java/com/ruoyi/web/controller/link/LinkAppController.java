package com.ruoyi.web.controller.link;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.LinkApp;
import com.ruoyi.system.service.ILinkAppService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应用管理Controller
 * 
 * @author tjq
 * @date 2023-10-31
 */
@Controller
@RequestMapping("/system/app")
public class LinkAppController extends BaseController
{
    private String prefix = "system/app";

    @Autowired
    private ILinkAppService linkAppService;

    @RequiresPermissions("system:app:view")
    @GetMapping()
    public String app()
    {
        return prefix + "/app";
    }

    /**
     * 查询应用管理列表
     */
    @RequiresPermissions("system:app:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LinkApp linkApp)
    {
        startPage();
        List<LinkApp> list = linkAppService.selectLinkAppList(linkApp);
        return getDataTable(list);
    }

    /**
     * 导出应用管理列表
     */
    @RequiresPermissions("system:app:export")
    @Log(title = "应用管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LinkApp linkApp)
    {
        List<LinkApp> list = linkAppService.selectLinkAppList(linkApp);
        ExcelUtil<LinkApp> util = new ExcelUtil<LinkApp>(LinkApp.class);
        return util.exportExcel(list, "应用管理数据");
    }

    /**
     * 新增应用管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存应用管理
     */
    @RequiresPermissions("system:app:add")
    @Log(title = "应用管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LinkApp linkApp)
    {
        return toAjax(linkAppService.insertLinkApp(linkApp));
    }

    /**
     * 修改应用管理
     */
    @RequiresPermissions("system:app:edit")
    @GetMapping("/edit/{appId}")
    public String edit(@PathVariable("appId") Long appId, ModelMap mmap)
    {
        LinkApp linkApp = linkAppService.selectLinkAppByAppId(appId);
        mmap.put("linkApp", linkApp);
        return prefix + "/edit";
    }

    /**
     * 修改保存应用管理
     */
    @RequiresPermissions("system:app:edit")
    @Log(title = "应用管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LinkApp linkApp)
    {
        return toAjax(linkAppService.updateLinkApp(linkApp));
    }

    /**
     * 删除应用管理
     */
    @RequiresPermissions("system:app:remove")
    @Log(title = "应用管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(linkAppService.deleteLinkAppByAppIds(ids));
    }
}

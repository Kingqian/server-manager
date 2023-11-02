package com.ruoyi.web.controller.link;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LinkServer;
import com.ruoyi.system.request.ConnectRequest;
import com.ruoyi.system.service.ILinkServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务器管理Controller
 *
 * @author tjq
 * @date 2023-10-31
 */
@Api("服务器管理")
@Controller
@RequestMapping("/system/server")
public class LinkServerController extends BaseController {
    private String prefix = "system/server";

    @Autowired
    private ILinkServerService linkServerService;


    @RequiresPermissions("system:server:view")
    @GetMapping()
    public String server() {
        return prefix + "/server";
    }

    /**
     * 查询服务器管理列表
     */
    @ApiOperation("查询服务器管理列表")
    @RequiresPermissions("system:server:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LinkServer linkServer) {
        startPage();
        List<LinkServer> list = linkServerService.selectLinkServerList(linkServer);
        return getDataTable(list);
    }

    /**
     * 导出服务器管理列表
     */
    @RequiresPermissions("system:server:export")
    @Log(title = "服务器管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LinkServer linkServer) {
        List<LinkServer> list = linkServerService.selectLinkServerList(linkServer);
        ExcelUtil<LinkServer> util = new ExcelUtil<LinkServer>(LinkServer.class);
        return util.exportExcel(list, "服务器管理数据");
    }

    /**
     * 新增服务器管理
     */
    @ApiOperation("新增服务器管理")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存服务器管理
     */
    @ApiOperation("新增保存服务器管理")
    @RequiresPermissions("system:server:add")
    @Log(title = "服务器管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LinkServer linkServer) {
        return toAjax(linkServerService.insertLinkServer(linkServer));
    }

    /**
     * 修改服务器管理
     */
    @ApiOperation("修改服务器管理")
    @RequiresPermissions("system:server:edit")
    @GetMapping("/edit/{serverId}")
    public String edit(@PathVariable("serverId") Long serverId, ModelMap mmap) {
        LinkServer linkServer = linkServerService.selectLinkServerByServerId(serverId);
        mmap.put("linkServer", linkServer);
        return prefix + "/edit";
    }

    /**
     * 修改保存服务器管理
     */
    @ApiOperation("修改保存服务器管理")
    @RequiresPermissions("system:server:edit")
    @Log(title = "服务器管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LinkServer linkServer) {
        return toAjax(linkServerService.updateLinkServer(linkServer));
    }

    /**
     * 删除服务器管理
     */
    @ApiOperation("删除服务器管理")
    @RequiresPermissions("system:server:remove")
    @Log(title = "服务器管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(linkServerService.deleteLinkServerByServerIds(ids));
    }

    /**
     * 测试服务器连接
     *
     * @param request
     * @return
     */
    @ApiOperation("测试服务器连接")
    @RequiresPermissions("system:server:connect")
    @PostMapping("/connect")
    @ResponseBody
    public AjaxResult connect(@RequestBody ConnectRequest request) {
        return toAjax(linkServerService.connect(request));
    }
}

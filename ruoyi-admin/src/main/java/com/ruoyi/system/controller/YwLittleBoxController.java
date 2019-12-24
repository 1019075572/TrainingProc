package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.system.domain.YwLittleBox;
import com.ruoyi.system.service.IYwLittleBoxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小红箱Controller
 *
 * @author linpq
 * @date 2019-11-05
 */
@Controller
@RequestMapping("/system/box")
public class YwLittleBoxController extends BaseController
{
    private String prefix = "system/box";

    @Autowired
    private IYwLittleBoxService ywLittleBoxService;

    @RequiresPermissions("system:box:view")
    @GetMapping()
    public String box()
    {
        return prefix + "/box";
    }

    /**
     * 查询小红箱列表
     */
    @RequiresPermissions("system:box:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwLittleBox ywLittleBox)
    {
        startPage();
        if (!ShiroUtils.getSysUser().isAdmin()){
            ywLittleBox.setCreateBy(ShiroUtils.getUserId());
        }
        List<YwLittleBox> list = ywLittleBoxService.selectYwLittleBoxList(ywLittleBox);
        return getDataTable(list);
    }

    /**
     * 导出小红箱列表
     */
    @RequiresPermissions("system:box:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwLittleBox ywLittleBox)
    {
        List<YwLittleBox> list = ywLittleBoxService.selectYwLittleBoxList(ywLittleBox);
        ExcelUtil<YwLittleBox> util = new ExcelUtil<YwLittleBox>(YwLittleBox.class);
        return util.exportExcel(list, "box");
    }

    /**
     * 新增小红箱
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小红箱
     */
    @RequiresPermissions("system:box:add")
    @Log(title = "小红箱", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwLittleBox ywLittleBox)
    {
        return toAjax(ywLittleBoxService.insertYwLittleBox(ywLittleBox));
    }

    /**
     * 修改小红箱
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwLittleBox ywLittleBox = ywLittleBoxService.selectYwLittleBoxById(id);
        mmap.put("ywLittleBox", ywLittleBox);
        return prefix + "/edit";
    }

    /**
     * 修改保存小红箱
     */
    @RequiresPermissions("system:box:edit")
    @Log(title = "小红箱", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwLittleBox ywLittleBox)
    {
        return toAjax(ywLittleBoxService.updateYwLittleBox(ywLittleBox));
    }

    /**
     * 删除小红箱
     */
    @RequiresPermissions("system:box:remove")
    @Log(title = "小红箱", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywLittleBoxService.deleteYwLittleBoxByIds(ids));
    }
}

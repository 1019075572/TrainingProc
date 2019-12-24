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
import com.ruoyi.system.domain.YeDaliyJob;
import com.ruoyi.system.service.IYeDaliyJobService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 日周报Controller
 *
 * @author linpq
 * @date 2019-11-05
 */
@Controller
@RequestMapping("/system/report")
public class YeDaliyJobController extends BaseController
{
    private String prefix = "system/report";

    @Autowired
    private IYeDaliyJobService yeDaliyJobService;

    @RequiresPermissions("system:report:view")
    @GetMapping()
    public String report(ModelMap mmap)
    {
        mmap.put("read",ShiroUtils.getSysUser().isAdmin());
        return prefix + "/report";
    }

    /**
     * 查询日周报列表
     */
    @RequiresPermissions("system:report:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo mylist(YeDaliyJob yeDaliyJob,ModelMap mmap)
    {
        startPage();

        if (!ShiroUtils.getSysUser().isAdmin()){
            yeDaliyJob.setCreateBy(ShiroUtils.getUserId());
        }else{
            mmap.put("read",ShiroUtils.getSysUser().isAdmin());
        }
        List<YeDaliyJob> list = yeDaliyJobService.selectYeDaliyJobList(yeDaliyJob);
        return getDataTable(list);
    }

    /**
     * 导出日周报列表
     */
    @RequiresPermissions("system:report:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YeDaliyJob yeDaliyJob)
    {
        List<YeDaliyJob> list = yeDaliyJobService.selectYeDaliyJobList(yeDaliyJob);
        ExcelUtil<YeDaliyJob> util = new ExcelUtil<YeDaliyJob>(YeDaliyJob.class);
        return util.exportExcel(list, "report");
    }

    /**
     * 新增日周报
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存日周报
     */
    @RequiresPermissions("system:report:add")
    @Log(title = "日周报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YeDaliyJob yeDaliyJob)
    {
        return toAjax(yeDaliyJobService.insertYeDaliyJob(yeDaliyJob));
    }

    /**
     * 修改日周报
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YeDaliyJob yeDaliyJob = yeDaliyJobService.selectYeDaliyJobById(id);
        mmap.put("yeDaliyJob", yeDaliyJob);
        return prefix + "/edit";
    }

    /**
     * 修改保存日周报
     */
    @RequiresPermissions("system:report:edit")
    @Log(title = "日周报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YeDaliyJob yeDaliyJob)
    {
        return toAjax(yeDaliyJobService.updateYeDaliyJob(yeDaliyJob));
    }

    /**
     * 删除日周报
     */
    @RequiresPermissions("system:report:remove")
    @Log(title = "日周报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yeDaliyJobService.deleteYeDaliyJobByIds(ids));
    }
}

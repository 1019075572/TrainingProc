package com.ruoyi.system.controller;

import java.util.Date;
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
import com.ruoyi.system.domain.DayRecords;
import com.ruoyi.system.service.IDayRecordsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 记录日报、周报、月报Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/records")
public class DayRecordsController extends BaseController
{
    private String prefix = "system/records";

    @Autowired
    private IDayRecordsService dayRecordsService;

    @RequiresPermissions("system:records:view")
    @GetMapping()
    public String records()
    {
        return prefix + "/records";
    }

    /**
     * 查询记录日报、周报、月报列表
     */
    @RequiresPermissions("system:records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayRecords dayRecords)
    {
        startPage();
        List<DayRecords> list = dayRecordsService.selectDayRecordsList(dayRecords);
        return getDataTable(list);
    }

    /**
     * 导出记录日报、周报、月报列表
     */
    @RequiresPermissions("system:records:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DayRecords dayRecords)
    {
        List<DayRecords> list = dayRecordsService.selectDayRecordsList(dayRecords);
        ExcelUtil<DayRecords> util = new ExcelUtil<DayRecords>(DayRecords.class);

        return util.exportExcel(list, "records");
    }

    /**
     * 新增记录日报、周报、月报
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存记录日报、周报、月报
     */
    @RequiresPermissions("system:records:add")
    @Log(title = "记录日报、周报、月报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DayRecords dayRecords)
    {
        dayRecords.setRecordId(ShiroUtils.getUserId());
        dayRecords.setRecordName(ShiroUtils.getSysUser().getUserName());
        return toAjax(dayRecordsService.insertDayRecords(dayRecords));
    }

    /**
     * 修改记录日报、周报、月报
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        DayRecords dayRecords = dayRecordsService.selectDayRecordsById(id);
        mmap.put("dayRecords", dayRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存记录日报、周报、月报
     */
    @RequiresPermissions("system:records:edit")
    @Log(title = "记录日报、周报、月报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DayRecords dayRecords)
    {
        return toAjax(dayRecordsService.updateDayRecords(dayRecords));
    }

    /**
     * 删除记录日报、周报、月报
     */
    @RequiresPermissions("system:records:remove")
    @Log(title = "记录日报、周报、月报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dayRecordsService.deleteDayRecordsByIds(ids));
    }
}

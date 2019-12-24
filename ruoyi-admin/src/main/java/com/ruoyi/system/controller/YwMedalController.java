package com.ruoyi.system.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.YwMedalRecord;
import com.ruoyi.system.service.IYwMedalRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.system.domain.YwMedal;
import com.ruoyi.system.service.IYwMedalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 战力称号Controller
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
@Api("战力称号")
@Controller
@RequestMapping("/system/medal")
public class YwMedalController extends BaseController
{
    private String prefix = "system/medal";

    @Autowired
    private IYwMedalService ywMedalService;

    @Autowired
    private IYwMedalRecordService ywMedalRecordService;

    @RequiresPermissions("system:medal:view")
    @GetMapping()
    public String medal()
    {
        return prefix + "/medal";
    }

    /**
     * 查询战力称号列表
     */
    @ApiOperation("获取称号列表")
    @RequiresPermissions("system:medal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwMedal ywMedal)
    {
        startPage();
        List<YwMedal> list = ywMedalService.selectYwMedalList(ywMedal);
        return getDataTable(list);
    }

    /**
     * 导出战力称号列表
     */
    @RequiresPermissions("system:medal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwMedal ywMedal)
    {
        List<YwMedal> list = ywMedalService.selectYwMedalList(ywMedal);
        ExcelUtil<YwMedal> util = new ExcelUtil<YwMedal>(YwMedal.class);
        return util.exportExcel(list, "medal");
    }

    /**
     * 新增战力称号
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存战力称号
     */
    @RequiresPermissions("system:medal:add")
    @Log(title = "战力称号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwMedal ywMedal)
    {
        return toAjax(ywMedalService.insertYwMedal(ywMedal));
    }

    /**
     * 修改战力称号
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedal ywMedal = ywMedalService.selectYwMedalById(id);
        mmap.put("ywMedal", ywMedal);
        return prefix + "/edit";
    }

    /**
     * 挑战战力称号
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedal ywMedal = ywMedalService.selectYwMedalById(id);
        YwMedalRecord ywMedalRecord = new YwMedalRecord();
        ywMedalRecord.setGuishuchenghao(id);
        mmap.put("all",  new PageInfo(ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord)).getTotal());
        ywMedalRecord.setKuo1("2");//临时魔法值 2 表示完成的
        mmap.put("finish",  new PageInfo(ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord)).getTotal());
        mmap.put("ywMedal", ywMedal);

        //查询当前称号是否已经被挑战
        ywMedalRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalRecord.setKuo1(null);
        ywMedalRecord.setGuishuchenghao(id);
        List<YwMedalRecord> ywMedalRecords = ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord);
        if(ywMedalRecords!=null && ywMedalRecords.size()!=0){
            mmap.put("status",  ywMedalRecords.get(0).getKuo1());
        }else {
            mmap.put("status",  "0");
        }

        return prefix + "/detail";
    }

    /**
     * 修改保存战力称号
     */
    @RequiresPermissions("system:medal:edit")
    @Log(title = "战力称号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwMedal ywMedal)
    {
        return toAjax(ywMedalService.updateYwMedal(ywMedal));
    }

    /**
     * 删除战力称号
     */
    @RequiresPermissions("system:medal:remove")
    @Log(title = "战力称号", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywMedalService.deleteYwMedalByIds(ids));
    }
}

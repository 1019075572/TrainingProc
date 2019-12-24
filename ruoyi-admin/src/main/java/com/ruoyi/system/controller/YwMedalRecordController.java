package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IYwMedalService;
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
import com.ruoyi.system.domain.YwMedalRecord;
import com.ruoyi.system.service.IYwMedalRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挑战称号记录Controller
 *
 * @author linpq
 * @date 2019-10-26
 */
@Controller
@RequestMapping("/system/medalRecord")
public class YwMedalRecordController extends BaseController
{
    private String prefix = "system/medalRecord";

    @Autowired
    private IYwMedalRecordService ywMedalRecordService;
    @Autowired
    private IYwMedalService ywMedalService;

    @Autowired
    private ISysUserService userService;
    @RequiresPermissions("system:medalRecord:view")
    @GetMapping()
    public String medalRecord()
    {
        return prefix + "/medalRecord";
    }

    /**
     * 查询挑战称号记录列表
     */
    @RequiresPermissions("system:medalRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwMedalRecord ywMedalRecord)
    {
        startPage();
        List<YwMedalRecord> list = ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord);
        return getDataTable(list);
    }

    /**
     * 导出挑战称号记录列表
     */
    @RequiresPermissions("system:medalRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwMedalRecord ywMedalRecord)
    {
        List<YwMedalRecord> list = ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord);
        ExcelUtil<YwMedalRecord> util = new ExcelUtil<YwMedalRecord>(YwMedalRecord.class);
        return util.exportExcel(list, "medalRecord");
    }

    /**
     * 新增挑战称号记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存挑战称号记录
     */
    @RequiresPermissions("system:medalRecord:add")
    @Log(title = "挑战称号记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwMedalRecord ywMedalRecord)
    {

        String xueneng = ywMedalService.selectYwMedalById(ywMedalRecord.getGuishuchenghao()).getDelFlag();

        SysUser sysUser = ShiroUtils.getSysUser();
        sysUser.setXueneng(String.valueOf(Integer.valueOf(sysUser.getXueneng())-Integer.valueOf(xueneng)));
        userService.updateUserInfo(sysUser);
        ywMedalRecord.setTiaozhanzhe(ShiroUtils.getUserId());

        List<YwMedalRecord> ywMedalRecords = ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord);
        if(ywMedalRecords !=null && ywMedalRecords.size()!=0){
            return error();
        }

        ywMedalRecord.setTiaozhanjindu("0");
        ywMedalRecord.setKuo1("1");
        return toAjax(ywMedalRecordService.insertYwMedalRecord(ywMedalRecord));
    }

    /**
     * 修改挑战称号记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalRecord ywMedalRecord = ywMedalRecordService.selectYwMedalRecordById(id);
        mmap.put("ywMedalRecord", ywMedalRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存挑战称号记录
     */
    @RequiresPermissions("system:medalRecord:edit")
    @Log(title = "挑战称号记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwMedalRecord ywMedalRecord)
    {
        return toAjax(ywMedalRecordService.updateYwMedalRecord(ywMedalRecord));
    }

    /**
     * 删除挑战称号记录
     */
    @RequiresPermissions("system:medalRecord:remove")
    @Log(title = "挑战称号记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywMedalRecordService.deleteYwMedalRecordByIds(ids));
    }
}

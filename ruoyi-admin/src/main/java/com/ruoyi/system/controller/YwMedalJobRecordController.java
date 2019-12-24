package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.YwMedal;
import com.ruoyi.system.domain.YwMedalRecord;
import com.ruoyi.system.service.IYwMedalJobService;
import com.ruoyi.system.service.IYwMedalRecordService;
import com.ruoyi.system.service.IYwMedalService;
import com.ruoyi.system.util.MedalUtil;
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
import com.ruoyi.system.domain.YwMedalJobRecord;
import com.ruoyi.system.service.IYwMedalJobRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 挑战称号任务记录Controller
 *
 * @author linpq
 * @date 2019-10-26
 */
@Controller
@RequestMapping("/system/medalJobRecord")
public class YwMedalJobRecordController extends BaseController
{
    private String prefix = "system/medalJobRecord";

    @Autowired
    private IYwMedalJobRecordService ywMedalJobRecordService;
    @Autowired
    private IYwMedalRecordService ywMedalRecordService;

    @Autowired
    private IYwMedalJobService ywMedalJobService;

    @Autowired
    private IYwMedalService ywMedalService;

    @RequiresPermissions("system:medalJobRecord:view")
    @GetMapping()
    public String medalJobRecord()
    {
        return prefix + "/medalJobRecord";
    }

    /**
     * 查询挑战称号任务记录列表
     */
    @RequiresPermissions("system:medalJobRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwMedalJobRecord ywMedalJobRecord)
    {
        startPage();
        List<YwMedalJobRecord> list = ywMedalJobRecordService.selectYwMedalJobRecordList(ywMedalJobRecord);
        return getDataTable(list);
    }

    /**
     * 导出挑战称号任务记录列表
     */
    @RequiresPermissions("system:medalJobRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwMedalJobRecord ywMedalJobRecord)
    {
        List<YwMedalJobRecord> list = ywMedalJobRecordService.selectYwMedalJobRecordList(ywMedalJobRecord);
        ExcelUtil<YwMedalJobRecord> util = new ExcelUtil<YwMedalJobRecord>(YwMedalJobRecord.class);
        return util.exportExcel(list, "medalJobRecord");
    }

    /**
     * 新增挑战称号任务记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存挑战称号任务记录
     */
    @RequiresPermissions("system:medalJobRecord:add")
    @Log(title = "挑战称号任务记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwMedalJobRecord ywMedalJobRecord)
    {
        return toAjax(ywMedalJobRecordService.insertYwMedalJobRecord(ywMedalJobRecord));
    }

    /**
     * 修改挑战称号任务记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalJobRecord ywMedalJobRecord = ywMedalJobRecordService.selectYwMedalJobRecordById(id);
        mmap.put("ywMedalJobRecord", ywMedalJobRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存挑战称号任务记录
     */
    @RequiresPermissions("system:medalJobRecord:edit")
    @Log(title = "挑战称号任务记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwMedalJobRecord ywMedalJobRecord)
    {
        return toAjax(ywMedalJobRecordService.updateYwMedalJobRecord(ywMedalJobRecord));
    }

    /**
     * 删除挑战称号任务记录
     */
    @RequiresPermissions("system:medalJobRecord:remove")
    @Log(title = "挑战称号任务记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywMedalJobRecordService.deleteYwMedalJobRecordByIds(ids));
    }

    /**
     * 查看完成情况
     */
    @GetMapping("/showRemark/{id}")
    public String showRemark(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord = ywMedalJobRecordService.selectYwMedalJobRecordById(id);

        mmap.put("ywMedalJobRecord", ywMedalJobRecord);
        return prefix + "/finish";
    }

    /**
     * 完成任务   任务批注
     */
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:proc:finish")
    @PostMapping("/finished")
    @ResponseBody
    public AjaxResult finished(YwMedalJobRecord ywMedalJobRecord)
    {
        ywMedalJobRecord.setKuo4(ShiroUtils.getUserId());
        ywMedalJobRecord.setUpdateBy(ShiroUtils.getUserId());


        if(MedalUtil.TONGGUO.equals(ywMedalJobRecord.getKuo2())){
            String renwubianhao = ywMedalJobRecordService.selectYwMedalJobRecordById(ywMedalJobRecord.getId()).getRenwubianhao();
            String guishuchenghao = ywMedalJobService.selectYwMedalJobById(renwubianhao).getGuishuchenghao();
            YwMedalRecord ywMedalRecord = new YwMedalRecord();
            ywMedalRecord.setTiaozhanzhe(ywMedalJobRecord.getTiaozhanzhe());
            ywMedalRecord.setGuishuchenghao(guishuchenghao);
            List<YwMedalRecord> ywMedalRecords = ywMedalRecordService.selectYwMedalRecordList(ywMedalRecord);
            YwMedalRecord ywMedalRecord1 = ywMedalRecords.get(0);
            ywMedalRecord1.setWanchengfenzhi(String.valueOf(Integer.valueOf(StringUtils.isBlank(ywMedalRecord1.getWanchengfenzhi())?"0":ywMedalRecord1.getWanchengfenzhi())+Integer.valueOf(StringUtils.isBlank(ywMedalJobRecord.getWanchengfenzhi())?"0":ywMedalJobRecord.getWanchengfenzhi())));
            YwMedal ywMedal = ywMedalService.selectYwMedalById(ywMedalRecord1.getGuishuchenghao());
            int jindu = (Integer.valueOf(ywMedalRecord1.getWanchengfenzhi()) * 100) / (Integer.valueOf(ywMedal.getFenduankaishi()));
            ywMedalRecord1.setTiaozhanjindu(String.valueOf(jindu));


            ywMedalRecordService.updateYwMedalRecord(ywMedalRecord1);



        }

        return toAjax(ywMedalJobRecordService.updateYwMedalJobRecordState(ywMedalJobRecord));
    }
}

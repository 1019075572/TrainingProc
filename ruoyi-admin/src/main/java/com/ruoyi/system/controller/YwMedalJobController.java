package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.YwMedalJobRecord;
import com.ruoyi.system.service.IYwMedalJobRecordService;
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
import com.ruoyi.system.domain.YwMedalJob;
import com.ruoyi.system.service.IYwMedalJobService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 称号任务Controller
 *
 * @author linpq
 * @date 2019-10-25
 */
@Controller
@RequestMapping("/system/job")
public class YwMedalJobController extends BaseController
{
    private String prefix = "system/job";

    @Autowired
    private IYwMedalJobService ywMedalJobService;

    @Autowired
    private IYwMedalJobRecordService ywMedalJobRecordService;

    @RequiresPermissions("system:job:view")
    @GetMapping()
    public String job()
    {
        return prefix + "/job";
    }

    @RequiresPermissions("system:job:view")
    @GetMapping("/medal/{id}")
    public String jobByMedal(@PathVariable("id") String id,ModelMap mmap)
    {
        mmap.put("guishuchenghao",id);
        mmap.put("userId",ShiroUtils.getUserId());
        return prefix + "/job";
    }

    /**
     * 查询称号任务列表
     */
    @RequiresPermissions("system:job:list")
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwMedalJob ywMedalJob)
    {
        startPage();
        List<YwMedalJob> list = ywMedalJobService.selectYwMedalJobList(ywMedalJob);
        return getDataTable(list);
    }
    /**
     * 查询称号任务列表
     */
    @RequiresPermissions("system:job:list")
    @RequestMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo listById(@PathVariable("id") String id,YwMedalJob ywMedalJob)
    {
        startPage();
        ywMedalJob.setGuishuchenghao(id);
        List<YwMedalJob> list = ywMedalJobService.selectYwMedalJobList(ywMedalJob);

        return getDataTable(list);
    }

    /**
     * 导出称号任务列表
     */
    @RequiresPermissions("system:job:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwMedalJob ywMedalJob)
    {
        List<YwMedalJob> list = ywMedalJobService.selectYwMedalJobList(ywMedalJob);
        ExcelUtil<YwMedalJob> util = new ExcelUtil<YwMedalJob>(YwMedalJob.class);
        return util.exportExcel(list, "job");
    }

    /**
     * 新增称号任务
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id,ModelMap mmap)
    {
        mmap.put("guishuchenghao",id);
        return prefix + "/add";
    }

    /**
     * 新增保存称号任务
     */
    @RequiresPermissions("system:job:add")
    @Log(title = "称号任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwMedalJob ywMedalJob)
    {
        return toAjax(ywMedalJobService.insertYwMedalJob(ywMedalJob));
    }

    /**
     * 修改称号任务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalJob ywMedalJob = ywMedalJobService.selectYwMedalJobById(id);
        mmap.put("ywMedalJob", ywMedalJob);
        return prefix + "/edit";
    }

    /**
     * 修改保存称号任务
     */
    @RequiresPermissions("system:job:edit")
    @Log(title = "称号任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwMedalJob ywMedalJob)
    {
        return toAjax(ywMedalJobService.updateYwMedalJob(ywMedalJob));
    }

    /**
     * 删除称号任务
     */
    @RequiresPermissions("system:job:remove")
    @Log(title = "称号任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywMedalJobService.deleteYwMedalJobByIds(ids));
    }




    /**
     * 领取任务
     */
    @Log(title = "任务管理", businessType = BusinessType.OTHER)
    @RequiresPermissions("system:proc:receive")
    @GetMapping("/receive/{renwubianhao}")
    @ResponseBody
    public AjaxResult receive(@PathVariable("renwubianhao") String renwubianhao)
    {

        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord.setId(IdGenerate.uuid());
        ywMedalJobRecord.setTiaozhanshijian(DateUtils.getTime());
        ywMedalJobRecord.setRenwubianhao(renwubianhao);
        ywMedalJobRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalJobRecord.setWanchengfenzhi(ywMedalJobService.selectYwMedalJobById(renwubianhao).getFenzhi());
        ywMedalJobRecord.setKuo2("1");
        ywMedalJobRecord.setXiaohaotili(ywMedalJobService.selectYwMedalJobById(renwubianhao).getXiaohaotili());
        ywMedalJobRecord.setCreateBy(ShiroUtils.getUserId());
        return toAjax(ywMedalJobRecordService.insertYwMedalJobRecord(ywMedalJobRecord));
    }


    /**
     * 完成任务
     */
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:proc:finish")
    @PostMapping("/finished")
    @ResponseBody
    public AjaxResult finished(YwMedalJobRecord ywMedalJobRecord)
    {
        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        ywMedalJobRecord.setRenwubianhao(ywMedalJobRecord.getRenwubianhao());
        ywMedalJobRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalJobRecord.setKuo2("2");
        ywMedalJobRecord.setTiaozhanshizhang(DateUtils.getTime());
        ywMedalJobRecord.setUpdateBy(ShiroUtils.getUserId());
        return toAjax(ywMedalJobRecordService.updateYwMedalJobRecordState(ywMedalJobRecord));
    }



    /**
     * 填写完成情况
     */
    @GetMapping("/finish/{renwubianhao}")
    public String finish(@PathVariable("renwubianhao") String renwubianhao, ModelMap mmap)
    {
        String userId = ShiroUtils.getUserId();
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord.setRenwubianhao(renwubianhao);
        ywMedalJobRecord.setTiaozhanzhe(userId);
        List<YwMedalJobRecord> list = ywMedalJobRecordService.selectYwMedalJobRecordList(ywMedalJobRecord);

        if(list!=null && list.size()!=0){
            ywMedalJobRecord = list.get(0);
        }
        mmap.put("ywMedalJobRecord", ywMedalJobRecord);
        return prefix + "/finish";
    }


    /**
     * 查看完成情况
     */
    @GetMapping("/showRemark/{id}")
    public String showRemark(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord.setRenwubianhao(id);
        ywMedalJobRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalJobRecord = ywMedalJobRecordService.selectYwMedalJobRecordList(ywMedalJobRecord).get(0);

        mmap.put("ywMedalJobRecord", ywMedalJobRecord);
        return prefix + "/finish";
    }
    /**
     * 查看完成情况
     */
    @GetMapping("/showRemark2/{id}")
    public String showRemark2(@PathVariable("id") String id, ModelMap mmap)
    {
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord.setRenwubianhao(id);
        ywMedalJobRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalJobRecord = ywMedalJobRecordService.selectYwMedalJobRecordList(ywMedalJobRecord).get(0);

        mmap.put("ywMedalJobRecord", ywMedalJobRecord);
        return prefix + "/finish2";
    }

    /**
     * 重做任务
     */
    @Log(title = "任务管理", businessType = BusinessType.OTHER)
    @RequiresPermissions("system:proc:repeat")
    @GetMapping("/repeat/{renwubianhao}")
    @ResponseBody
    public AjaxResult repeat(@PathVariable("renwubianhao") String renwubianhao)
    {
        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        YwMedalJobRecord ywMedalJobRecord = new YwMedalJobRecord();
        ywMedalJobRecord.setRenwubianhao(renwubianhao);
        ywMedalJobRecord.setTiaozhanzhe(ShiroUtils.getUserId());
        ywMedalJobRecord.setKuo2("1");
        ywMedalJobRecord.setWanchengfenzhi(ywMedalJobService.selectYwMedalJobById(renwubianhao).getFenzhi());
        ywMedalJobRecord.setUpdateBy(ShiroUtils.getUserId());
        return toAjax(ywMedalJobRecordService.updateYwMedalJobRecordState(ywMedalJobRecord));
    }
}

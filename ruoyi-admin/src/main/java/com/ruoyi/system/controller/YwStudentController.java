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
import com.ruoyi.system.domain.YwStudent;
import com.ruoyi.system.service.IYwStudentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员信息Controller
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
@Controller
@RequestMapping("/system/student")
public class YwStudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private IYwStudentService ywStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学员信息列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwStudent ywStudent)
    {
        startPage();
        List<YwStudent> list = ywStudentService.selectYwStudentList(ywStudent);
        return getDataTable(list);
    }

    /**
     * 导出学员信息列表
     */
    @RequiresPermissions("system:student:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwStudent ywStudent)
    {
        List<YwStudent> list = ywStudentService.selectYwStudentList(ywStudent);
        ExcelUtil<YwStudent> util = new ExcelUtil<YwStudent>(YwStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增学员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学员信息
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwStudent ywStudent)
    {
        return toAjax(ywStudentService.insertYwStudent(ywStudent));
    }

    /**
     * 修改学员信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        YwStudent ywStudent = ywStudentService.selectYwStudentById(id);
        mmap.put("ywStudent", ywStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学员信息
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwStudent ywStudent)
    {
        return toAjax(ywStudentService.updateYwStudent(ywStudent));
    }

    /**
     * 修改保存学员信息
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(YwStudent ywStudent)
    {
        YwStudent dbStu = ywStudentService.selectYwStudentById(ywStudent.getId());
        if(dbStu==null){
            ywStudentService.insertYwStudent(ywStudent);
        }
        return toAjax(ywStudentService.updateYwStudent(ywStudent));
    }

    /**
     * 删除学员信息
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywStudentService.deleteYwStudentByIds(ids));
    }
}

package com.ruoyi.system.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Calendar;
import com.ruoyi.system.service.ICalendarService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日程Controller
 *
 * @author linpq
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/system/calendar")
public class CalendarController extends BaseController
{
    private String prefix = "system/calendar";

    @Autowired
    private ICalendarService calendarService;

    @RequiresPermissions("system:calendar:view")
    @GetMapping("/list")
    public String calendar()
    {
        return prefix + "/calendar";
    }

    /**
     * 日历页面
     */
    @GetMapping(value = { "index", "" })
    public String index(Calendar myCalendar, HttpServletRequest request,
                        HttpServletResponse response, Model model) {
        return prefix + "/mycalendar";
    }

    /**
     * 查询日程列表
     */
    @RequiresPermissions("system:calendar:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Calendar calendar)
    {
        startPage();
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        return getDataTable(list);
    }

    /**
     * 导出日程列表
     */
    @RequiresPermissions("system:calendar:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Calendar calendar)
    {
        List<Calendar> list = calendarService.selectCalendarList(calendar);
        ExcelUtil<Calendar> util = new ExcelUtil<Calendar>(Calendar.class);
        return util.exportExcel(list, "calendar");
    }

    /**
     * 新增日程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存日程
     */
    @RequiresPermissions("system:calendar:add")
    @Log(title = "日程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Calendar calendar)
    {
        return toAjax(calendarService.insertCalendar(calendar));
    }

    /**
     * 修改日程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Calendar calendar = calendarService.selectCalendarById(id);
        mmap.put("calendar", calendar);
        return prefix + "/edit";
    }

    /**
     * 修改保存日程
     */
    @RequiresPermissions("system:calendar:edit")
    @Log(title = "日程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Calendar calendar)
    {
        return toAjax(calendarService.updateCalendar(calendar));
    }

    /**
     * 删除日程
     */
    @RequiresPermissions("system:calendar:remove")
    @Log(title = "日程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(calendarService.deleteCalendarByIds(ids));
    }


    @ResponseBody
    @RequestMapping(value = "findList")
    protected List<Calendar> doPost(Calendar myCalendar,
                                      HttpServletRequest request, HttpServletResponse response,
                                      Model model) throws ServletException, IOException {
        myCalendar.setUser(ShiroUtils.getSysUser());
        List<Calendar> list = calendarService.selectCalendarList(myCalendar);

        return list;
    }


    /**
     * 编辑日历
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "save")
    public AjaxResult save(Calendar myCalendar, HttpServletRequest request,
                         HttpServletResponse response, Model model) throws Exception {
        return toAjax(calendarService.updateCalendar(myCalendar));
    }

    /**
     * 删除日历
     */
    @ResponseBody
    @RequestMapping(value = "del")
    public AjaxResult del(Calendar myCalendar,
                        RedirectAttributes redirectAttributes) {
        return toAjax(calendarService.deleteCalendarById(myCalendar.getId()));

    }
}

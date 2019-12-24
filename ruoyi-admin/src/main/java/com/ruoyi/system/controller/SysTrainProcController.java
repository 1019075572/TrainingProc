package com.ruoyi.system.controller;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysFinishProc;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysTrainProc;
import com.ruoyi.system.service.ISysFinishProcService;
import com.ruoyi.system.service.ISysTrainProcService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 攻略信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/proc")
public class SysTrainProcController extends BaseController
{
    private String prefix = "system/proc";

    @Autowired
    private ISysTrainProcService procService;
    @Autowired
    private ISysFinishProcService sysFinishProcService;

    @RequiresPermissions("system:proc:view")
    @GetMapping()
    public String proc()
    {
        return prefix + "/proc";
    }

    @RequiresPermissions("system:proc:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysTrainProc> list(SysTrainProc proc)
    {
        String userId = ShiroUtils.getUserId();
        List<SysTrainProc> procList = procService.selectMenuList(proc, userId);
        return procList;
    }

    /**
     * 删除攻略a
     */
    @Log(title = "攻略管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:proc:remove")
    @GetMapping("/remove/{procId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("procId") String procId)
    {
        if (procService.selectCountMenuByParentId(procId) > 0)
        {
            return AjaxResult.warn("存在子攻略,不允许删除");
        }
        if (procService.selectCountRoleMenuByMenuId(procId) > 0)
        {
            return AjaxResult.warn("攻略已分配,不允许删除");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(procService.deleteMenuById(procId));
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
    {
        SysTrainProc proc = null;
        if (!"0".equals( parentId))
        {
            proc = procService.selectMenuById(parentId);
        }
        else
        {
            proc = new SysTrainProc();
            proc.setMenuId("0");
            proc.setMenuName("主目录");
        }
        mmap.put("proc", proc);
        return prefix + "/add";
    }

    /**
     * 新增保存攻略
     */
    @Log(title = "攻略管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:proc:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysTrainProc proc)
    {
        if (UserConstants.MENU_NAME_NOT_UNIQUE.equals(procService.checkMenuNameUnique(proc)))
        {
            return error("新增攻略'" + proc.getMenuName() + "'失败，攻略名称已存在");
        }
        proc.setCreateBy(ShiroUtils.getLoginName());
        proc.setMenuId(IdGenerate.uuid());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(procService.insertMenu(proc));
    }

    /**
     * 修改攻略
     */
    @GetMapping("/edit/{procId}")
    public String edit(@PathVariable("procId") String procId, ModelMap mmap)
    {
        mmap.put("proc", procService.selectMenuById(procId));
        return prefix + "/edit";
    }

    /**
     * 修改保存攻略
     */
    @Log(title = "攻略管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:proc:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysTrainProc proc)
    {
        if (UserConstants.MENU_NAME_NOT_UNIQUE.equals(procService.checkMenuNameUnique(proc)))
        {
            return error("修改攻略'" + proc.getMenuName() + "'失败，攻略名称已存在");
        }
        proc.setUpdateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(procService.updateMenu(proc));
    }

    /**
     * 选择攻略图标
     */
    @GetMapping("/icon")
    public String icon()
    {
        return prefix + "/icon";
    }

    /**
     * 校验攻略名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysTrainProc proc)
    {
        return procService.checkMenuNameUnique(proc);
    }

    /**
     * 加载角色攻略列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(SysRole role)
    {
        String userId = ShiroUtils.getUserId();
        List<Ztree> ztrees = procService.roleMenuTreeData(role, userId);
        return ztrees;
    }

    /**
     * 加载所有攻略列表树
     */
    @GetMapping("/procTreeData")
    @ResponseBody
    public List<Ztree> procTreeData()
    {
        String userId = ShiroUtils.getUserId();
        List<Ztree> ztrees = procService.menuTreeData(userId);
        return ztrees;
    }

    /**
     * 选择攻略树
     */
    @GetMapping("/selectMenuTree/{procId}")
    public String selectMenuTree(@PathVariable("procId") String procId, ModelMap mmap)
    {
        SysTrainProc sysTrainProc = procService.selectMenuById(procId);
        mmap.put("proc", sysTrainProc==null?new SysTrainProc():sysTrainProc);
        return prefix + "/tree";
    }


    /**
     * 领取攻略
     */
    @Log(title = "攻略管理", businessType = BusinessType.OTHER)
    @RequiresPermissions("system:proc:receive")
    @GetMapping("/receive/{procId}")
    @ResponseBody
    public AjaxResult receive(@PathVariable("procId") String procId)
    {

        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setId(IdGenerate.uuid());
        sysFinishProc.setProcId(procId);
        sysFinishProc.setUserId(ShiroUtils.getUserId());
        sysFinishProc.setScore(procService.selectMenuById(procId).getEx2());
        sysFinishProc.setFinishState("1");
        sysFinishProc.setEx1(procService.selectMenuById(procId).getPerms());
        sysFinishProc.setCreateBy(ShiroUtils.getUserId());
        return toAjax(sysFinishProcService.insertSysFinishProc(sysFinishProc));
    }


    /**
     * 完成攻略
     */
    @Log(title = "攻略管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:proc:finish")
    @PostMapping("/finished")
    @ResponseBody
    public AjaxResult finished(SysFinishProc sysFinishProc)
    {
        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        sysFinishProc.setProcId(sysFinishProc.getProcId());
        sysFinishProc.setUserId(ShiroUtils.getUserId());
        sysFinishProc.setFinishState("2");
        sysFinishProc.setEx1(procService.selectMenuById(sysFinishProc.getProcId()).getPerms());
        sysFinishProc.setUpdateBy(ShiroUtils.getUserId());
        return toAjax(sysFinishProcService.updateSysFinishProcState(sysFinishProc));
    }



    /**
     * 填写完成情况
     */
    @GetMapping("/finish/{procId}")
    public String finish(@PathVariable("procId") String procId, ModelMap mmap)
    {
        String userId = ShiroUtils.getUserId();
        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setProcId(procId);
        sysFinishProc.setUserId(userId);
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcList(sysFinishProc);

        if(list!=null && list.size()!=0){
            sysFinishProc = list.get(0);
        }
        mmap.put("sysFinishProc", sysFinishProc);
        return prefix + "/finish";
    }


    /**
     * 查看完成情况
     */
    @GetMapping("/showRemark/{id}")
    public String showRemark(@PathVariable("id") String id, ModelMap mmap)
    {
        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setId(id);
        sysFinishProc = sysFinishProcService.selectSysFinishProcById(id);

        mmap.put("sysFinishProc", sysFinishProc);
        return prefix + "/finish";
    }

    /**
     * 重做攻略
     */
    @Log(title = "攻略管理", businessType = BusinessType.OTHER)
    @RequiresPermissions("system:proc:repeat")
    @GetMapping("/repeat/{procId}")
    @ResponseBody
    public AjaxResult repeat(@PathVariable("procId") String procId)
    {
        //不规范代码演示，这部分本该写在service中的哦 ，并且 setFinishState("1") 属于硬编码，魔法值。应该设置常量类记录哦。
        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setProcId(procId);
        sysFinishProc.setUserId(ShiroUtils.getUserId());
        sysFinishProc.setFinishState("1");
        sysFinishProc.setEx1(procService.selectMenuById(procId).getPerms());
        sysFinishProc.setUpdateBy(ShiroUtils.getUserId());
        return toAjax(sysFinishProcService.updateSysFinishProcState(sysFinishProc));
    }
}

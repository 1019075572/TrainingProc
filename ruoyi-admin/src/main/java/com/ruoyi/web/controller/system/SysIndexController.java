package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.ResourcesConfig;
import com.ruoyi.system.domain.SysFinishProc;
import com.ruoyi.system.service.ISysFinishProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysFinishProcService sysFinishProcService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {

        if(SysUser.isAdmin(ShiroUtils.getUserId())){

            List list =  new ArrayList<>();
            for (int i = 0; i < 10 ; i++) {
                Map m = new HashMap<String,Object>();
                m.put("name", "张三"+i);
                m.put("age", "张1三"+i);
                m.put("test", "张2三"+i);
                m.put("test1", "张3三"+i);
                list.add(m);
            }





            mmap.put("list", list);
            mmap.put("xxx", "555555");
            mmap.put("hyjy", "666");
            return "main_v1";
        }

        SysFinishProc sysFinishProc = new SysFinishProc();
        sysFinishProc.setUserId(ShiroUtils.getUserId());
        List<SysFinishProc> list = sysFinishProcService.selectSysFinishProcListSectionScore(sysFinishProc);

        mmap.put("hyjy", 0);
        mmap.put("xmjy", 0);
        mmap.put("jsnl", 0);
        mmap.put("zxnl", 0);
        mmap.put("zhnl", 0);
        mmap.put("zysy", 0);


        for (SysFinishProc obj :list) {
            mmap.put(obj.getEx1(), StringUtils.isBlank(obj.getScore())?0:obj.getScore());
        }

        List<SysFinishProc> list2 = sysFinishProcService.selectSysFinishProcListTotalScore(sysFinishProc);
        List<SysFinishProc> list3 = sysFinishProcService.selectSysFinishProcListAfterMe(sysFinishProc);

        mmap.put("userName", ShiroUtils.getSysUser().getUserName());

        if(list2!=null && list2.size()!=0){
            mmap.put("score", list2.get(0).getScore());
            mmap.put("avatar", list2.get(0).getAvatar());
        }else{
            mmap.put("avatar", "小白不配有头像");
        }


        mmap.put("count", list3.size());
        return "main";
    }
}

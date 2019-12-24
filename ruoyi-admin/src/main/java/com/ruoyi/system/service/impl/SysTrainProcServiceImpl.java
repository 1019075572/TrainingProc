package com.ruoyi.system.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysTrainProc;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysTrainProcMapper;
import com.ruoyi.system.mapper.SysRoleMenuMapper;
import com.ruoyi.system.service.ISysTrainProcService;

/**
 * 菜单 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysTrainProcServiceImpl implements ISysTrainProcService
{
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Autowired
    private SysTrainProcMapper sysTrainProcMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    /**
     * 根据用户查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    @Override
    public List<SysTrainProc> selectMenusByUser(SysUser user)
    {
        List<SysTrainProc> menus = new LinkedList<SysTrainProc>();
        // 管理员显示所有菜单信息
        if (user.isAdmin())
        {
            menus = sysTrainProcMapper.selectMenuNormalAll();
        }
        else
        {
            menus = sysTrainProcMapper.selectMenusByUserId(user.getUserId());
        }
        return getChildPerms(menus, "0");
    }

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    @Override
    public List<SysTrainProc> selectMenuList(SysTrainProc menu, String userId)
    {
        List<SysTrainProc> menuList = null;
        if (SysUser.isAdmin(userId))
        {
            menuList = sysTrainProcMapper.selectMenuList(menu);
        }
        else
        {
            menu.getParams().put("userId", userId);
            menu.setVisible("0");
            menuList = sysTrainProcMapper.selectMenuListByUserId(menu);
        }
        return menuList;
    }

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    @Override
    public List<SysTrainProc> selectMenuAll(String userId)
    {
        List<SysTrainProc> menuList = null;
        if (SysUser.isAdmin(userId))
        {
            menuList = sysTrainProcMapper.selectMenuAll();
        }
        else
        {
            menuList = sysTrainProcMapper.selectMenuAllByUserId(userId);
        }
        return menuList;
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectPermsByUserId(String userId)
    {
        List<String> perms = sysTrainProcMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (StringUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    @Override
    public List<Ztree> roleMenuTreeData(SysRole role, String userId)
    {
        String roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysTrainProc> menuList = selectMenuAll(userId);
        if (StringUtils.isNotNull(roleId))
        {
            List<String> roleMenuList = sysTrainProcMapper.selectMenuTree(roleId);
            ztrees = initZtree(menuList, roleMenuList, true);
        }
        else
        {
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    /**
     * 查询所有菜单
     *
     * @return 菜单列表
     */
    @Override
    public List<Ztree> menuTreeData(String userId)
    {
        List<SysTrainProc> menuList = selectMenuAll(userId);
        List<Ztree> ztrees = initZtree(menuList);
        return ztrees;
    }

    /**
     * 查询系统所有权限
     *
     * @return 权限列表
     */
    @Override
    public LinkedHashMap<String, String> selectPermsAll(String userId)
    {
        LinkedHashMap<String, String> section = new LinkedHashMap<>();
        List<SysTrainProc> permissions = selectMenuAll(userId);
        if (StringUtils.isNotEmpty(permissions))
        {
            for (SysTrainProc menu : permissions)
            {
                section.put(menu.getUrl(), MessageFormat.format(PREMISSION_STRING, menu.getPerms()));
            }
        }
        return section;
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysTrainProc> menuList)
    {
        return initZtree(menuList, null, false);
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @param roleMenuList 角色已存在菜单列表
     * @param permsFlag 是否需要显示权限标识
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysTrainProc> menuList, List<String> roleMenuList, boolean permsFlag)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (SysTrainProc menu : menuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getMenuId());
            ztree.setpId(menu.getParentId());
            ztree.setName(transMenuName(menu, permsFlag));
            ztree.setTitle(menu.getMenuName());
            if (isCheck)
            {
                ztree.setChecked(roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }

    public String transMenuName(SysTrainProc menu, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag)
        {
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>");
        }
        return sb.toString();
    }

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    @Override
    public int deleteMenuById(String menuId)
    {
        return sysTrainProcMapper.deleteMenuById(menuId);
    }

    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    @Override
    public SysTrainProc selectMenuById(String menuId)
    {
        return sysTrainProcMapper.selectMenuById(menuId);
    }

    /**
     * 查询子菜单数量
     *
     * @param parentId 父级菜单ID
     * @return 结果
     */
    @Override
    public int selectCountMenuByParentId(String parentId)
    {
        return sysTrainProcMapper.selectCountMenuByParentId(parentId);
    }

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    @Override
    public int selectCountRoleMenuByMenuId(String menuId)
    {
        return roleMenuMapper.selectCountRoleMenuByMenuId(menuId);
    }

    /**
     * 新增保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    @Override
    public int insertMenu(SysTrainProc menu)
    {
        return sysTrainProcMapper.insertMenu(menu);
    }

    /**
     * 修改保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    @Override
    public int updateMenu(SysTrainProc menu)
    {
        return sysTrainProcMapper.updateMenu(menu);
    }

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    @Override
    public String checkMenuNameUnique(SysTrainProc menu)
    {
        String menuId = StringUtils.isNull(menu.getMenuId()) ? "-1" : menu.getMenuId();
        SysTrainProc info = sysTrainProcMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());
        if (StringUtils.isNotNull(info) && !info.getMenuId().equals( menuId))
        {
            return UserConstants.MENU_NAME_NOT_UNIQUE;
        }
        return UserConstants.MENU_NAME_UNIQUE;
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SysTrainProc> getChildPerms(List<SysTrainProc> list, String parentId)
    {
        List<SysTrainProc> returnList = new ArrayList<SysTrainProc>();
        for (Iterator<SysTrainProc> iterator = list.iterator(); iterator.hasNext();)
        {
            SysTrainProc t = (SysTrainProc) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId().equals( parentId))
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysTrainProc> list, SysTrainProc t)
    {
        // 得到子节点列表
        List<SysTrainProc> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysTrainProc tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysTrainProc> it = childList.iterator();
                while (it.hasNext())
                {
                    SysTrainProc n = (SysTrainProc) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysTrainProc> getChildList(List<SysTrainProc> list, SysTrainProc t)
    {
        List<SysTrainProc> tlist = new ArrayList<SysTrainProc>();
        Iterator<SysTrainProc> it = list.iterator();
        while (it.hasNext())
        {
            SysTrainProc n = (SysTrainProc) it.next();
            if (n.getParentId().equals( t.getMenuId()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysTrainProc> list, SysTrainProc t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}

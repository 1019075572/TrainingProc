package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysTrainProc;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;

/**
 * 菜单 业务层
 *
 * @author ruoyi
 */
public interface ISysTrainProcService
{
    /**
     * 根据用户ID查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenusByUser(SysUser user);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuList(SysTrainProc menu, String userId);

    /**
     * 查询菜单集合
     *
     * @param userId 用户ID
     * @return 所有菜单信息
     */
    public List<SysTrainProc> selectMenuAll(String userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(String userId);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<Ztree> roleMenuTreeData(SysRole role, String userId);

    /**
     * 查询所有菜单信息
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<Ztree> menuTreeData(String userId);

    /**
     * 查询系统所有权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Map<String, String> selectPermsAll(String userId);

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(String menuId);

    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysTrainProc selectMenuById(String menuId);

    /**
     * 查询菜单数量
     *
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(String parentId);

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    public int selectCountRoleMenuByMenuId(String menuId);

    /**
     * 新增保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysTrainProc menu);

    /**
     * 修改保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysTrainProc menu);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public String checkMenuNameUnique(SysTrainProc menu);
}

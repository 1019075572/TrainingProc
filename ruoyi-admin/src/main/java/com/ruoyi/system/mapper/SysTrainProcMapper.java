package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysTrainProc;
import com.ruoyi.system.domain.SysTrainProc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 实训流程Mapper接口
 *
 * @author ruoyi
 * @date 2019-10-08
 */
public interface SysTrainProcMapper
{
    /**
     * 查询系统所有菜单（含按钮）
     *
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuAll();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuAllByUserId(String userId);

    /**
     * 查询系统正常显示菜单（不含按钮）
     *
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuNormalAll();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenusByUserId(String userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(String userId);

    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(String roleId);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuList(SysTrainProc menu);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysTrainProc> selectMenuListByUserId(SysTrainProc menu);

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
     * 新增菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysTrainProc menu);

    /**
     * 修改菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysTrainProc menu);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysTrainProc checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") String parentId);
}

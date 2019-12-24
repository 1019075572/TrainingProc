package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysFinishProc;
import java.util.List;

/**
 * 完成情况Mapper接口
 *
 * @author 林鹏群
 * @date 2019-10-09
 */
public interface SysFinishProcMapper
{
    /**
     * 查询完成情况
     *
     * @param id 完成情况ID
     * @return 完成情况
     */
    public SysFinishProc selectSysFinishProcById(String id);

    /**
     * 查询完成情况列表
     *
     * @param sysFinishProc 完成情况
     * @return 完成情况集合
     */
    public List<SysFinishProc> selectSysFinishProcList(SysFinishProc sysFinishProc);

    /**
     * 查询完成总分情况列表
     *
     * @param
     * @return 完成情况集合
     */
    public List<SysFinishProc> selectSysFinishProcTotalScore(SysFinishProc sysFinishProc);
    public List<SysFinishProc> selectSysFinishProcListSectionScore(SysFinishProc sysFinishProc);
    public List<SysFinishProc> selectSysFinishProcListCard(SysFinishProc sysFinishProc);
    public List<SysFinishProc> selectSysFinishProcListAfterMe(SysFinishProc sysFinishProc);

    /**
     * 新增完成情况
     *
     * @param sysFinishProc 完成情况
     * @return 结果
     */
    public int insertSysFinishProc(SysFinishProc sysFinishProc);

    /**
     * 修改完成情况
     *
     * @param sysFinishProc 完成情况
     * @return 结果
     */
    public int updateSysFinishProc(SysFinishProc sysFinishProc);
    public int updateSysFinishProcState(SysFinishProc sysFinishProc);

    /**
     * 删除完成情况
     *
     * @param id 完成情况ID
     * @return 结果
     */
    public int deleteSysFinishProcById(String id);

    /**
     * 批量删除完成情况
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFinishProcByIds(String[] ids);
}

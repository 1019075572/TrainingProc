package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFinishProcMapper;
import com.ruoyi.system.domain.SysFinishProc;
import com.ruoyi.system.service.ISysFinishProcService;
import com.ruoyi.common.core.text.Convert;

/**
 * 完成情况Service业务层处理
 *
 * @author 林鹏群
 * @date 2019-10-09
 */
@Service
public class SysFinishProcServiceImpl implements ISysFinishProcService
{
    @Autowired
    private SysFinishProcMapper sysFinishProcMapper;

    /**
     * 查询完成情况
     *
     * @param id 完成情况ID
     * @return 完成情况
     */
    @Override
    public SysFinishProc selectSysFinishProcById(String id)
    {
        return sysFinishProcMapper.selectSysFinishProcById(id);
    }

    /**
     * 查询完成情况列表
     *
     * @param sysFinishProc 完成情况
     * @return 完成情况
     */
    @Override
    public List<SysFinishProc> selectSysFinishProcList(SysFinishProc sysFinishProc)
    {
        return sysFinishProcMapper.selectSysFinishProcList(sysFinishProc);
    }

    /**
     * 查询完成总分情况列表
     *
     * @param sysFinishProc 完成情况
     * @return 完成情况
     */
    @Override
    public List<SysFinishProc> selectSysFinishProcListTotalScore(SysFinishProc sysFinishProc)
    {
        return sysFinishProcMapper.selectSysFinishProcTotalScore(sysFinishProc);
    }
    /**
     * 查询完成各类情况列表
     *
     * @param sysFinishProc 完成情况
     * @return 完成情况
     */
    @Override
    public List<SysFinishProc> selectSysFinishProcListSectionScore(SysFinishProc sysFinishProc)
    {
        return sysFinishProcMapper.selectSysFinishProcListSectionScore(sysFinishProc);
    }

    /**
     * 查询完成各类情况列表
     *
     * @param sysFinishProc 完成情况
     * @return 完成情况
     */
    @Override
    public List<SysFinishProc> selectSysFinishProcListCard(SysFinishProc sysFinishProc)
    {
        return sysFinishProcMapper.selectSysFinishProcListCard(sysFinishProc);
    }

    @Override
    public List<SysFinishProc> selectSysFinishProcListAfterMe(SysFinishProc sysFinishProc)
    {
        return sysFinishProcMapper.selectSysFinishProcListAfterMe(sysFinishProc);
    }

    /**
     * 新增完成情况
     *
     * @param sysFinishProc 完成情况
     * @return 结果
     */
    @Override
    public int insertSysFinishProc(SysFinishProc sysFinishProc)
    {
        sysFinishProc.setCreateTime(DateUtils.getNowDate());
        return sysFinishProcMapper.insertSysFinishProc(sysFinishProc);
    }

    /**
     * 修改完成情况
     *
     * @param sysFinishProc 完成情况
     * @return 结果
     */
    @Override
    public int updateSysFinishProc(SysFinishProc sysFinishProc)
    {
        sysFinishProc.setUpdateTime(DateUtils.getNowDate());
        return sysFinishProcMapper.updateSysFinishProc(sysFinishProc);
    }
    @Override
    public int updateSysFinishProcState(SysFinishProc sysFinishProc)
    {
        sysFinishProc.setUpdateTime(DateUtils.getNowDate());
        return sysFinishProcMapper.updateSysFinishProcState(sysFinishProc);
    }

    /**
     * 删除完成情况对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysFinishProcByIds(String ids)
    {
        return sysFinishProcMapper.deleteSysFinishProcByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除完成情况信息
     *
     * @param id 完成情况ID
     * @return 结果
     */
    @Override
    public int deleteSysFinishProcById(String id)
    {
        return sysFinishProcMapper.deleteSysFinishProcById(id);
    }
}

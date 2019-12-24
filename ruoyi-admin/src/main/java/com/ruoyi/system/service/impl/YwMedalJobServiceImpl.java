package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwMedalJobMapper;
import com.ruoyi.system.domain.YwMedalJob;
import com.ruoyi.system.service.IYwMedalJobService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 称号任务Service业务层处理
 *
 * @author linpq
 * @date 2019-10-25
 */
@Service
public class YwMedalJobServiceImpl implements IYwMedalJobService
{
    @Autowired
    private YwMedalJobMapper ywMedalJobMapper;

    /**
     * 查询称号任务
     *
     * @param id 称号任务ID
     * @return 称号任务
     */
    @Override
    public YwMedalJob selectYwMedalJobById(String id)
    {
        return ywMedalJobMapper.selectYwMedalJobById(id);
    }

    /**
     * 查询称号任务列表
     *
     * @param ywMedalJob 称号任务
     * @return 称号任务
     */
    @Override
    public List<YwMedalJob> selectYwMedalJobList(YwMedalJob ywMedalJob)
    {
        return ywMedalJobMapper.selectYwMedalJobList(ywMedalJob);
    }

    /**
     * 新增称号任务
     *
     * @param ywMedalJob 称号任务
     * @return 结果
     */
    @Override
    public int insertYwMedalJob(YwMedalJob ywMedalJob)
    {
        ywMedalJob.setCreateTime(DateUtils.getNowDate());
        ywMedalJob.setId(IdGenerate.uuid());
        return ywMedalJobMapper.insertYwMedalJob(ywMedalJob);
    }

    /**
     * 修改称号任务
     *
     * @param ywMedalJob 称号任务
     * @return 结果
     */
    @Override
    public int updateYwMedalJob(YwMedalJob ywMedalJob)
    {
        ywMedalJob.setUpdateTime(DateUtils.getNowDate());
        return ywMedalJobMapper.updateYwMedalJob(ywMedalJob);
    }

    /**
     * 删除称号任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalJobByIds(String ids)
    {
        return ywMedalJobMapper.deleteYwMedalJobByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除称号任务信息
     *
     * @param id 称号任务ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalJobById(String id)
    {
        return ywMedalJobMapper.deleteYwMedalJobById(id);
    }
}

package com.ruoyi.system.service;

import com.ruoyi.system.domain.YwMedalJob;
import java.util.List;

/**
 * 称号任务Service接口
 * 
 * @author linpq
 * @date 2019-10-25
 */
public interface IYwMedalJobService 
{
    /**
     * 查询称号任务
     * 
     * @param id 称号任务ID
     * @return 称号任务
     */
    public YwMedalJob selectYwMedalJobById(String id);

    /**
     * 查询称号任务列表
     * 
     * @param ywMedalJob 称号任务
     * @return 称号任务集合
     */
    public List<YwMedalJob> selectYwMedalJobList(YwMedalJob ywMedalJob);

    /**
     * 新增称号任务
     * 
     * @param ywMedalJob 称号任务
     * @return 结果
     */
    public int insertYwMedalJob(YwMedalJob ywMedalJob);

    /**
     * 修改称号任务
     * 
     * @param ywMedalJob 称号任务
     * @return 结果
     */
    public int updateYwMedalJob(YwMedalJob ywMedalJob);

    /**
     * 批量删除称号任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwMedalJobByIds(String ids);

    /**
     * 删除称号任务信息
     * 
     * @param id 称号任务ID
     * @return 结果
     */
    public int deleteYwMedalJobById(String id);
}

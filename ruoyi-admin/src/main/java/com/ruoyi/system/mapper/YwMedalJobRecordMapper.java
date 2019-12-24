package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.YwMedalJobRecord;
import java.util.List;

/**
 * 挑战称号任务记录Mapper接口
 *
 * @author linpq
 * @date 2019-10-26
 */
public interface YwMedalJobRecordMapper
{
    /**
     * 查询挑战称号任务记录
     *
     * @param id 挑战称号任务记录ID
     * @return 挑战称号任务记录
     */
    public YwMedalJobRecord selectYwMedalJobRecordById(String id);

    /**
     * 查询挑战称号任务记录列表
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 挑战称号任务记录集合
     */
    public List<YwMedalJobRecord> selectYwMedalJobRecordList(YwMedalJobRecord ywMedalJobRecord);

    /**
     * 新增挑战称号任务记录
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 结果
     */
    public int insertYwMedalJobRecord(YwMedalJobRecord ywMedalJobRecord);

    /**
     * 修改挑战称号任务记录
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 结果
     */
    public int updateYwMedalJobRecord(YwMedalJobRecord ywMedalJobRecord);
    public int updateYwMedalJobRecordState(YwMedalJobRecord ywMedalJobRecord);

    /**
     * 删除挑战称号任务记录
     *
     * @param id 挑战称号任务记录ID
     * @return 结果
     */
    public int deleteYwMedalJobRecordById(String id);

    /**
     * 批量删除挑战称号任务记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwMedalJobRecordByIds(String[] ids);
}

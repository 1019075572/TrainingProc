package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwMedalJobRecordMapper;
import com.ruoyi.system.domain.YwMedalJobRecord;
import com.ruoyi.system.service.IYwMedalJobRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 挑战称号任务记录Service业务层处理
 *
 * @author linpq
 * @date 2019-10-26
 */
@Service
public class YwMedalJobRecordServiceImpl implements IYwMedalJobRecordService
{
    @Autowired
    private YwMedalJobRecordMapper ywMedalJobRecordMapper;

    /**
     * 查询挑战称号任务记录
     *
     * @param id 挑战称号任务记录ID
     * @return 挑战称号任务记录
     */
    @Override
    public YwMedalJobRecord selectYwMedalJobRecordById(String id)
    {
        return ywMedalJobRecordMapper.selectYwMedalJobRecordById(id);
    }

    /**
     * 查询挑战称号任务记录列表
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 挑战称号任务记录
     */
    @Override
    public List<YwMedalJobRecord> selectYwMedalJobRecordList(YwMedalJobRecord ywMedalJobRecord)
    {
        return ywMedalJobRecordMapper.selectYwMedalJobRecordList(ywMedalJobRecord);
    }

    /**
     * 新增挑战称号任务记录
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 结果
     */
    @Override
    public int insertYwMedalJobRecord(YwMedalJobRecord ywMedalJobRecord)
    {
        ywMedalJobRecord.setCreateTime(DateUtils.getNowDate());
        ywMedalJobRecord.setId(IdGenerate.uuid());
        return ywMedalJobRecordMapper.insertYwMedalJobRecord(ywMedalJobRecord);
    }

    /**
     * 修改挑战称号任务记录
     *
     * @param ywMedalJobRecord 挑战称号任务记录
     * @return 结果
     */
    @Override
    public int updateYwMedalJobRecord(YwMedalJobRecord ywMedalJobRecord)
    {
        ywMedalJobRecord.setUpdateTime(DateUtils.getNowDate());
        return ywMedalJobRecordMapper.updateYwMedalJobRecord(ywMedalJobRecord);
    }
    @Override
    public int updateYwMedalJobRecordState(YwMedalJobRecord ywMedalJobRecord)
    {
        ywMedalJobRecord.setUpdateTime(DateUtils.getNowDate());
        return ywMedalJobRecordMapper.updateYwMedalJobRecordState(ywMedalJobRecord);
    }

    /**
     * 删除挑战称号任务记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalJobRecordByIds(String ids)
    {
        return ywMedalJobRecordMapper.deleteYwMedalJobRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除挑战称号任务记录信息
     *
     * @param id 挑战称号任务记录ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalJobRecordById(String id)
    {
        return ywMedalJobRecordMapper.deleteYwMedalJobRecordById(id);
    }
}

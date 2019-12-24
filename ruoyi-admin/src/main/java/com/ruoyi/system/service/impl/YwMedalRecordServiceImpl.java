package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwMedalRecordMapper;
import com.ruoyi.system.domain.YwMedalRecord;
import com.ruoyi.system.service.IYwMedalRecordService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 挑战称号记录Service业务层处理
 *
 * @author linpq
 * @date 2019-10-26
 */
@Service
public class YwMedalRecordServiceImpl implements IYwMedalRecordService
{
    @Autowired
    private YwMedalRecordMapper ywMedalRecordMapper;

    /**
     * 查询挑战称号记录
     *
     * @param id 挑战称号记录ID
     * @return 挑战称号记录
     */
    @Override
    public YwMedalRecord selectYwMedalRecordById(String id)
    {
        return ywMedalRecordMapper.selectYwMedalRecordById(id);
    }

    /**
     * 查询挑战称号记录列表
     *
     * @param ywMedalRecord 挑战称号记录
     * @return 挑战称号记录
     */
    @Override
    public List<YwMedalRecord> selectYwMedalRecordList(YwMedalRecord ywMedalRecord)
    {
        return ywMedalRecordMapper.selectYwMedalRecordList(ywMedalRecord);
    }

    /**
     * 新增挑战称号记录
     *
     * @param ywMedalRecord 挑战称号记录
     * @return 结果
     */
    @Override
    public int insertYwMedalRecord(YwMedalRecord ywMedalRecord)
    {
        ywMedalRecord.setCreateTime(DateUtils.getNowDate());
        ywMedalRecord.setId(IdGenerate.uuid());
        return ywMedalRecordMapper.insertYwMedalRecord(ywMedalRecord);
    }

    /**
     * 修改挑战称号记录
     *
     * @param ywMedalRecord 挑战称号记录
     * @return 结果
     */
    @Override
    public int updateYwMedalRecord(YwMedalRecord ywMedalRecord)
    {
        ywMedalRecord.setUpdateTime(DateUtils.getNowDate());
        return ywMedalRecordMapper.updateYwMedalRecord(ywMedalRecord);
    }

    /**
     * 删除挑战称号记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalRecordByIds(String ids)
    {
        return ywMedalRecordMapper.deleteYwMedalRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除挑战称号记录信息
     *
     * @param id 挑战称号记录ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalRecordById(String id)
    {
        return ywMedalRecordMapper.deleteYwMedalRecordById(id);
    }
}

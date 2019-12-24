package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DayRecordsMapper;
import com.ruoyi.system.domain.DayRecords;
import com.ruoyi.system.service.IDayRecordsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 记录日报、周报、月报Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class DayRecordsServiceImpl implements IDayRecordsService 
{
    @Autowired
    private DayRecordsMapper dayRecordsMapper;

    /**
     * 查询记录日报、周报、月报
     * 
     * @param id 记录日报、周报、月报ID
     * @return 记录日报、周报、月报
     */
    @Override
    public DayRecords selectDayRecordsById(String id)
    {
        return dayRecordsMapper.selectDayRecordsById(id);
    }

    /**
     * 查询记录日报、周报、月报列表
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 记录日报、周报、月报
     */
    @Override
    public List<DayRecords> selectDayRecordsList(DayRecords dayRecords)
    {
        return dayRecordsMapper.selectDayRecordsList(dayRecords);
    }

    /**
     * 新增记录日报、周报、月报
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 结果
     */
    @Override
    public int insertDayRecords(DayRecords dayRecords)
    {
        Date date=new Date();
        dayRecords.setAddTime(date);
        dayRecords.setIsdelete(0);
        dayRecords.setUpdateTime(date);
        dayRecords.setId(DateUtils.parseDateToStr("yyyyMMddHHmmssSSS",date)+"0000"+String.valueOf((int)((Math.random()*9+1)*1000)));
        return dayRecordsMapper.insertDayRecords(dayRecords);
    }

    /**
     * 修改记录日报、周报、月报
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 结果
     */
    @Override
    public int updateDayRecords(DayRecords dayRecords)
    {
        return dayRecordsMapper.updateDayRecords(dayRecords);
    }

    /**
     * 删除记录日报、周报、月报对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDayRecordsByIds(String ids)
    {
        return dayRecordsMapper.deleteDayRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除记录日报、周报、月报信息
     * 
     * @param id 记录日报、周报、月报ID
     * @return 结果
     */
    @Override
    public int deleteDayRecordsById(String id)
    {
        return dayRecordsMapper.deleteDayRecordsById(id);
    }
}

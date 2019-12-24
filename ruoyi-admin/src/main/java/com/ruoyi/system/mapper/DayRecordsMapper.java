package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.DayRecords;
import java.util.List;

/**
 * 记录日报、周报、月报Mapper接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface DayRecordsMapper 
{
    /**
     * 查询记录日报、周报、月报
     * 
     * @param id 记录日报、周报、月报ID
     * @return 记录日报、周报、月报
     */
    public DayRecords selectDayRecordsById(String id);

    /**
     * 查询记录日报、周报、月报列表
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 记录日报、周报、月报集合
     */
    public List<DayRecords> selectDayRecordsList(DayRecords dayRecords);

    /**
     * 新增记录日报、周报、月报
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 结果
     */
    public int insertDayRecords(DayRecords dayRecords);

    /**
     * 修改记录日报、周报、月报
     * 
     * @param dayRecords 记录日报、周报、月报
     * @return 结果
     */
    public int updateDayRecords(DayRecords dayRecords);

    /**
     * 删除记录日报、周报、月报
     * 
     * @param id 记录日报、周报、月报ID
     * @return 结果
     */
    public int deleteDayRecordsById(String id);

    /**
     * 批量删除记录日报、周报、月报
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDayRecordsByIds(String[] ids);
}

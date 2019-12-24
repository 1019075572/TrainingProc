package com.ruoyi.system.service;

import com.ruoyi.system.domain.Calendar;
import java.util.List;

/**
 * 日程Service接口
 * 
 * @author linpq
 * @date 2019-11-12
 */
public interface ICalendarService 
{
    /**
     * 查询日程
     * 
     * @param id 日程ID
     * @return 日程
     */
    public Calendar selectCalendarById(String id);

    /**
     * 查询日程列表
     * 
     * @param calendar 日程
     * @return 日程集合
     */
    public List<Calendar> selectCalendarList(Calendar calendar);

    /**
     * 新增日程
     * 
     * @param calendar 日程
     * @return 结果
     */
    public int insertCalendar(Calendar calendar);

    /**
     * 修改日程
     * 
     * @param calendar 日程
     * @return 结果
     */
    public int updateCalendar(Calendar calendar);

    /**
     * 批量删除日程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCalendarByIds(String ids);

    /**
     * 删除日程信息
     * 
     * @param id 日程ID
     * @return 结果
     */
    public int deleteCalendarById(String id);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CalendarMapper;
import com.ruoyi.system.domain.Calendar;
import com.ruoyi.system.service.ICalendarService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 日程Service业务层处理
 *
 * @author linpq
 * @date 2019-11-12
 */
@Service
public class CalendarServiceImpl implements ICalendarService
{
    @Autowired
    private CalendarMapper calendarMapper;

    /**
     * 查询日程
     *
     * @param id 日程ID
     * @return 日程
     */
    @Override
    public Calendar selectCalendarById(String id)
    {
        return calendarMapper.selectCalendarById(id);
    }

    /**
     * 查询日程列表
     *
     * @param calendar 日程
     * @return 日程
     */
    @Override
    public List<Calendar> selectCalendarList(Calendar calendar)
    {
        return calendarMapper.selectCalendarList(calendar);
    }

    /**
     * 新增日程
     *
     * @param calendar 日程
     * @return 结果
     */
    @Override
    public int insertCalendar(Calendar calendar)
    {
        calendar.setId(IdGenerate.uuid());
        return calendarMapper.insertCalendar(calendar);
    }

    /**
     * 修改日程
     *
     * @param calendar 日程
     * @return 结果
     */
    @Override
    public int updateCalendar(Calendar calendar)
    {
        return calendarMapper.updateCalendar(calendar);
    }

    /**
     * 删除日程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCalendarByIds(String ids)
    {
        return calendarMapper.deleteCalendarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除日程信息
     *
     * @param id 日程ID
     * @return 结果
     */
    @Override
    public int deleteCalendarById(String id)
    {
        return calendarMapper.deleteCalendarById(id);
    }
}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 日程对象 calendar
 *
 * @author linpq
 * @date 2019-11-12
 */
public class Calendar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String title;

    /** 事件开始时间 */
    @Excel(name = "事件开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;

    /** 事件结束时间 */
    @Excel(name = "事件结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 是否为全天时间 */
    @Excel(name = "是否为全天时间")
    private String allday;

    /** 时间的背景色 */
    @Excel(name = "时间的背景色")
    private String color;

    /** null */
    private SysUser user;

    private String startString;

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setStarttime(Date starttime)
    {
        this.starttime = starttime;
    }

    public Date getStarttime()
    {
        return starttime;
    }
    public void setEndtime(Date endtime)
    {
        this.endtime = endtime;
    }

    public Date getEndtime()
    {
        return endtime;
    }
    public void setAllday(String allday)
    {
        this.allday = allday;
    }

    public String getAllday()
    {
        return allday;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public SysUser getUser() {
        return user;
    }
    public String getUserid() {
        return user.getUserId();
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
            .append("allday", getAllday())
            .append("color", getColor())
            .toString();
    }


    public void setStart(Date starttime)
    {
        this.starttime = starttime;
    }

    public Date getStart()
    {
        return starttime;
    }
    public void setEnd(Date endtime)
    {
        this.endtime = endtime;
    }

    public Date getEnd()
    {
        return endtime;
    }
}

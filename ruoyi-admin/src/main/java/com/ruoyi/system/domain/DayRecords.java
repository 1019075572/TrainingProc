package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 记录日报、周报、月报对象 day_records
 * 
 * @author linpq
 * @date 2019-10-28
 */
public class DayRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编写 */
    private String id;

    /** 记录类型（record_day、record_week、record_month） */
    @Excel(name = "记录类型", readConverterExp = "r=ecord_day、record_week、record_month")
    private String type;

    /** 记录的时间 */
    @Excel(name = "记录的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDay;

    /** 记录的开始时间 */
    private String beginRecordDay;

    /** 记录的结束时间 */
    private String endRecordDay;

    /** 记录者Id */
    @Excel(name = "记录者Id")
    private String recordId;

    /** 记录者姓名 */
    @Excel(name = "记录者姓名")
    private String recordName;

    /** 今日任务 */
    @Excel(name = "今日任务")
    private String workContent;

    /** 完成情况 */
    @Excel(name = "完成情况")
    private String workResult;

    /** 明日工作目标 */
    private String workTomorrow;

    /** 记录备注 */
    private String content;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 是否有效（0有效 1无效） */
    private Integer isdelete;

    public String getBeginRecordDay() {
        return beginRecordDay;
    }

    public void setBeginRecordDay(String beginRecordDay) {
        this.beginRecordDay = beginRecordDay;
    }

    public String getEndRecordDay() {
        return endRecordDay;
    }

    public void setEndRecordDay(String endRecordDay) {
        this.endRecordDay = endRecordDay;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setRecordDay(Date recordDay) 
    {
        this.recordDay = recordDay;
    }

    public Date getRecordDay() 
    {
        return recordDay;
    }
    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
    }
    public void setRecordName(String recordName) 
    {
        this.recordName = recordName;
    }

    public String getRecordName() 
    {
        return recordName;
    }
    public void setWorkContent(String workContent) 
    {
        this.workContent = workContent;
    }

    public String getWorkContent() 
    {
        return workContent;
    }
    public void setWorkResult(String workResult) 
    {
        this.workResult = workResult;
    }

    public String getWorkResult() 
    {
        return workResult;
    }
    public void setWorkTomorrow(String workTomorrow)
    {
        this.workTomorrow = workTomorrow;
    }

    public String getWorkTomorrow()
    {
        return workTomorrow;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setIsdelete(Integer isdelete) 
    {
        this.isdelete = isdelete;
    }

    public Integer getIsdelete() 
    {
        return isdelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("recordDay", getRecordDay())
            .append("recordId", getRecordId())
            .append("recordName", getRecordName())
            .append("workContent", getWorkContent())
            .append("workResult", getWorkResult())
            .append("workTomorrow", getWorkTomorrow())
            .append("content", getContent())
            .append("remark", getRemark())
            .append("addTime", getAddTime())
            .append("updateTime", getUpdateTime())
            .append("isdelete", getIsdelete())
            .toString();
    }
}

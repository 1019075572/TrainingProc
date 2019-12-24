package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 完成情况对象 sys_finish_proc
 *
 * @author 林鹏群
 * @date 2019-10-09
 */
public class SysFinishProc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** 流程id */
    @Excel(name = "流程id")
    private String procId;
    private String procName;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 完成分数 */
    @Excel(name = "完成分数")
    private String score;

    /** 进行状态 */
    @Excel(name = "进行状态")
    private String finishState;

    private String avatar;
    private String userName;

    /** $column.columnComment */
    @Excel(name = "类别")
    private String ex1;

    /** $column.columnComment */
    @Excel(name = "个人Or团队")
    private String ex2;
    /** $column.columnComment */
    @Excel(name = "完成内容")
    private String ex3;

    private String counts;
    private String deptName;

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public String getEx2() {
        return ex2;
    }

    public void setEx2(String ex2) {
        this.ex2 = ex2;
    }

    public String getEx3() {
        return ex3;
    }

    public void setEx3(String ex3) {
        this.ex3 = ex3;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setProcId(String procId)
    {
        this.procId = procId;
    }

    public String getProcId()
    {
        return procId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setScore(String score)
    {
        this.score = score;
    }

    public String getScore()
    {
        return score;
    }
    public void setFinishState(String finishState)
    {
        this.finishState = finishState;
    }

    public String getFinishState()
    {
        return finishState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("procId", getProcId())
            .append("userId", getUserId())
            .append("score", getScore())
            .append("finishState", getFinishState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小红箱对象 yw_little_box
 * 
 * @author linpq
 * @date 2019-11-05
 */
public class YwLittleBox extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 标题 */
    @Excel(name = "标题")
    private String biaoti;

    /** 类型 */
    @Excel(name = "类型")
    private String leixing;

    /** 内容 */
    @Excel(name = "内容")
    private String neirong;

    /** 扩1 */
    private String kuo1;

    /** 扩2 */
    private String kuo2;

    /** 扩3 */
    private String kuo3;

    /** 扩4 */
    private String kuo4;

    /** 扩5 */
    private String kuo5;

    /** 扩6 */
    private String kuo6;

    /** 删除标记（0：正常；1：删除） */
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setBiaoti(String biaoti) 
    {
        this.biaoti = biaoti;
    }

    public String getBiaoti() 
    {
        return biaoti;
    }
    public void setLeixing(String leixing) 
    {
        this.leixing = leixing;
    }

    public String getLeixing() 
    {
        return leixing;
    }
    public void setNeirong(String neirong) 
    {
        this.neirong = neirong;
    }

    public String getNeirong() 
    {
        return neirong;
    }
    public void setKuo1(String kuo1) 
    {
        this.kuo1 = kuo1;
    }

    public String getKuo1() 
    {
        return kuo1;
    }
    public void setKuo2(String kuo2) 
    {
        this.kuo2 = kuo2;
    }

    public String getKuo2() 
    {
        return kuo2;
    }
    public void setKuo3(String kuo3) 
    {
        this.kuo3 = kuo3;
    }

    public String getKuo3() 
    {
        return kuo3;
    }
    public void setKuo4(String kuo4) 
    {
        this.kuo4 = kuo4;
    }

    public String getKuo4() 
    {
        return kuo4;
    }
    public void setKuo5(String kuo5) 
    {
        this.kuo5 = kuo5;
    }

    public String getKuo5() 
    {
        return kuo5;
    }
    public void setKuo6(String kuo6) 
    {
        this.kuo6 = kuo6;
    }

    public String getKuo6() 
    {
        return kuo6;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("biaoti", getBiaoti())
            .append("leixing", getLeixing())
            .append("neirong", getNeirong())
            .append("kuo1", getKuo1())
            .append("kuo2", getKuo2())
            .append("kuo3", getKuo3())
            .append("kuo4", getKuo4())
            .append("kuo5", getKuo5())
            .append("kuo6", getKuo6())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

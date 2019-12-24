package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 称号任务对象 yw_medal_job
 *
 * @author linpq
 * @date 2019-10-25
 */
public class YwMedalJob extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 归属称号 */
    @Excel(name = "归属称号")
    private String guishuchenghao;
    private String guishuchenghaoName;

    /** 分值 */
    @Excel(name = "分值")
    private String fenzhi;

    /** 标题 */
    @Excel(name = "标题")
    private String biaoti;

    /** 内容 */
    @Excel(name = "内容")
    private String neirong;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 类型 */
    @Excel(name = "类型")
    private String leixing;

    /** 难度 */
    @Excel(name = "难度")
    private String nandu;

    /** 挑战时长 */
    @Excel(name = "挑战时长")
    private String tiaozhanshizhang;

    /** 消耗体力 */
    @Excel(name = "消耗体力")
    private String xiaohaotili;


    private String kuo1;

    /** 扩2 *//**  状态 0未挑战 1挑战中 2已完成 3已通过*/
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

    public String getGuishuchenghaoName() {
        return guishuchenghaoName;
    }

    public void setGuishuchenghaoName(String guishuchenghaoName) {
        this.guishuchenghaoName = guishuchenghaoName;
    }

    public String getId()
    {
        return id;
    }
    public void setGuishuchenghao(String guishuchenghao)
    {
        this.guishuchenghao = guishuchenghao;
    }

    public String getGuishuchenghao()
    {
        return guishuchenghao;
    }
    public void setFenzhi(String fenzhi)
    {
        this.fenzhi = fenzhi;
    }

    public String getFenzhi()
    {
        return fenzhi;
    }
    public void setBiaoti(String biaoti)
    {
        this.biaoti = biaoti;
    }

    public String getBiaoti()
    {
        return biaoti;
    }
    public void setNeirong(String neirong)
    {
        this.neirong = neirong;
    }

    public String getNeirong()
    {
        return neirong;
    }
    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
    }
    public void setLeixing(String leixing)
    {
        this.leixing = leixing;
    }

    public String getLeixing()
    {
        return leixing;
    }
    public void setNandu(String nandu)
    {
        this.nandu = nandu;
    }

    public String getNandu()
    {
        return nandu;
    }
    public void setTiaozhanshizhang(String tiaozhanshizhang)
    {
        this.tiaozhanshizhang = tiaozhanshizhang;
    }

    public String getTiaozhanshizhang()
    {
        return tiaozhanshizhang;
    }
    public void setXiaohaotili(String xiaohaotili)
    {
        this.xiaohaotili = xiaohaotili;
    }

    public String getXiaohaotili()
    {
        return xiaohaotili;
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
            .append("guishuchenghao", getGuishuchenghao())
            .append("fenzhi", getFenzhi())
            .append("biaoti", getBiaoti())
            .append("neirong", getNeirong())
            .append("leibie", getLeibie())
            .append("leixing", getLeixing())
            .append("nandu", getNandu())
            .append("tiaozhanshizhang", getTiaozhanshizhang())
            .append("xiaohaotili", getXiaohaotili())
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

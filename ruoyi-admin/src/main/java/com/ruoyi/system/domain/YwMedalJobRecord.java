package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 挑战称号任务记录对象 yw_medal_job_record
 *
 * @author linpq
 * @date 2019-10-26
 */
public class YwMedalJobRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private String renwubianhao;
    private String renwubianhaoName;

    /** 挑战时间 */
    @Excel(name = "挑战时间")
    private String tiaozhanshijian;

    /** 挑战进度 */
    @Excel(name = "挑战进度")
    private String tiaozhanjindu;

    /** 完成分值 */
    @Excel(name = "完成分值")
    private String wanchengfenzhi;

    /** 挑战者 */
    @Excel(name = "挑战者")
    private String tiaozhanzhe;

    /** 挑战评价 */
    @Excel(name = "挑战评价")
    private String tiaozhanpingjia;

    /** 挑战时长 */
    @Excel(name = "挑战时长")
    private String tiaozhanshizhang;

    /** 消耗体力 */
    @Excel(name = "消耗体力")
    private String xiaohaotili;


    @Excel(name = "扩1")
    private String kuo1;

    /** 扩2 */ /**  状态 0未挑战 1挑战中 2已完成*/
    @Excel(name = "扩2")
    private String kuo2;

    /** 评语 */
    @Excel(name = "扩3")
    private String kuo3;

    /** 阅卷人id */
    @Excel(name = "扩4")
    private String kuo4;

    /** 阅卷人name */
    @Excel(name = "扩5")
    private String kuo5;

    /** 扩6 */
    @Excel(name = "扩6")
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
    public void setRenwubianhao(String renwubianhao)
    {
        this.renwubianhao = renwubianhao;
    }

    public String getRenwubianhao()
    {
        return renwubianhao;
    }
    public void setTiaozhanshijian(String tiaozhanshijian)
    {
        this.tiaozhanshijian = tiaozhanshijian;
    }

    public String getTiaozhanshijian()
    {
        return tiaozhanshijian;
    }
    public void setTiaozhanjindu(String tiaozhanjindu)
    {
        this.tiaozhanjindu = tiaozhanjindu;
    }

    public String getTiaozhanjindu()
    {
        return tiaozhanjindu;
    }
    public void setWanchengfenzhi(String wanchengfenzhi)
    {
        this.wanchengfenzhi = wanchengfenzhi;
    }

    public String getWanchengfenzhi()
    {
        return wanchengfenzhi;
    }
    public void setTiaozhanzhe(String tiaozhanzhe)
    {
        this.tiaozhanzhe = tiaozhanzhe;
    }

    public String getTiaozhanzhe()
    {
        return tiaozhanzhe;
    }
    public void setTiaozhanpingjia(String tiaozhanpingjia)
    {
        this.tiaozhanpingjia = tiaozhanpingjia;
    }

    public String getTiaozhanpingjia()
    {
        return tiaozhanpingjia;
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

    public String getRenwubianhaoName() {
        return renwubianhaoName;
    }

    public void setRenwubianhaoName(String renwubianhaoName) {
        this.renwubianhaoName = renwubianhaoName;
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
            .append("renwubianhao", getRenwubianhao())
            .append("tiaozhanshijian", getTiaozhanshijian())
            .append("tiaozhanjindu", getTiaozhanjindu())
            .append("wanchengfenzhi", getWanchengfenzhi())
            .append("tiaozhanzhe", getTiaozhanzhe())
            .append("tiaozhanpingjia", getTiaozhanpingjia())
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

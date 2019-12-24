package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 日周报对象 ye_daliy_job
 *
 * @author linpq
 * @date 2019-11-05
 */
public class YeDaliyJob extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 日期 */
    @Excel(name = "日期")
    private String riqi;

    /** 标题 */
    @Excel(name = "标题")
    private String biaoti;

    /** 工作目标 */
    @Excel(name = "工作目标")
    private String gongzuomubiao;

    /** 完成工作 */
    @Excel(name = "完成工作")
    private String wanchenggongzuo;

    /** 未完成工作 */
    @Excel(name = "未完成工作")
    private String weiwanchenggongzuo;

    /** 工作计划 */
    @Excel(name = "工作计划")
    private String gongzuojihua;

    /** 需要协调配合工作 */
    @Excel(name = "需要协调配合工作")
    private String xuyaoxiediaopeihegongzuo;

    /** 备注 */
    @Excel(name = "备注")
    private String beizhu;

    /** 图片 */
    @Excel(name = "图片")
    private String tupian;

    /** 是否阅读 */
    @Excel(name = "是否阅读")
    private String shifouyuedu;

    /** 是否草稿 */
    @Excel(name = "是否草稿")
    private String shifoucaogao;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String huifuneirong;

    /** 回复人 */
    @Excel(name = "回复人")
    private String huifuren;

    /** 类型 */
    @Excel(name = "类型")
    private String leixing;

    private String userName;

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
    public void setRiqi(String riqi)
    {
        this.riqi = riqi;
    }

    public String getRiqi()
    {
        return riqi;
    }
    public void setBiaoti(String biaoti)
    {
        this.biaoti = biaoti;
    }

    public String getBiaoti()
    {
        return biaoti;
    }
    public void setGongzuomubiao(String gongzuomubiao)
    {
        this.gongzuomubiao = gongzuomubiao;
    }

    public String getGongzuomubiao()
    {
        return gongzuomubiao;
    }
    public void setWanchenggongzuo(String wanchenggongzuo)
    {
        this.wanchenggongzuo = wanchenggongzuo;
    }

    public String getWanchenggongzuo()
    {
        return wanchenggongzuo;
    }
    public void setWeiwanchenggongzuo(String weiwanchenggongzuo)
    {
        this.weiwanchenggongzuo = weiwanchenggongzuo;
    }

    public String getWeiwanchenggongzuo()
    {
        return weiwanchenggongzuo;
    }
    public void setGongzuojihua(String gongzuojihua)
    {
        this.gongzuojihua = gongzuojihua;
    }

    public String getGongzuojihua()
    {
        return gongzuojihua;
    }
    public void setXuyaoxiediaopeihegongzuo(String xuyaoxiediaopeihegongzuo)
    {
        this.xuyaoxiediaopeihegongzuo = xuyaoxiediaopeihegongzuo;
    }

    public String getXuyaoxiediaopeihegongzuo()
    {
        return xuyaoxiediaopeihegongzuo;
    }
    public void setBeizhu(String beizhu)
    {
        this.beizhu = beizhu;
    }

    public String getBeizhu()
    {
        return beizhu;
    }
    public void setTupian(String tupian)
    {
        this.tupian = tupian;
    }

    public String getTupian()
    {
        return tupian;
    }
    public void setShifouyuedu(String shifouyuedu)
    {
        this.shifouyuedu = shifouyuedu;
    }

    public String getShifouyuedu()
    {
        return shifouyuedu;
    }
    public void setShifoucaogao(String shifoucaogao)
    {
        this.shifoucaogao = shifoucaogao;
    }

    public String getShifoucaogao()
    {
        return shifoucaogao;
    }
    public void setHuifuneirong(String huifuneirong)
    {
        this.huifuneirong = huifuneirong;
    }

    public String getHuifuneirong()
    {
        return huifuneirong;
    }
    public void setHuifuren(String huifuren)
    {
        this.huifuren = huifuren;
    }

    public String getHuifuren()
    {
        return huifuren;
    }
    public void setLeixing(String leixing)
    {
        this.leixing = leixing;
    }

    public String getLeixing()
    {
        return leixing;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("riqi", getRiqi())
            .append("biaoti", getBiaoti())
            .append("gongzuomubiao", getGongzuomubiao())
            .append("wanchenggongzuo", getWanchenggongzuo())
            .append("weiwanchenggongzuo", getWeiwanchenggongzuo())
            .append("gongzuojihua", getGongzuojihua())
            .append("xuyaoxiediaopeihegongzuo", getXuyaoxiediaopeihegongzuo())
            .append("beizhu", getBeizhu())
            .append("tupian", getTupian())
            .append("shifouyuedu", getShifouyuedu())
            .append("shifoucaogao", getShifoucaogao())
            .append("huifuneirong", getHuifuneirong())
            .append("huifuren", getHuifuren())
            .append("leixing", getLeixing())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

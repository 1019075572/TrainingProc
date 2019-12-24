package com.ruoyi.system.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 战力称号对象 yw_medal
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
public class YwMedal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 称号 */
    @Excel(name = "称号")
    private String chenghao;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 等级 */
    @Excel(name = "等级")
    private String dengji;

    /** 标志 */
    @Excel(name = "标志")
    private String biaozhi;

    /** 图片 */
    @Excel(name = "图片")
    private String tupian;
    private String beijing;

    /** 备注 */
    @Excel(name = "备注")
    private String beizhu;

    /** 通关分值 */
    @Excel(name = "通关分值")
    private String fenduankaishi;

    /** 加持战力 */
    @Excel(name = "加持战力")
    private String fenduanjieshu;

    /** 所需学能 */
    private String delFlag;

    /** 进度 */
    private String prcession;
    private String leftProc;

    public String getLeftProc() {
        return String.valueOf(100-Integer.valueOf(StringUtils.isBlank(prcession)?"0":prcession));
    }

    public void setLeftProc(String leftProc) {
        this.leftProc = leftProc;
    }

    /**  状态 0未挑战 1挑战中 2已完成*/
    private String state;

    public String getBeijing() {
        return beijing;
    }

    public void setBeijing(String beijing) {
        this.beijing = beijing;
    }

    public String getPrcession() {
        return prcession;
    }

    public void setPrcession(String prcession) {
        this.prcession = prcession;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setChenghao(String chenghao)
    {
        this.chenghao = chenghao;
    }

    public String getChenghao()
    {
        return chenghao;
    }
    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
    }
    public void setDengji(String dengji)
    {
        this.dengji = dengji;
    }

    public String getDengji()
    {
        return dengji;
    }
    public void setBiaozhi(String biaozhi)
    {
        this.biaozhi = biaozhi;
    }

    public String getBiaozhi()
    {
        return biaozhi;
    }
    public void setTupian(String tupian)
    {
        this.tupian = tupian;
    }

    public String getTupian()
    {
        return tupian;
    }
    public void setBeizhu(String beizhu)
    {
        this.beizhu = beizhu;
    }

    public String getBeizhu()
    {
        return beizhu;
    }
    public void setFenduankaishi(String fenduankaishi)
    {
        this.fenduankaishi = fenduankaishi;
    }

    public String getFenduankaishi()
    {
        return fenduankaishi;
    }
    public void setFenduanjieshu(String fenduanjieshu)
    {
        this.fenduanjieshu = fenduanjieshu;
    }

    public String getFenduanjieshu()
    {
        return fenduanjieshu;
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
            .append("chenghao", getChenghao())
            .append("leibie", getLeibie())
            .append("dengji", getDengji())
            .append("biaozhi", getBiaozhi())
            .append("tupian", getTupian())
            .append("beizhu", getBeizhu())
            .append("fenduankaishi", getFenduankaishi())
            .append("fenduanjieshu", getFenduanjieshu())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

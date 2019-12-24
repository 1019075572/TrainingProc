package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员信息对象 yw_student
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
public class YwStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 主键 */
    @Excel(name = "主键")
    private String zhujian;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nicheng;

    /** 学号 */
    @Excel(name = "学号")
    private String xuehao;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private String yonghubianhao;

    /** 学校 */
    @Excel(name = "学校")
    private String xuexiao;

    /** 年级 */
    @Excel(name = "年级")
    private String nianji;

    /** 专业 */
    @Excel(name = "专业")
    private String zhuanye;

    /** 等级 */
    @Excel(name = "等级")
    private String dengji;

    /** 住址 */
    @Excel(name = "住址")
    private String sushe;

    /** 扣扣号 */
    @Excel(name = "扣扣号")
    private String koukouhao;

    /** 宣言 */
    @Excel(name = "宣言")
    private String xuanyan;

    /** 删除标记（0：正常；1：删除） */
    private String delFlag;
    /**
     * 战斗力，越高越强
     */
    private String zhandouli;
    /**
     * 学能，用于挑战副本的金币
     */
    private String xueneng;
    /**
     * 等级，表示个人累积修炼时间（在线时长）
     */
    private String level;

    public String getZhandouli() {
        return zhandouli;
    }

    public void setZhandouli(String zhandouli) {
        this.zhandouli = zhandouli;
    }

    public String getXueneng() {
        return xueneng;
    }

    public void setXueneng(String xueneng) {
        this.xueneng = xueneng;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setZhujian(String zhujian)
    {
        this.zhujian = zhujian;
    }

    public String getZhujian()
    {
        return zhujian;
    }
    public void setNicheng(String nicheng)
    {
        this.nicheng = nicheng;
    }

    public String getNicheng()
    {
        return nicheng;
    }
    public void setXuehao(String xuehao)
    {
        this.xuehao = xuehao;
    }

    public String getXuehao()
    {
        return xuehao;
    }
    public void setYonghubianhao(String yonghubianhao)
    {
        this.yonghubianhao = yonghubianhao;
    }

    public String getYonghubianhao()
    {
        return yonghubianhao;
    }
    public void setXuexiao(String xuexiao)
    {
        this.xuexiao = xuexiao;
    }

    public String getXuexiao()
    {
        return xuexiao;
    }
    public void setNianji(String nianji)
    {
        this.nianji = nianji;
    }

    public String getNianji()
    {
        return nianji;
    }
    public void setZhuanye(String zhuanye)
    {
        this.zhuanye = zhuanye;
    }

    public String getZhuanye()
    {
        return zhuanye;
    }
    public void setDengji(String dengji)
    {
        this.dengji = dengji;
    }

    public String getDengji()
    {
        return dengji;
    }
    public void setSushe(String sushe)
    {
        this.sushe = sushe;
    }

    public String getSushe()
    {
        return sushe;
    }
    public void setKoukouhao(String koukouhao)
    {
        this.koukouhao = koukouhao;
    }

    public String getKoukouhao()
    {
        return koukouhao;
    }
    public void setXuanyan(String xuanyan)
    {
        this.xuanyan = xuanyan;
    }

    public String getXuanyan()
    {
        return xuanyan;
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
            .append("zhujian", getZhujian())
            .append("nicheng", getNicheng())
            .append("xuehao", getXuehao())
            .append("yonghubianhao", getYonghubianhao())
            .append("xuexiao", getXuexiao())
            .append("nianji", getNianji())
            .append("zhuanye", getZhuanye())
            .append("dengji", getDengji())
            .append("sushe", getSushe())
            .append("koukouhao", getKoukouhao())
            .append("xuanyan", getXuanyan())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

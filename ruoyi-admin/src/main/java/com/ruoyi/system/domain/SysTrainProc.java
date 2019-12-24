package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 实训流程对象 sys_train_proc
 *
 * @author ruoyi
 * @date 2019-10-08
 */
public class SysTrainProc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    private String menuId;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String menuName;

    /** 父菜单名称 */
    private String parentName;

    /** 请求地址 */
    @Excel(name = "请求地址")
    private String url;

    /** 打开方式（menuItem页签 menuBlank新窗口） */
    @Excel(name = "打开方式", readConverterExp = "m=enuItem页签,m=enuBlank新窗口")
    private String target;

    /** 菜单类型（M目录 C菜单 F按钮） */
    @Excel(name = "菜单类型", readConverterExp = "M=目录,C=菜单,F=按钮")
    private String menuType;

    /** 菜单状态（0显示 1隐藏） */
    @Excel(name = "菜单状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /** 权限标识 */
    @Excel(name = "权限标识")
    private String perms;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String icon;

    /** $column.columnComment */
    @Excel(name = "菜单图标")
    private String ex1;

    /** $column.columnComment */
    @Excel(name = "分值")
    private String ex2;

    /** $column.columnComment */
    @Excel(name = "学能")
    private String ex3;

    /** $column.columnComment */
    @Excel(name = "菜单图标")
    private String parentIds;

    /** $column.columnComment */
    @Excel(name = "菜单图标")
    private String treeLeaf;

    /** $column.columnComment */
    @Excel(name = "菜单图标")
    private String treeLevel;

    /** 父菜单ID */
    private String parentId;

    /** 显示顺序 */
    private String orderNum;

    /** 完成情况 */
    private String finishState;

    /** 子菜单 */
    private List<SysTrainProc> children = new ArrayList<SysTrainProc>();

    public List<SysTrainProc> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysTrainProc> children)
    {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setMenuId(String menuId)
    {
        this.menuId = menuId;
    }

    public String getMenuId()
    {
        return menuId;
    }
    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
    }

    public String getMenuName()
    {
        return menuName;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getTarget()
    {
        return target;
    }
    public void setMenuType(String menuType)
    {
        this.menuType = menuType;
    }

    public String getMenuType()
    {
        return menuType;
    }
    public void setVisible(String visible)
    {
        this.visible = visible;
    }

    public String getVisible()
    {
        return visible;
    }
    public void setPerms(String perms)
    {
        this.perms = perms;
    }

    public String getPerms()
    {
        return perms;
    }
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getIcon()
    {
        return icon;
    }
    public void setEx1(String ex1)
    {
        this.ex1 = ex1;
    }

    public String getEx1()
    {
        return ex1;
    }
    public void setEx2(String ex2)
    {
        this.ex2 = ex2;
    }

    public String getEx2()
    {
        return ex2;
    }
    public void setEx3(String ex3)
    {
        this.ex3 = ex3;
    }

    public String getEx3()
    {
        return ex3;
    }
    public void setParentIds(String parentIds)
    {
        this.parentIds = parentIds;
    }

    public String getParentIds()
    {
        return parentIds;
    }
    public void setTreeLeaf(String treeLeaf)
    {
        this.treeLeaf = treeLeaf;
    }

    public String getTreeLeaf()
    {
        return treeLeaf;
    }
    public void setTreeLevel(String treeLevel)
    {
        this.treeLevel = treeLevel;
    }

    public String getTreeLevel()
    {
        return treeLevel;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public String getFinishState() {
        return finishState;
    }

    public void setFinishState(String finishState) {
        this.finishState = finishState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menuId", getMenuId())
            .append("menuName", getMenuName())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("url", getUrl())
            .append("target", getTarget())
            .append("menuType", getMenuType())
            .append("visible", getVisible())
            .append("perms", getPerms())
            .append("icon", getIcon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("ex1", getEx1())
            .append("ex2", getEx2())
            .append("ex3", getEx3())
            .append("parentIds", getParentIds())
            .append("treeLeaf", getTreeLeaf())
            .append("treeLevel", getTreeLevel())
            .toString();
    }
}

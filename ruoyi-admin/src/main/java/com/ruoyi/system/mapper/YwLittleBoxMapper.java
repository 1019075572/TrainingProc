package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.YwLittleBox;
import java.util.List;

/**
 * 小红箱Mapper接口
 * 
 * @author linpq
 * @date 2019-11-05
 */
public interface YwLittleBoxMapper 
{
    /**
     * 查询小红箱
     * 
     * @param id 小红箱ID
     * @return 小红箱
     */
    public YwLittleBox selectYwLittleBoxById(String id);

    /**
     * 查询小红箱列表
     * 
     * @param ywLittleBox 小红箱
     * @return 小红箱集合
     */
    public List<YwLittleBox> selectYwLittleBoxList(YwLittleBox ywLittleBox);

    /**
     * 新增小红箱
     * 
     * @param ywLittleBox 小红箱
     * @return 结果
     */
    public int insertYwLittleBox(YwLittleBox ywLittleBox);

    /**
     * 修改小红箱
     * 
     * @param ywLittleBox 小红箱
     * @return 结果
     */
    public int updateYwLittleBox(YwLittleBox ywLittleBox);

    /**
     * 删除小红箱
     * 
     * @param id 小红箱ID
     * @return 结果
     */
    public int deleteYwLittleBoxById(String id);

    /**
     * 批量删除小红箱
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwLittleBoxByIds(String[] ids);
}

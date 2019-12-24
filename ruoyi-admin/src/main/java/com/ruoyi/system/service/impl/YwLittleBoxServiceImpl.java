package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwLittleBoxMapper;
import com.ruoyi.system.domain.YwLittleBox;
import com.ruoyi.system.service.IYwLittleBoxService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 小红箱Service业务层处理
 *
 * @author linpq
 * @date 2019-11-05
 */
@Service
public class YwLittleBoxServiceImpl implements IYwLittleBoxService
{
    @Autowired
    private YwLittleBoxMapper ywLittleBoxMapper;

    /**
     * 查询小红箱
     *
     * @param id 小红箱ID
     * @return 小红箱
     */
    @Override
    public YwLittleBox selectYwLittleBoxById(String id)
    {
        return ywLittleBoxMapper.selectYwLittleBoxById(id);
    }

    /**
     * 查询小红箱列表
     *
     * @param ywLittleBox 小红箱
     * @return 小红箱
     */
    @Override
    public List<YwLittleBox> selectYwLittleBoxList(YwLittleBox ywLittleBox)
    {
        return ywLittleBoxMapper.selectYwLittleBoxList(ywLittleBox);
    }

    /**
     * 新增小红箱
     *
     * @param ywLittleBox 小红箱
     * @return 结果
     */
    @Override
    public int insertYwLittleBox(YwLittleBox ywLittleBox)
    {
        ywLittleBox.setCreateTime(DateUtils.getNowDate());
        ywLittleBox.setId(IdGenerate.uuid());
        return ywLittleBoxMapper.insertYwLittleBox(ywLittleBox);
    }

    /**
     * 修改小红箱
     *
     * @param ywLittleBox 小红箱
     * @return 结果
     */
    @Override
    public int updateYwLittleBox(YwLittleBox ywLittleBox)
    {
        ywLittleBox.setUpdateTime(DateUtils.getNowDate());
        return ywLittleBoxMapper.updateYwLittleBox(ywLittleBox);
    }

    /**
     * 删除小红箱对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwLittleBoxByIds(String ids)
    {
        return ywLittleBoxMapper.deleteYwLittleBoxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小红箱信息
     *
     * @param id 小红箱ID
     * @return 结果
     */
    @Override
    public int deleteYwLittleBoxById(String id)
    {
        return ywLittleBoxMapper.deleteYwLittleBoxById(id);
    }
}

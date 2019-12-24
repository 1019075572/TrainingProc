package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwMedalMapper;
import com.ruoyi.system.domain.YwMedal;
import com.ruoyi.system.service.IYwMedalService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 战力称号Service业务层处理
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
@Service
public class YwMedalServiceImpl implements IYwMedalService
{
    @Autowired
    private YwMedalMapper ywMedalMapper;

    /**
     * 查询战力称号
     *
     * @param id 战力称号ID
     * @return 战力称号
     */
    @Override
    public YwMedal selectYwMedalById(String id)
    {
        return ywMedalMapper.selectYwMedalById(id);
    }

    /**
     * 查询战力称号列表
     *
     * @param ywMedal 战力称号
     * @return 战力称号
     */
    @Override
    public List<YwMedal> selectYwMedalList(YwMedal ywMedal)
    {
        return ywMedalMapper.selectYwMedalList(ywMedal);
    }

    /**
     * 新增战力称号
     *
     * @param ywMedal 战力称号
     * @return 结果
     */
    @Override
    public int insertYwMedal(YwMedal ywMedal)
    {
        ywMedal.setCreateTime(DateUtils.getNowDate());
        ywMedal.setId(IdGenerate.uuid());
        return ywMedalMapper.insertYwMedal(ywMedal);
    }

    /**
     * 修改战力称号
     *
     * @param ywMedal 战力称号
     * @return 结果
     */
    @Override
    public int updateYwMedal(YwMedal ywMedal)
    {
        ywMedal.setUpdateTime(DateUtils.getNowDate());
        return ywMedalMapper.updateYwMedal(ywMedal);
    }

    /**
     * 删除战力称号对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalByIds(String ids)
    {
        return ywMedalMapper.deleteYwMedalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除战力称号信息
     *
     * @param id 战力称号ID
     * @return 结果
     */
    @Override
    public int deleteYwMedalById(String id)
    {
        return ywMedalMapper.deleteYwMedalById(id);
    }
}

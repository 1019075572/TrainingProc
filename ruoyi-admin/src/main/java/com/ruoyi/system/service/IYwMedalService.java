package com.ruoyi.system.service;

import com.ruoyi.system.domain.YwMedal;
import java.util.List;

/**
 * 战力称号Service接口
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
public interface IYwMedalService
{
    /**
     * 查询战力称号
     *
     * @param id 战力称号ID
     * @return 战力称号
     */
    public YwMedal selectYwMedalById(String id);

    /**
     * 查询战力称号列表
     *
     * @param ywMedal 战力称号
     * @return 战力称号集合
     */
    public List<YwMedal> selectYwMedalList(YwMedal ywMedal);

    /**
     * 新增战力称号
     *
     * @param ywMedal 战力称号
     * @return 结果
     */
    public int insertYwMedal(YwMedal ywMedal);

    /**
     * 修改战力称号
     *
     * @param ywMedal 战力称号
     * @return 结果
     */
    public int updateYwMedal(YwMedal ywMedal);

    /**
     * 批量删除战力称号
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwMedalByIds(String ids);

    /**
     * 删除战力称号信息
     *
     * @param id 战力称号ID
     * @return 结果
     */
    public int deleteYwMedalById(String id);
}

package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.YwMedalRecord;
import java.util.List;

/**
 * 挑战称号记录Mapper接口
 * 
 * @author linpq
 * @date 2019-10-26
 */
public interface YwMedalRecordMapper 
{
    /**
     * 查询挑战称号记录
     * 
     * @param id 挑战称号记录ID
     * @return 挑战称号记录
     */
    public YwMedalRecord selectYwMedalRecordById(String id);

    /**
     * 查询挑战称号记录列表
     * 
     * @param ywMedalRecord 挑战称号记录
     * @return 挑战称号记录集合
     */
    public List<YwMedalRecord> selectYwMedalRecordList(YwMedalRecord ywMedalRecord);

    /**
     * 新增挑战称号记录
     * 
     * @param ywMedalRecord 挑战称号记录
     * @return 结果
     */
    public int insertYwMedalRecord(YwMedalRecord ywMedalRecord);

    /**
     * 修改挑战称号记录
     * 
     * @param ywMedalRecord 挑战称号记录
     * @return 结果
     */
    public int updateYwMedalRecord(YwMedalRecord ywMedalRecord);

    /**
     * 删除挑战称号记录
     * 
     * @param id 挑战称号记录ID
     * @return 结果
     */
    public int deleteYwMedalRecordById(String id);

    /**
     * 批量删除挑战称号记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwMedalRecordByIds(String[] ids);
}

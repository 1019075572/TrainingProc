package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.YeDaliyJob;
import java.util.List;

/**
 * 日周报Mapper接口
 * 
 * @author linpq
 * @date 2019-11-05
 */
public interface YeDaliyJobMapper 
{
    /**
     * 查询日周报
     * 
     * @param id 日周报ID
     * @return 日周报
     */
    public YeDaliyJob selectYeDaliyJobById(String id);

    /**
     * 查询日周报列表
     * 
     * @param yeDaliyJob 日周报
     * @return 日周报集合
     */
    public List<YeDaliyJob> selectYeDaliyJobList(YeDaliyJob yeDaliyJob);

    /**
     * 新增日周报
     * 
     * @param yeDaliyJob 日周报
     * @return 结果
     */
    public int insertYeDaliyJob(YeDaliyJob yeDaliyJob);

    /**
     * 修改日周报
     * 
     * @param yeDaliyJob 日周报
     * @return 结果
     */
    public int updateYeDaliyJob(YeDaliyJob yeDaliyJob);

    /**
     * 删除日周报
     * 
     * @param id 日周报ID
     * @return 结果
     */
    public int deleteYeDaliyJobById(String id);

    /**
     * 批量删除日周报
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYeDaliyJobByIds(String[] ids);
}

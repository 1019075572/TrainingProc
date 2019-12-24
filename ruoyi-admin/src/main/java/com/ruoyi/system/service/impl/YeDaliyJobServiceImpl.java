package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YeDaliyJobMapper;
import com.ruoyi.system.domain.YeDaliyJob;
import com.ruoyi.system.service.IYeDaliyJobService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.IdGenerate;

/**
 * 日周报Service业务层处理
 *
 * @author linpq
 * @date 2019-11-05
 */
@Service
public class YeDaliyJobServiceImpl implements IYeDaliyJobService
{
    @Autowired
    private YeDaliyJobMapper yeDaliyJobMapper;

    /**
     * 查询日周报
     *
     * @param id 日周报ID
     * @return 日周报
     */
    @Override
    public YeDaliyJob selectYeDaliyJobById(String id)
    {
        return yeDaliyJobMapper.selectYeDaliyJobById(id);
    }

    /**
     * 查询日周报列表
     *
     * @param yeDaliyJob 日周报
     * @return 日周报
     */
    @Override
    public List<YeDaliyJob> selectYeDaliyJobList(YeDaliyJob yeDaliyJob)
    {
        return yeDaliyJobMapper.selectYeDaliyJobList(yeDaliyJob);
    }

    /**
     * 新增日周报
     *
     * @param yeDaliyJob 日周报
     * @return 结果
     */
    @Override
    public int insertYeDaliyJob(YeDaliyJob yeDaliyJob)
    {
        yeDaliyJob.setCreateTime(DateUtils.getNowDate());
        yeDaliyJob.setCreateBy(ShiroUtils.getUserId());
        yeDaliyJob.setId(IdGenerate.uuid());
        return yeDaliyJobMapper.insertYeDaliyJob(yeDaliyJob);
    }

    /**
     * 修改日周报
     *
     * @param yeDaliyJob 日周报
     * @return 结果
     */
    @Override
    public int updateYeDaliyJob(YeDaliyJob yeDaliyJob)
    {
        yeDaliyJob.setUpdateTime(DateUtils.getNowDate());
        return yeDaliyJobMapper.updateYeDaliyJob(yeDaliyJob);
    }

    /**
     * 删除日周报对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYeDaliyJobByIds(String ids)
    {
        return yeDaliyJobMapper.deleteYeDaliyJobByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除日周报信息
     *
     * @param id 日周报ID
     * @return 结果
     */
    @Override
    public int deleteYeDaliyJobById(String id)
    {
        return yeDaliyJobMapper.deleteYeDaliyJobById(id);
    }
}

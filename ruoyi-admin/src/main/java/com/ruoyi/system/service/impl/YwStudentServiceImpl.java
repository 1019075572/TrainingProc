package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdGenerate;
import com.ruoyi.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwStudentMapper;
import com.ruoyi.system.domain.YwStudent;
import com.ruoyi.system.service.IYwStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学员信息Service业务层处理
 *
 * @author 林鹏群
 * @date 2019-10-20
 */
@Service
public class YwStudentServiceImpl implements IYwStudentService
{
    @Autowired
    private YwStudentMapper ywStudentMapper;

    /**
     * 查询学员信息
     *
     * @param id 学员信息ID
     * @return 学员信息
     */
    @Override
    public YwStudent selectYwStudentById(String id)
    {
        return ywStudentMapper.selectYwStudentById(id);
    }

    /**
     * 查询学员信息列表
     *
     * @param ywStudent 学员信息
     * @return 学员信息
     */
    @Override
    public List<YwStudent> selectYwStudentList(YwStudent ywStudent)
    {
        return ywStudentMapper.selectYwStudentList(ywStudent);
    }

    /**
     * 新增学员信息
     *
     * @param ywStudent 学员信息
     * @return 结果
     */
    @Override
    public int insertYwStudent(YwStudent ywStudent)
    {
        ywStudent.setCreateTime(DateUtils.getNowDate());
        ywStudent.setId(ShiroUtils.getUserId());
        return ywStudentMapper.insertYwStudent(ywStudent);
    }

    /**
     * 修改学员信息
     *
     * @param ywStudent 学员信息
     * @return 结果
     */
    @Override
    public int updateYwStudent(YwStudent ywStudent)
    {
        ywStudent.setUpdateTime(DateUtils.getNowDate());
//        ywStudent.setId(ShiroUtils.getUserId());
        return ywStudentMapper.updateYwStudent(ywStudent);
    }

    /**
     * 删除学员信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYwStudentByIds(String ids)
    {
        return ywStudentMapper.deleteYwStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学员信息信息
     *
     * @param id 学员信息ID
     * @return 结果
     */
    @Override
    public int deleteYwStudentById(String id)
    {
        return ywStudentMapper.deleteYwStudentById(id);
    }
}

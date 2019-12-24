package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.YwStudent;
import java.util.List;

/**
 * 学员信息Mapper接口
 * 
 * @author 林鹏群
 * @date 2019-10-20
 */
public interface YwStudentMapper 
{
    /**
     * 查询学员信息
     * 
     * @param id 学员信息ID
     * @return 学员信息
     */
    public YwStudent selectYwStudentById(String id);

    /**
     * 查询学员信息列表
     * 
     * @param ywStudent 学员信息
     * @return 学员信息集合
     */
    public List<YwStudent> selectYwStudentList(YwStudent ywStudent);

    /**
     * 新增学员信息
     * 
     * @param ywStudent 学员信息
     * @return 结果
     */
    public int insertYwStudent(YwStudent ywStudent);

    /**
     * 修改学员信息
     * 
     * @param ywStudent 学员信息
     * @return 结果
     */
    public int updateYwStudent(YwStudent ywStudent);

    /**
     * 删除学员信息
     * 
     * @param id 学员信息ID
     * @return 结果
     */
    public int deleteYwStudentById(String id);

    /**
     * 批量删除学员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYwStudentByIds(String[] ids);
}

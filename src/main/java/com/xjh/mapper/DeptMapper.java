package com.xjh.mapper;


import com.xjh.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Ballauma
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门数据
     *
     */
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    /**
     *
     * 根据id 删除部门
     */
    @Delete("delete from dept where id = #{id}")
    boolean deleteById(Integer id);

    /**
     * 新增部门
     *
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 通过id 查找部门
     */
    @Select("select id,name,create_time,update_time from dept where id = #{id}")
    Dept findById(Integer id);

    /**
     * 通过id 更新数据
     */
    @Update("update dept set name = #{name} , update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}

package com.xjh.mapper;

import com.xjh.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ballauma
 */
@Mapper
public interface ClazzMapper {
    /**
     * 查询所有学生
     */
    public List<Clazz> findAll();

    /**
     * 根据id 删除班级
     */
    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAllClazz();
}

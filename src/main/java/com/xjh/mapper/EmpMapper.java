package com.xjh.mapper;

import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ballauma
 */
@Mapper
public interface EmpMapper {


    //-------原始分页查询相关方法-------
    /**
     * 返回总记录数
     */
//    public long getCount();

    /**
     * 根据传入的 page pageSize 进行分页查询 并返回对应的emp数据
     */
//    public List<Emp> list(Integer page, Integer pageSize);

    //-------基于PageHelper分页查询相关方法-------
    /**
     * 返回所有emp数据
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    void save(Emp emp);
}

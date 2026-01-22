package com.xjh.service;

import com.xjh.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ballauma
 */

@Service
public interface DeptService {

    /**
     * 查询所有部门数据
     *
     */
    List<Dept> findAll();

    boolean deleteById(Integer id);


    void addDept(Dept dept);

    Dept findById(Integer id);

    void updateById(Dept dept);
}

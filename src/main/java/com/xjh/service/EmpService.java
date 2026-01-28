package com.xjh.service;

import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ballauma
 */
@Service
public interface EmpService {

    void delete(List<Integer> ids);

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    Emp getInfo(Integer id);

    void update(Emp emp);
}

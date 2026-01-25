package com.xjh.service;

import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.pageResult;
import org.springframework.stereotype.Service;

/**
 * @author Ballauma
 */
@Service
public interface EmpService {
    pageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}

package com.xjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xjh.mapper.EmpMapper;
import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.pageResult;
import com.xjh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ballauma
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public pageResult page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 执行查询
        List<Emp> list = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) list;

        return new pageResult<Emp>(p.getTotal(), p.getResult());
    }
}

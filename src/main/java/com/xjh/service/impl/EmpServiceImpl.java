package com.xjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xjh.mapper.EmpExprMapper;
import com.xjh.mapper.EmpMapper;
import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpExpr;
import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.pageResult;
import com.xjh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ballauma
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        // 删除员工信息
        empMapper.deleteByIds(ids);
        // 删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public pageResult page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 执行查询
        List<Emp> list = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) list;

        return new pageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        //1.保存员工的基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);

        //2.保存员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach((expr) -> {
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        //根据id修改员工基本信息
        empMapper.updateById(emp);


        //1.先根据员工id删除现有工作经历
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //2.新增工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(list -> {
                list.setEmpId(emp.getId());
                empExprMapper.insertBatch(exprList);
            });
        }


    }

    @Override
    public Emp getInfo(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }
}

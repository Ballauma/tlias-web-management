package com.xjh.service.impl;

import com.xjh.mapper.EmpMapper;
import com.xjh.pojo.Emp;
import com.xjh.pojo.LoginData;
import com.xjh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ballauma
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public LoginData login(Emp emp) {
        Emp loginEmp = empMapper.selectByUsernameAndPassword(emp.getUsername(), emp.getPassword());
        if (loginEmp == null) {
            return null;
        }
        return new LoginData(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(),"");
    }
}

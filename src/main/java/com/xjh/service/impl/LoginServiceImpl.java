package com.xjh.service.impl;

import com.xjh.mapper.EmpMapper;
import com.xjh.pojo.Emp;
import com.xjh.pojo.LoginData;
import com.xjh.service.LoginService;
import com.xjh.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        // 生成JWT 令牌


        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginEmp.getId());
        claims.put("username", loginEmp.getUsername());
        String jwt = JwtUtils.generateJwt(claims);


        return new LoginData(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(), jwt);
    }
}

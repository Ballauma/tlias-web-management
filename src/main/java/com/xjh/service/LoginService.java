package com.xjh.service;

import com.xjh.pojo.Emp;
import com.xjh.pojo.LoginData;
import org.springframework.stereotype.Service;

/**
 * @author Ballauma
 */
@Service
public interface LoginService {
    LoginData login(Emp emp);
}

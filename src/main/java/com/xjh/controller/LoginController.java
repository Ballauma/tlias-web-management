package com.xjh.controller;

import com.xjh.pojo.Emp;
import com.xjh.pojo.LoginData;
import com.xjh.pojo.Result;
import com.xjh.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ballauma
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("login...");
        // 调用登录服务
        LoginData loginData = loginService.login(emp);

        if (loginData == null) {
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginData);
    }
}

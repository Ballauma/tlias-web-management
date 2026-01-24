package com.xjh.controller;

import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.Result;
import com.xjh.pojo.pageResult;
import com.xjh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ballauma
 * 员工控制器
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询{}{}", empQueryParam.getPage(), empQueryParam.getPageSize());

        pageResult pageResult = empService.page(empQueryParam);

        return Result.success(pageResult);
    }
}

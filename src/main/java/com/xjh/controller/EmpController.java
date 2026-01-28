package com.xjh.controller;

import com.xjh.pojo.Emp;
import com.xjh.pojo.EmpQueryParam;
import com.xjh.pojo.PageResult;
import com.xjh.pojo.Result;
import com.xjh.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        PageResult pageResult = empService.page(empQueryParam);

        return Result.success(pageResult);
    }

    /**
     * 根据ID 查询员工
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工{}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工 - 使用查询参数，支持批量删除
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 更新员工数据
     * @param emp
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);

        return Result.success();
    }
}

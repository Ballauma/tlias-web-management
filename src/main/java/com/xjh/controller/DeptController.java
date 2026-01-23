package com.xjh.controller;

import com.xjh.pojo.Dept;
import com.xjh.pojo.Result;
import com.xjh.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ballauma
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    //    @RequestMapping("/depts")
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> list = deptService.findAll();
        return Result.success(list);
    }

    /**
     *  @RequestParam 注解一旦使用则必须传递参数，否则报错
     * 如果前端传递参数名和服务器端方法名一致则 @RequestParam 可以省略
     */
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
//        System.out.println("删除对应部门数据");
        log.info("删除对应部门数据");
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门" + dept);
        log.info("新增部门{}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据id 查询部门
     */
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    /**
     *
     * 根据id 更新数据
     */
    @PutMapping
    public Result updateById(@RequestBody Dept dept) {
        deptService.updateById(dept);
        return Result.success();
    }
}

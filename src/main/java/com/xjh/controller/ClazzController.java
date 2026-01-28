package com.xjh.controller;

import com.xjh.pojo.Clazz;
import com.xjh.pojo.PageResult;
import com.xjh.pojo.Result;
import com.xjh.pojo.ClazzQueryParam;
import com.xjh.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Ballauma
 */

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 查询所有学生
     */
    @GetMapping
    public Result findAll(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        ClazzQueryParam studentQueryParam = new ClazzQueryParam(name, begin, end, page, pageSize);
        PageResult pageResult = clazzService.findAll(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据id查询班级
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    /**
     * 更新班级
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }

     /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result selectAll(){

        List<Clazz> clazzList = clazzService.findAllClazz();
        return Result.success(clazzList);
    }
}

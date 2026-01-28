package com.xjh.controller;

import com.xjh.pojo.PageResult;
import com.xjh.pojo.Result;
import com.xjh.pojo.Student;
import com.xjh.pojo.StudentQueryParam;
import com.xjh.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ballauma
 */
@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学生
     * @return
     */
    @GetMapping
    public Result findAll(StudentQueryParam studentQueryParam){
        log.info("分页查询学生，参数：{}", studentQueryParam);
       PageResult<Student> pageResult = studentService.findAll(studentQueryParam);
       return Result.success(pageResult);
    }
    /**
     * 添加学生
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学生");
        studentService.add(student);
        return Result.success();
    }
    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询学生，id：{}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生");
        studentService.update(student);
        return Result.success();
    }

    /**
     * 违纪处理
     * @param id 学生id
     * @param score 违纪分数
     * @return
     */
    @PostMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("违纪处理");
        Student student = studentService.findById(id);
        student.setViolationCount((short) (student.getViolationCount() + 1));
        student.setViolationScore((short) (student.getViolationScore() + score));
        studentService.update(student);
        return Result.success();
    }


}

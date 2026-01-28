package com.xjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xjh.mapper.StudentMapper;
import com.xjh.pojo.PageResult;
import com.xjh.pojo.Student;
import com.xjh.pojo.StudentQueryParam;
import com.xjh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ballauma
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> findAll(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> list = studentMapper.findAll(studentQueryParam);

        Page<Student> page = (Page<Student>) list;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());

        studentMapper.insert(student);
    }
}

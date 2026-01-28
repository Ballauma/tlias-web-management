package com.xjh.service;

import com.xjh.pojo.PageResult;
import com.xjh.pojo.Student;
import com.xjh.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

/**
 * @author Ballauma
 */
@Service
public interface StudentService {
    PageResult<Student> findAll(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student findById(Integer id);

    void update(Student student);
}

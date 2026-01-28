package com.xjh.mapper;

import com.xjh.pojo.Student;
import com.xjh.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Ballauma
 */
@Mapper
public interface StudentMapper {
    /**
     * 查询所有学生
     * @param studentQueryParam
     * @return
     */
    List<Student> findAll(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student selectByPrimaryKey(Integer id);

    void updateByPrimaryKey(Student student);

    @MapKey("name")
    List<Map<String, Object>> getDegreeData();

    @MapKey("className")
    List<Map<String, Object>> getStudentCountData();
}

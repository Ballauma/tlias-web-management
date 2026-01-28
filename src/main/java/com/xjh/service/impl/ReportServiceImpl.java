package com.xjh.service.impl;

import com.xjh.mapper.EmpMapper;
import com.xjh.mapper.StudentMapper;
import com.xjh.pojo.JobOption;
import com.xjh.pojo.StudentOption;
import com.xjh.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Ballauma
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Map> getGenderData() {
        return empMapper.getGenderData();
    }

    @Override
    public List<Map<String, Object>> getDegreeData() {
        return studentMapper.getDegreeData();
    }

    @Override
    public JobOption getJobData() {
        List<Map<String, Object>> list = empMapper.getJobData();

        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public StudentOption getStudentCountData() {
        List<Map<String, Object>> list = studentMapper.getStudentCountData();
        List<Object> classNameList = list.stream().map(dataMap -> dataMap.get("className")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("studentCount")).toList();

        return new StudentOption(classNameList, dataList);
    }
}

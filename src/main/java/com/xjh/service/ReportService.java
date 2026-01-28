package com.xjh.service;

import com.xjh.pojo.JobOption;
import com.xjh.pojo.StudentOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Ballauma
 */
@Service
public interface ReportService {
    JobOption getJobData();

    List<Map> getGenderData();

    List<Map<String, Object>> getDegreeData();

    StudentOption getStudentCountData();
}

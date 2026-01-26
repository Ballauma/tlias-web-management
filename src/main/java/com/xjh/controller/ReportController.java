package com.xjh.controller;

import com.xjh.pojo.JobOption;
import com.xjh.pojo.Result;
import com.xjh.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Ballauma
 */
@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getJobData() {
        JobOption jobOption = reportService.getJobData();

        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getGenderData() {
        List<Map> list = reportService.getGenderData();
        return Result.success(list);
    }
}



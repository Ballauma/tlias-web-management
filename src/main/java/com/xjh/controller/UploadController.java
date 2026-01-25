package com.xjh.controller;

import com.xjh.pojo.Result;
import com.xjh.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ballauma
 */
@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOssOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传{}",file.getOriginalFilename());

        //将文件交给oss处理
        String url = aliyunOssOperator.upload(file.getBytes(), file.getOriginalFilename());


        return Result.success(url);
    }
}

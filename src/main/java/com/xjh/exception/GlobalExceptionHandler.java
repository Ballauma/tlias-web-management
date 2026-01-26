package com.xjh.exception;

import com.xjh.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ballauma
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler
    public Result handleException(Exception e) {

        log.error("程序出错了", e);
        return Result.error("出错了，请联系管理员");
    }

    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("信息重复", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");


        return Result.error(arr[2] + "重复");

    }
}

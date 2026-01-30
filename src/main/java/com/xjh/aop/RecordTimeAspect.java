package com.xjh.aop;

import com.xjh.mapper.OperateLogMapper;
import com.xjh.pojo.OperateLog;
import com.xjh.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Ballauma
 */

@Component
@Slf4j
@Aspect
public class RecordTimeAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("execution(* com.xjh.controller.*.save*(..)) ||" +
            "execution(* com.xjh.controller.*.delete*(..)) ||" +
            "execution(* com.xjh.controller.*.update*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录方法执行开始的时间
        long begin = System.currentTimeMillis();

        // 2. 执行方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long costTime = end - begin;
        // 构建日志实体
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 这里需要你根据实际情况获取当前用户 ID
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");
        operateLog.setCostTime(costTime);

        operateLogMapper.insert(operateLog);


        log.info("方法执行时间{}", costTime);
        return result;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}

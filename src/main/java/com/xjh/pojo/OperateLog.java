package com.xjh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Ballauma
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {
    //ID
    private Integer id;
    //操作人 ID
    private Integer operateEmpId;
    //操作时间
    private LocalDateTime operateTime;
    //操作类名
    private String className;
    //操作方法名
    private String methodName;
    //操作方法参数
    private String methodParams;
    //操作方法返回值
    private String returnValue;
    //操作耗时
    private Long costTime;
}

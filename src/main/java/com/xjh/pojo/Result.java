package com.xjh.pojo;

import lombok.Data;

/**
 * @author Ballauma
 */

@Data
public class Result {
    // 响应码，1 代表成功; 0 代表失败
    private Integer code;
    // 响应信息 描述字符串
    private String msg;
    // 返回的数据
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "操作成功";
        return result;
    }

    public static Result success(Object data) {
        Result result = success();
        result.data = data;
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }


}

package com.lxd.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author 兰晓东
 * @create 2023-04-06 19:13
 * @describe:
 */
@Data
@ToString
public class Result {


    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

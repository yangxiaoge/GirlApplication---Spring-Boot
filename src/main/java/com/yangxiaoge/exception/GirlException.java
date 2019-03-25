package com.yangxiaoge.exception;

/**
 * Created by yangxiaoge
 * 2019/3/25 20:09
 * 自定义异常类
 */
public class GirlException extends RuntimeException { //spring 框架只能捕获运行时异常
    private Integer code;

    public GirlException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

package com.yangxiaoge.exception;

import com.yangxiaoge.enums.ResultEnum;

/**
 * Created by yangxiaoge
 * 2019/3/25 20:09
 * 自定义异常类
 */
public class GirlException extends RuntimeException { //spring 框架只能捕获运行时异常
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

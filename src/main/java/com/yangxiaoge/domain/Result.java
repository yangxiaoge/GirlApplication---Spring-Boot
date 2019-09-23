package com.yangxiaoge.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * http请求返回的最外层对象
 * Created by yangxiaoge
 * 2019/3/25 19:36
 */
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 后台时间
     */
    private String time;

    /**
     * 返回的具体内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setCurrentTime() {
        this.time = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(new Date());
    }
}

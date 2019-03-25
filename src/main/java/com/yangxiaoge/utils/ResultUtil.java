package com.yangxiaoge.utils;

import com.yangxiaoge.domain.Result;

/**
 * Created by yangxiaoge
 * 2019/3/25 19:43
 * 返回工具类，统一封装success，error
 */
public class ResultUtil {
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

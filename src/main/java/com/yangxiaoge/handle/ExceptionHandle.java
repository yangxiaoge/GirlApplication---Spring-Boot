package com.yangxiaoge.handle;

import com.yangxiaoge.domain.Result;
import com.yangxiaoge.exception.GirlException;
import com.yangxiaoge.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yangxiaoge
 * 2019/3/25 19:59
 * 异常统一处理
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("[系统异常]{}", e);
//            return ResultUtil.error(-1, "未知错误");
            return ResultUtil.error(-1, e.getMessage());
        }
    }
}

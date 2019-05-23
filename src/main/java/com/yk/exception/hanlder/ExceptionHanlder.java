package com.yk.exception.hanlder;

import com.yk.enums.ResultEnum;
import com.yk.exception.GlobalException;
import com.yk.util.ResponseUtil;
import com.yk.util.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionHanlder {

    @ExceptionHandler(Exception.class)
    public ResultVO handler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            log.error("【全局自定义异常】: err = {} url = {} ", e.getMessage(),request.getRequestURL());
            return ResponseUtil.error(globalException.getCode(), e.getMessage());
        } else {
            e.printStackTrace();
            log.error("【未捕获异常】: err = {} url = {}", e.getMessage(),request.getRequestURL());
            return ResponseUtil.error(ResultEnum.SERVER_ERROR);
        }
    }
}

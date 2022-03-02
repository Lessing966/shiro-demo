package com.example.demo.common.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.BindException;

@ControllerAdvice
@RestController
public class CommonExceptionHandler {

    /**
     * Java一般异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String  exceptionHandler(Exception e){
        e.printStackTrace();
        if(e instanceof BindException){
            int index = e.getMessage().lastIndexOf("[");
            return Result.defeatedResultByCodeAndMsg(2, index!= -1?e.getMessage().substring(index + 1,e.getMessage().length()-1).trim():e.getMessage());
        }
        return Result.defeatedResultByMsg(e.toString());
    }

    /**
     * 拦截自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public String exceptionHandler(BaseException ex){
        ex.printStackTrace();
        if(ex.getCode()==null){
            ex.setCode(4);
        }
        return Result.defeatedResultByCodeAndMsg(ex.getCode(),ex.getMsg());
    }

}

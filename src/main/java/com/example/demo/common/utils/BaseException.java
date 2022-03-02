package com.example.demo.common.utils;

public class BaseException extends RuntimeException{

    private Integer code;

    private String msg;

    /**
     * 默认异常，状态码为2
     * @param msg
     */
    public BaseException(String msg){
        super();
        this.msg=msg;
        this.code=2;
    }


    /**
     * 自定义异常
     * @param code
     * @param massge
     */
    public BaseException(Integer code,String massge){
        super(massge);
        this.msg=msg;
        this.code=code;
    }


    public BaseException(){
        super("系统错误，请联系管理员");
        this.code=4;
        this.msg="系统错误，请联系管理员";
    }





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

}

package com.example.demo.common.utils;

import lombok.Data;

@Data
public class Consequence {

    private Integer code;

    private String msg;

    private Object date;

    private String devMsg;

    public void clear(){
        this.code=null;
        this.date=null;
        this.msg=null;
        this.devMsg=null;
    }

}

package com.example.demo.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Result {
    private static volatile Consequence consequence=new Consequence();

    /**
     * code结果状态码 0:操作成功；
     */
    public static int code0=0;
    public static int code1=1;//1:未登录;
    public static int code2=2;//2:参数错误;
    public static int code3=3;//3:没有权限;
    public static int code4=4;//4:系统异常
    //时间格式
    public static String dateFormat="yyyy-MM-dd  HH:mm:ss";



    public static String succeedResultByMsgAndDate( String msg, Object date){
        consequence.clear();
        consequence.setCode(code0);
        consequence.setMsg(msg);
        consequence.setDate(date);
        return getResult(consequence);    }

    public static String succeedResultByMsg( String msg){
        consequence.clear();
        consequence.setCode(code0);
        consequence.setMsg(msg);
        consequence.setDate("");
        return getResult(consequence);    }


    public static String succeedResult(){
        consequence.clear();
        consequence.setCode(code0);
        consequence.setMsg("操作成功");
        consequence.setDate("");
        return getResult(consequence);    }


    public static String defeatedResultByMsg(String msg){
        consequence.clear();
        consequence.setCode(code4);
        consequence.setDate("");
        consequence.setMsg("系统异常，请联系管理员");
        consequence.setDevMsg(msg);
        return getResult(consequence);    }

    public static String defeatedResult(){
        consequence.clear();
        consequence.setCode(code4);
        consequence.setDate("");
        consequence.setMsg("系统异常，请联系管理员");
        return getResult(consequence);    }

    public static String noLoginResult(){
        consequence.clear();
        consequence.setCode(code1);
        consequence.setDate("");
        consequence.setMsg("没有登录，请登录");
        return getResult(consequence);    }

    public static String noAuthorityResult(){
        consequence.clear();
        consequence.setCode(code3);
        consequence.setDate("");
        consequence.setMsg("没有权限，请联系管理员分配权限");
        return getResult(consequence);    }

    public static String noAuthorityResultByMsg(String msg){
        consequence.clear();
        consequence.setCode(code3);
        consequence.setDate("");
        consequence.setMsg(msg);
        return getResult(consequence);    }

    public static String errorParameterResult(String 参数错误){
        consequence.clear();
        consequence.setCode(code2);
        consequence.setDate("");
        consequence.setMsg("参数错误，或参数不能为空");
        return getResult(consequence);
    }


    public static String errorParameterResultByMsg(String msg){
        consequence.clear();
        consequence.setCode(code2);
        consequence.setDate("");
        consequence.setMsg(msg);
        return getResult(consequence);    }

    public static String defeatedResultByCodeAndMsg(Integer code,String msg){
        consequence.clear();
        consequence.setCode(code);
        consequence.setDate("");
        consequence.setMsg(msg);
        return getResult(consequence);    }



    public static String setResultByCodeAndMsgAndDate(Integer code,String msg, Object date){
        consequence.clear();
        consequence.setCode(code);
        consequence.setDate(date);
        consequence.setMsg(msg);
        return getResult(consequence);
    }


    public static String getResult(Consequence consequence){
        return JSON.toJSONStringWithDateFormat(consequence,dateFormat, SerializerFeature.DisableCircularReferenceDetect);
    }


}

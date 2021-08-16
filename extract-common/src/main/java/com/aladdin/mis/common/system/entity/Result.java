package com.aladdin.mis.common.system.entity;

import com.aladdin.mis.common.system.support.ResultCodeEnum;
import lombok.Data;

@Data
public class Result {
    private  String message="successful";
    private  boolean success=true;
    private  int code=20000;
    private  int count;
    private Object data;

    public Result(){

    }

    public Result(boolean success, int code, String message){

    }

    public static Result success(Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }
}

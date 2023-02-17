package com.aladdin.mis.common.system.entity;

import com.aladdin.mis.common.enums.ResultCodeEnum;
import lombok.Data;

import java.util.UUID;

/**
 * @author libia
 */
@Data
public class Result {
    /**
     * 请求唯一主键，方便查询日志，及服务之间的调用排查
     */
    private  String requestId = UUID.randomUUID().toString();
    private  String message="successful";
    private  boolean success=true;
    private  int code = 20000;
    private Object data;

    public Result(){

    }

    public Result(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, int code, String message, Object data){
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    public static Result save(){
        return new Result(true, ResultCodeEnum.SAVE.getCode(), ResultCodeEnum.SAVE.getMsg());
    }

    public static Result update(){
        return new Result(true, ResultCodeEnum.UPDATE.getCode(), ResultCodeEnum.UPDATE.getMsg());
    }

    public static Result successMsg(String message){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), message, null);
    }

    public static Result success(){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), null);
    }

    public static Result success(String message, Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static Result error(int code, String message){
        return new Result(false, code, message);
    }

    public static Result error(){
        return new Result(false, ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }

    public static Result error(String msg){
        return new Result(false, ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static Result error(String msg, Object data){
        return new Result(false, ResultCodeEnum.FAIL.getCode(), msg, data);
    }
}

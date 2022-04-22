package com.aladdin.mis.common.system.entity;

import com.aladdin.mis.enums.ResultCodeEnum;
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
    private  int code=20000;
    private Object data;

    public Result(){

    }

    public Result(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static Result success(Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static Result success(String message, Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), message);
    }

    public static Result error(int code, String message){
        return new Result(false, code, message);
    }

    public static Result error(){
        return new Result(false, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }
}

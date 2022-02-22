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
    private  int code=20000;
    private Object data;

    public Result(){

    }

    public Result(boolean success, int code, String message){

    }

    public static Result success(Object data){
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }
}

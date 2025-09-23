package com.aladdin.mis.common.exception;
/**
 * Created by cles on 2025/9/12 16:42
 */

/** todo 全局错误日志
 * @description:
 * @author cles
 * @Date 2020/5/31 16:42
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

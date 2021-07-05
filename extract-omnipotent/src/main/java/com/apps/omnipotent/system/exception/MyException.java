package com.apps.omnipotent.system.exception;
/**
 * Created by cles on 2020/5/31 16:42
 */

/**
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

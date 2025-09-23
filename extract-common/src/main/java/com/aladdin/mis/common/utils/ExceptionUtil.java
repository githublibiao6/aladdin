package com.aladdin.mis.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class ExceptionUtil {

    /**
     * 获取错误详情
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}

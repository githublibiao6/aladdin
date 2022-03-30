package com.aladdin.mis.dao.utils;

public class StringUtil {

    public static String firstCharLower(String str) {
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str.toLowerCase();
        }
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    public static String firstCharUp(String str) {
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    /**
     * 带下划线的字符串转为驼峰
     * 例如：hello_world->helloWorld
     * @param str 转换前字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String toCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        if (str == null || str.isEmpty()) {
            return "";
        } else if (!str.contains("_")) {
            // 不含下划线，不转换
            return firstCharLower(str);
        }
        // 用下划线将原始字符串分割
        String camel[] = str.split("_");
        for (String s :  camel) {
            // 跳过空字符串
            if (s.isEmpty()) {
                continue;
            }
            result.append(firstCharUp(s));
        }
        return firstCharLower(result.toString());
    }
}

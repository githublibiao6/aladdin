package com.aladdin.mis.common.string.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static final String FLAG_COLON = ":";

    public static final String FLAG_EQUAL = "=";

    /**
     * 拆分key flag value形式字符返回key
     */
    public static String getKeyString(String falg, String tempStr) {
        if (!StringUtils.isEmpty(tempStr) && appearStringNumber(tempStr, falg) == 1) {
            String[] tempStrArray = tempStr.split(falg);
            return tempStrArray[0];
        } else {
            return "";
        }
    }

    /**
     * 拆分key flag value形式字符返回value
     */
    public static String getValueString(String falg, String tempStr) {
        if (!StringUtils.isEmpty(tempStr) && appearStringNumber(tempStr, falg) == 1) {
            String[] tempStrArray = tempStr.split(falg);
            return tempStrArray[1];
        } else {
            return "";
        }
    }

    /**
     * 获取指定字符串出现的次数
     */
    public static int appearStringNumber(String srcText, String findText) {
        Integer count = 0;
        Pattern pattern = Pattern.compile(findText);
        Matcher matcher = pattern.matcher(srcText);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static boolean isBlank(String str) {
        if(str == null || "".equals(str)){
            return true;
        }
        return "".equals(str.trim());
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }


    /**
     * 首字母转小写
     * HELLO -> hELLO
     * @param str
     * @return
     */
    public static String firstCharLower(String str) {
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            return str.toLowerCase();
        }
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    /**
     * 首字母转大写
     * HELLO -> hELLO
     * @param str
     * @return
     */
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
     * 例如：hello_world->HelloWorld
     * @param str 转换前字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String toCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        if (str == null || str.isEmpty()) {
            return "";
        } else if (!str.contains("_")) {
            // 不含下划线，不转换
            return firstCharUp(str);
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
        return result.toString();
    }
}

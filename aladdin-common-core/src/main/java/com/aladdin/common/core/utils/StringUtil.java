package com.aladdin.common.core.utils;

import com.aladdin.common.core.constant.CommonConstant;

/**
 * 字符串工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class StringUtil {

    public static final String FLAG_COLON = ":";

    public static final String FLAG_EQUAL = "=";

    public static final String FLAG_UNDERLINE = "_";

    private StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    public static String format(String template, Object... params) {
        if (isEmpty(template) || params == null || params.length == 0) {
            return template;
        }
        for (Object param : params) {
            template = template.replaceFirst("\\{\\}", param == null ? CommonConstant.UTF8 : param.toString());
        }
        return template;
    }

    public static String toCamelCase(String underscoreName) {
        if (isEmpty(underscoreName)) {
            return underscoreName;
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        for (char c : underscoreName.toCharArray()) {
            if (c == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(c));
                    nextUpper = false;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static String toUnderlineCase(String camelCaseName) {
        if (isEmpty(camelCaseName)) {
            return camelCaseName;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < camelCaseName.length(); i++) {
            char c = camelCaseName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String firstCharLower(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String firstCharUpper(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String getKeyString(String flag, String tempStr) {
        if (!isEmpty(tempStr) && appearStringNumber(tempStr, flag) == 1) {
            String[] tempStrArray = tempStr.split(flag);
            return tempStrArray[0];
        }
        return "";
    }

    public static String getValueString(String flag, String tempStr) {
        if (!isEmpty(tempStr) && appearStringNumber(tempStr, flag) == 1) {
            String[] tempStrArray = tempStr.split(flag);
            return tempStrArray[1];
        }
        return "";
    }

    public static int appearStringNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }
}

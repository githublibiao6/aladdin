package com.aladdin.common.core.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JSON工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class JsonUtil {

    private static final Pattern CONTROL_CHAR_PATTERN = Pattern.compile("\\p{C}");

    private JsonUtil() {
    }

    public static String toJson(Object obj) {
        return obj == null ? null : JSON.toJSONString(obj, JSONWriter.Feature.WriteMapNullValue);
    }

    public static String toJsonPretty(Object obj) {
        return obj == null ? null : JSON.toJSONString(obj, JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return isEmpty(json) ? null : JSON.parseObject(json, clazz, JSONReader.Feature.SupportSmartMatch);
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return isEmpty(json) ? null : JSON.parseArray(json, clazz);
    }

    public static boolean isJson(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            JSON.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String unicodeToString(String unicode) {
        if (isEmpty(unicode)) {
            return unicode;
        }
        StringBuilder sb = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            sb.append((char) data);
        }
        return sb.toString();
    }

    public static String stringToUnicode(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append("\\u").append(Integer.toHexString(c));
        }
        return sb.toString();
    }

    public static String escapeControlChars(String str) {
        if (isEmpty(str)) {
            return str;
        }
        Matcher m = CONTROL_CHAR_PATTERN.matcher(str);
        while (m.find()) {
            str = str.replace(m.group(), stringToUnicode(m.group()));
        }
        return str;
    }

    public static String unescapeControlChars(String str) {
        if (isEmpty(str)) {
            return str;
        }
        Matcher m = CONTROL_CHAR_PATTERN.matcher(str);
        while (m.find()) {
            str = str.replace(m.group(), unicodeToString(m.group()));
        }
        return str;
    }

    public static void toCamelCaseKeys(JSONObject object) {
        if (object == null || object.isEmpty()) {
            return;
        }
        Set<String> keys = object.keySet();
        JSONObject data = new JSONObject();
        keys.forEach(key -> {
            Object value = object.get(key);
            String field = StringUtil.firstCharLower(StringUtil.toCamelCase(key));
            data.put(field, value);
        });
        object.clear();
        object.putAll(data);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

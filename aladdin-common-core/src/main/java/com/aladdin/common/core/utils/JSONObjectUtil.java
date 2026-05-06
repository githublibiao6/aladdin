package com.aladdin.common.core.utils;

import com.alibaba.fastjson2.JSONObject;

import java.util.Map;

public class JSONObjectUtil {

    public static void getCamelCaseJSONObject(JSONObject json) {
        if (json == null || json.isEmpty()) {
            return;
        }
        String[] keys = json.keySet().toArray(new String[0]);
        for (String key : keys) {
            String camelKey = toCamelCase(key);
            if (!key.equals(camelKey)) {
                json.put(camelKey, json.get(key));
                json.remove(key);
            }
        }
    }

    private static String toCamelCase(String underscoreName) {
        if (underscoreName == null || underscoreName.isEmpty()) {
            return underscoreName;
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        for (int i = 0; i < underscoreName.length(); i++) {
            char c = underscoreName.charAt(i);
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
}

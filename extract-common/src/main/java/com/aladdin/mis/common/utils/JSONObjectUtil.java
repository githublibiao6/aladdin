package com.aladdin.mis.common.utils;

import com.aladdin.mis.common.string.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * d登录的用户
 * @author cles
 */
public  class JSONObjectUtil {

    /**
     * 获取当前用户
     * @return
     */
    public static void getCamelCaseJSONObject(JSONObject object) {
        if (object == null) {
            return;
        }
        Set<String> set = object.keySet();
        if(set.isEmpty()) {
            return;
        }
        JSONObject data = new JSONObject();
        set.forEach(s->{
            Object value = object.get(s);
            String field = StringUtil.firstCharLower(StringUtil.toCamelCase(s));
            data.put(field, value);
        });
        object.clear();
        object.putAll(data);
    }
}

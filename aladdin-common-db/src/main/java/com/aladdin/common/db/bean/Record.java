package com.aladdin.common.db.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库记录映射
 *
 * @author cles
 * @date 2026/04/30
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> map = new HashMap<>();

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getColumns() {
        return this.map;
    }

    public String getString(String column) {
        Object o = this.map.get(column);
        if (o == null) {
            return null;
        }
        return o.toString();
    }

    public void setString(String column, Object value) {
        this.map.put(column, value);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}

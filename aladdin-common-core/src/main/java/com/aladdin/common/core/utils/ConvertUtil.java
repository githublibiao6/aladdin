package com.aladdin.common.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据转换工具类
 *
 * @author cles
 * @date 2026/04/30
 */
public class ConvertUtil {

    private ConvertUtil() {
    }

    @SuppressWarnings("unchecked")
    public static void convertTree(List<Map<String, Object>> list, String idField, String parentField,
                                   String childrenField, String pid, boolean removeChildren) {
        List<Map<String, Object>> toRemove = new ArrayList<>();
        list.forEach(item -> {
            List<Map<String, Object>> children = new ArrayList<>();
            Object parentVal = item.get(parentField);
            if (pid.equals(parentVal == null ? null : parentVal.toString())) {
                for (Map<String, Object> record : list) {
                    Object recordParentVal = record.get(parentField);
                    Object itemIdVal = item.get(idField);
                    if (recordParentVal != null && itemIdVal != null
                            && recordParentVal.equals(itemIdVal)) {
                        children.add(record);
                    }
                }
                if (!children.isEmpty()) {
                    children.forEach(child -> convertTree(list, idField, parentField, childrenField,
                            String.valueOf(item.get(idField)), removeChildren));
                    item.put(childrenField, children);
                }
            }
            if (removeChildren) {
                toRemove.addAll(children);
            }
        });
        list.removeAll(toRemove);
    }
}

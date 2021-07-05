package com.apps.omnipotent.system.utils;
/**
 * Created by cles on 2020/5/30 0:33
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 转换工具类
 * @author cles
 * @Date 2020/5/30 0:33
 */
public class ConvertUtils {

    /**
    * @Description:  list 转换为tree
    * @Param: [list, pid]
    * @return: void
    * @Author: cles
    * @Date: 2020/5/30 0:34
    */
    public static void convertTree(List<Map> list, String idField, String parentField,
                             String childrenField , String pid, boolean removeChildren){
        list.forEach(t->{
            List<Map> children = new ArrayList<>();
            if(pid.equals(t.get(parentField))){
                for (Map record : list) {
                    if(record.get(parentField).equals(t.get(idField))){
                        children.add(record);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertTree(list,idField,parentField,childrenField,t.get(idField).toString(),removeChildren);
                    });
                    t.put(childrenField,children);
                }
            }
            if(removeChildren){
                children.forEach(list::remove);
            }
        });
    }
}

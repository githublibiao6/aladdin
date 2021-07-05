package com.apps.omnipotent.system.bean;
/**
 * Created by cles on 2020/5/10 23:24
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 实体
 * @author cles
 * @Date 2020/5/10 23:24
 */
public class Record  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String , Object> map = new HashMap<>();

    public void setMap(Map<String , Object> map){
        this.map = map;
    }

    public Map<String , Object> getColumns(){
        return this.map;
    }

    public String getString(String column){
        Object o = this.map.get(column);
        if(o == null){
            return null;
        }
        return o.toString();
    }

    public void setString(String column, Object value){
        this.map.put(column,value);
    }

    @Override
    public String toString(){
        System.err.println(map.toString());
        return map.toString();
    }

    public String toJson(){
        System.err.println(map.toString());
        return map.toString();
    }
}

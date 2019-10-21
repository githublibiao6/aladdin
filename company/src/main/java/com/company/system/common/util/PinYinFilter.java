package com.company.system.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 拼音首字母过滤辅助类
 * @author lb
 * @date 2018年6月23日 下午7:39:29
 */
public class PinYinFilter  {

    
    /*public <T>  List<T>   filterByFirstletter (List<T> beforeFilterList,String methodName,String firstLetter) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        if(beforeFilterList!=null&&methodName!=null){
            List<T> aftreFilterList=new ArrayList<T>();
            for(T obj:beforeFilterList){
                if(firstLetter!=null&&!firstLetter.equals("")){
                    Method method=obj.getClass().getMethod(methodName);
                    String firstChar=((String)method.invoke(obj)).substring(0,1);
                    if(firstChar.matches("^[\u4e00-\u9fa5]$")){
                        String[] pinyins=PinyinHelper.toHanyuPinyinStringArray(firstChar.charAt(0));
                        for(String pinyin:pinyins){
                            if(pinyin.substring(0, 1).equalsIgnoreCase(firstLetter)){
                                if(!aftreFilterList.contains(obj)){
                                    aftreFilterList.add(obj);
                                }
                            }
                        }
                    }else{
                        if(firstChar.matches("^[a-zA-Z]$")){
                            if(firstChar.equalsIgnoreCase(firstLetter)){
                                aftreFilterList.add(obj);
                                }
                            }
                        }
                    }else{
                        aftreFilterList.add(obj);
                        }
                }
            return aftreFilterList;
            }else{
                return null;
                }
        }
public  List<Map> filterByFirstletterForMap(List<Map>  beforeFilterList,String key,String firstLetter){
    if(beforeFilterList!=null&&key!=null){
        List<Map> aftreFilterList=new ArrayList<Map>();
            for(Map map:beforeFilterList){
                if(firstLetter!=null&&!firstLetter.equals("")){
                    String firstChar=((String)map.get(key)).substring(0, 1);
                    if(firstChar.matches("^[\u4e00-\u9fa5]$")){
                        System.out.println(firstChar);
                        String[] pinyins=PinyinHelper.toHanyuPinyinStringArray(firstChar.charAt(0));
                        System.out.println(Arrays.asList(pinyins));
                        for(String pinyin:pinyins){
                            if(pinyin.substring(0, 1).equalsIgnoreCase(firstLetter)){
                                System.out.println(pinyin.substring(0, 1));
                                if(!aftreFilterList.contains(map)){
                                    aftreFilterList.add(map);
                                    }
                                }
                            }
                        }else{
                            if(firstChar.matches("^[a-zA-Z]$")){
                                if(firstChar.equalsIgnoreCase(firstLetter)){
                                    aftreFilterList.add(map);
                                    }
                                }
                            }
                    }else{
                        aftreFilterList.add(map);
                        }
                }
            return aftreFilterList;
            }
    return null;
    }*/
}

package com.company.system.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 拼音与首个汉字的映射关系，用于根据首字母检索数据的数据库查询
 * @author lb
 * @date 2018年6月23日 下午7:48:32
 */
public class PingYinMapper {
    // gb2312 编码 字母与字母对应的首个汉字
    public static final Map<String, String> mapper_gb2312 
        = new HashMap<String, String>();
    // 通过静态代码块初始化
    static{
        mapper_gb2312.put("A", "啊");
        mapper_gb2312.put("B", "芭");
        mapper_gb2312.put("C", "擦");
        mapper_gb2312.put("D", "搭");
        mapper_gb2312.put("E", "蛾");
        mapper_gb2312.put("F", "发");
        mapper_gb2312.put("G", "噶");
        mapper_gb2312.put("H", "哈");
        mapper_gb2312.put("I", "击");//无
        mapper_gb2312.put("J", "击");
        mapper_gb2312.put("K", "喀");
        mapper_gb2312.put("L", "垃");
        mapper_gb2312.put("M", "呒");
        mapper_gb2312.put("N", "拿");
        mapper_gb2312.put("O", "哦");
        mapper_gb2312.put("P", "啪");
        mapper_gb2312.put("Q", "期");
        mapper_gb2312.put("R", "然");
        mapper_gb2312.put("S", "撒");
        mapper_gb2312.put("T", "塌");
        mapper_gb2312.put("U", "挖");
        mapper_gb2312.put("V", "挖");
        mapper_gb2312.put("W", "挖");
        mapper_gb2312.put("X", "昔");
        mapper_gb2312.put("Y", "压");
        mapper_gb2312.put("Z", "匝");
    }
}

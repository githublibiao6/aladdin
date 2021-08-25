package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.util.List;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateXmlUtils {

    public static void writeXmlToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
        content.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> \n");
        content.append("<mapper namespace=\""+po.getImportDaoClass().substring(7,po.getImportDaoClass().length()-1 )+"\">\n\n");
        content.append("    <sql id=\"baseColumn\">\n");

        List<TableFieldInfo> fields = tableInfo.getFields();

        fields.forEach(t->{
            content.append("        "+ t.getColName() +",\n");
        });
        content.delete(content.length()-2, content.length());
        content.append("\n  </sql>\n");
        content.append("    <resultMap type=\""+po.getImportEntityClass().substring(7,po.getImportEntityClass().length() -1)+"\" id=\"baseResultMap\"> \n");

        fields.forEach(t->{
            if("id".equals(t.getColumnName())){
                content.append("        <id property=\"id\" column=\"id\"/>\n");
            }else {
                content.append("        <result property=\""+t.getColName()+"\" column=\""+t.getColumnName()+"\"/>\n");
            }
        });

        content.append("    </resultMap>\n\n");
        content.append("<select id=\"paginate\" resultType=\""+po.getImportEntityVoClass().substring(7,po.getImportEntityVoClass().length()-1 )+"\">\n" +
                "        select <include refid=\"baseColumn\"></include>\n" +
                "        from "+tableInfo.getTableName()+" t where 1=1\n");

        fields.forEach(t->{
            content.append("        <if test=\""+t.getColumnName()+"!= null and "+t.getColumnName()+" != '' "+"\">\n" +
                    "            and t."+t.getColName()+" = #{"+t.getColumnName()+"}\n" +
                    "        </if>\n" );
        });

        content.append("    </select>");
        content.append("</mapper>\n");

        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Dao.xml", po.isOverWrite());
    }
}

package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableFieldInfo;
import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.utils.CommonFileUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateXmlUtils {

    public static void writeXmlToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer();
        content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
        content.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> \n");
        content.append("<mapper namespace=\""+po.getImportDaoClass().substring(7,po.getImportDaoClass().length()-1 )+"\">\n\n");
        content.append("    <sql id=\"baseColumn\">\n");

        List<TableFieldInfo> fields = tableInfo.getFields();

        fields.forEach(t->{
            content.append("        t."+ t.getColName() +",\n");
        });
        content.delete(content.length()-2, content.length());
        content.append("\n    </sql>\n\n");
        content.append("    <resultMap id=\"baseResultMap\" type=\""+po.getImportEntityClass().substring(7,po.getImportEntityClass().length() -1)+"\" > \n");

        fields.forEach(t->{
            if("id".equals(t.getColumnName())){
                content.append("        <id property=\"id\" column=\"id\"/>\n");
            }else if(t.getColumnType().startsWith("List")){
                content.append("        <result property=\""+t.getColName()+"\" column=\""+t.getColumnName()+"\"  typeHandler=\"com.aladdin.mis.dao.handle.ListTypeHandler\" />\n");
            }else {
                content.append("        <result property=\""+t.getColName()+"\" column=\""+t.getColumnName()+"\"/>\n");
            }
        });

        content.append("    </resultMap>\n\n");
        content.append("    <select id=\"list\" resultType=\""+po.getImportEntityVoClass().substring(7,po.getImportEntityVoClass().length()-1 )+"\">\n" +
                "        select <include refid=\"baseColumn\"></include>\n" +
                "        from "+tableInfo.getTableName()+" t where t.sys005 = 1\n");

        String s = "id,sys000,sys001,sys002,sys003,sys004,sys005,sys006,sys007";
        Set<String > set = new HashSet<>(Arrays.asList(s.split(",")));

        fields.forEach(t->{
            if(set.contains(t.getColumnName())){
                return;
            }
            content.append("        <if test=\""+t.getColumnName()+"  != null and "+t.getColumnName()+" != '' "+"\">\n" +
                    "            and t."+t.getColName()+" = #{"+t.getColumnName()+"}\n" +
                    "        </if>\n" );
        });
        content.append("        <if test= \" sortInfo  != null and sortInfo != '' "+"\">\n" +
                "           order by ${sortInfo}\n" +
                "        </if>\n" );
        content.append("    </select>\n\n");


        System.err.println(content);
        String oldContent = CommonFileUtil.readContentToFile(po.getFilePath(), po.getEntityName()+"Dao.xml");
        if(oldContent != null){
            oldContent = oldContent.substring(oldContent.indexOf("<!-- *************GenerateXmlUtils************** -->"));
            boolean result = CommonFileUtil.writeContentToFile(content.toString() + "    " + oldContent,
                    po.getFilePath(), po.getEntityName()+"Dao.xml", true);
        }else {
            content.append("    <!-- *************GenerateXmlUtils************** -->\n");
            content.append("</mapper>\n");
            boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                    po.getFilePath(), po.getEntityName()+"Dao.xml", true);
        }
    }
}

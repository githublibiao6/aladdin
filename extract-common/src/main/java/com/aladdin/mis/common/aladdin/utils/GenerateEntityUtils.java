package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateEntityUtils {

    public static void writeContentToFile(GeneratePo po){

        TableInfo tableInfo = po.getTableInfo();

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +"\n\n");
        content.append(po.getTablePath()+" \n");
        content.append(po.getBaseModelPath() +" \n");
        content.append("import lombok.Data; \n\n");
        content.append("/**\n");
        content.append(" * "+ tableInfo.getTableComment() +"\n");
        content.append(" * @author cles \n");
        content.append(" * @date "+ LocalDateTime.now() +" \n");
        content.append("*/ \n");
        content.append("@Table(\""+ tableInfo.getTableName()+"\") \n");
        content.append("@Data \n");
        content.append("public class "+tableInfo.getClassName()+" extends GlobalModel { \n");

        List<TableFieldInfo> fields = tableInfo.getFields();
        fields.forEach(t->{
            content.append("    /*");
            content.append("    *"+t.getColumnComment());
            content.append("    */");
            content.append("    @TableField(\""+t.getColumnName()+"\")");
            content.append("    private "+t.getColType()+" "+ t.getColumnName());
            content.append("\n");
        });

        content.append("} \n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),  po.getFilePath(), "Data.java");
    }
}

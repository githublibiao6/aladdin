package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateEntityUtils {

    public static void writeEntityToFile(GeneratePo po){

        TableInfo tableInfo = po.getTableInfo();

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getTablePath()+"\n");
        content.append(po.getTableFieldPath()+"\n");
        content.append(po.getBaseModelPath() +"\n");
        content.append("import java.util.Date;\n");

        content.append("import lombok.Data;\n\n");
        content.append("/**\n");
        content.append(" * "+ tableInfo.getTableComment() +"\n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@Table(\""+ tableInfo.getTableName()+"\")\n");
        content.append("@Data\n");
        content.append("public class "+StringUtil.toCamelCase(tableInfo.getTableName())+" extends GlobalModel {\n");

        List<TableFieldInfo> fields = tableInfo.getFields();

        String s = "id,sys001,sys002,sys003,sys004,sys005,sys005,sys007";
        Set<String >set = new HashSet<>(Arrays.asList(s.split(",")));

        fields.forEach(t->{
            if(set.contains(t.getColName())){
                return;
            }
            content.append("    /**\n");
            content.append("    *  "+t.getColumnName()+t.getColumnComment()==null?"":t.getColumnComment() +"\n");
            content.append("    */\n");
            content.append("    @TableField(\""+t.getColName()+"\")\n");
            content.append("    private "+t.getColumnType()+" "+ t.getColumnName() +";\n");
            content.append("\n");
        });

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName() +".java", true);
    }
}

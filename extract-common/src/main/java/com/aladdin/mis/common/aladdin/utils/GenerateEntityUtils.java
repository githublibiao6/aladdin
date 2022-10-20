package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.common.utils.CommonFileUtil;
import com.aladdin.mis.system.db.entity.TableFieldInfo;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getTablePath()).append("\n");
        content.append(po.getTableFieldPath()).append("\n");
        content.append(po.getBaseModelPath()).append("\n");
        content.append("import java.time.LocalDateTime;\n");
        content.append("import java.time.LocalDate;\n");
        content.append("import java.util.List;\n");
        content.append("import com.fasterxml.jackson.annotation.JsonFormat;\n");
        content.append("import org.springframework.format.annotation.DateTimeFormat;\n");

        content.append("import lombok.Data;\n\n");
        content.append("/**\n");
        content.append(" * ").append(tableInfo.getTableComment()).append("\n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");
        content.append("@Table(\"").append(tableInfo.getTableName()).append("\")\n");
        content.append("@Data\n");
        content.append("public class ").append(StringUtil.toCamelCase(tableInfo.getTableName()))
                .append(" extends GlobalModel {\n\n");

        List<TableFieldInfo> fields = tableInfo.getFields();

        String s = "id,sys001,sys002,sys003,sys004,sys005,sys006,sys007";
        Set<String >set = new HashSet<>(Arrays.asList(s.split(",")));

        fields.forEach(t->{
            if(set.contains(t.getColName())){
                return;
            }
            content.append("    /**\n");
            content.append("     * "+t.getColumnName()+(t.getColumnComment()==null?"":t.getColumnComment()) +"\n");
            content.append("     */\n");
            content.append("    @TableField(\""+t.getColName()+"\")\n");
            if("Date".equals(t.getColumnType()) || "LocalDate".equals(t.getColumnType())){
                content.append("    @JsonFormat(pattern=\"yyyy-MM-dd\",timezone=\"GMT+8\")\n");
                content.append("    @DateTimeFormat(pattern = \"yyyy-MM-dd\")\n");
            }
            if("DateTime".equals(t.getColumnType()) || "LocalDateTime".equals(t.getColumnType())){
                content.append("    @JsonFormat(pattern=\"yyyy-MM-dd HH:mm:ss\",timezone=\"GMT+8\")\n");
                content.append("    @DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")\n");
            }
            content.append("    private "+t.getColumnType()+" "+ t.getColumnName() +";\n");
            content.append("\n");
        });

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName() +".java", true);
    }
}

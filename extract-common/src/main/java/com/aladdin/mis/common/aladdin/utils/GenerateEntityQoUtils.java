package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateEntityQoUtils {

    public static void writeEntityToFile(GeneratePo po){

        TableInfo tableInfo = po.getTableInfo();

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass()+"\n");
        content.append("import java.util.Date;\n");
        content.append("import com.fasterxml.jackson.annotation.JsonFormat;\n");
        content.append("import org.springframework.format.annotation.DateTimeFormat;\n");

        content.append("import lombok.Data;\n\n");
        content.append("/**\n");
        content.append(" * "+ tableInfo.getTableComment() +"查询实体 \n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@Data\n");
        content.append("public class "+StringUtil.toCamelCase(tableInfo.getTableName())+"Qo extends "+po.getEntityName()+" {\n\n");
        content.append("    private Integer page;\n\n");
        content.append("    private Integer limit;\n\n");
        content.append("    /**\n");
        content.append("    * 关键字条件过滤 \n");
        content.append("     */\n");
        content.append("    private String  keyWord;\n");
        content.append("    /**\n");
        content.append("    * 排序条件 \n");
        content.append("     */\n");
        content.append("    private String  sortInfo;\n");
        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName() +"Qo.java", true);
    }
}

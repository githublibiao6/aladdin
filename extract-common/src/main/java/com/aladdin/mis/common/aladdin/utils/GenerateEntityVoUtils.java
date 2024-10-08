package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.common.utils.CommonFileUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateEntityVoUtils {

    public static void writeEntityToFile(GeneratePo po){

        TableInfo tableInfo = po.getTableInfo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass()+"\n");
        content.append("import java.util.Date;\n");
        content.append("import com.fasterxml.jackson.annotation.JsonFormat;\n");
        content.append("import org.springframework.format.annotation.DateTimeFormat;\n");

        content.append("import lombok.Data;\n\n");
        content.append("/**\n");
        content.append(" * "+ tableInfo.getTableComment() +"应用层实体 \n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");
        content.append("@Data\n");
        content.append("public class "+StringUtil.toCamelCase(tableInfo.getTableName())+"Vo extends "+po.getEntityName()+" {\n\n");

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName() +"Vo.java", po.isOverWrite());
    }
}

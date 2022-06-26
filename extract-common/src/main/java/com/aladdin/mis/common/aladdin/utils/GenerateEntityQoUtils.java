package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.common.utils.CommonFileUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateEntityQoUtils {

    public static void writeEntityToFile(GeneratePo po){

        TableInfo tableInfo = po.getTableInfo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass()).append("\n");
        content.append("import java.util.Date;\n");
        content.append("import com.fasterxml.jackson.annotation.JsonFormat;\n");
        content.append("import org.springframework.format.annotation.DateTimeFormat;\n");

        content.append("import lombok.Data;\n\n");
        content.append("/**\n");
        content.append(" * ").append(tableInfo.getTableComment()).append("查询实体 \n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");
        content.append("@Data\n");
        content.append("public class ").append(StringUtil.toCamelCase(tableInfo.getTableName())).append("Qo extends ").append(po.getEntityName()).append(" {\n\n");
        content.append("    private Integer page;\n\n");
        content.append("    private Integer limit;\n\n");
        content.append("    /**\n");
        content.append("     * 关键字条件过滤 \n");
        content.append("     */\n");
        content.append("    private String  keyWord;\n");
        content.append("    /**\n");
        content.append("     * 排序条件 \n");
        content.append("     */\n");
        content.append("    private String  sortInfo;\n");
        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName() +"Qo.java", true);
    }
}

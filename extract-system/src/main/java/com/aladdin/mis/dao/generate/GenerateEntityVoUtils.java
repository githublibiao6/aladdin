package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.core.utils.StringUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateEntityVoUtils {

    public static void writeEntityToFile(GeneratePo po, FileWriteFunction writeFn){

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
        content.append("public class "+ StringUtil.toCamelCase(tableInfo.getTableName())+"Vo extends "+po.getEntityName()+" {\n\n");

        content.append("}\n");
        writeFn.write(content.toString(), po.getFilePath(), po.getEntityName() +"Vo.java", po.isOverWrite());
    }
}

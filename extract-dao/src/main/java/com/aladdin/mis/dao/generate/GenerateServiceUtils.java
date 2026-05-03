package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.core.utils.StringUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateServiceUtils {

    public static void writeServiceToFile(GeneratePo po, FileWriteFunction writeFn){
        TableInfo tableInfo = po.getTableInfo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getBaseServicePath() +"\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append(po.getImportEntityVoClass() +"\n");
        content.append(po.getImportEntityQoClass() +"\n");
        content.append("import com.github.pagehelper.PageInfo;\n");

        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");

        content.append("public interface "+ po.getEntityName() +"Service extends GlobalService<"+po.getEntityName()+">  {\n\n");

        content.append("}\n");
        writeFn.write(content.toString(), po.getFilePath(), StringUtil.toCamelCase(tableInfo.getTableName())+"Service.java", po.isOverWrite());
    }
}

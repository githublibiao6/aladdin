package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateServiceUtils {

    public static void writeServiceToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getBaseServicePath() +"\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("public interface "+ po.getEntityName() +"Service extends GlobalService<"+po.getEntityName()+">  {\n");

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), StringUtil.toCamelCase(tableInfo.getTableName())+"Service.java", false);
    }
}

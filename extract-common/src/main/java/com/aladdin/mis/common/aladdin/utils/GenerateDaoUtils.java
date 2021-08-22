package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateDaoUtils {

    public static void writeDaoToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append("import org.springframework.stereotype.Repository;\n\n");
        content.append("import java.util.List;\n");
        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@Repository\n");
        content.append("public interface "+ po.getEntityName() +"Dao {\n");

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Dao.java", true);
    }
}

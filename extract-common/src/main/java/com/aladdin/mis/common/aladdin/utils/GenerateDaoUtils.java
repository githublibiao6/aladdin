package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.utils.CommonFileUtil;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateDaoUtils {

    public static void writeDaoToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass()).append("\n");
        content.append(po.getImportEntityQoClass()).append("\n");
        content.append(po.getImportEntityVoClass()).append("\n");
        content.append("import org.springframework.stereotype.Repository;\n\n");
        content.append("import java.util.List;\n");
        content.append("/**\n");
        content.append(" * ").append(po.getEntityName()).append("Dao\n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(LocalDateTime.now()).append("\n");
        content.append("*/\n");
        content.append("@Repository\n");
        content.append("public interface ").append(po.getEntityName()).append("Dao {\n");

        content.append("    /**\n" +
                "     * 列表\n" +
                "     * @param qo\n" +
                "     * @return list\n" +
                "     */\n" +
                "    List<"+po.getEntityName()+"Vo> list("+po.getEntityName()+"Qo qo);");

        content.append("\n}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Dao.java", po.isOverWrite());
    }
}

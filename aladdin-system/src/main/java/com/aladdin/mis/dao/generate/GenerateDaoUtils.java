package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;

import java.time.LocalDateTime;

public class GenerateDaoUtils {

    public static void writeDaoToFile(GeneratePo po, FileWriteFunction writeFn){
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
        content.append("public interface ").append(po.getEntityName()).append("Dao {\n\n");

        content.append("    /**\n" +
                "     * 列表\n" +
                "     * @param qo\n" +
                "     * @return list\n" +
                "     */\n" +
                "    List<"+po.getEntityName()+"Vo> list("+po.getEntityName()+"Qo qo);");

        content.append("\n}\n");
        writeFn.write(content.toString(), po.getFilePath(), po.getEntityName()+"Dao.java", po.isOverWrite());
    }
}

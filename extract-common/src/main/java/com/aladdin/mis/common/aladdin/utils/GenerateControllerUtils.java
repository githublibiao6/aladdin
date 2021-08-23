package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateControllerUtils {

    public static void writeControllerToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append(po.getImportServiceClass() +"\n");
        content.append(po.getBaseControllerPath() +"\n");
        content.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
        content.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.stereotype.Controller;\n\n");
        content.append("import java.util.List;\n");
        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@RequestMapping(\""+ StringUtil.firstCharLower(po.getEntityName()) +"\")\n");
        content.append("@Controller\n");
        content.append("public class "+ po.getEntityName() +"Controller  extends GlobalController {\n");
        content.append("    @Autowired\n");
        content.append("    private "+po.getEntityName()+"Service "+ StringUtil.firstCharLower(po.getEntityName())+"Service;\n\n");

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Controller.java", false);
    }
}

package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.core.utils.StringUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateControllerUtils {

    public static void writeControllerToFile(GeneratePo po, FileWriteFunction writeFn){
        TableInfo tableInfo = po.getTableInfo();
        String tableComment = tableInfo.getTableComment();
        tableComment = tableComment == null?"":tableComment;
        StringBuilder content = new StringBuilder("package "+ po.getPackagePath() +";\n\n");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);
        content.append(po.getImportEntityClass()).append("\n");
        content.append(po.getImportServiceClass()).append("\n");
        content.append(po.getBaseControllerPath()).append("\n");
        content.append(po.getImportEntityQoClass()).append("\n");
        content.append(po.getImportEntityVoClass()).append("\n");
        content.append(po.getWebLogPath()).append("\n");
        content.append("import com.aladdin.mis.common.system.entity.Result;\n");
        content.append("import com.github.pagehelper.PageInfo;\n");
        content.append("import com.aladdin.mis.base.service.GlobalService;\n");
        content.append("import org.springframework.web.bind.annotation.RequestBody;\n");
        content.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
        content.append("import org.springframework.web.bind.annotation.PostMapping;\n");
        content.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.stereotype.Controller;\n\n");
        content.append("import java.util.List;\n\n");
        content.append("/**\n");
        content.append(" * ").append(tableComment).append(" ").append(po.getEntityName()).append("Service--- \n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");
        content.append("@RequestMapping(\"/"+ StringUtil.firstCharLower(po.getEntityName()) +"\")\n");
        content.append("@Controller\n");
        content.append("public class "+ po.getEntityName() +"Controller  extends GlobalController<"+ po.getEntityName() +", "+ po.getEntityName() +"Service> {\n\n");

        content.append("}\n");
        writeFn.write(content.toString(), po.getFilePath(), po.getEntityName()+"Controller.java", po.isOverWrite());
    }
}

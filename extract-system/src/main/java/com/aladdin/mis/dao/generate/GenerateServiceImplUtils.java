package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;
import com.aladdin.common.core.utils.StringUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateServiceImplUtils {

    public static void writeServiceImplToFile(GeneratePo po, FileWriteFunction writeFn){
        TableInfo tableInfo = po.getTableInfo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = dtf.format(now);

        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getBaseServiceImplPath() +"\n");
        content.append(po.getImportServiceClass() +"\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append(po.getImportEntityVoClass() +"\n");
        content.append(po.getImportEntityQoClass() +"\n");
        content.append(po.getImportDaoClass() +"\n");
        content.append("import com.github.pagehelper.PageHelper;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import com.github.pagehelper.PageInfo;\n\n");
        content.append("import java.util.List;\n");
        content.append("import org.springframework.stereotype.Service;\n\n");

        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");

        content.append("@Service\n");
        content.append("public class "+ po.getEntityName() +"ServiceImpl extends GlobalServiceImpl<"+po.getEntityName()+"> implements "+ po.getEntityName() +"Service{\n\n");
        content.append("    @Autowired\n");
        String dao = StringUtil.firstCharLower(po.getEntityName())+"Dao";
        content.append("    private "+po.getEntityName()+"Dao "+ dao +";\n\n");

        content.append("}\n\n");
        writeFn.write(content.toString(), po.getFilePath(), po.getEntityName()+"ServiceImpl.java", po.isOverWrite());
    }
}

package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.file.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateServiceImplUtils {

    public static void writeServiceImplToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();


        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getBaseServiceImplPath() +"\n");
        content.append(po.getImportServiceClass() +"\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append(po.getImportEntityQoClass() +"\n");
        content.append(po.getImportDaoClass() +"\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.stereotype.Service;\n");
        content.append("import com.github.pagehelper.PageInfo;\n");
        content.append("/**\n");
        content.append(" * "+ po.getEntityName() +"Service\n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@Service\n");
        content.append("public class "+ po.getEntityName() +"ServiceImpl extends GlobalServiceImpl<"+po.getEntityName()+"> implements "+ po.getEntityName() +"Service{\n");
        content.append("    @Autowired\n");
        content.append("    private "+po.getEntityName()+"Dao "+ StringUtil.firstCharLower(po.getEntityName())+"Dao;\n\n");

        content.append("    /**\n" +
                "     * 分页查询\n" +
                "     * @param qo\n" +
                "     * @return\n" +
                "     */\n" +
                "   @Override\n" +
                "    public PageInfo<Project> paginate("+po.getEntityName()+"Qo qo){\n" +
                "       return null;\n" +
                "}\n");

        content.append("    @Override\n" +
                "    public boolean remove(Project entity) {\n" +
                "        return delete(entity);\n" +
                "    }\n");

        content.append("    @Override\n" +
                "    public boolean update(Project entity) {\n" +
                "        return updateSelective(entity);\n" +
                "    }\n");

        content.append("    @Override\n" +
                "    public Project save(Project entity) {\n" +
                "        return insertSelective(entity);\n" +
                "    }\n");

        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"ServiceImpl.java", po.isOverWrite());
    }
}

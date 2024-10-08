package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.common.utils.CommonFileUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateServiceImplUtils {

    public static void writeServiceImplToFile(GeneratePo po){
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

//        content.append("    /**\n" +
//                "     * 分页查询\n" +
//                "     * @param qo\n" +
//                "     * @return\n" +
//                "     */\n" +
//                "   @Override\n" +
//                "    public PageInfo<"+po.getEntityName()+"Vo> paginate("+po.getEntityName()+"Qo qo){\n" +
//                "       PageHelper.offsetPage(qo.getPage(), qo.getLimit());\n" +
//                "       List<"+po.getEntityName()+"Vo> list = "+dao+".list(qo);\n" +
//                "       return new PageInfo<>(list);\n" +
//                "}\n");
//
//        content.append("    /**\n" +
//                "     * 查询详情\n" +
//                "     * @param qo\n" +
//                "     * @return\n" +
//                "     */\n" +
//                "   @Override\n" +
//                "    public "+po.getEntityName()+" detail("+po.getEntityName()+" qo){\n" +
//                "       return detailQuery(qo.getId());\n" +
//                "}\n");
//
//        content.append("    @Override\n" +
//                "    public boolean remove("+po.getEntityName()+" entity) {\n" +
//                "       return delete(entity);\n" +
//                "    }\n\n");
//
//        content.append("    @Override\n" +
//                "    public boolean update("+po.getEntityName()+" entity) {\n" +
//                "       return updateSelective(entity);\n" +
//                "    }\n\n");
//
//        content.append("    @Override\n" +
//                "    public "+po.getEntityName()+" save("+po.getEntityName()+" entity) {\n" +
//                "       return insertSelective(entity);\n" +
//                "    }\n\n");

        content.append("}\n\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"ServiceImpl.java", po.isOverWrite());
    }
}

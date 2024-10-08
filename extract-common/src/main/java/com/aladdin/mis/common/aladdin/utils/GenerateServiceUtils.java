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
public  class GenerateServiceUtils {

    public static void writeServiceToFile(GeneratePo po){
        TableInfo tableInfo = po.getTableInfo();
        String  tableComment = tableInfo.getTableComment();
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

//        content.append("\n    /**\n" +
//                "     * 分页查询\n" +
//                "     * @param qo\n" +
//                "     * @return\n" +
//                "     */\n" +
//                "    PageInfo<"+po.getEntityName()+"Vo> paginate("+po.getEntityName()+"Qo qo);\n\n");
//
//        content.append("    /**\n" +
//                "     * 查询详情\n" +
//                "     * @param qo\n" +
//                "     * @return entity\n" +
//                "     */\n" +
//                "    "+po.getEntityName()+" detail("+po.getEntityName()+" qo);\n\n");
//
//        content.append("    /**\n" +
//                "     * 删除"+tableComment+"\n" +
//                "     * @param entity\n" +
//                "     * @return flag\n" +
//                "     */\n" +
//                "    boolean remove("+po.getEntityName()+" entity);\n\n");
//
//        content.append("    /**\n" +
//                "     * 更新"+tableComment+"\n" +
//                "     * @param entity\n" +
//                "     * @return flag\n" +
//                "     */\n" +
//                "    boolean update("+po.getEntityName()+" entity);\n\n");
//
//        content.append("    /**\n" +
//                "     * 保存"+tableComment+"\n" +
//                "     * @param entity\n" +
//                "     * @return m\n" +
//                "     */\n" +
//                "    "+po.getEntityName()+" save("+po.getEntityName()+" entity);\n\n");
        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), StringUtil.toCamelCase(tableInfo.getTableName())+"Service.java",  po.isOverWrite());
    }
}

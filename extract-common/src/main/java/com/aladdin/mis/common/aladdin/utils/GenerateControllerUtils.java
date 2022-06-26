package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.utils.CommonFileUtil;
import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.system.db.entity.TableInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateControllerUtils {

    public static void writeControllerToFile(GeneratePo po){
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
        content.append(po.getWeoLogPath()).append("\n");
        content.append("import com.aladdin.mis.common.system.entity.Result;\n");
        content.append("import com.github.pagehelper.PageInfo;\n");
        content.append("import com.aladdin.mis.common.system.service.GlobalService;\n");
        content.append("import org.springframework.web.bind.annotation.RequestBody;\n");
        content.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
        content.append("import org.springframework.web.bind.annotation.PostMapping;\n");
        content.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.stereotype.Controller;\n\n");
        content.append("import java.util.List;\n");
        content.append("/**\n");
        content.append(" * ").append(tableComment).append(" ").append(po.getEntityName()).append("Service--- \n");
        content.append(" * @author cles\n");
        content.append(" * @date ").append(nowStr).append("\n");
        content.append("*/\n");
        content.append("@RequestMapping(\""+po.getModule()+"/"+ StringUtil.firstCharLower(po.getEntityName()) +"\")\n");
        content.append("@Controller\n");
        content.append("public class "+ po.getEntityName() +"Controller  extends GlobalController<"+ po.getEntityName() +", "+ po.getEntityName() +"Service> {\n\n");
        content.append("    @Autowired\n");
        String service = StringUtil.firstCharLower(po.getEntityName())+"Service";
        content.append("    private "+po.getEntityName()+"Service "+ service+";\n\n");

        content.append("\n" +
        "    @Override\n" +
        "    protected GlobalService<"+po.getEntityName()+"> getBaseService(){\n" +
        "        return "+service+" ;\n" +
        "    }\n\n");

//        content.append("    /**\n" +
//                "     * 分页查询"+tableComment+"\n" +
//                "     */\n" +
//                "    @PostMapping(\"paginate\")\n" +
//                "    @WebLog(\"分页查询 "+tableComment+"\")\n" +
//                "    @ResponseBody\n" +
//                "    public Result paginate(@RequestBody "+po.getEntityName()+"Qo qo){\n" +
//                "        PageInfo<"+po.getEntityName()+"Vo> page = "+service+".paginate(qo);\n" +
//                "        result.setData(page);\n" +
//                "        return result ;\n" +
//                "    }\n\n");
//
//        content.append("    /**\n" +
//                "     * 查询"+tableComment+"详情\n" +
//                "     */\n" +
//                "    @PostMapping(\"detail\")\n" +
//                "    @WebLog(\"查询 "+tableComment+"详情\")\n" +
//                "    @ResponseBody\n" +
//                "    public Result detail(@RequestBody "+po.getEntityName()+" qo){\n" +
//                "        "+po.getEntityName()+" entity = "+service+".detail(qo);\n" +
//                "        result.setData(entity);\n" +
//                "        return result ;\n" +
//                "    }\n\n");
//
//        content.append("    /**\n" +
//                "     * 保存"+tableComment+"\n" +
//                "     */\n" +
//                "    @PostMapping(\"save\")\n" +
//                "    @WebLog(\""+tableComment+"保存\")\n" +
//                "    @ResponseBody\n" +
//                "    public Result save(@RequestBody "+po.getEntityName()+" entity){\n" +
//                "        "+po.getEntityName()+" data = "+service+".save(entity);\n" +
//                "        result.setData(data);\n" +
//                "        return result ;\n" +
//                "    }\n\n");
//
//        content.append("    /**\n" +
//                "     * 删除"+tableComment+"\n" +
//                "     */\n" +
//                "    @PostMapping(\"delete\")\n" +
//                "    @WebLog(\"删除"+tableComment+"\")\n" +
//                "    @ResponseBody\n" +
//                "    public Result delete(@RequestBody "+po.getEntityName()+" entity){\n" +
//                "        boolean flag = "+service+".remove(entity);\n" +
//                "        if(flag){\n" +
//                "            result.setData(entity);\n" +
//                "            result.setMessage(\"刪除成功\");\n" +
//                "        }else {\n" +
//                "            result.setMessage(\"刪除失败\");\n" +
//                "        }\n" +
//                "        return result ;\n" +
//                "    }\n\n");
//
//        content.append("    /**\n" +
//                "     * 更新"+tableComment+"\n" +
//                "     */\n" +
//                "    @PostMapping(\"update\")\n" +
//                "    @WebLog(\""+tableComment+"更新\")\n" +
//                "    @ResponseBody\n" +
//                "    public Result update(@RequestBody "+po.getEntityName()+" entity){\n" +
//                "        boolean flag = "+service+".update(entity);\n" +
//                "        if(flag){\n" +
//                "            result.setData(entity);\n" +
//                "            result.setMessage(\"更新成功\");\n" +
//                "        }else {\n" +
//                "            result.setMessage(\"更新失败\");\n" +
//                "        }\n" +
//                "        return result ;\n" +
//                "    }\n\n");


        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Controller.java", po.isOverWrite());
    }
}

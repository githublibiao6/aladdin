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
        String tableComment = tableInfo.getTableComment();
        tableComment = tableComment == null?"":tableComment;
        StringBuffer content = new StringBuffer("package "+ po.getPackagePath() +";\n\n");
        content.append(po.getImportEntityClass() +"\n");
        content.append(po.getImportServiceClass() +"\n");
        content.append(po.getBaseControllerPath() +"\n");
        content.append(po.getImportEntityQoClass() +"\n");
        content.append(po.getImportEntityVoClass() +"\n");
        content.append(po.getWeoLogPath() +"\n");
        content.append("import com.aladdin.mis.common.system.entity.Result;\n");
        content.append("import com.github.pagehelper.PageInfo;\n");
        content.append("import org.springframework.web.bind.annotation.RequestBody;\n");
        content.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
        content.append("import org.springframework.web.bind.annotation.PostMapping;\n");
        content.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        content.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.stereotype.Controller;\n\n");
        content.append("import java.util.List;\n");
        content.append("/**\n");
        content.append(" * "+tableComment +" "+ po.getEntityName() +"Service--- \n");
        content.append(" * @author cles\n");
        content.append(" * @date "+ LocalDateTime.now() +"\n");
        content.append("*/\n");
        content.append("@RequestMapping(\""+po.getModule()+"/"+ StringUtil.firstCharLower(po.getEntityName()) +"\")\n");
        content.append("@Controller\n");
        content.append("public class "+ po.getEntityName() +"Controller  extends GlobalController {\n");
        content.append("    @Autowired\n");
        String service = StringUtil.firstCharLower(po.getEntityName())+"Service";
        content.append("    private "+po.getEntityName()+"Service "+ service+";\n\n");

        content.append("    /**\n" +
                "     * 分页查询"+tableComment+"\n" +
                "     */\n" +
                "    @PostMapping(\"paginate\")\n" +
                "    @WebLog(\"分页查询 "+tableComment+"\")\n" +
                "    @ResponseBody\n" +
                "    public Result paginate(@RequestBody "+po.getEntityName()+"Qo qo){\n" +
                "        PageInfo<"+po.getEntityName()+"Vo> page = "+service+".paginate(qo);\n" +
                "        result.setData(page);\n" +
                "        return result ;\n" +
                "    }");

        content.append("    /**\n" +
                "     * 查询"+tableComment+"详情\n" +
                "     */\n" +
                "    @PostMapping(\"detail\")\n" +
                "    @WebLog(\"查询 "+tableComment+"详情\")\n" +
                "    @ResponseBody\n" +
                "    public Result detail(@RequestBody "+po.getEntityName()+" qo){\n" +
                "        "+po.getEntityName()+" entity = "+service+".detail(qo);\n" +
                "        result.setData(entity);\n" +
                "        return result ;\n" +
                "    }");

        content.append("    /**\n" +
                "     * 保存"+tableComment+"\n" +
                "     */\n" +
                "    @PostMapping(\"save\")\n" +
                "    @WebLog(\""+tableComment+"保存\")\n" +
                "    @ResponseBody\n" +
                "    public Result save(@RequestBody "+po.getEntityName()+" entity){\n" +
                "        "+po.getEntityName()+" data = "+service+".save(entity);\n" +
                "        result.setData(data);\n" +
                "        return result ;\n" +
                "    }");

        content.append("    /**\n" +
                "     * 删除"+tableComment+"\n" +
                "     */\n" +
                "    @PostMapping(\"delete\")\n" +
                "    @WebLog(\"删除"+tableComment+"\")\n" +
                "    @ResponseBody\n" +
                "    public Result delete(@RequestBody "+po.getEntityName()+" entity){\n" +
                "        boolean flag = "+service+".remove(entity);\n" +
                "        if(flag){\n" +
                "            result.setData(entity);\n" +
                "            result.setMessage(\"刪除成功\");\n" +
                "        }else {\n" +
                "            result.setMessage(\"刪除失败\");\n" +
                "        }\n" +
                "        return result ;\n" +
                "    }");

        content.append("    /**\n" +
                "     * 更新"+tableComment+"\n" +
                "     */\n" +
                "    @PostMapping(\"update\")\n" +
                "    @WebLog(\""+tableComment+"更新\")\n" +
                "    @ResponseBody\n" +
                "    public Result update(@RequestBody "+po.getEntityName()+" entity){\n" +
                "        boolean flag = "+service+".update(entity);\n" +
                "        if(flag){\n" +
                "            result.setData(entity);\n" +
                "            result.setMessage(\"更新成功\");\n" +
                "        }else {\n" +
                "            result.setMessage(\"更新失败\");\n" +
                "        }\n" +
                "        return result ;\n" +
                "    }");


        content.append("}\n");
        boolean result = CommonFileUtil.writeContentToFile(content.toString(),
                po.getFilePath(), po.getEntityName()+"Controller.java", po.isOverWrite());
    }
}

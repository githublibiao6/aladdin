package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableInfo;
import com.aladdin.mis.common.string.utils.StringUtil;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateUtils {


    /**
     * 生成简单的类
     * @param tableInfo
     * @param module
     */
    public static void create(TableInfo tableInfo, String module, String pathName) {
        GeneratePo po = initGeneratePo();
        po.setOverWrite(false);
        po.setModule(module);
//        todo
        po.setTableInfo(tableInfo);

        String className = StringUtil.toCamelCase(po.getTableInfo().getTableName());
        po.setEntityName(className);
        String packagePath = "com.aladdin.mis";
        String entityPath = packagePath +"." +module +".entity";
        po.setPackagePath(entityPath);
        entityPath = entityPath.replaceAll("\\.", "\\/");
        String path = "";
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
            if(path.startsWith("/")){
                path = path.substring(1);
            }
            System.err.println(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String replacePathName = "extract-omnipotent";
        String entityFilePath = path.replaceAll(replacePathName + "/target/classes","extract-pojo");
        entityFilePath += "src/main/java/" + entityPath;
        po.setFilePath(entityFilePath);
        GenerateEntityUtils.writeEntityToFile(po);

        po.setImportEntityClass("import "+ packagePath +"." +module +".entity."+po.getEntityName()+";");

        String entityQoPath = packagePath +"." +module +".qo";
        po.setPackagePath(entityQoPath);
        entityQoPath = entityQoPath.replaceAll("\\.", "\\/");
        String entityQoFilePath = path.replaceAll(replacePathName + "/target/classes","extract-pojo");
        entityQoFilePath += "src/main/java/" +  entityQoPath;
        po.setFilePath(entityQoFilePath);
        GenerateEntityQoUtils.writeEntityToFile(po);

        po.setImportEntityQoClass("import "+ packagePath +"." +module +".qo."+po.getEntityName()+"Qo;");

        String entityVoPath = packagePath +"." +module +".vo";
        po.setPackagePath(entityVoPath);
        entityVoPath = entityVoPath.replaceAll("\\.", "\\/");
        String entityVoFilePath = path.replaceAll(replacePathName + "/target/classes","extract-pojo");
        entityVoFilePath += "src/main/java/" + entityVoPath;
        po.setFilePath(entityVoFilePath);
        GenerateEntityVoUtils.writeEntityToFile(po);

        po.setImportEntityVoClass("import "+ packagePath +"." +module +".vo."+po.getEntityName()+"Vo;");

        String daoPath = packagePath +".dao." +module ;
        po.setPackagePath(daoPath);
        daoPath = daoPath.replaceAll("\\.", "\\/");
        String daoFilePath = path.replaceAll(replacePathName + "/target/classes","extract-dao");
        daoFilePath += "src/main/java/" + daoPath;
        po.setFilePath(daoFilePath);
        GenerateDaoUtils.writeDaoToFile(po);

        po.setImportDaoClass("import "+ packagePath +".dao." +module +"."+po.getEntityName()+"Dao;");

        String servicePath = packagePath +"." +module +".service";
        po.setPackagePath(servicePath);
        servicePath = servicePath.replaceAll("\\.", "\\/");
        String serviceFilePath = path.replaceAll(replacePathName + "/target/classes","extract-service");
        serviceFilePath += "src/main/java/" + servicePath;
        po.setFilePath(serviceFilePath);
        GenerateServiceUtils.writeServiceToFile(po);

        po.setImportServiceClass("import "+ packagePath +"." +module +".service."+po.getEntityName()+"Service;");

        String serviceImplPath = packagePath +"." +module +".service.impl";
        po.setPackagePath(serviceImplPath);
        serviceImplPath = serviceImplPath.replaceAll("\\.", "\\/");
        String serviceImplFilePath = path.replaceAll(replacePathName + "/target/classes","extract-service");
        serviceImplFilePath += "src/main/java/" + serviceImplPath;
        po.setFilePath(serviceImplFilePath);
        GenerateServiceImplUtils.writeServiceImplToFile(po);

        po.setImportServiceImplClass("import "+ packagePath +"." +module +".service.impl."+po.getEntityName()+"ServiceImpl;");

        String controllerPath = packagePath +"." +module +".controller";
        po.setPackagePath(controllerPath);
        controllerPath = controllerPath.replaceAll("\\.", "\\/");
        String controllerFilePath = path.replaceAll(replacePathName + "/target/classes", pathName);
        controllerFilePath += "src/main/java/" + controllerPath;
        po.setFilePath(controllerFilePath);
        GenerateControllerUtils.writeControllerToFile(po);

        String xmlPath = path.replaceAll(replacePathName + "/target/classes","extract-dao");
        xmlPath += "src/main/resources/mybatis-mapper/" + module+"/";
        po.setFilePath(xmlPath);
        GenerateXmlUtils.writeXmlToFile(po);



    }

    private static GeneratePo initGeneratePo() {
        GeneratePo po = new GeneratePo();
        po.setTablePath("import com.aladdin.mis.annotation.entity.Table;");
        po.setTableFieldPath("import com.aladdin.mis.annotation.entity.TableField;");
        po.setBaseModelPath("import com.aladdin.mis.system.base.GlobalModel;");
        po.setBaseServicePath("import com.aladdin.mis.base.service.GlobalService;");
        po.setBaseServiceImplPath("import com.aladdin.mis.base.service.impl.GlobalServiceImpl;");
        po.setBaseControllerPath("import com.aladdin.mis.system.controller.GlobalController;");
        po.setWebLogPath("import com.aladdin.mis.common.annotation.WebLog;");
        return po;
    }
}

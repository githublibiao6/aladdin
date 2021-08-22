package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.string.utils.StringUtil;
import com.aladdin.mis.dao.db.config.MainDb;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * 常用的文件工具类
 * @author cles
 */
public  class GenerateUtils {


    public static void create(String tableName, String module) {
        GeneratePo po = new GeneratePo();
        po.setTableInfo(MainDb.initTableInfo(tableName));
        po.setTablePath("import com.aladdin.mis.annotation.entity.Table;");
        po.setTableFieldPath("import com.aladdin.mis.annotation.entity.TableField;");
        po.setBaseModelPath("import com.aladdin.mis.system.base.GlobalModel;");
        po.setBaseServicePath("import com.aladdin.mis.common.system.service.GlobalService;");
        po.setBaseServiceImplPath("import com.aladdin.mis.common.system.service.impl.GlobalServiceImpl;");
        po.setBaseControllerPath("import com.aladdin.mis.common.system.controller.GlobalController;");
        String className = StringUtil.toCamelCase(po.getTableInfo().getTableName());
        po.setEntityName(className);
        String packagePath = "com.aladdin.mis";
        String entityPath = packagePath +"." +module +".entity";
        po.setPackagePath(entityPath);
        entityPath = entityPath.replaceAll("\\.", "\\/");
        String path = "";
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String entityFilePath = path.replaceAll("extract-omnipotent/target/classes","extract-pojo");
        entityFilePath += "src/main/java/" + entityPath;
        po.setFilePath(entityFilePath);
        GenerateEntityUtils.writeEntityToFile(po);

        po.setImportEntityClass("import "+ packagePath +"." +module +".entity."+po.getEntityName()+";");

        String daoPath = packagePath +".dao." +module ;
        po.setPackagePath(daoPath);
        daoPath = daoPath.replaceAll("\\.", "\\/");
        String daoFilePath = path.replaceAll("extract-omnipotent/target/classes","extract-dao");
        daoFilePath += "src/main/java/" + daoPath;
        po.setFilePath(daoFilePath);
        GenerateDaoUtils.writeDaoToFile(po);

        po.setImportDaoClass("import "+ packagePath +".dao." +module +"."+po.getEntityName()+"Dao;");

        String servicePath = packagePath +"." +module +".service";
        po.setPackagePath(servicePath);
        servicePath = servicePath.replaceAll("\\.", "\\/");
        String serviceFilePath = path.replaceAll("extract-omnipotent/target/classes","extract-service");
        serviceFilePath += "src/main/java/" + servicePath;
        po.setFilePath(serviceFilePath);
        GenerateServiceUtils.writeServiceToFile(po);

        po.setImportServiceClass("import "+ packagePath +"." +module +".service."+po.getEntityName()+"Service;");

        String serviceImplPath = packagePath +"." +module +".service.impl";
        po.setPackagePath(serviceImplPath);
        serviceImplPath = serviceImplPath.replaceAll("\\.", "\\/");
        String serviceImplFilePath = path.replaceAll("extract-omnipotent/target/classes","extract-service");
        serviceImplFilePath += "src/main/java/" + serviceImplPath;
        po.setFilePath(serviceImplFilePath);
        GenerateServiceImplUtils.writeServiceImplToFile(po);

        po.setImportServiceImplClass("import "+ packagePath +"." +module +".service.impl."+po.getEntityName()+"ServiceImpl;");

        String controllerPath = packagePath +".omnipotent." +module +".controller";
        po.setPackagePath(controllerPath);
        controllerPath = controllerPath.replaceAll("\\.", "\\/");
        String controllerFilePath = path.replaceAll("extract-omnipotent/target/classes","extract-omnipotent");
        controllerFilePath += "src/main/java/" + controllerPath;
        po.setFilePath(controllerFilePath);
        GenerateControllerUtils.writeControllerToFile(po);



    }
}

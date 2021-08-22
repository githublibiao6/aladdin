package com.aladdin.mis.common.aladdin.utils;



import com.aladdin.mis.system.db.entity.TableInfo;
import lombok.Data;

/**
 * 生成辅助类
 */
@Data
public class GeneratePo {
    private String filePath;
    private String packagePath;
    private TableInfo tableInfo;
    private String baseModelPath;
    private String baseServicePath;
    private String baseServiceImplPath;
    private String baseControllerPath;
    private String tablePath;
    private String tableFieldPath;
    private String entityName;
    private String importEntityClass;
    private String importDaoClass;
    private String importServiceClass;
    private String importServiceImplClass;
}

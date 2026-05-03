package com.aladdin.mis.dao.generate;

import com.aladdin.common.db.bean.TableInfo;
import lombok.Data;

@Data
public class GeneratePo {

    private String module;

    private String filePath;

    private String packagePath;

    private TableInfo tableInfo;

    private String baseModelPath;

    private String baseServicePath;

    private String baseServiceImplPath;

    private String baseControllerPath;

    private String webLogPath;

    private String tablePath;

    private String tableFieldPath;

    private String entityName;

    private String importEntityClass;

    private String importEntityQoClass;

    private String importEntityVoClass;

    private String importDaoClass;

    private String importServiceClass;

    private String importServiceImplClass;

    private boolean overWrite;
}

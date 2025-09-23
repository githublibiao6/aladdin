package com.aladdin.mis.common.aladdin.utils;

import com.aladdin.mis.common.db.bean.TableInfo;
import lombok.Data;

/**
 * 生成辅助类
 * @author cles
 */
@Data
public class GeneratePo {

    /**
     * 模块
     */
    private String module;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 包路径
     */
    private String packagePath;

    /**
     * 表信息
     */
    private TableInfo tableInfo;

    /**
     * 基础类路径
     */
    private String baseModelPath;

    /**
     * 基础服务类路径
     */
    private String baseServicePath;

    /**
     * 基础服务实现类路径
     */
    private String baseServiceImplPath;

    /**
     * 基础web类路径
     */
    private String baseControllerPath;

    /**
     * 日之类路径
     */
    private String webLogPath;

    /**
     * 表注解类路径
     */
    private String tablePath;

    /**
     * 字段注解类路径
     */
    private String tableFieldPath;

    /**
     * jaav类表名
     */
    private String entityName;

    /**
     * 表的类路径
     */
    private String importEntityClass;

    /**
     * 查询条件的类路径
     */
    private String importEntityQoClass;

    /**
     * 返回实体的类路径
     */
    private String importEntityVoClass;

    /**
     * dao层的类路径
     */
    private String importDaoClass;

    /**
     * 服务层的类路径
     */
    private String importServiceClass;

    /**
     * 服务实现的类路径
     */
    private String importServiceImplClass;

    /**
     * 是否覆盖
     */
    private boolean overWrite;
}

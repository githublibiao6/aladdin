package com.aladdin.mis.manager.bean;


import com.aladdin.mis.system.base.GlobalModel;
import lombok.Data;

/**
 * 项目实体："
 * @author lb
 * @date 2018："："4："下午6:52:01
 */
@Data
public class Project extends GlobalModel {

    /**
     * 项目编码
     */
    private String code;

    /**
     * 项目："
     */
    private String projectName;

    /**
     * 项目地址
     */
    private String projectAddress;

    /**
     * 项目负责："
     */
    private String leader;

    /**
     * 项目描述
     */
    private String notes;

}

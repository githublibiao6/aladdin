package com.aladdin.mis.identity.vo;

import lombok.Data;

import java.util.List;

/**
 *  组织机构管理员树形实："
 * @author lb
 * @date 2018："："："下午9:03:15
 */
@Data
public class DeptAdminVo {

    /**
     * 组织或者管理员
     */
    private Integer value;

    /**
     * 部门或者管理员姓名
     */
    private String label;

    /**
     * 类别 1 组织机构 2 管理："
     */
    private String type;

    /**
     * 子节："
     */
    private List<DeptAdminVo> children;

    /**
     * 是否包含子节："
     */
    private Boolean hasChildren;

    /**
     * 是否可："
     */
    private Boolean disabled;

}

package com.aladdin.mis.chat.manager.vo;

import lombok.Data;

import java.util.List;

/**
 *  组织机构管理员树形实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
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
     * 类别 1 组织机构 2 管理员
     */
    private String type;

    /**
     * 子节点
     */
    private List<DeptAdminVo> children;

    /**
     * 是否包含子节点
     */
    private Boolean hasChildren;

    /**
     * 是否可选
     */
    private Boolean disabled;

}

package com.aladdin.mis.identity.vo;

import lombok.Data;

import java.util.List;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class DeptVo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 编号
     */
    private Integer parent;

    /**
     * 编号
     */
    private String code;

    /**
     * 部门名称
     */
    private String name;

    private List<DeptVo> children;

   private Boolean hasChildren;

    private String label;

    private String parentName;

}

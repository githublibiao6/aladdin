package com.aladdin.mis.manager.vo;

import com.aladdin.mis.manager.bean.Dept;
import lombok.Data;

import java.util.List;

/**
 *  查询实体
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class DeptVo extends Dept {

    private List<DeptVo> children;

    private Boolean hasChildren;

    private String label;

    private String parentName;

}

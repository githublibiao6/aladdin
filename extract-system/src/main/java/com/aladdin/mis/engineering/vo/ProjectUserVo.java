package com.aladdin.mis.engineering.vo;

import com.aladdin.mis.engineering.entity.ProjectUser;
import lombok.Data;

/**
 * 应用层实体
 * @author cles
 * @date 2021-10-12T00:48:58.744
*/
@Data
public class ProjectUserVo extends ProjectUser {

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 人员联系方式
     */
    private String phone;
}

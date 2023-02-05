package com.aladdin.mis.build.entity;

import com.aladdin.mis.annotation.entity.Table;
import com.aladdin.mis.annotation.entity.TableField;
import com.aladdin.mis.system.base.GlobalModel;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 建设大类
 * @author cles
 * @date 2023-02-05 16:40:09
*/
@Table("build_group")
@Data
public class BuildGroup extends GlobalModel {

    /**
     * groupIcon图标
     */
    @TableField("group_icon")
    private String groupIcon;

    /**
     * groupName
     */
    @TableField("group_name")
    private String groupName;

    /**
     * state0停用1启用
     */
    @TableField("state")
    private String state;

    /**
     * parentId父节点
     */
    @TableField("parent_id")
    private Integer parentId;

}

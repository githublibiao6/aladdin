package com.aladdin.mis.system.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 基础model(默认参数)
* @Description
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
public class GlobalModel extends BaseModel {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime sys001;

    /**
     * 修改时间
     */
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sys002;

    /**
     * 创建人
     */
    @Transient
    private Integer sys003;

    /**
     * 修改人
     */
    @Transient
    private Integer sys004;

    /**
     * 有效标志
     */
    @Transient
    private String sys005;

    /**
     * 状态位，根据对应的类实现状态功能,最好不要影响有效问题
     */
    @Transient
    private String sys006;

    /**
     * 更新次数
     */
    @Transient
    private int sys007;
}

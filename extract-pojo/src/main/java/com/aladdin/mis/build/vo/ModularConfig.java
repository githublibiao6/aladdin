package com.aladdin.mis.build.vo;

import lombok.Data;

/**
 * 搭建组件
 * @author cles
 * @date 2023-02-04 23:28:02
*/
@Data
public class ModularConfig {

    /**
     * label标签
     */
    private String label;

    /**
     * showLabel是否显示标签
     */
    private Boolean showLabel;

    /**
     * labelWidth标签宽度（px）
     */
    private Integer labelWidth;

    /**
     * changeTag组件类型
     */
    private Boolean changeTag;

    /**
     * tag使changeRenderKey在目标组件改变时可用?
     */
    private String tag;

    /**
     * tagIcon时间类型 图标?
     */
    private String tagIcon;

    /**
     * defaultValue默认值
     */
    private String defaultValue;

    /**
     * layoutTree布局结构树
     */
    private String layout;

    /**
     * span表单栅栏
     */
    private Integer span;

    /**
     * document
     */
    private String document;

}

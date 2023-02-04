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
 * 搭建组件
 * @author cles
 * @date 2023-02-04 22:50:09
*/
@Table("build_modular")
@Data
public class BuildModular extends GlobalModel {

    /**
     * gooupId组群主键
     */
    @TableField("gooup_id")
    private Integer gooupId;

    /**
     * label标签
     */
    @TableField("label")
    private String label;

    /**
     * fieldCol字段名
     */
    @TableField("field_col")
    private String fieldCol;

    /**
     * labelWidth标签宽度（px）
     */
    @TableField("label_width")
    private Integer labelWidth;

    /**
     * showLabel是否显示标签
     */
    @TableField("show_label")
    private Integer showLabel;

    /**
     * placeholder占位提示
     */
    @TableField("placeholder")
    private String placeholder;

    /**
     * changeTag组件类型
     */
    @TableField("change_tag")
    private Integer changeTag;

    /**
     * tag使changeRenderKey在目标组件改变时可用?
     */
    @TableField("tag")
    private String tag;

    /**
     * tagIcon时间类型 图标?
     */
    @TableField("tag_icon")
    private String tagIcon;

    /**
     * width组件宽度
     */
    @TableField("width")
    private Integer width;

    /**
     * span表单栅栏
     */
    @TableField("span")
    private Integer span;

    /**
     * gutter栅栏间隔
     */
    @TableField("gutter")
    private Integer gutter;

    /**
     * type布局模式(布局式组件）
     */
    @TableField("type")
    private String type;

    /**
     * justify水平排列(布局式组件）
     */
    @TableField("justify")
    private String justify;

    /**
     * align垂直排列
     */
    @TableField("align")
    private String align;

    /**
     * defaultValue默认值
     */
    @TableField("default_value")
    private String defaultValue;

    /**
     * min至少应选或最大值
     */
    @TableField("min")
    private Integer min;

    /**
     * max最多可选或最大值
     */
    @TableField("max")
    private Integer max;

    /**
     * disabled是否禁选
     */
    @TableField("disabled")
    private Integer disabled;

    /**
     * prepend前缀
     */
    @TableField("prepend")
    private String prepend;

    /**
     * append后缀
     */
    @TableField("append")
    private String append;

    /**
     * prefixIcon前图标
     */
    @TableField("prefix_icon")
    private String prefixIcon;

    /**
     * suffixIcon后图标
     */
    @TableField("suffix_icon")
    private String suffixIcon;

    /**
     * icon按钮图标
     */
    @TableField("icon")
    private String icon;

    /**
     * separator选项分隔符
     */
    @TableField("separator")
    private String separator;

    /**
     * minRows最小行数
     */
    @TableField("min_rows")
    private Integer minRows;

    /**
     * maxRows最大行数
     */
    @TableField("max_rows")
    private Integer maxRows;

    /**
     * height组件高度
     */
    @TableField("height")
    private Integer height;

    /**
     * step步数
     */
    @TableField("step")
    private Integer step;

    /**
     * precision精度
     */
    @TableField("precision")
    private Integer precision;

    /**
     * controlsPosition按钮位置
     */
    @TableField("controls_position")
    private String controlsPosition;

    /**
     * maxLength最多输入
     */
    @TableField("max_length")
    private Integer maxLength;

    /**
     * activeText开启提示
     */
    @TableField("active_text")
    private Integer activeText;

    /**
     * inactiveText关闭提示
     */
    @TableField("inactive_text")
    private Integer inactiveText;

    /**
     * activeValue开启值
     */
    @TableField("active_value")
    private Integer activeValue;

    /**
     * inactiveValue关闭值
     */
    @TableField("inactive_value")
    private Integer inactiveValue;

    /**
     * name文件字段名
     */
    @TableField("name")
    private String name;

    /**
     * accept文件类型
     */
    @TableField("accept")
    private String accept;

    /**
     * fileSize文件大小
     */
    @TableField("file_size")
    private Integer fileSize;

    /**
     * sizeUnit大小单位
     */
    @TableField("size_unit")
    private String sizeUnit;

    /**
     * action上传地址
     */
    @TableField("action")
    private String action;

    /**
     * listType列表类型
     */
    @TableField("list_type")
    private String listType;

    /**
     * buttonText按钮文字
     */
    @TableField("button_text")
    private String buttonText;

    /**
     * rangeSeparator分隔符（范围性的）
     */
    @TableField("range_separator")
    private String rangeSeparator;

    /**
     * format时间格式
     */
    @TableField("format")
    private String format;

    /**
     * dataType数据类型
     */
    @TableField("data_type")
    private String dataType;

    /**
     * url接口地址
     */
    @TableField("url")
    private String url;

    /**
     * dataPath数据位置
     */
    @TableField("data_path")
    private String dataPath;

    /**
     * value值键名
     */
    @TableField("value")
    private String value;

    /**
     * optionType选项样式
     */
    @TableField("option_type")
    private String optionType;

    /**
     * activeColor开启颜色
     */
    @TableField("active_color")
    private Integer activeColor;

    /**
     * inactiveColor关闭颜色
     */
    @TableField("inactive_color")
    private Integer inactiveColor;

    /**
     * branding品牌烙印
     */
    @TableField("branding")
    private String branding;

    /**
     * allowHalf允许半选
     */
    @TableField("allow_half")
    private Integer allowHalf;

    /**
     * showText辅助文字
     */
    @TableField("show_text")
    private String showText;

    /**
     * showScore显示分数
     */
    @TableField("show_score")
    private Integer showScore;

    /**
     * showStops显示间断点
     */
    @TableField("show_stops")
    private Integer showStops;

    /**
     * range范围选择
     */
    @TableField("range")
    private Integer range;

    /**
     * border是否有边框
     */
    @TableField("border")
    private Integer border;

    /**
     * colorFormat选择颜色格式
     */
    @TableField("color_format")
    private String colorFormat;

    /**
     * size组件尺寸（medium中等 small较小 mini迷你）
     */
    @TableField("size")
    private String size;

    /**
     * showWordLimit
     */
    @TableField("show_word_limit")
    private Integer showWordLimit;

    /**
     * stepStrictly严格步数
     */
    @TableField("step_strictly")
    private Integer stepStrictly;

    /**
     * checkStrictly任选层级
     */
    @TableField("checkStrictly")
    private Integer checkStrictly;

    /**
     * propMultiple是否多选
     */
    @TableField("prop_multiple")
    private Integer propMultiple;

    /**
     * showAllLevels展示全路径
     */
    @TableField("show_all_levels")
    private Integer showAllLevels;

    /**
     * filterable可否筛选
     */
    @TableField("filterable")
    private Integer filterable;

    /**
     * clearable能否清空
     */
    @TableField("clearable")
    private Integer clearable;

    /**
     * showTip显示提示
     */
    @TableField("showTip")
    private Integer showTip;

    /**
     * multiple多选文件
     */
    @TableField("multiple")
    private Integer multiple;

    /**
     * autoUpload自动上传
     */
    @TableField("auto_upload")
    private Integer autoUpload;

    /**
     * readonly是否只读
     */
    @TableField("readonly")
    private Integer readonly;

    /**
     * required是否必填
     */
    @TableField("required")
    private Integer required;

    /**
     * layoutTree布局结构树
     */
    @TableField("layoutTree")
    private String layoutTree;

    /**
     * regList正则校验
     */
    @TableField("regList")
    private String regList;

    /**
     * pattern正则表达式
     */
    @TableField("pattern")
    private String pattern;

    /**
     * message错误提示
     */
    @TableField("message")
    private String message;

}

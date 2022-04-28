package com.aladdin.mis.manager.vo;

import lombok.Data;

/**
 *  展示实体
 *  1、entity里的每一个字段，与数据库相对应，
 *  2、VO里的每一个字段，是和你前台页面相对应，
 *  3、DTO，这是用来转换从entity到dto，或者从dto到entity的中间的东西。
 * @author lb
 * @date 2018年6月5日 下午9:03:15
 */
@Data
public class UserVo {


    /**
     * 账号
     */
    private String account;

    /**
     * 手机号码
     */
    private String phone;

}

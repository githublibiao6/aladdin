package com.aladdin.mis.identity.vo;

import com.aladdin.mis.identity.entity.User;
import lombok.Data;

/**
 * 应用层实体
 * @author cles
 * @date 2024-08-27 23:28:22
*/
@Data
public class UserVo extends User {

    /**
     *  展示实体
     *  1、entity里的每一个字段，与数据库相对应，
     *  2、VO里的每一个字段，是和你前台页面相对应，
     *  3、DTO，这是用来转换从entity到dto，或者从dto到entity的中间的东西。
     * @author lb
     * @date 2018年6月5日 下午9:03:15
     */
    @Data
    public static class UserVo {

        /**
         * 账号
         */
        private String account;

        /**
         * 手机号码
         */
        private String phone;

    }
}

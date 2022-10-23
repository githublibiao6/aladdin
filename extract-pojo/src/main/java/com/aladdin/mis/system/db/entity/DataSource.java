package com.aladdin.mis.system.db.entity;
/**
 * Created by cles on 2020/5/9 23:00
 */

import lombok.Data;

/**
 * @description:
 * @author cles
 * @Date 2020/5/9 23:00
 */
@Data
public class DataSource {

    String id;
    String url;
    String username;
    String password;
    String code;
    String dbType;
}

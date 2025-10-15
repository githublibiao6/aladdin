package com.aladdin.mis.common.db.bean;
/**
 * Created by cles on 2025/5/9 23:00
 */

import lombok.Data;

/**
 * @description:
 * @author cles
 * @Date 2025/5/9 23:00
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

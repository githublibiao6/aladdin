package com.aladdin.common.db.bean;

import lombok.Data;

/**
 * 数据源信息
 *
 * @author cles
 * @date 2026/04/30
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

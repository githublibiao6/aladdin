package com.aladdin.mis.base.db.bean;
/**
 * Created by cles on 2025/5/9 23:00
 */

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author cles
 * @Date 2025/5/9 23:00
 */
@Component
@Data
public class DataSourceDb {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    String dbType;
}

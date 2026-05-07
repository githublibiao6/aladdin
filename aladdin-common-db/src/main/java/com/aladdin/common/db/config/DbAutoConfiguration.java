package com.aladdin.common.db.config;

import com.aladdin.common.db.dynamic.DynamicDataSourceAutoConfiguration;
import com.aladdin.common.db.interceptor.AutoFillInterceptor;
import com.aladdin.common.db.interceptor.DataPermissionHandler;
import com.aladdin.common.db.interceptor.DataPermissionInterceptor;
import com.aladdin.common.db.interceptor.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 数据访问自动配置
 *
 * @author cles
 * @date 2026/05/06
 */
@Configuration
@ConditionalOnProperty(prefix = "aladdin.db", name = "enabled", havingValue = "true", matchIfMissing = true)
@Import(DynamicDataSourceAutoConfiguration.class)
public class DbAutoConfiguration {

    private final List<SqlSessionFactory> sqlSessionFactoryList;

    public DbAutoConfiguration(List<SqlSessionFactory> sqlSessionFactoryList) {
        this.sqlSessionFactoryList = sqlSessionFactoryList;
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.db.auto-fill", name = "enabled", havingValue = "true", matchIfMissing = true)
    public AutoFillInterceptor autoFillInterceptor() {
        return new AutoFillInterceptor();
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.db.page", name = "enabled", havingValue = "true", matchIfMissing = true)
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    @Bean
    @ConditionalOnProperty(prefix = "aladdin.db.data-permission", name = "enabled", havingValue = "true")
    public DataPermissionInterceptor dataPermissionInterceptor(DataPermissionHandler handler) {
        DataPermissionInterceptor interceptor = new DataPermissionInterceptor();
        interceptor.setDataPermissionHandler(handler);
        return interceptor;
    }

    @PostConstruct
    public void addInterceptors() {
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        }
    }
}

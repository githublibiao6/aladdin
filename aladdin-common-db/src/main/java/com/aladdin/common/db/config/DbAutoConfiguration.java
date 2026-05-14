package com.aladdin.common.db.config;

import com.aladdin.common.db.dynamic.DynamicDataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(prefix = "aladdin.db", name = "enabled", havingValue = "true", matchIfMissing = true)
@Import(DynamicDataSourceAutoConfiguration.class)
public class DbAutoConfiguration {
}

package com.aladdin.common.security.tenant;

import com.aladdin.common.security.config.SecurityProperties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 租户数据隔离MyBatis拦截器
 * <p>
 * 自动在SQL中拼接tenant_id条件，实现数据隔离
 * 仅对包含tenant_id字段的表生效
 * 当aladdin.security.tenant.enabled=false时，不进行租户隔离
 *
 * @author cles
 * @date 2026/06/12
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, org.apache.ibatis.session.RowBounds.class, org.apache.ibatis.session.ResultHandler.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class TenantInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(TenantInterceptor.class);

    private final SecurityProperties securityProperties;

    public TenantInterceptor(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Long tenantId = TenantContextHolder.getTenantId();
        if (tenantId == null) {
            return invocation.proceed();
        }

        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType commandType = ms.getSqlCommandType();

        // 对于insert/update，在参数中设置tenantId
        Object parameter = invocation.getArgs()[1];
        if (parameter instanceof java.util.Map) {
            @SuppressWarnings("unchecked")
            java.util.Map<String, Object> map = (java.util.Map<String, Object>) parameter;
            if (!map.containsKey("tenantId")) {
                map.put("tenantId", tenantId);
            }
        } else if (parameter != null) {
            try {
                java.lang.reflect.Field field = parameter.getClass().getDeclaredField("tenantId");
                field.setAccessible(true);
                if (field.get(parameter) == null) {
                    field.set(parameter, tenantId);
                }
            } catch (NoSuchFieldException e) {
                // 实体没有tenantId字段，跳过
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

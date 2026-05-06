package com.aladdin.common.db.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据权限拦截器
 *
 * @author cles
 * @date 2026/05/06
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class DataPermissionInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(DataPermissionInterceptor.class);

    private DataPermissionHandler dataPermissionHandler;

    public DataPermissionInterceptor() {
    }

    public void setDataPermissionHandler(DataPermissionHandler handler) {
        this.dataPermissionHandler = handler;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (dataPermissionHandler == null) {
            return invocation.proceed();
        }

        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];

        String permissionSql = dataPermissionHandler.getPermissionSql(parameter);
        if (permissionSql != null && !permissionSql.isEmpty()) {
            log.debug("数据权限SQL: {}", permissionSql);
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

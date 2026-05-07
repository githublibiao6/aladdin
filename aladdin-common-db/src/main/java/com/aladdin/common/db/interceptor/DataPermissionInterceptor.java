package com.aladdin.common.db.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * 数据权限拦截器
 * <p>
 * 拦截查询SQL，自动拼接数据权限条件
 *
 * @author cles
 * @date 2026/05/06
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
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

        BoundSql boundSql = ms.getBoundSql(parameter);
        String originalSql = boundSql.getSql();

        String permissionSql = dataPermissionHandler.getPermissionSql(parameter);
        if (permissionSql != null && !permissionSql.isEmpty()) {
            String newSql = injectPermissionSql(originalSql, permissionSql);
            log.debug("数据权限SQL注入: 原始={}, 权限条件={}, 最终={}", originalSql, permissionSql, newSql);

            BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), newSql,
                    boundSql.getParameterMappings(), parameter);
            for (Map.Entry<String, Object> entry : boundSql.getAdditionalParameters().entrySet()) {
                newBoundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
            }

            MappedStatement newMs = newMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
            args[0] = newMs;
        }

        return invocation.proceed();
    }

    private String injectPermissionSql(String originalSql, String permissionSql) {
        String trimmedSql = originalSql.trim().toLowerCase();
        if (trimmedSql.contains(" where ")) {
            return originalSql + " AND (" + permissionSql + ")";
        } else {
            String upperSql = originalSql.trim();
            int groupByIndex = findKeywordIndex(upperSql, "GROUP BY");
            int havingIndex = findKeywordIndex(upperSql, "HAVING");
            int orderByIndex = findKeywordIndex(upperSql, "ORDER BY");
            int limitIndex = findKeywordIndex(upperSql, "LIMIT");

            int insertIndex = upperSql.length();
            int[] indices = {groupByIndex, havingIndex, orderByIndex, limitIndex};
            for (int idx : indices) {
                if (idx > 0 && idx < insertIndex) {
                    insertIndex = idx;
                }
            }

            if (insertIndex < upperSql.length()) {
                return upperSql.substring(0, insertIndex) + " WHERE (" + permissionSql + ") " + upperSql.substring(insertIndex);
            } else {
                return originalSql + " WHERE (" + permissionSql + ")";
            }
        }
    }

    private int findKeywordIndex(String sql, String keyword) {
        String upper = sql.toUpperCase();
        int idx = upper.indexOf(" " + keyword + " ");
        return idx >= 0 ? idx + 1 : -1;
    }

    private MappedStatement newMappedStatement(MappedStatement ms, BoundSqlSqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.fetchSize(ms.getFetchSize());
        builder.timeout(ms.getTimeout());
        builder.statementType(ms.getStatementType());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
            builder.keyProperty(String.join(",", ms.getKeyProperties()));
        }
        builder.databaseId(ms.getDatabaseId());
        builder.lang(ms.getLang());
        builder.resultOrdered(ms.isResultOrdered());
        return builder.build();
    }

    public static class BoundSqlSqlSource implements SqlSource {
        private final BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

package com.aladdin.common.db.interceptor;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 分页拦截器
 * <p>
 * 拦截MyBatis查询，自动拼接分页SQL，返回PageResult
 *
 * @author cles
 * @date 2026/05/06
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(PageInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];

        if (!(parameter instanceof Map)) {
            return invocation.proceed();
        }

        Map<?, ?> paramMap = (Map<?, ?>) parameter;
        PageQuery pageQuery = extractPageQuery(paramMap);
        if (pageQuery == null) {
            return invocation.proceed();
        }

        BoundSql boundSql = ms.getBoundSql(parameter);
        String originalSql = boundSql.getSql();

        Executor executor = (Executor) invocation.getTarget();
        long total = executeCount(executor, ms, parameter, boundSql, originalSql);

        String pageSql = buildPageSql(originalSql, pageQuery);
        log.debug("分页SQL: {}", pageSql);

        BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), pageSql,
                boundSql.getParameterMappings(), parameter);
        copyAdditionalParameters(boundSql, pageBoundSql);

        List<?> resultList = executePageQuery(executor, ms, parameter, pageBoundSql, (ResultHandler<?>) args[3]);

        return buildPageResult(resultList, total, pageQuery);
    }

    private PageQuery extractPageQuery(Map<?, ?> paramMap) {
        for (Object value : paramMap.values()) {
            if (value instanceof PageQuery) {
                return (PageQuery) value;
            }
        }
        return null;
    }

    private long executeCount(Executor executor, MappedStatement ms, Object parameter,
                              BoundSql boundSql, String originalSql) throws Throwable {
        String countSql = "SELECT COUNT(1) FROM (" + originalSql + ") _count";
        log.debug("计数SQL: {}", countSql);

        Connection connection = executor.getTransaction().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(countSql)) {
            List<org.apache.ibatis.mapping.ParameterMapping> mappings = boundSql.getParameterMappings();
            for (int i = 0; i < mappings.size(); i++) {
                org.apache.ibatis.mapping.ParameterMapping mapping = mappings.get(i);
                String propName = mapping.getProperty();
                Object value = null;
                if (boundSql.hasAdditionalParameter(propName)) {
                    value = boundSql.getAdditionalParameter(propName);
                } else if (parameter instanceof Map) {
                    value = ((Map<?, ?>) parameter).get(propName);
                }
                ps.setObject(i + 1, value);
            }
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return 0;
    }

    private String buildPageSql(String sql, PageQuery pageQuery) {
        int offset = (pageQuery.getPage() - 1) * pageQuery.getLimit();
        return sql + " LIMIT " + offset + ", " + pageQuery.getLimit();
    }

    @SuppressWarnings("unchecked")
    private List<?> executePageQuery(Executor executor, MappedStatement ms, Object parameter,
                                     BoundSql pageBoundSql, ResultHandler<?> resultHandler) throws Throwable {
        MappedStatement newMs = newMappedStatement(ms, new BoundSqlSqlSource(pageBoundSql));
        return executor.query(newMs, parameter, RowBounds.DEFAULT, resultHandler);
    }

    private PageResult<?> buildPageResult(List<?> list, long total, PageQuery pageQuery) {
        return new PageResult<>(pageQuery.getPage(), pageQuery.getLimit(), total, list);
    }

    private MappedStatement newMappedStatement(MappedStatement ms, BoundSqlSqlSource newSqlSource) {
        org.apache.ibatis.builder.MapperBuilderAssistant assistant =
                new org.apache.ibatis.builder.MapperBuilderAssistant(
                        ms.getConfiguration(), ms.getResource());
        assistant.setCurrentNamespace(ms.getId().substring(0, ms.getId().lastIndexOf(".")));
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
        builder.keyColumn(String.join(",", ms.getKeyColumns() != null ? ms.getKeyColumns() : new String[]{}));
        builder.databaseId(ms.getDatabaseId());
        builder.lang(ms.getLang());
        builder.resultOrdered(ms.isResultOrdered());
        builder.resultSets(String.join(",", ms.getResultSets() != null ? ms.getResultSets() : new String[]{}));
        return builder.build();
    }

    private void copyAdditionalParameters(BoundSql source, BoundSql target) {
        for (Map.Entry<String, Object> entry : source.getAdditionalParameters().entrySet()) {
            target.setAdditionalParameter(entry.getKey(), entry.getValue());
        }
    }

    public static class BoundSqlSqlSource implements org.apache.ibatis.mapping.SqlSource {
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

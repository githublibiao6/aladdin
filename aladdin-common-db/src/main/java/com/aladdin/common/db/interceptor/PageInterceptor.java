package com.aladdin.common.db.interceptor;

import com.aladdin.common.core.domain.PageQuery;
import com.aladdin.common.core.domain.PageResult;
import org.apache.ibatis.executor.Executor;
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
 *
 * @author cles
 * @date 2026/05/06
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(PageInterceptor.class);

    private static final String COUNT_SQL_PREFIX = "SELECT COUNT(1) FROM (";
    private static final String COUNT_SQL_SUFFIX = ") _count";

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

        Executor executor = (Executor) invocation.getTarget();
        String originalSql = ms.getBoundSql(parameter).getSql();

        long total = executeCount(executor, ms, parameter, originalSql);

        String pageSql = buildPageSql(originalSql, pageQuery);
        List<?> resultList = executeQuery(executor, ms, parameter, pageSql, (ResultHandler<?>) args[3]);

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

    private long executeCount(Executor executor, MappedStatement ms, Object parameter, String sql) throws Throwable {
        String countSql = COUNT_SQL_PREFIX + sql + COUNT_SQL_SUFFIX;
        Connection connection = executor.getTransaction().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(countSql)) {
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

    private List<?> executeQuery(Executor executor, MappedStatement ms, Object parameter, String pageSql, ResultHandler<?> resultHandler) throws Throwable {
        return executor.query(ms, parameter, RowBounds.DEFAULT, resultHandler);
    }

    private PageResult<?> buildPageResult(List<?> list, long total, PageQuery pageQuery) {
        return new PageResult<>(pageQuery.getPage(), pageQuery.getLimit(), total, list);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

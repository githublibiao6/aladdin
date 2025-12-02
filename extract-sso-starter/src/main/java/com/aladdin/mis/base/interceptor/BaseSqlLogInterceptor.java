package com.aladdin.mis.base.interceptor;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * sql 日志
 */
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
)})
@Log4j2
public class BaseSqlLogInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String originalSql = statementHandler.getBoundSql().getSql();
        log.error("originalSql: {}" , originalSql);
        // 在这里修改 SQL
//        String modifiedSql = "modifySql(originalSql);";
//        // 反射设置修改后的 SQL
//        Field field = ReflectionUtils.findField(BoundSql.class, "sql");
//        field.setAccessible(true);
//        field.set(statementHandler.getBoundSql(), modifiedSql);

        String sql = boundSql.getSql();
        log.error("SQL: {}" , sql); // 记录SQL语句

        long start = System.currentTimeMillis(); // 开始时间
        Object result = invocation.proceed(); // 执行原方法
        long end = System.currentTimeMillis(); // 结束时间
        log.error("Execution Time: {} ms", (end - start)); // 记录执行时间

        return result;
    }
}

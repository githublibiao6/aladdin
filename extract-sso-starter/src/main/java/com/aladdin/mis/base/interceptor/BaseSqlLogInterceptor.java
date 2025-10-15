package com.aladdin.mis.base.interceptor;

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
public class BaseSqlLogInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String originalSql = statementHandler.getBoundSql().getSql();
        System.out.println("originalSql:" + originalSql);
        // 在这里修改 SQL
//        String modifiedSql = "modifySql(originalSql);";
//        // 反射设置修改后的 SQL
//        Field field = ReflectionUtils.findField(BoundSql.class, "sql");
//        field.setAccessible(true);
//        field.set(statementHandler.getBoundSql(), modifiedSql);

        String sql = boundSql.getSql();
        System.out.println("SQL: " + sql); // 记录SQL语句

        long start = System.currentTimeMillis(); // 开始时间
        Object result = invocation.proceed(); // 执行原方法
        long end = System.currentTimeMillis(); // 结束时间
        System.out.println("Execution Time: " + (end - start) + "ms"); // 记录执行时间

        return result;
    }
}

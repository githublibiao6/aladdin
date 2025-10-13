package com.aladdin.mis.base.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Field;

/**
 * 基础拦截
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update",
                args = {MappedStatement.class, Object.class})
})
public class BaseSqlInterceptor  implements Interceptor {

    private static final String UPDATE_PREFIX = "update";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        System.err.println(ms.getId());
        String newSql = "update person set name = #{name} where id #{id}";
        resetMappedStatement(ms, newSql, invocation);
        return invocation.proceed();
    }

    private void resetMappedStatement(MappedStatement ms, String newSql, Invocation invocation)
            throws NoSuchFieldException, IllegalAccessException {
        BoundSql boundSql = ms.getBoundSql(invocation.getArgs()[1]);
        Field sqlField = boundSql.getClass().getDeclaredField("sql");
        sqlField.setAccessible(true);
        sqlField.set(boundSql, newSql);
    }


    private boolean isInsertOperation(MappedStatement ms) {
        return ms.getId().toLowerCase().contains(UPDATE_PREFIX);
    }
}

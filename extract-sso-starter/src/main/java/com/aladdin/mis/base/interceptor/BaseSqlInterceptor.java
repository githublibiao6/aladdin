package com.aladdin.mis.base.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 在执行前拦截并重写 BaseMapper.updateById 的 SQL。
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare",
                args = {Connection.class, Integer.class})
})
public class BaseSqlInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        Configuration configuration = (Configuration) handler.getClass()
                .getDeclaredMethod("getConfiguration").invoke(handler);
        MetaObject metaObject = configuration.newMetaObject(handler);

        MappedStatement ms = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        System.err.println(boundSql.getSql());
        String msId = ms.getId();

        if (msId != null && msId.endsWith(".updateById")) {
            Object param = boundSql.getParameterObject();
            boolean hasEt = false;
            Object entity;
            if (param instanceof Map && ((Map<?, ?>) param).containsKey("et")) {
                hasEt = true;
                entity = ((Map<?, ?>) param).get("et");
            } else {
                entity = param;
            }

            if (entity != null) {
                String table = toSnake(entity.getClass().getSimpleName());
                StringJoiner sets = new StringJoiner(", ");
                Object idValue = null;

                for (Field f : entity.getClass().getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                    f.setAccessible(true);
                    Object value = f.get(entity);
                    String name = f.getName();
                    if ("id".equalsIgnoreCase(name)) {
                        idValue = value;
                        continue;
                    }
                    if (value == null) continue; // 仅更新非空字段
                    String col = toSnake(name);
                    sets.add(col + " = #{" + (hasEt ? "et." : "") + name + "}");
                }

                if (idValue == null) {
                    throw new IllegalArgumentException("updateById requires non-null id field");
                }

                String newSql = "update " + table + " set " + sets + " where id = #{" + (hasEt ? "et." : "") + "id}";
                setSql(boundSql, newSql);
            }
        }

        return invocation.proceed();
    }

    private void setSql(BoundSql boundSql, String sql) throws NoSuchFieldException, IllegalAccessException {
        Field sqlField = boundSql.getClass().getDeclaredField("sql");
        sqlField.setAccessible(true);
        sqlField.set(boundSql, sql);
    }

    private String toSnake(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c) && i > 0) sb.append('_');
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}

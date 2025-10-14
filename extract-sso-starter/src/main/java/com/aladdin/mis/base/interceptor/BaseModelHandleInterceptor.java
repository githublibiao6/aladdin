package com.aladdin.mis.base.interceptor;

import com.aladdin.mis.base.db.core.DbPro;
import com.aladdin.mis.base.model.BaseModel;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 在执行前拦截并重写 BaseMapper.updateById 的 SQL。
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update",
                args = {MappedStatement.class, Object.class})
})
public class BaseModelHandleInterceptor implements Interceptor {

    @Autowired
    @Lazy
    private DbPro dbPro;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        String msId = ms.getId();
        if (msId != null ) {
            String newSql = "";
            if(msId.endsWith(".updateById")){
                Object param = args[1];
                BaseModel baseModel = (BaseModel) ((Map<?, ?>) param).get("et");
                newSql =  dbPro.getUpdateSql(baseModel);
                System.err.println("newSql" + newSql);
            }
            resetMappedStatement(ms, newSql, invocation);
        }
        return invocation.proceed();
    }

    private void resetMappedStatement(MappedStatement ms, String newSql, Invocation invocation)
            throws NoSuchFieldException, IllegalAccessException {
        BoundSql boundSql = ms.getBoundSql(invocation.getArgs()[1]);
        Field sqlField = boundSql.getClass().getDeclaredField("sql");
        sqlField.setAccessible(true);
        sqlField.set(boundSql, newSql);
    }
}

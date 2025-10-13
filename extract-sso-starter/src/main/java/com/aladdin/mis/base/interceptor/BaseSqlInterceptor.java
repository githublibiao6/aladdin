package com.aladdin.mis.base.interceptor;

import com.aladdin.mis.base.mapper.BaseMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;


/**
 * 基础拦截
 */
@Intercepts({
        @Signature(type = Executor.class, method = "updateById",
                args = {BaseMapper.class, Object.class})
})
public class BaseSqlInterceptor  implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.print("invocation");
        return null;
    }
}

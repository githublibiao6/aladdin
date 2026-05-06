package com.aladdin.common.db.interceptor;

import com.aladdin.common.core.context.UserContextHolder;
import com.aladdin.common.core.domain.BaseEntity;
import com.aladdin.common.core.utils.IdUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * 自动填充拦截器
 *
 * @author cles
 * @date 2026/05/06
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class AutoFillInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(AutoFillInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];

        if (parameter instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) parameter;
            LocalDateTime now = LocalDateTime.now();
            Long currentUserId = getCurrentUserId();

            if (ms.getSqlCommandType() == SqlCommandType.INSERT) {
                fillInsert(entity, now, currentUserId);
            } else if (ms.getSqlCommandType() == SqlCommandType.UPDATE) {
                fillUpdate(entity, now, currentUserId);
            }
        }

        return invocation.proceed();
    }

    private void fillInsert(BaseEntity entity, LocalDateTime now, Long userId) {
        if (entity.getId() == null) {
            entity.setId(IdUtil.nextId());
        }
        if (entity.getSys001() == null) {
            entity.setSys001(now);
        }
        if (entity.getSys002() == null) {
            entity.setSys002(now);
        }
        if (entity.getSys003() == null) {
            entity.setSys003(userId);
        }
        if (entity.getSys004() == null) {
            entity.setSys004(userId);
        }
        if (entity.getSys005() == null) {
            entity.setSys005(1);
        }
    }

    private void fillUpdate(BaseEntity entity, LocalDateTime now, Long userId) {
        entity.setSys002(now);
        entity.setSys004(userId);
    }

    private Long getCurrentUserId() {
        try {
            Long userId = UserContextHolder.getUserId();
            return userId != null ? userId : 0L;
        } catch (Exception e) {
            return 0L;
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

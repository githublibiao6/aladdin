package com.aladdin.common.security.handler;

import com.aladdin.common.core.domain.R;
import com.aladdin.common.core.exception.GlobalErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SecurityExceptionHandler 单元测试
 * 覆盖：AccessDeniedException处理、返回403状态码
 */
@DisplayName("安全异常处理器测试")
class SecurityExceptionHandlerTest {

    private final SecurityExceptionHandler handler = new SecurityExceptionHandler();

    @Test
    @DisplayName("处理AccessDeniedException - 返回403错误码")
    void handleAccessDeniedException_returns403() {
        AccessDeniedException exception = new AccessDeniedException("Access is denied");

        R<Void> result = handler.handleAccessDeniedException(exception);

        assertNotNull(result);
        assertEquals(GlobalErrorCode.FORBIDDEN.getCode(), result.getCode());
        assertEquals(GlobalErrorCode.FORBIDDEN.getMsg(), result.getMsg());
        assertNull(result.getData());
    }

    @Test
    @DisplayName("处理AccessDeniedException - 自定义消息")
    void handleAccessDeniedException_customMessage() {
        AccessDeniedException exception = new AccessDeniedException("无权限访问用户管理");

        R<Void> result = handler.handleAccessDeniedException(exception);

        assertEquals(403, result.getCode());
        assertEquals("无权限", result.getMsg());
    }

    @Test
    @DisplayName("处理AccessDeniedException - null消息")
    void handleAccessDeniedException_nullMessage() {
        AccessDeniedException exception = new AccessDeniedException(null);

        R<Void> result = handler.handleAccessDeniedException(exception);

        assertEquals(403, result.getCode());
        assertNotNull(result);
    }

    @Test
    @DisplayName("返回结果isSuccess为false")
    void handleAccessDeniedException_resultIsNotSuccess() {
        AccessDeniedException exception = new AccessDeniedException("denied");

        R<Void> result = handler.handleAccessDeniedException(exception);

        assertFalse(result.isSuccess());
    }
}

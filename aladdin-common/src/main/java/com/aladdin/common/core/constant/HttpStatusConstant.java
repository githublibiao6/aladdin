package com.aladdin.common.core.constant;

/**
 * HTTP状态码常量
 *
 * @author cles
 * @date 2026/04/30
 */
public interface HttpStatusConstant {

    int SUCCESS = 200;
    int CREATED = 201;
    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int METHOD_NOT_ALLOWED = 405;
    int TOO_MANY_REQUESTS = 429;
    int INTERNAL_SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int SERVICE_UNAVAILABLE = 503;
    int GATEWAY_TIMEOUT = 504;
}

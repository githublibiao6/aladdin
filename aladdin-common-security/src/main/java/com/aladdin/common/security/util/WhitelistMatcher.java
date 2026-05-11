package com.aladdin.common.security.util;

import org.springframework.util.AntPathMatcher;

import java.util.List;

/**
 * 白名单路径匹配工具
 *
 * @author cles
 * @date 2026/05/07
 */
public class WhitelistMatcher {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    private WhitelistMatcher() {
    }

    public static boolean match(List<String> patterns, String requestPath) {
        if (patterns == null || patterns.isEmpty() || requestPath == null) {
            return false;
        }
        for (String pattern : patterns) {
            if (PATH_MATCHER.match(pattern, requestPath)) {
                return true;
            }
        }
        return false;
    }
}

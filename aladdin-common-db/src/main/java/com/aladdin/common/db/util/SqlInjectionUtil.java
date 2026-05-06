package com.aladdin.common.db.util;

import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * SQL注入防护工具
 *
 * @author cles
 * @date 2026/05/06
 */
public class SqlInjectionUtil {

    private static final Logger log = LoggerFactory.getLogger(SqlInjectionUtil.class);

    private static final Pattern[] DANGEROUS_PATTERNS = {
            Pattern.compile("(?i)(\\b(insert|delete|update|select|drop|truncate|exec|execute|alter|create)\\b.*\\b(from|into|table|database|set)\\b)"),
            Pattern.compile("(?i)(\\b(union)\\b.*\\b(select)\\b)"),
            Pattern.compile("(?i)(\\b(or|and)\\b\\s+\\d+\\s*=\\s*\\d+)"),
            Pattern.compile("(?i)(\\b(or|and)\\b\\s+['\"]\\w+['\"]\\s*=\\s*['\"]\\w+['\"])"),
            Pattern.compile("(?i)(--|/\\*|\\*/|;|\\b(waitfor)\\b\\s+\\b(delay)\\b)"),
            Pattern.compile("(?i)(\\b(exec|execute)\\b\\s*\\()"),
            Pattern.compile("(?i)(\\b(char|concat)\\b\\s*\\()"),
            Pattern.compile("(?i)(\\b(load_file|benchmark|sleep)\\s*\\()")
    };

    public static void validate(String value) {
        if (value == null || value.isEmpty()) {
            return;
        }
        for (Pattern pattern : DANGEROUS_PATTERNS) {
            if (pattern.matcher(value).find()) {
                log.warn("SQL注入风险检测: value={}", value);
                throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "参数包含非法字符");
            }
        }
    }

    public static void validateTableName(String tableName) {
        if (tableName == null || tableName.isEmpty()) {
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "表名不能为空");
        }
        if (!Pattern.matches("^[a-zA-Z_][a-zA-Z0-9_]*$", tableName)) {
            log.warn("非法表名: {}", tableName);
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "表名格式非法");
        }
    }

    public static void validateColumnName(String columnName) {
        if (columnName == null || columnName.isEmpty()) {
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "列名不能为空");
        }
        if (!Pattern.matches("^[a-zA-Z_][a-zA-Z0-9_]*$", columnName)) {
            log.warn("非法列名: {}", columnName);
            throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "列名格式非法");
        }
    }

    public static String escape(String value) {
        if (value == null) {
            return null;
        }
        return value.replace("'", "''")
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }
}

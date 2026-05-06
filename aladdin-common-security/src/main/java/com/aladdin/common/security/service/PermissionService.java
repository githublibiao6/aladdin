package com.aladdin.common.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 权限校验服务
 *
 * @author cles
 * @date 2026/05/06
 */
@Component("perm")
public class PermissionService {

    public boolean hasPermission(String permission) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        return authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals(permission));
    }

    public boolean hasAnyPermission(String... permissions) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Set<String> authSet = java.util.Arrays.stream(permissions).collect(java.util.stream.Collectors.toSet());
        return authentication.getAuthorities().stream()
                .anyMatch(auth -> authSet.contains(auth.getAuthority()));
    }

    public boolean hasRole(String role) {
        return hasPermission("ROLE_" + role);
    }

    public boolean hasAnyRole(String... roles) {
        String[] rolePermissions = java.util.Arrays.stream(roles)
                .map(r -> "ROLE_" + r)
                .toArray(String[]::new);
        return hasAnyPermission(rolePermissions);
    }
}

package com.aladdin.common.security.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LoginUserDetails 单元测试
 * 覆盖：权限构建、用户状态、账号锁定逻辑
 */
@DisplayName("登录用户详情测试")
class LoginUserDetailsTest {

    @Test
    @DisplayName("创建用户 - 权限正确转换")
    void create_permissions_convertedToAuthorities() {
        Set<String> permissions = new HashSet<>();
        permissions.add("system:user:list");
        permissions.add("system:role:list");

        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, permissions);

        assertEquals(2, user.getAuthorities().size());
        Set<String> authNames = new HashSet<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            authNames.add(auth.getAuthority());
        }
        assertTrue(authNames.contains("system:user:list"));
        assertTrue(authNames.contains("system:role:list"));
    }

    @Test
    @DisplayName("创建用户 - null权限列表不报错")
    void create_nullPermissions_noError() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, null);

        assertTrue(user.getAuthorities().isEmpty());
    }

    @Test
    @DisplayName("创建用户 - 空权限列表")
    void create_emptyPermissions_emptyAuthorities() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, new HashSet<>());

        assertTrue(user.getAuthorities().isEmpty());
    }

    @Test
    @DisplayName("用户状态1 - 账号启用且未锁定")
    void status1_accountEnabledAndUnlocked() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, new HashSet<>());

        assertTrue(user.isEnabled());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    @DisplayName("用户状态0 - 账号禁用且锁定")
    void status0_accountDisabledAndLocked() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 0, new HashSet<>());

        assertFalse(user.isEnabled());
        assertFalse(user.isAccountNonLocked());
    }

    @Test
    @DisplayName("用户状态null - 默认启用")
    void statusNull_defaultEnabled() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", null, new HashSet<>());

        assertTrue(user.isEnabled());
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    @DisplayName("用户基本信息正确")
    void basicInfo_correct() {
        LoginUserDetails user = new LoginUserDetails(1L, "admin", "encrypted", 1, new HashSet<>());

        assertEquals(1L, user.getUserId());
        assertEquals("admin", user.getUsername());
        assertEquals("encrypted", user.getPassword());
    }

    @Test
    @DisplayName("ROLE_前缀权限正确识别")
    void rolePrefix_recognizedAsAuthority() {
        Set<String> permissions = new HashSet<>();
        permissions.add("ROLE_admin");
        permissions.add("ROLE_user");

        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, permissions);

        Set<String> authNames = new HashSet<>();
        for (GrantedAuthority auth : user.getAuthorities()) {
            authNames.add(auth.getAuthority());
        }
        assertTrue(authNames.contains("ROLE_admin"));
        assertTrue(authNames.contains("ROLE_user"));
    }

    @Test
    @DisplayName("混合角色和菜单权限")
    void mixedRoleAndMenuPerms_allPresent() {
        Set<String> permissions = new HashSet<>();
        permissions.add("ROLE_admin");
        permissions.add("system:user:list");
        permissions.add("system:role:list");
        permissions.add("system:user:add");

        LoginUserDetails user = new LoginUserDetails(1L, "admin", "pass", 1, permissions);

        assertEquals(4, user.getAuthorities().size());
    }
}

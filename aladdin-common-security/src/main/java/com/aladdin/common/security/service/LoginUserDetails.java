package com.aladdin.common.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 登录用户详情
 *
 * @author cles
 * @date 2026/05/06
 */
public class LoginUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private Integer status;
    private Set<GrantedAuthority> authorities;
    private Set<String> roleKeys;
    private Map<String, Object> attributes = new HashMap<>();

    public LoginUserDetails(Long userId, String username, String password, Integer status, Set<String> permissions) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.authorities = new HashSet<>();
        if (permissions != null) {
            for (String perm : permissions) {
                this.authorities.add(new SimpleGrantedAuthority(perm));
            }
        }
    }

    public LoginUserDetails(Long userId, String username, String nickname, String password, Integer status, Set<String> permissions, Set<String> roleKeys) {
        this(userId, username, password, status, permissions);
        this.nickname = nickname;
        this.roleKeys = roleKeys;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public Set<String> getRoleKeys() {
        return roleKeys;
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == null || status == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == null || status == 1;
    }
}

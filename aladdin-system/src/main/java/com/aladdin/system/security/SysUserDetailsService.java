package com.aladdin.system.security;

import com.aladdin.common.security.service.LoginUserDetails;
import com.aladdin.common.security.service.SecurityUserDetailsService;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SysUserDetailsService implements SecurityUserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(SysUserDetailsService.class);

    private static final String DEV_PASSWORD = "123456";

    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;

    public SysUserDetailsService(SysUserService sysUserService, @Lazy PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户
        SysUser user = sysUserService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在：" + username);
        }

        if (DEV_PASSWORD.equals(user.getPassword()) || !user.getPassword().startsWith("$2a$")) {
            log.info("开发模式：重置用户[{}]密码为BCrypt加密", username);
            user.setPassword(passwordEncoder.encode(DEV_PASSWORD));
            sysUserService.updateById(user);
        }

        Set<String> permissions = new HashSet<>();
        Set<String> roleKeys = sysUserService.getRoleKeysByUserId(user.getId());
        for (String roleKey : roleKeys) {
            if (roleKey != null && !roleKey.trim().isEmpty()) {
                permissions.add("ROLE_" + roleKey);
            }
        }
        Set<String> perms = sysUserService.getPermsByUserId(user.getId());
        for (String perm : perms) {
            if (perm != null && !perm.trim().isEmpty()) {
                permissions.add(perm);
            }
        }

        LoginUserDetails userDetails = new LoginUserDetails(user.getId(), user.getUsername(), user.getNickname(),
                user.getPassword(), user.getStatus(), permissions, roleKeys);
        // 设置租户ID到用户属性
        if (user.getTenantId() != null) {
            userDetails.setAttribute("tenantId", user.getTenantId());
        }
        return userDetails;
    }
}

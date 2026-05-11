package com.aladdin.system.security;

import com.aladdin.common.security.service.LoginUserDetails;
import com.aladdin.common.security.service.SecurityUserDetailsService;
import com.aladdin.system.entity.SysUser;
import com.aladdin.system.service.SysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户详情服务实现
 * <p>
 * 连接Spring Security认证与系统用户表
 *
 * @author cles
 * @date 2026/05/06
 */
@Service
public class SysUserDetailsService implements SecurityUserDetailsService {

    private final SysUserService sysUserService;

    public SysUserDetailsService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存：" + username);
        }

        Set<String> permissions = new HashSet<>();
        Set<String> roleKeys = sysUserService.getRoleKeysByUserId(user.getId());
        for (String roleKey : roleKeys) {
            permissions.add("ROLE_" + roleKey);
        }
        Set<String> perms = sysUserService.getPermsByUserId(user.getId());
        permissions.addAll(perms);

        return new LoginUserDetails(user.getId(), user.getUsername(), user.getPassword(),
                user.getStatus(), permissions);
    }
}

package com.aladdin.common.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;

/**
 * 用户详情服务接口
 * <p>
 * 业务系统需实现此接口，提供用户查询和权限加载能力
 *
 * @author cles
 * @date 2026/05/06
 */
public interface SecurityUserDetailsService extends UserDetailsService {

    /**
     * 根据用户名加载用户
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * 根据用户ID加载权限标识
     */
    default Map<String, Object> loadUserPermissions(Long userId) {
        return null;
    }
}

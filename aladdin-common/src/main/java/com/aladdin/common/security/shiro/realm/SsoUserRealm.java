package com.aladdin.common.security.shiro.realm;

import com.aladdin.common.security.entity.OmUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class SsoUserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new org.apache.shiro.authz.AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        OmUser user = (OmUser) getAvailablePrincipal(principals);
        Set<String> roles = new HashSet<>();
        roles.add("guest");

        Set<String> permissions = new HashSet<>();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        throw new AuthenticationException("SsoUserRealm does not support direct authentication. Use SsoAuth for token-based login.");
    }
}

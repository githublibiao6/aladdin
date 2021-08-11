package com.aladdin.mis.omnipotent.system.shiro.realm;
/**
 * Created by cles on 2020/4/23 22:39
 */

import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.service.AdminService;
import com.aladdin.mis.service.impl.MenuServiceImpl;
import com.aladdin.mis.service.impl.RoleServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 用户Realm
 * @Date 2020/4/23 22:39
 * @author cles
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    MenuServiceImpl menuService;

    /* 判断密码？ */
    /*{
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashMatcher.setStoredCredentialsHexEncoded(false);
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
    }*/
    /**
    * @Description: 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
    * @Param: [principalCollection]
    * @return: org.apache.shiro.authz.AuthorizationInfo
    * @Author: cles
    * @Date: 2020/4/23 22:40
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        Admin admin0 = (Admin) getAvailablePrincipal(principals);
//        Admin admin = adminService.findById(1);
        Admin admin = new Admin();
        admin.setId(1);
        admin.setLoginName("1");
        admin.setLoginPassword("1");

        if (admin == null) {
            throw new UnknownAccountException("No account found for admin [" + admin0.getLoginName() + "]");
        }
        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        // Object a = SecurityUtils.getSubject().getPrincipal();
        Set<String> roles = roleService.getRolesByUserId(admin.getId());
        roles.add("admin");
        // 获取菜单权限
        Set<String> perms = new HashSet<>();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 用户权限
        Set<String> permissions = menuService.queryByRoles(roles);

//        permissions.add("/**");
        info.setRoles(roles);
        info.setStringPermissions(permissions);
//        info.addStringPermission("/roles/list");
        return info;
    }

    /**
    * @Description: 定义如何获取用户信息的业务逻辑，给shiro做登录
    * @Param: [authenticationToken]
    * @return: org.apache.shiro.authc.AuthenticationInfo
    * @Author: cles
    * @Date: 2020/4/23 22:40
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        Admin admin = new Admin();
        admin.setId(1);
        admin.setLoginName("1");
        admin.setLoginPassword("1");
        /*try{
            admin = adminService.findById(1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }*/
        //单用户登录
        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        //获取当前已登录的用户session列表
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
        System.err.println(sessions.size());
        Admin temp;
        for(Session session : sessions){
            //清除该用户以前登录时保存的session，强制退出
            System.err.println(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }

            temp = (Admin) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if(username.equals(temp.getLoginName())) {
                sessionManager.getSessionDAO().delete(session);
            }
        }

        Collection<Session> sessions2 = sessionManager.getSessionDAO().getActiveSessions();
        System.err.println(sessions2.size());

        if (admin == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }

        // todo upToken.getPassword() 前台传的密码
        // 和 admin.getLoginPassword() 比较
        SimpleAuthenticationInfo  info = new SimpleAuthenticationInfo(admin, upToken.getPassword(), getName());
        return info;
    }
}

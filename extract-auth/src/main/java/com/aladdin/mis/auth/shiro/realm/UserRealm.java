package com.aladdin.mis.auth.shiro.realm;
/**
 * Created by cles on 2020/4/23 22:39
 */

import com.aladdin.mis.common.currency.DefaultTools;
import com.aladdin.mis.manager.bean.Admin;
import com.aladdin.mis.manager.bean.Dept;
import com.aladdin.mis.manager.service.*;
import com.aladdin.mis.manager.vo.BeUserMenuVo;
import com.aladdin.mis.system.user.vo.OmUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 用户Realm
 * @Date 2020/4/23 22:39
 * @author cles
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BeUserMenuService userMenuService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private DeptService deptService;


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

        OmUser user = (OmUser) getAvailablePrincipal(principals);

        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        // Object a = SecurityUtils.getSubject().getPrincipal();
//        Set<String> roles = roleService.getRolesByUserId(admin.getId());
        Set<String> roles = new HashSet<>();
        roles.add("guest");
        // 获取用户的权限
        List<BeUserMenuVo> userMenuVos = userMenuService.queryMenuByUserId(user.getUserId());
        userMenuVos.forEach(t->{
            roles.add(t.getRoleCode());
        });

        // 获取菜单权限
        Set<String> permissions = new HashSet<>();
        userMenuVos.forEach(t->{
            permissions.add(t.getMenuPermissions());
        });

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用户权限
//        Set<String> permissions = menuService.queryByRoles(roles);
//        permissions.add("/**");
        info.setRoles(roles);
        info.setStringPermissions(permissions);
//        info.addStringPermission("/roles/list");
        return info;
    }

    /**
     * http://refined-x.com/2017/08/29/%E5%9F%BA%E4%BA%8EVue%E5%AE%9E%E7%8E%B0%E5%90%8E%E5%8F%B0%E7%B3%BB%E7%BB%9F%E6%9D%83%E9%99%90%E6%8E%A7%E5%88%B6/
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
        char[] passwordChar = upToken.getPassword();
        String password = String.valueOf(passwordChar);

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        Admin admin = new Admin();
//        admin.setId(1);
//        admin.setLoginName("1");
//        admin.setLoginPassword("1");
        List<Admin> list = adminService.findByAccount(username);
        if(list == null || list.isEmpty()){
            throw new UnknownAccountException("未找到该用户");
        }
        if(list.size() > 1){
            throw new AccountException("重复的用户");
        }
        admin = list.get(0);
        String salt = admin.getSalt();
        String pass = DefaultTools.Md5Tool.digestHex(password + salt);
        if(!pass.equals(admin.getLoginPassword())){
            throw new AccountException("密码错误");
        }

        Integer deptId = admin.getDeptId();
        Dept dept = deptService.findById(deptId);
        if(deptId == null || dept == null){
            throw new AccountException("用户无权限");
        }
        OmUser user = new OmUser();
        user.setUserId(admin.getId());
        user.setUserName(admin.getLoginName());
        user.setDeptId(deptId);
        user.setDeptName(dept.getName());
        //单用户登录
        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        //获取当前已登录的用户session列表
//        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
//        System.err.println(sessions.size());
//        for(Session session : sessions){
//            //清除该用户以前登录时保存的session，强制退出
//            System.err.println(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//            Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//            if (attribute == null) {
//                continue;
//            }
//
//            temp = (Admin) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
//            if(username.equals(temp.getLoginName())) {
//                sessionManager.getSessionDAO().delete(session);
//            }
//        }

        Collection<Session> sessions2 = sessionManager.getSessionDAO().getActiveSessions();
        System.err.println(sessions2.size());

        // todo upToken.getPassword() 前台传的密码
        // 和 admin.getLoginPassword() 比较
        SimpleAuthenticationInfo  info = new SimpleAuthenticationInfo(user, upToken.getPassword(), getName());
        return info;
    }
}

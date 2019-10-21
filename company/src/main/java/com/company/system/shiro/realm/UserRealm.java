package com.company.system.shiro.realm;

import com.company.manage.admin.bean.Admin;
import com.company.manage.admin.service.impl.AdminServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
/**
 * 1.继承AuthenticatingRealm，只需要验证 org.apache.shiro.realm.AuthenticatingRealm
 * 2.继承AuthorizingRealm 验证加授权  org.apache.shiro.realm.AuthorizingRealm;
 * @author lb
 * @date 2018年5月30日 下午8:16:52
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    AdminServiceImpl adminService;
    
    /**
     * 用于验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 将前台传入的数值加入shiro中
        System.err.println("****************进入shiro验证****************************");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String loginName = upToken.getUsername();
        char[] pass = upToken.getPassword();
        System.out.println(pass.length);
        System.err.println(11111);
        //调用数据库查询
        Admin admin = adminService.getByname(loginName,String.valueOf(pass));
        System.err.println(loginName);
        System.err.println(pass.toString());
        System.err.println(admin);
        if(admin == null ){
            System.out.println("****************没有该用户****************");
            throw new UnknownAccountException();
        }else {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(session.getId(), admin);
            session.setAttribute(session.getId()+"id", admin.getId());
            session.setAttribute(session.getId()+"username", admin.getLoginName());
//            session.setAttribute(session.getId()+"type", "admin");
//            session.setAttribute(session.getId()+"dept", admin.getDeptId());
            session.setTimeout(1000L*60*30);
            // 传入的是从数据库得到的密码和用户名   第一个值也可以是实体类
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin.getLoginName(), admin.getLoginPassword(), getName());
        /*SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getLoginName(),
                user.getLoginPassword(),
                getName());*/
            System.err.println("****************shiro验证完成****************************");
            return info;
        }
    }
    
    /**
     * 用于授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipals) {
        System.err.println("************************shiro授权********************************");
        Object principal = pricipals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        pricipals.getRealmNames();
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        //可能需要查询数据库用户的权限，或是根据传入的实体类来判断权限
        if("admin".equals(principal)){
            roles.add("admin");
        }
        info.setRoles(roles);
        info.setStringPermissions(roles);
//        SimpleAuthorizationInfo info1 = new SimpleAuthorizationInfo(roles);
        System.err.println("************************shiro完成********************************");
        System.err.println("用户角色："+roles);
        return info;
    }

    
}
package com.aladdin.mis.shiro.config;
/**
 * Created by cles on 2020/4/27 21:52
 */

import com.aladdin.mis.shiro.realm.UserRealm;
import jakarta.servlet.Filter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.*;

/**
 * @description: shiro
 * @Author cles
 * @Date 2020/4/27 21:52
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建过滤器
     * @param securityManager manager
     * @return bean
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*Shiro配置类的过滤器中启用安全管理器，即shiroFilterFactoryBean中配置SecurityManager*/
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /* fixme
        添加Shiro内置过滤器，常用的有如下过滤器：
        anon： 无需认证就可以访问
        authc： 必须认证才可以访问
        user： 如果使用了记住我功能就可以直接访问
        perms:    拥有某个资源权限才可以访问
        role： 拥有某个角色权限才可以访问
        */
        //设置拦截默认访问，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/auth/interceptLogin");
        //设置登录成功后需要跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/auth/welcome");
        // 没有权限的设置
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/unauthorizedUrl");

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>(16);
        filterChainDefinitionMap.put("/shiro/user/add","authc");  //这里user/*可以通配符的
        filterChainDefinitionMap.put("/shiro/user/update","authc");
        filterChainDefinitionMap.put("/shiro/queryList","authc");

        // fixme 添加自己的过滤器
//        Map<String, Filter> filterMap = new HashMap<String, Filter>(16);
//        filterMap.put("jwt", new CustomRolesAuthorizationFilter()); // 自己定义的过滤类型
//        filterMap.put("authc", new ShiroFormAuthenticationFilter());
//        filterMap.put("jwt", new CustomPermissionsAuthorizationFilter());
//        filterMap.put("authc", new UserFormAuthenticationFilter());
//        filterMap.put("authc", new ShiroFormAuthenticationFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);

        // 数据库设置规则 service
//        filterChainDefinitionMap = shiroService.loadFilterChainDefinitions();
//        filterChainDefinitionMap.put("/testing","jwt");
//        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //  修改到要跳转的login页面(shrio没security会帮你自动生成一个登录的，得自己写)；
        shiroFilterFactoryBean.setLoginUrl("/shiro/toLogin");
        return shiroFilterFactoryBean;
    }

    @Bean
    public UserRealm userRealm(){
        return  new UserRealm();
    }


    /**  SecurityManager安全管理器需要到realm中去验证认证信息，所以给SecurityManager设置Realm
    * @Description:
    * @Param: []
    * @return: org.apache.shiro.web.mgt.DefaultWebSecurityManager
    * @Author: cles
    * @Date: 2020/4/27 23:29
    */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);

        //  fixme  多个 realms？
        /* List<Realm> list = new ArrayList<>();
        list.add(myRealm());
        securityManager.setRealms(list);*/

        return manager;
    }
}

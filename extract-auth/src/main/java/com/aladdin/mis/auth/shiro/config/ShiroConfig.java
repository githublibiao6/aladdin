package com.aladdin.mis.auth.shiro.config;
/**
 * Created by cles on 2020/4/27 21:52
 */

import com.aladdin.mis.auth.shiro.service.ShiroService;
import com.aladdin.mis.auth.shiro.realm.UserRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;

/**
 * @description: shiro
 * @Author cles
 * @Date 2020/4/27 21:52
 */
@Configuration
public class ShiroConfig {


    /**
     * @Description:  开启注解
     * @return: org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     * @Author: cles
     * @Date: 2020/5/15 0:22
     */
    @Bean(name = "sourceAdvisor")
    public AuthorizationAttributeSourceAdvisor sourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }

    /**
     * 附名后正确运行
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager, ShiroService shiroService){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*Shiro配置类的过滤器中启用安全管理器，即shiroFilterFactoryBean中配置SecurityManager*/
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置拦截默认访问，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/system/interceptLogin");
        //设置登录成功后需要跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/system/welcome");
        // 没有权限的设置
        shiroFilterFactoryBean.setUnauthorizedUrl("/system/unauthorizedUrl");

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 添加自己的过滤器
        Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
//        filterMap.put("jwt", new CustomRolesAuthorizationFilter()); // 自己定义的过滤类型
//        filterMap.put("authc", new ShiroFormAuthenticationFilter());

        filterMap.put("authc", new UserFormAuthenticationFilter());
        filterMap.put("perms", new CustomPermissionsAuthorizationFilter());

        shiroFilterFactoryBean.setFilters(filterMap);
        //设置规则
        filterChainDefinitionMap = shiroService.loadFilterChainDefinitions();
//        filterChainDefinitionMap.put("/**","jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /*@Bean
    public CustomRolesAuthorizationFilter rolesAuthorizationFilter() {
        return new CustomRolesAuthorizationFilter();
    }*/


    /**  SecurityManager安全管理器需要到realm中去验证认证信息，所以给SecurityManager设置Realm
    * @Description:
    * @Param: []
    * @return: org.apache.shiro.web.mgt.DefaultWebSecurityManager
    * @Author: cles
    * @Date: 2020/4/27 23:29
    */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        manager.setRealm(myRealm());
//        manager.setRealm(realm);
//        多个 realms？
/*        List<Realm> list = new ArrayList<>();
        list.add(myRealm());
        securityManager.setRealms(list);*/
        /*
         *SecurityManager安全管理器需要到realm中去验证认证信息，所以给SecurityManager设置Realm。*/
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);

//        manager.setCacheManager();
        manager.setSessionManager(sessionManager());
        return manager;
    }

    /**
     * 管理session
     * @return
     */
    /*@Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        sessionManager.setSessionDAO(redisSessionDAO());
        sessionListeners.add(customSessionListener());

        return sessionManager;
    }*/


    /**
     * @Description: 自定义的 shiro session 缓存管理器
     * 用于跨域等情况下获取请求头中的sessionId
     * @method: sessionManager
     * @author: MengyuWu
     * @date: 18:38 2019-8-26
     * @throws
     **/

    @Bean
    public SessionManager sessionManager()
    {
        // 将我们继承后重写的shiro session 注册
        MySessionManager sessionManager = new MySessionManager();

        Collection<SessionListener> sessionListeners = new ArrayList<>();
        sessionManager.setSessionListeners(sessionListeners);
        // 单位为毫秒，600000毫秒为1个小时
        sessionManager.setSessionValidationInterval(3600000 * 12);
        // 3600000 milliseconds = 1 hour
        sessionManager.setGlobalSessionTimeout(3600000 * 12);
        // 是否删除无效的，默认也是开启
        sessionManager.setDeleteInvalidSessions(true);
        // 是否开启 检测，默认开启
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 创建会话Cookie
        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setName("WEBID");
        cookie.setHttpOnly(true);
        sessionManager.setSessionIdCookie(cookie);
        // 处理sessionDao
//        sessionManager.setSessionDAO();

        // 单位为毫秒，600000毫秒为1个小时
        sessionManager.setSessionValidationInterval(3600000 * 12);
        // 3600000 milliseconds = 1 hour
        sessionManager.setGlobalSessionTimeout(1000 * 60 * 60 * 12);
        // 是否删除无效的，默认也是开启
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    @Bean(name = "myRealm")
    public UserRealm myRealm(){
        UserRealm myRealm =  new UserRealm();
        return myRealm;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 添加注解支持
     */
    @Bean("defaultAdvisorAutoProxyCreator")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        //指定强制使用cglib为action创建代理对象
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * Redis集群使用RedisClusterManager，单个Redis使用RedisManager
     * @param redisProperties
     * @return
     */
    /*@Bean
    public RedisClusterManager redisManager(RedisProperties redisProperties) {
        RedisClusterManager redisManager = new RedisClusterManager();
        redisManager.setHost(redisProperties.getHost());
        redisManager.setPassword(redisProperties.getPassword());
        return redisManager;
    }*/
}

package com.aladdin.mis.sso.shiro.config;
/**
 * Created by cles on 2020/4/27 21:52
 */

import com.aladdin.mis.sso.shiro.realm.UserRealm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

//        SecurityManager安全管理器需要到realm中去验证认证信息，所以给SecurityManager设置Realm。*/

        // fixme 查看具体作用
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        manager.setSubjectDAO(subjectDAO);

//        manager.setCacheManager();
        manager.setSessionManager(sessionManager());

        return manager;
    }

    /**
     * @Description: 自定义的 shiro session 缓存管理器
     * 用于跨域等情况下获取请求头中的sessionId
     * @method: sessionManager
     * @author: MengyuWu
     * @date: 18:38 2019-8-26
     * @throws
     **/

    @Bean
    public SessionManager sessionManager(){
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
        // fixme 处理sessionDao 如果我们要自己保存session的话，比如将session保存到redis中实现集群间的session同步，
        //  我们就可以实现自己的sessionDao类，继承AbstractSessionDAO。
//        sessionManager.setSessionDAO();

        // 单位为毫秒，600000毫秒为1个小时
        sessionManager.setSessionValidationInterval(3600000 * 12);
        // 3600000 milliseconds = 1 hour
        sessionManager.setGlobalSessionTimeout(1000 * 60 * 60 * 12);
        // 是否删除无效的，默认也是开启
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }
}

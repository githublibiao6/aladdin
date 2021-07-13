package com.aladdin.mis.omnipotent.system.shiro.service;
/**
 * Created by cles on 2020/5/18 22:57
 */

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author cles
 * @Date 2020/5/18 22:57
 */
@Service("shiroService")
public class ShiroService {

    /**
     * 初始化权限
     */
    public Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /*List<Authority> authorities = authorityMapper.findAuthorities();
        // 权限控制map.从数据库获取角色

        if (authorities.size() > 0) {
            String uris;
            String[] uriArr;
            for (Authority authority : authorities) {
                if (StringUtils.isEmpty(authority.getPermission())) {
                    continue;
                }
                uris = authority.getUri();
                uriArr = uris.split(",");
                for (String uri : uriArr) {
                    filterChainDefinitionMap.put(uri, authority.getPermission());
                }
            }
        }*/
        //配置匿名可访问页面和静态文件
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/pic/**","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/ajaxLogin","anon");
        // 放开登录接口
        filterChainDefinitionMap.put("/**/login","anon");
        filterChainDefinitionMap.put("/**/logout","anon");
        // 测试接口
        filterChainDefinitionMap.put("/test/**","anon");
        // 开放接口
        filterChainDefinitionMap.put("/api/**","anon");
        // 获取信息接口
        filterChainDefinitionMap.put("/user/info","anon");
//        filterChainDefinitionMap.put("/menu/list","authc");
//        filterChainDefinitionMap.put("/menu/page","anon");
        filterChainDefinitionMap.put("/logout","logout");
        //过滤器规则，从上而下顺序执行，将/**放在最后
        filterChainDefinitionMap.put("/**","authc");
        /*filterChainDefinitionMap.put("/user/login", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/user/logout", "anon");
        filterChainDefinitionMap.put("/**", "authc");*/
        return filterChainDefinitionMap;
    }

    /**
     * 在对角色进行增删改操作时，需要调用此方法进行动态刷新
     * @param shiroFilterFactoryBean
     */
    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        synchronized (this) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim()
                        .replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }
}

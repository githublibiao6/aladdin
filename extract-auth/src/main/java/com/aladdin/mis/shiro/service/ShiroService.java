package com.aladdin.mis.shiro.service;

import com.aladdin.common.core.utils.StringUtil;
import com.aladdin.common.security.config.SecurityProperties;
import com.aladdin.mis.shiro.vo.BeAuthUrlVo;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroService {

    @Autowired
    private BeAuthUrlService beAuthUrlService;

    @Autowired
    private SecurityProperties securityProperties;

    public Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        List<BeAuthUrlVo> authorities = beAuthUrlService.list();

        if (authorities.size() > 0) {
            for (BeAuthUrlVo authUrl : authorities) {
                if (StringUtil.isEmpty(authUrl.getUrl())) {
                    continue;
                }
                if (StringUtil.isEmpty(authUrl.getPermission())) {
                    continue;
                }
                filterChainDefinitionMap.put(authUrl.getUrl(), authUrl.getPermission());
            }
        }

        List<String> whitelist = securityProperties.getWhitelist();
        if (whitelist != null && !whitelist.isEmpty()) {
            for (String pattern : whitelist) {
                filterChainDefinitionMap.put(pattern, "anon");
            }
        }

        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }

    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        synchronized (this) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }
        }
    }
}

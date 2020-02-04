package com.yuhj.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: springboot-security
 * @description: 配置类
 * @author: Yuhongjie
 * @create: 2020-01-30 22:28
 * @Version: 1.0
 */
@Configuration
public class ShiroConfig {

    //设置安全管理器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro过滤器
        /*
         anon：无需认证就可以访问
         authc：必须认证才可以访问
         user：必须拥有记住我才可以访问
         role：拥有某个资源的权限才可以访问
         perms：拥有角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        //必须验证才可以访问add/update
        //filterMap.put("/user/add","authc");

        //授权
        //要有user：add权限才能访问/user/add
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //未授权
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //关联userRealm
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm());
        return securityManager;

    }

    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
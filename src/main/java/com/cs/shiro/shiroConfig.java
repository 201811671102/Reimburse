
package com.cs.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配置类
 */
@Configuration
public class shiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("defaultWebSecurityManager")
                    DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon");

        filterMap.put("/main","authc");
        

        filterMap.put("/Studnetinfo","perms[2]");//学生个人信息页面
        filterMap.put("/WorkerReimburse","perms[1]");//职工报销
        filterMap.put("/StudnetReimburse","perms[2]");//学生报销页面


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/main");

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     * @Qualifier("userRealm")UserRealm userRealm ：
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }


    /*remeberme功能实习 免登陆*/
    /**
     *Cookie
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
        simpleCookie.setHttpOnly(true);
        //记住我cookie生效时间,单位是秒
        simpleCookie.setMaxAge(360000);
        return simpleCookie;
    }
    /**
     * cookie管理器;
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        byte[] cipherKey = Base64.decode("wGiHplamyXlVB11UXWol8g==");
        cookieRememberMeManager.setCipherKey(cipherKey);
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
}


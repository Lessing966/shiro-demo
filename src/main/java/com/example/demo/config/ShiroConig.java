package com.example.demo.config;


import com.example.demo.config.shiro.CustomerRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConig {


    //1 创建shiroFilter  负责拦截请求
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置系统受限资源
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/sys/test", "anon");
        filterMap.put("/websocket/**", "anon");
        filterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        //给安全管理器设置sessionManager
        //defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }


    @Bean
    public Realm realm(){
        CustomerRealm customerRealm =new CustomerRealm( );
        //密码匹配规则
        customerRealm.setCredentialsMatcher(credentialsMatcher());
        return customerRealm;
    }

    @Bean
    public  HashedCredentialsMatcher  credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher =new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }

/**
 96      *  开启shiro aop注解支持.
 97      *  使用代理方式;所以需要开启代码支持;
 98      * @param securityManager
 99      * @return
 100      */
     @Bean
     public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
         AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
         aasa.setSecurityManager(securityManager);
         return aasa;
     }

     @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
         DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
         advisorAutoProxyCreator.setUsePrefix(true);
         return advisorAutoProxyCreator;
     }

}
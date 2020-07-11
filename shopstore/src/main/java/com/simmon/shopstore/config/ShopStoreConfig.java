package com.simmon.shopstore.config;

import com.simmon.shopstore.realm.ShopStoreRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Hashtable;
import java.util.Map;

@Configuration
public class ShopStoreConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        /*请在这里添加权限信息*/
        Map<String,String> map=new Hashtable<>();
        map.put("/shopstore/contact","authc");
        map.put("/shopstore/toBlogSidebar","authc");
        map.put("/shopstore/toBlogDetails","authc");
        map.put("/productdetails","authc");
        map.put("/shopList","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/shopstore/login");
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("shopStoreRealm") ShopStoreRealm shopStoreRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(shopStoreRealm);
        return manager;
    }

    @Bean
    public ShopStoreRealm shopStoreRealm(){
        return new ShopStoreRealm();
    }
}

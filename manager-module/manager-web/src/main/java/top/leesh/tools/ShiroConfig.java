package top.leesh.tools;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/7/28 22:03
 */
@Configuration
public class ShiroConfig
{

    //加密方式
    @Bean
    public CredentialsMatcher credentialsMatcher()
    {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");
        matcher.setHashIterations(2);
        return  matcher;
    }


    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(UserRealm realm,TokenMnager tokenMnager,CredentialsMatcher matcher)
    {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        realm.setCredentialsMatcher(matcher);
        defaultWebSecurityManager.setRealm(realm);
//        defaultWebSecurityManager.setSessionManager();
        //设置session
        defaultWebSecurityManager.setSessionManager(tokenMnager);
        return defaultWebSecurityManager;
    }


    @Bean
    public DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition()
    {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        HashMap<String,String> objectHashMap = new HashMap<>();
        objectHashMap.put("/login","anon");
        objectHashMap.put("/captcha.jpg","anon");
        objectHashMap.put("/**","authc");

        chainDefinition.addPathDefinitions(objectHashMap);

        return  chainDefinition;
    }


//    public static void main(String[] args) {
//        Md5Hash md5Hash = new Md5Hash("123456", "lee", 2);
//        System.out.println(md5Hash.toString());
//    }



}

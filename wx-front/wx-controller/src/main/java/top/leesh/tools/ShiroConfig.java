package top.leesh.tools;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/8/6 20:29
 */
@Configuration
public class ShiroConfig
{


    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm,TokenSessionManager tokenSessionManager)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(tokenSessionManager);
        return  securityManager;
    }

    /**
     *@Description //TODO
     *@Param 放行路径
     *@Return
     */

    @Bean
    public DefaultShiroFilterChainDefinition chainDefinition()
    {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/*","anon");
        return  chainDefinition;
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return  new RestTemplate();
    }

}

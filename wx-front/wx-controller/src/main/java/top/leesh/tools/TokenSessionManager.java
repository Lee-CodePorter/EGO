package top.leesh.tools;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/8/6 19:40
 */
@Configuration
public class TokenSessionManager extends DefaultWebSessionManager
{
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response)
    {
        String token = WebUtils.toHttp(request).getHeader("TOKEN");
        if(token!=null)
        {
            return  token;
        }
        else
        {
            return UUID.randomUUID().toString();
        }
    }
}

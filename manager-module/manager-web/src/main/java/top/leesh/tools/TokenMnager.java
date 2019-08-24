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
 * @createdate 2019/7/29 11:32
 */
@Configuration
public class TokenMnager extends DefaultWebSessionManager
{
    ///shiro的request经过加密 不能直接获得数据
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response)
    {
        String token = WebUtils.toHttp(request).getHeader("TOKEN");
        if(token==null)
        {
            token= UUID.randomUUID().toString();
        }
        return token;
    }
}

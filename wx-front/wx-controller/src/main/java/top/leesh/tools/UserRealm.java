package top.leesh.tools;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import top.leesh.pojo.User;
import top.leesh.service.IUserService;
import java.util.Date;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/8/6 19:56
 */
@Configuration
public class UserRealm extends AuthorizingRealm
{

    @Reference
    private IUserService userService;


    @Autowired
    private RestTemplate restTemplate;

    @Value("${wx.appid}")
    private  String AppID;

    @Value("${wx.secret}")
    private  String AppSecret;

    @Value("${wx.url}")
    private  String codeUrl;

    /**
     *@Description //TODO  授权(会调用多次)
     *@Param [principals]
     *@Return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

   /**
    *@Description //TODO 认证(只会调用一次)
    *@Param [token]
    *@Return org.apache.shiro.authc.AuthenticationInfo
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        String code = token.getPrincipal().toString();
        String accToken = restTemplate.getForObject(String.format(codeUrl, code), String.class);

        JSON parse = JSONUtil.parse(accToken);
        String openId = parse.getByPath("openid").toString();

        User user=null;
        if(StringUtils.hasText(openId))
        {
            //获取openid
            user= userService.findUserByOpenid(openId);
            if(user==null)
            {
                user=new User();
                user.setUserId(openId);
                user.setUserRegtime(new Date());
                user.setModifyTime(new Date());
                user.setStatus(1);
                userService.save(user);
            }
        }
        return new SimpleAuthenticationInfo(user,"OK",user.getUserId());
    }
}

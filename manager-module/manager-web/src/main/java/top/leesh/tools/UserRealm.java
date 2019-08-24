package top.leesh.tools;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.leesh.pojo.SysUser;
import top.leesh.pojo.User;
import top.leesh.service.ISysUserService;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/7/28 21:36
 */
@Configuration
public class UserRealm extends AuthorizingRealm
{

    @Reference
    private ISysUserService userService;

    //授权 调用n次
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        String username = token.getPrincipal().toString();
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);

        SysUser user = userService.getOne(wrapper);
        System.out.println(user);

//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("123456");

        if(null==user)
        {
            return null;
        }
        //加密的密码
        String password = user.getPassword();

        user.setPassword("$*$*$*$*");

        ByteSource byteSource = ByteSource.Util.bytes("lee".getBytes());

        return new SimpleAuthenticationInfo(user, password,byteSource,this.getName());
//    return  null;
    }
}

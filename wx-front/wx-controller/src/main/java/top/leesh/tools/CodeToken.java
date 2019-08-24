package top.leesh.tools;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author 李书涵
 * @package_name: top.leesh.tools
 * @createdate 2019/8/6 21:04
 */
public class CodeToken extends UsernamePasswordToken
{
    private static final long serialVersionUID = -1097963793481593163L;

    public  CodeToken(String code)
    {
        super(code,"OK");
    }
}

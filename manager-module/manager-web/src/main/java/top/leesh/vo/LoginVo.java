package top.leesh.vo;

import lombok.Data;

/**
 * @author 李书涵
 * 登录需要用的扩展类
 * @package_name: top.leesh.vo
 * @createdate 2019/7/29 11:39
 */
@Data
public class LoginVo
{
    //用户名
    private String principal;

    //密码
    private  String credentials;

    //验证码
    private  String imageCode;

    //UUID
    private  String sessionUUID;

}

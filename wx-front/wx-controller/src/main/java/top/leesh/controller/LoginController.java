package top.leesh.controller;

import cn.hutool.extra.emoji.EmojiUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.Code;
import top.leesh.pojo.User;
import top.leesh.pojo.UserParm;
import top.leesh.service.IUserService;
import top.leesh.tools.CodeToken;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李书涵 微信小程序登录控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/6 19:20
 */
@RestController
public class LoginController
{
    public static  String AppID ="wxed39963c7477653c";
    public static  String AppSecret="912d6de3b7fb3485e4f57ad55068aaf4";
    public static  String CODE_SESSION="https://api.weixin.qq.com/sns/jscode2session?appid="+AppID+"&secret="+AppSecret+"&js_code=$s&grant_type=authorization_code";

    @Reference
    private  IUserService userService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Code code, String grant_type)
    {

        Subject subject = SecurityUtils.getSubject();
        CodeToken codeToken = new CodeToken(code.getPrincipal());
        subject.login(codeToken);

        String token = subject.getSession().getId().toString();

        Map<String, Object> map = new HashMap<>();

        map.put("access_token",token);


        User user =(User) subject.getPrincipal();

        map.put("nickName",user.getNickName());
        map.put("userStatus",user.getStatus());
        return  ResponseEntity.ok(map);


//        String token = String.format(CODE_SESSION, code.getPrincipal());
//        RestTemplate template = new RestTemplate();
//        String object = template.getForObject(token, String.class);
//        System.out.println("obj"+object);
//        return  ResponseEntity.ok(object);
    }



    @PutMapping("/p/user/setUserInfo")
    public ResponseEntity<Boolean> setUserInfo(@RequestBody UserParm userParm)
    {
        SecurityUtils.getSubject().getPrincipal();
        User user=null;
        user =(User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        String alias = EmojiUtil.toAlias(userParm.getNickName());
        user.setNickName(alias);
        user.setPic(userParm.getAvatarUrl());
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("user_id",user.getUserId());
        return ResponseEntity.ok(userService.update(user,wrapper));
    }


}

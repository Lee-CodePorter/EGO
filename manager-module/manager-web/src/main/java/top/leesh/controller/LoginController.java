package top.leesh.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.leesh.pojo.SysUser;
import top.leesh.redis.RedisConfig;
import top.leesh.service.ISysMenuService;
import top.leesh.vo.LoginVo;
import top.leesh.vo.MenuVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/7/28 21:25
 */
@RestController
public class LoginController
{
    //验证码前缀
    public  static final String CAP_PREFIX="captcha";

    @Reference
    private RedisConfig redisConfig;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysMenuService menuService;

    //生成验证码
    @GetMapping("/captcha.jpg")
    public  void cap(String uuid,HttpServletResponse response)
    {
        //生成验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 50, 4, 5);
        try
        {
            //写出图片流
            lineCaptcha.write(response.getOutputStream());
            //存入验证码
            redisConfig.set(CAP_PREFIX+uuid,lineCaptcha.getCode());
            //设置验证码过期时间
            redisConfig.expire(CAP_PREFIX+uuid,60);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //登录控制器
    @PostMapping("/login")
    public  Object login(@RequestBody LoginVo loginVo)
    {
//        System.out.println(loginVo.getImageCode());
        //验证验证码
        Verification(loginVo.getSessionUUID(),loginVo.getImageCode());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getPrincipal() ,loginVo.getCredentials());
        String tokenid=null;
        Map<String, Object> map = new HashMap<>();
        try {
            subject.login(token);

            tokenid= subject.getSession().getId().toString();

        }
        catch (UnknownAccountException e) {
            map.put("code", "404");
            map.put("msg", "没有该用户，请注册");
        }catch(IncorrectCredentialsException e) {
            map.put("code", "500");
            map.put("msg", "用户名或密码错误");
        }catch (ConcurrentAccessException e) {
            map.put("code", "700");
            map.put("msg", "多个用户同时访问");
        }catch(RuntimeException e) {
            map.put("code", "401");
            map.put("msg", "发送了未知错误");
        }

        catch (Exception e)
        {
            e.printStackTrace();;
        }


        map.put("data",tokenid);
//        return  subject.getSession().getId();
        return  map;

    }

    //验证码验证
    private void Verification(String sessionUUID, String imageCode)
    {
//        System.out.println("redis"+sessionUUID);
//        System.out.println("input"+imageCode);
        String code = redisConfig.get(CAP_PREFIX + sessionUUID);
//        System.out.println("取出的验证码"+code);
        if(!imageCode.equals(code)) throw  new RuntimeException("验证码错误");


        System.out.println(request.getRemoteHost());;

    }

    //获取菜单控制器(全查询)
    @GetMapping("/menu/nav")
    public Map<String,Object> loadTree(){
        HashMap<String, Object> hashMap = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        List<MenuVo> treeData = menuService.loadTreeData(user.getUserId());
        List<String> allAuths = menuService.loadAllAuths(user.getUserId());
        hashMap.put("menuList", treeData);
        hashMap.put("authorities",allAuths);
        return  hashMap ;
    }


    //获得user信息
    @GetMapping("userInfo")
    public SysUser userInfo()
    {
        Subject subject = SecurityUtils.getSubject();
        return  (SysUser) subject.getPrincipal();
    }

}

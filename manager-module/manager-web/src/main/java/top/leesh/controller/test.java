package top.leesh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.sms.SMS;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/8/3 15:14
 */
@RestController
public class test
{
    public static void main(String[] args) {
        int message = SMS.sendMessage("15629761730", "1234", "10");
        System.out.println(message);
    }


    @GetMapping("/test")
    public  String test()
    {
        return  "成功";
    }

}

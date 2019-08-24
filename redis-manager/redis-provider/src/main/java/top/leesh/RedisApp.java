package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionProperties;

/**
 * @author 李书涵
 * @package_name: top.leesh.redis.impl
 * @createdate 2019/7/30 21:08
 */
@SpringBootApplication
@EnableDubbo
public class RedisApp
{
    public static void main(String[] args) throws  Exception
    {
        SpringApplication.run(RedisApp.class,args);
    }



}

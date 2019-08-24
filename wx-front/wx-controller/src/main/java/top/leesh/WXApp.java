package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李书涵
 * @package_name: top.leesh
 * @createdate 2019/8/6 19:30
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "top.leesh.mapper")
public class WXApp
{
    public static void main(String[] args) throws  Exception
    {
        SpringApplication.run(WXApp.class,args);
    }
}

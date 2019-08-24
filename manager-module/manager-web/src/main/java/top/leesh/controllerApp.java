package top.leesh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/7/28 20:55
 */
@SpringBootApplication
@MapperScan(basePackages = "top.leesh.mapper")
public class controllerApp
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(controllerApp.class,args);
    }
}

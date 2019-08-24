package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李书涵
 * @package_name: top.leesh.service.impl
 * @createdate 2019/8/13 20:54
 */
@SpringBootApplication
@MapperScan(basePackages = "top.leesh.mapper")
@EnableDubbo
public class SysApp
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(SysApp.class,args);
    }
}

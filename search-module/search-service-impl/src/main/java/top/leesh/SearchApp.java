package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 李书涵
 * @package_name: top.leesh.service.impl
 * @createdate 2019/8/8 9:15
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "top.leesh.mapper")
@EnableAspectJAutoProxy
public class SearchApp
{
    public static void main(String[] args) throws  Exception
    {
        SpringApplication.run(SearchApp.class,args);
    }
}

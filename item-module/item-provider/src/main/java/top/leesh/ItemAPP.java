package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李书涵
 * @package_name: top.leesh.service.impl
 * @createdate 2019/7/28 19:26
 */
@SpringBootApplication
@MapperScan(basePackages = "top.leesh.mapper")
@EnableDubbo
public class ItemAPP
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(ItemAPP.class,args);
    }
}

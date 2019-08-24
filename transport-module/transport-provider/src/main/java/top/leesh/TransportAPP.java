package top.leesh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李书涵
 * @package_name: top.leesh.service.impl
 * @createdate 2019/8/5 20:56
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "top.leesh.mapper")
public class TransportAPP
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(TransportAPP.class,args);
    }
}

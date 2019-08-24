package top.leesh.tools;

import org.springframework.context.annotation.Bean;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfig {

	/**
	 * 字段的映射工厂
	 * @return
	 */
	@Bean
	public MapperFactory mapperFactory() {
		return new DefaultMapperFactory.Builder().build();
	}

	/**
	 * 对象的属性copy
	 * 以后使用它代替Spring BeanUtils
	 * @param mapperFactory
	 * @return
	 */
	@Bean
	public MapperFacade mapperFacade(MapperFactory mapperFactory) {
		return mapperFactory.getMapperFacade();
	}
}

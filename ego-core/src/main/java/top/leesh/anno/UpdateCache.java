package top.leesh.anno;

import java.lang.annotation.*;

/**
 * @author 李书涵
 * @package_name: top.leesh.anno
 * @createdate 2019/8/8 16:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UpdateCache
{
    /**
     *@Description //TODO      缓存的key
     *@Param []
     *@Return java.lang.String
     */
    public  String key() default "";

    /**
     *@Description //TODO      是否使用el表达式
     *@Param []
     *@Return boolean
     */
    public boolean userEL() default true;

    /**
     *@Description //TODO   参数的实际返回值
     *@Param []
     *@Return java.lang.Class<?>
     */
    public  Class<?> returnClass() default  Object.class;

}

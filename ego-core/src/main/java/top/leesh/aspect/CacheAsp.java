package top.leesh.aspect;

import com.alibaba.dubbo.config.annotation.Reference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import top.leesh.anno.EnableCache;
import top.leesh.redis.RedisConfig;
import top.leesh.tools.SerializationUtil;
import top.leesh.tools.SpringElUtil;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.aspect
 * @createdate 2019/8/8 14:43
 */
@Component
@Aspect
public class CacheAsp
{

    @Reference
    private RedisConfig redisConfig;

    /**
     *@Description //TODO      添加缓存
     *@Param [point]
     *@Return java.lang.Object
     */
    @Around("@annotation(top.leesh.anno.EnableCache)")
    public  Object addCache(ProceedingJoinPoint point)
    {
        /**
         *@Description //TODO      获得方法签名
         *@Param [point]
         *@Return java.lang.Object
         */
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        EnableCache cache = method.getAnnotation(EnableCache.class);
        //获得key
        String key=getKey(cache.key(),cache.userEL(),point);
        //判断缓存是否存在该值
        //有(直接返回缓存结果)
        if(redisConfig.exist(key))
        {
            byte bs[] = redisConfig.get(key.getBytes());
            Class<?> type = method.getReturnType();
            if(List.class.isAssignableFrom(type))
            {
                    return SerializationUtil.deserializeList(bs,cache.returnClass());
            }
            else
            {
                    return  SerializationUtil.deserialize(bs,type);
            }
        }
        //无(执行调用方法)
        Object proceed=null;
        try {
            proceed = point.proceed(point.getArgs());
            byte[] bytes=null;
            //判断是否为集合（普通序列化，集合序列化）
            if(List.class.isAssignableFrom(proceed.getClass()))
            {
                //序列化集合
                bytes = SerializationUtil.serializeList((List) proceed);
            }
            else
            {
                //普通序列化
                bytes = SerializationUtil.serialize(proceed);
            }
            redisConfig.set(key.getBytes(),bytes);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  proceed;
    }


    /**
     *@Description //TODO      更新缓存
     *@Param [point]
     *@Return java.lang.Object
     */
    @Around("@annotation(top.leesh.anno.UpdateCache)")
    public  Object updateCache(ProceedingJoinPoint point)
    {
        /**
         *@Description //TODO      获得方法签名
         *@Param [point]
         *@Return java.lang.Object
         */
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        EnableCache cache = method.getAnnotation(EnableCache.class);
        //获得key
        String key=getKey(cache.key(),cache.userEL(),point);

        Object proceed=null;
        try {
            proceed = point.proceed(point.getArgs());
            byte bs[]=null;
            if(List.class.isAssignableFrom(proceed.getClass()))
            {
                bs= SerializationUtil.serializeList((List)proceed);
            }
            else
            {
                bs=SerializationUtil.serialize(proceed);
            }
            redisConfig.set(key.getBytes(),bs);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  point;
    }


    /**
     *@Description //TODO      删除缓存
     *@Param [point]
     *@Return java.lang.Object
     */
    @Around("@annotation(top.leesh.anno.DeleteCache)")
    public  Object delCache(ProceedingJoinPoint point)
    {
        /**
         *@Description //TODO      获得方法签名
         *@Param [point]
         *@Return java.lang.Object
         */
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        EnableCache cache = method.getAnnotation(EnableCache.class);
        //获得key
        String key=getKey(cache.key(),cache.userEL(),point);
        Object result=null;
        try {
            result = point.proceed(point.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        redisConfig.delete(key.getBytes());
        return  result;
    }


    /**
     *@Description //TODO      获取key的方式
     *@Param [key(), userEL(是否使用el), point]
     *@Return java.lang.String
     */
    private String getKey(String key, boolean userEL, ProceedingJoinPoint point)
    {
        if(userEL)
        {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            return SpringElUtil.parse(point.getTarget(),key,method,point.getArgs());
        }
        else
        {
            return  key;
        }
    }

}

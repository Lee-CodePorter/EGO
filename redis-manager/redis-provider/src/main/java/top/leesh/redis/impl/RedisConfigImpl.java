package top.leesh.redis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import top.leesh.redis.RedisConfig;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author 李书涵
 * @package_name: top.leesh.redis.impl
 * @createdate 2019/7/30 21:03
 */
@Service
public class  RedisConfigImpl implements RedisConfig
{
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate<Object,Object>  redisTemplate;

    //添加简单的key，values
    @Override
    public void set(String key, String value)
    {
        Assert.hasText(key,"key必须为字符串");
        stringRedisTemplate.opsForValue().set(key,value);
    }
    //获得简单字符
    @Override
    public String get(String key)
    {
        Assert.hasText(key,"key必须为字符串");
        return stringRedisTemplate.opsForValue().get(key);
    }

    //判断是否存在
    @Override
    public boolean exist(String key)
    {
        Assert.hasText(key,"key必须为字符串");
        return    stringRedisTemplate.hasKey(key);
    }

    //设置过期时间
    @Override
    public void expire(String key, long timeout)
    {
        stringRedisTemplate.expire(key,timeout, TimeUnit.SECONDS);
    }

    //删除redis
    @Override
    public void delete(String... key)
    {
        Assert.noNullElements(key,"删除key不能为空");
        //循环删除
        stringRedisTemplate.delete(Arrays.asList(key));
    }

    @Override
    public void set(byte key[], byte value[])
    {
//        stringRedisTemplate.setKeySerializer();

//        stringRedisTemplate.opsForValue().set();
        redisTemplate.execute(new RedisCallback<Object>() { // 这里面不会在走redis的序列化
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                return null;
            }
        });
    }

    @Override
    public byte[] get(byte key[])
    {
        return redisTemplate.execute(new RedisCallback<byte[]>() {

            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key);
            }
        });
    }

    @Override
    public Long increment(String key)
    {
        Assert.hasText(key, "该key 必须是一个字符串");
        return stringRedisTemplate.opsForValue().increment(key, 1);
    }

    @Override
    public void delete(byte[] bytes)
    {
        redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                connection.del(bytes);
                return null ;
            }
        });
    }
}

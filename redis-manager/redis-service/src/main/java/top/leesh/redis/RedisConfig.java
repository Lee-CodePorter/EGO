package top.leesh.redis;

/**
 * @author 李书涵
 * redis接口
 * @package_name: top.leesh.redis
 * @createdate 2019/7/30 21:01
 */

public interface RedisConfig
{
    /**
     * 设置一个值
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 获取值
     * @param key
     */
    String get(String key);

    /**
     * redis 里面是否存在一个值
     * @param key
     * @return
     */
    boolean exist(String key);

    /**
     * 设置过期时间
     * @param key
     * @param timeout
     */
    void expire(String key,long timeout);
    /**
     * 删除一个key
     * @param key
     */
    void delete(String ...key);

    /**
     * 使用对象set
     * @param key
     * @param value
     */
    void set(byte key[],byte value[]) ;

    /**
     * 使用对象get
     * @param key
     */
    byte [] get(byte key[]);

    /**
     * ++ 操作
     * @param key
     * @return
     */
    Long increment(String key);


    void delete(byte[] bytes);
}

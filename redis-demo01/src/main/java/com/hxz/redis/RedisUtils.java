package com.hxz.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-03-10-21:32
 * @address 成都
 */
public class RedisUtils {
    private static volatile JedisPool jedisPool = null;

    private static String script1 = "local userid=KEYS[1];\r\n" +
            "local prodid=KEYS[2];\r\n" +
            "local qtKey='Seckill:'..prodid..\":kc\";\r\n" +
            "local usersKey='Seckill:'..prodid..\":user\";\r\n" +
            "local userExists=redis.call(\"sismember\",usersKey,userid);\r\n" +
            "if tonumber(userExists)==1 then \r\n" +
            "  return 2;\r\n" +
            "end\r\n" +
            "local num=redis.call(\"get\",qtKey);\r\n" +
            "if tonumber(num)<=0 then \r\n" +
            "  return 0;\r\n" +
            "else \r\n" +
            "   redis.call(\"decr\",qyKey);\r\n" +
            "   redis.call(\"sadd\",usersKey,userid);\r\n" +
            "end\r\n" +
            "return 1";
    private static String script2 = "local userExists=redis.call(\"sismember\",\"{sk}:1010:user\",userid);\r\n" +
            " return 1";


    /**
     * 通过lua脚本进行秒杀，解决库存遗漏
     */
    public static void doSecSkill(String userid, String prodid) {
        JedisPool jedisPool = getJedisPool();
        Jedis jedis = jedisPool.getResource();
        String sha1 = jedis.scriptLoad(script1);
        Object result = jedis.evalsha(sha1, 2, userid, prodid);
        String str = String.valueOf(result);
        if ("0".equals(str)) {
            System.out.println("已抢空");
        } else if ("1".equals(str)) {
            System.out.println("抢购成功");
        } else if ("2".equals(str)) {
            System.out.println("该用户已抢过");
        } else {
            System.out.println("抢购异常");
        }
        release(jedisPool, jedis);
    }

    public RedisUtils() {
    }

    /**
     * 创建连接池
     */
    public static JedisPool getJedisPool() {
        if (jedisPool == null) {
            synchronized (RedisUtils.class) {
                if (jedisPool == null) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(100); // 最大连接数
                    config.setMaxIdle(32); // 最大空闲数
                    config.setMaxWait(Duration.ofSeconds(100000)); // 等待时间
                    config.setBlockWhenExhausted(true); // 超时等待
                    config.setTestOnBorrow(true); // 测试连接是否正常
                    jedisPool = new JedisPool(config, "192.168.0.124", 6379, 6000);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 释放连接
     */
    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}

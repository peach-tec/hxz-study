package com.hxz.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Random;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 秒杀demo
 * @copyright &copy; DYH
 * @date 2022-03-10-20:39
 * @address 成都
 */
public class SecKillRedisDemo {
    /**
     * @param uid    用户ID
     * @param prodid 商品ID
     * @return boolean
     * @desc 执行秒杀过程
     * @author 華小灼
     * @date 2022-03-10 20:41
     */
    public static boolean doSecKill(String uid, String prodid) {
        // 非空判断
        if (uid == null || prodid == null) {
            return false;
        }

        // 连接redis
//        Jedis jedis = new Jedis("192.168.0.124", 6379); // 普通连接，会有超时的情况发生
        JedisPool jedisPool = RedisUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource(); // 通过连接池连接，解决连接时的情况
        // 拼接key
        // 1. 库存key
        String kcKey = "sk:" + prodid + ":qt";
        // 秒杀成功用户key
        String userKey = "sk:" + prodid + ":user";

        // 加入乐观锁解决超卖情况
        // 监视库存
        jedis.watch(kcKey);

        // 获取库存，如果为null，秒杀还没开始
        String kc = jedis.get(kcKey);
        if (kc == null) {
            System.out.println("秒杀还未开始, 请等待");
            return false;
        }

        // 判断用户是否重复秒杀
        if (jedis.sismember(userKey, uid)) { // 判断值是否存在，存在则表示已经秒杀过了
            System.out.println("已经秒杀成功, 不能重复秒杀");
            RedisUtils.release(jedisPool, jedis);
            return false;
        }

        // 判断商品库存，小于1则秒杀结束
        if (Integer.parseInt(kc) <= 0) {
            System.out.println("秒杀已经结束");
            RedisUtils.release(jedisPool, jedis);
            return false;
        }

        // 秒杀过程
        // 增加事务，配合乐观锁解决超卖
        Transaction multi = jedis.multi();
        // 组队操作
        // 1. 库存减一
        multi.decr(kcKey);
        // 2. 秒杀成功的用户加入到set集合中
        multi.sadd(userKey, uid);
        // 3. 执行
        List<Object> exec = multi.exec();
        if (exec == null || exec.size() == 0) {
            System.out.println("秒杀失败");
            RedisUtils.release(jedisPool, jedis);
            return false;
        }

        // 1. 库存减一
//        jedis.decr(kcKey);
        // 2. 秒杀成功的用户加入到set集合中
//        jedis.sadd(userKey, uid);
        System.out.println("秒杀成功");
        return true;
    }

    public static void main(String[] args) {
        // 单例测试
//        for (int i = 0; i < 10; i++) {
//            String uid = new Random().nextInt(5000) + "";
//            String prodid = "1010";
//            doSecKill(uid, prodid);
//        }

        // 并发测试
        for (int i = 0; i < 200; i++) {
            new Thread01().start();
        }
    }

    public static class Thread01 extends Thread {
        @Override
        public void run() {
            String uid = new Random().nextInt(5000) + "";
            String prodid = "1010";
            RedisUtils.doSecSkill(uid, prodid);
        }
    }
}

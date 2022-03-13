package com.hxz.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * @author 華小灼
 * @version V1.0
 * @desc redis 集群demo
 * @copyright &copy; DYH
 * @date 2022-03-13-21:47
 * @address 成都
 */
public class RedisCluster {
    public static void main(String[] args) {
        HashSet<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.0.124",6379));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6380));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6381));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6382));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6383));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6384));
        hostAndPorts.add(new HostAndPort("192.168.0.124",6385));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        jedisCluster.set("name","ding123yh");
        jedisCluster.set("name1","ding123yh");
        jedisCluster.set("name2","ding123yh");
        jedisCluster.set("name3","ding123yh");
        System.out.println(jedisCluster.get("name"));
    }
}

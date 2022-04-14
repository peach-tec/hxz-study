package com.hxz.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 華小灼
 * @version V1.0
 * @desc curator分布式锁
 * @copyright &copy; DYH
 * @date 2022-04-14-23:04
 * @address 成都
 */
public class CuratorTest {
    public static CuratorFramework getClient() {
        // 创建连接
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.0.132:2181,192.168.0.133:2181,192.168.0.134:2181")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(2000)
                .retryPolicy(new ExponentialBackoffRetry(3000, 3)).build();
        // 启动客户端
        client.start();
        System.out.println("zookeeper 启动成功");
        return client;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 创建分布式锁
            InterProcessMutex lock = new InterProcessMutex(getClient(), "/locks");
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.acquire();// 获取锁
                        System.out.println("线程" + finalI + "获取到锁");
                        Thread.sleep(2000);
                        lock.release();// 释放锁
                        System.out.println("线程" + finalI + "释放锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

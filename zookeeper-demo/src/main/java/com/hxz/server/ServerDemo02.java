package com.hxz.server;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 第二个服务端
 * @copyright &copy; DYH
 * @date 2022-04-14-20:55
 * @address 成都
 */
public class ServerDemo02 {
    public static void main(String[] args) throws InterruptedException, KeeperException {
        // 1. 获取zookeeper连接
        ZooKeeper zooKeeper = getConnection();
        // 2. 服务端注册到zookeeper集群,创建临时的带序列号的节点
        zooKeeper.create("/servers/ServerDemo02", "ServerDemo02".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("ServerDemo02 上线了");
        // 3. 业务处理逻辑
        Thread.sleep(Long.MAX_VALUE);
    }

    public static ZooKeeper getConnection() {
        return getConnection("192.168.0.132:2181,192.168.0.133:2181,192.168.0.134:2181", 2000);
    }

    public static ZooKeeper getConnection(String connectString, int sessionTimeout) {
        try {
            return new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

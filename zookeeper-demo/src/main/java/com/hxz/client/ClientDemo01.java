package com.hxz.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 第一个客户端
 * @copyright &copy; DYH
 * @date 2022-04-14-21:07
 * @address 成都
 */
public class ClientDemo01 {
    public static ZooKeeper zooKeeper;

    public static void main(String[] args) throws InterruptedException, KeeperException {
        // 1. 获取zookeeper连接
        zooKeeper = getConnection();
        // 2. 监听节点的变化
        List<String> children = zooKeeper.getChildren("/servers", true);
        List<String> list = new ArrayList<>();
        for (String child : children) {
            // 获取子节点数据
            byte[] data = zooKeeper.getData("/servers/" + child, false, null);
            String s = new String(data);
            list.add(s);
        }
        list.forEach(System.out::println);
        System.out.println("=========================================================");
        // 3. 业务逻辑
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
                    List<String> children = null;
                    try {
                        children = zooKeeper.getChildren("/servers", true);
                    } catch (KeeperException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    List<String> list = new ArrayList<>();
                    assert children != null;
                    for (String child : children) {
                        // 获取子节点数据
                        byte[] data = new byte[0];
                        try {
                            data = zooKeeper.getData("/servers/" + child, false, null);
                        } catch (KeeperException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        String s = new String(data);
                        list.add(s);
                    }
                    list.forEach(System.out::println);
                    System.out.println("=========================================================");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.hxz.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-14-20:57
 * @address 成都
 */
public class ZookeeperUtils {
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

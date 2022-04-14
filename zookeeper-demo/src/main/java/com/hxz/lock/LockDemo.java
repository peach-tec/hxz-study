package com.hxz.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 分布式锁
 * @copyright &copy; DYH
 * @date 2022-04-14-21:41
 * @address 成都
 */
public class LockDemo {
    private final String NODE = "/locks";
    private final CountDownLatch latch = new CountDownLatch(1);
    private final CountDownLatch waitLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;
    private String waitPath;
    private String currentNode;

    public LockDemo() throws InterruptedException, KeeperException, IOException {
        // 获取连接
        zooKeeper = new ZooKeeper("192.168.0.132:2181,192.168.0.133:2181,192.168.0.134:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 释放等待
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    latch.countDown();
                }
                if (event.getType() == Event.EventType.NodeDeleted && event.getPath().equals(waitPath)) {
                    waitLatch.countDown();
                }
            }
        });
        // 等待zookeeper正常连接后，才执行后面的代码
        latch.await();
        // 判断根节点是否存在
        Stat exists = zooKeeper.exists(NODE, false);
        if (exists == null) { // 不存在则创建根节点
            zooKeeper.create(NODE, NODE.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    /**
     * 加锁
     */
    public void lock() throws InterruptedException, KeeperException {
        // 创建对应的临时的带序号的节点
        currentNode = zooKeeper.create(NODE + "/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        // 判断节点是否是最小序号的节点，如果是则获取到锁，如果不是则监听前一个序号的节点
        List<String> children = zooKeeper.getChildren(NODE, false);

        // 如果只有一个节点，直接获取锁，如果有多个节点，判断是否是最小值
        if (children.size() == 1) {
        } else {
            Collections.sort(children);// 排序
            // 当前节点名称
            String thisNode = currentNode.substring(NODE.length() + 1);
            // 当前节点的下标
            int index = children.indexOf(thisNode);
            if (index == -1) {
                System.out.println("数据异常");
            } else if (index == 0) {
                // 获取锁
            } else {
                // 监听前一个节点
                waitPath = NODE + "/" + children.get(index - 1);
                zooKeeper.getData(waitPath, true, null);
                // 等待监听完成
                waitLatch.await();
            }
        }
    }

    /**
     * 解锁
     */
    public void unLock() throws InterruptedException, KeeperException {
        // 删除当前节点
        zooKeeper.delete(currentNode, -1);
    }
}

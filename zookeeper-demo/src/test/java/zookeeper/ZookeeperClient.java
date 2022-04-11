package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc zookeeper 客户端
 * @copyright &copy; DYH
 * @date 2022-04-11-21:46
 * @address 成都
 */
public class ZookeeperClient {
    ZooKeeper zooKeeper;

    /**
     * 创建客户端
     */
    @Before
    public void createZooKeeperClient() throws IOException {
        // 创建zookeeper客户端
        zooKeeper = new ZooKeeper("192.168.0.132:2181,192.168.0.133:2181,192.168.0.134:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 监听节点事件，实现无限次监听
                // 获取子节点
                List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/", true);
                } catch (KeeperException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                for (String child : children) {
                    System.out.println(child);
                }
            }
        });
    }

    /**
     * 创建节点
     */
    @Test
    public void createNode() throws InterruptedException, KeeperException {
        // 创建子节点
        // 第三个参数代表权限：
        String node = zooKeeper.create("/test", "test demo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取子节点
     */
    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        // 获取子节点
        List<String> children = zooKeeper.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
        // 延迟
        Thread.sleep(Integer.MAX_VALUE);

        // 运行后在控制台增加或删除子节点可查看效果
    }

    /**
     * 判断节点是否存在
     */
    @Test
    public void exists() throws InterruptedException, KeeperException {
        Stat exists = zooKeeper.exists("/sdfasd", false);
        System.out.println(exists == null ? "节点不存在" : "节点存在");
    }

    /**
     * 删除节点
     */
    @Test
    public void deleteNode() throws InterruptedException, KeeperException {
        // 删除节点，-1代码不指定版本即删除所有版本，也可以指定版本
        zooKeeper.delete("/test", -1);
    }
}

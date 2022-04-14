package com.hxz.lock;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 测试分布式锁
 * @copyright &copy; DYH
 * @date 2022-04-14-22:14
 * @address 成都
 */
public class LockDemoTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        for (int i = 0; i < 10; i++) {
            LockDemo lockDemo = new LockDemo();
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lockDemo.lock();// 加锁
                        System.out.println("线程" + (finalI + 1) + "启动，获得锁");
                        Thread.sleep(1000);
                        lockDemo.unLock();//解锁
                        System.out.println("线程" + (finalI + 1) + "释放锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

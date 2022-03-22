package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 自定义分区器
 * @copyright &copy; DYH
 * @date 2022-03-21-20:57
 * @address 成都
 */
public class MyPartitioner implements Partitioner {
    /**
     * @param topic      主题
     * @param key        键
     * @param keyBytes   序列化后的键
     * @param value      值
     * @param valueBytes 序列化后的值
     * @return int
     * @desc 实现自定义分区
     * @author 華小灼
     * @date 2022-03-21 20:58
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        /**
         * 需求：
         *   如果数据包含"dev"就发往0号分区，包含"prod"发往1号分区，其余的发往2号分区
         */
        String str = value.toString();
        if (str.contains("dev")) {
            return 0;
        }
        if (str.contains("prod")) {
            return 1;
        }
        return 2;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}

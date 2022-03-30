package com.hxz.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 指定时间消费
 * @copyright &copy; DYH
 * @date 2022-03-28-21:29
 * @address 成都
 */
public class CustomConsumerSeekTime {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.120:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first_01");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        List<String> topics = new ArrayList<>();
        topics.add("first");
        consumer.subscribe(topics);

        // 指定位置进行消费
        Set<TopicPartition> partitions = consumer.assignment();// 分区集合
        // 保证分区分配方案已经制定完成
        while (partitions.size() == 0) {
            consumer.poll(Duration.ofSeconds(1));// 拉取一次数据
            partitions = consumer.assignment();// 更新
        }

        // 把时间转换为对应的offset
        Map<TopicPartition, Long> map = new HashMap<>();
        for (TopicPartition partition : partitions) {
            map.put(partition, System.currentTimeMillis() - 24 * 3600 * 1000); // 消费分区一天前到现在的数据
        }
        Map<TopicPartition, OffsetAndTimestamp> offsets = consumer.offsetsForTimes(map);// 通过时间获取offset的集合
        for (TopicPartition partition : partitions) {
            OffsetAndTimestamp offsetAndTimestamp = offsets.get(partition);
            consumer.seek(partition, offsetAndTimestamp.offset()); // 指定消费的offset
        }

        while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(5)); // 间隔5秒拉取数据
            for (ConsumerRecord<String, String> record : poll) {
                System.out.println(record);
            }
        }
    }
}

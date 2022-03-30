package com.hxz.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 消费者自动提交offset
 * @copyright &copy; DYH
 * @date 2022-03-28-21:29
 * @address 成都
 */
public class CustomConsumerAutoOffset {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.120:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first_01");
        properties.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, RangeAssignor.class.getName());

        // 自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        // 提交时间间隔
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        List<String> topics = new ArrayList<>();
        topics.add("first");
        consumer.subscribe(topics);
        while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(5)); // 间隔5秒拉取数据
            for (ConsumerRecord<String, String> record : poll) {
                System.out.println(record);
            }
        }
    }
}

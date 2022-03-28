package com.hxz.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 消费一个主题下的指定分区
 * @copyright &copy; DYH
 * @date 2022-03-28-21:29
 * @address 成都
 */
public class CustomConsumerPartition {
    public static void main(String[] args) {
        // 配置
        Properties properties = new Properties();
        // 连接kafka
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.120:9092");
        // 反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // 配置消费者groupid, 注意：必须的配置此参数
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first_01");

        // 创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 订阅主题对应的分区
        List<TopicPartition> topics = new ArrayList<>();
        topics.add(new TopicPartition("first", 0));
        consumer.assign(topics);

        // 消费数据
        while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(5)); // 间隔5秒拉取数据
            poll.forEach(System.out::println);
        }
    }
}

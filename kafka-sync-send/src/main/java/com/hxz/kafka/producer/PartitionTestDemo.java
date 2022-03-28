package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 分区测试demo
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class PartitionTestDemo {
    public static void main(String[] args) {
        // kafka属性配置
        Properties properties = new Properties();
        // 连接kafka
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.120:9092");
        // k-v序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // 发送数据
        for (int i = 0; i < 100; i++) {
            // 发送到指定分区
            designPartition(producer, i % 3);
            // 不指定分区发送
//            notDesignPartition(producer, i);
        }

        // 关闭资源
        producer.close();
    }

    /**
     * 指定分区发送
     */
    public static void designPartition(KafkaProducer<String, String> producer, int i) {
        producer.send(new ProducerRecord<String, String>("first", i, "", "测试发送到指定的分区" + i), new Callback() {
            @Override
            public void onCompletion(RecordMetadata data, Exception e) {
                if (e == null) {
                    System.out.println("发送成功");
                    System.out.println("主题：" + data.topic());
                    System.out.println("分区：" + data.partition());
                    System.out.println("-----------------------------------------------------");
                } else {
                    System.err.println("发送失败");
                    System.err.println(e);
                }
            }
        }); // 不带回调参数的发送
    }

    /**
     * 不指定分区发送
     */
    public static void notDesignPartition(KafkaProducer<String, String> producer, int i) {
        producer.send(new ProducerRecord<String, String>("first", "b", "测试发送不指定分区" + i), new Callback() {
            @Override
            public void onCompletion(RecordMetadata data, Exception e) {
                if (e == null) {
                    System.out.println("发送成功");
                    System.out.println("主题：" + data.topic());
                    System.out.println("分区：" + data.partition());
                    System.out.println("-----------------------------------------------------");
                } else {
                    System.err.println("发送失败");
                    System.err.println(e);
                }
            }
        }); // 不带回调参数的发送
    }
}

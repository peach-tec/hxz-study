package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 测试自定义分区
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class MyPartitionTest {
    public static void main(String[] args) {
        // kafka属性配置
        Properties properties = new Properties();
        // 连接kafka
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.120:9092");
        // k-v序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 关联分区器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class);

        // 创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // 发送数据
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first", (i % 2 == 0 ? "dev开发环境" : "prod生产环境") + i), new Callback() {
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
            });
        }

        producer.send(new ProducerRecord<String, String>("first", "看看你发送到哪儿"), new Callback() {
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
        });

        // 关闭资源
        producer.close();
    }

}

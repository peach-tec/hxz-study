package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 事务
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class CustomProducerTransaction {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.124:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // ack应答机制必须是-1或all
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        // 幂等性
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        // 指定事务ID,保证全局唯一
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "trasation_id_001");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 初始化事务
        producer.initTransactions();
        // 启动事务
        producer.beginTransaction();

        try {
            // 发送数据
            for (int i = 0; i < 10; i++) {
                producer.send(new ProducerRecord<String, String>("first", 0, "", "事务测试"));
            }
            // 模拟失败
//            int i = 10 / 0;
            // 提交事务
            producer.commitTransaction();
        } catch (Exception e) {
            // 发送失败，终止事务
            producer.abortTransaction();
        } finally {
            // 关闭资源
            producer.close();
        }
    }

}

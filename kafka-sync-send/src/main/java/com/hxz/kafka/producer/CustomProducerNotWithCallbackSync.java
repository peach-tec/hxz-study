package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 没有回调函数的同步发送测试demo
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class CustomProducerNotWithCallbackSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // kafka属性配置
        Properties properties = new Properties();
        // 连接kafka
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.124:9092");
        // k-v序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // 发送数据
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first", "CustomProducerNotWithCallbackSync" + i)).get(); // 不带回调参数的发送
        }

        // 关闭资源
        producer.close();
    }
}

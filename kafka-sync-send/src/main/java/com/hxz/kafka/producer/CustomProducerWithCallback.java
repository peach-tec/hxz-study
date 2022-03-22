package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 带回调函数的异步发送测试demo
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class CustomProducerWithCallback {
    public static void main(String[] args) {
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
            producer.send(new ProducerRecord<String, String>("first", "hello world" + i), new Callback() {
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

        // 关闭资源
        producer.close();
    }
}

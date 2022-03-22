package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc ack应答机制测试
 * @copyright &copy; DYH
 * @date 2022-03-20-21:19
 * @address 成都
 */
public class CustomProducerAcks {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.124:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // ack配置,默认-1(all)
        properties.put(ProducerConfig.ACKS_CONFIG, "1");
        // 重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first", "ACK测试" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata data, Exception e) {
                    if (e == null) {
                        System.out.println("分区：" + data.partition());
                    } else {
                        System.err.println("发送失败");
                        System.err.println(e);
                    }
                }
            });
        }

        // 关闭资源
        producer.close();
    }

}

package com.hxz.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Date;
import java.util.Properties;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 生产者提高吞吐量参数
 * @copyright &copy; DYH
 * @date 2022-03-21-21:24
 * @address 成都
 */
public class CustomProducerParameters {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.124:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 缓冲区大小
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 64 * 1024 * 1024);
        // 批次大小
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 32 * 1024);
        // linger.ms
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        // 压缩,默认none，可配置：gzip snappy lz4 zstd
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first", i + ""));
        }
        producer.close();
    }
}

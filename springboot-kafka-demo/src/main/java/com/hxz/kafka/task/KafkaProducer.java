package com.hxz.kafka.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 生产者
 * @copyright &copy; DYH
 * @date 2022/3/24-10:40
 * @address 成都
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${test.topic}")
    private String topic;
    @Value("${test.key}")
    private String key;

    private ExecutorService pool = Executors.newFixedThreadPool(10);

    @Scheduled(cron = "0/2 * * * * ?")
    public void send() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                kafkaTemplate.send(topic, key, finalI + "=>" + date());
            }, pool);
        }
    }

    private String date() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return format.format(new Date());
    }
}

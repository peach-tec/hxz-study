package com.hxz.kafka.task;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 消费者
 * @copyright &copy; DYH
 * @date 2022/3/24-10:39
 * @address 成都
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${test.topic}", groupId = "testTopicGroup")
    public void listener(ConsumerRecord<String, String> record) {
        int partition = record.partition();
        String key = record.key();
        String topic = record.topic();
        String value = record.value();
        System.out.println(date() + ":   分区：" + partition + "  |  主体：" + topic + "  |  键：" + key + "  |  值：" + value);
    }

    private String date() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

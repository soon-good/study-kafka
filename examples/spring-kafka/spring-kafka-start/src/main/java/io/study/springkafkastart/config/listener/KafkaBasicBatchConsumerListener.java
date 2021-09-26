package io.study.springkafkastart.config.listener;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component
public class KafkaBasicBatchListener {
	public static final String TOPIC_NAME = "KAFKA_SAMPLE";

	@KafkaListener(
		topics = TOPIC_NAME,
		groupId = "test-group01"
	)
	public void batchListener(ConsumerRecords<String, String> records){
		records.forEach(record -> log.info(record.toString()));
	}

	@KafkaListener(
		topics = TOPIC_NAME,
		groupId = "test-group02"
	)
	public void batchListener(List<String> list){
		list.forEach(str -> log.info(str));
	}

	@KafkaListener(
		topics = TOPIC_NAME,
		groupId = "test-group03",
		concurrency = "3"
	)
	public void cuncurrentBatchListener(ConsumerRecords<String, String> records){
		records.forEach(record->log.info(record.toString()));
	}
}

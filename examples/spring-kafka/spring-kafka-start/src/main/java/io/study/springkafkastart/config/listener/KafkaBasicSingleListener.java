package io.study.springkafkastart.config.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaBasicListener {

	@KafkaListener(
		topics = "KAFKA-SAMPLE",
		groupId = "test-group00"
	)
	public void recordListener00(ConsumerRecord<String, String> record){
		log.info(record.toString());
	}

	@KafkaListener(
		topics = "KAFKA-SAMPLE",
		groupId = "test-group01"
	)
	public void recordListener01(String messageValue){
		log.info(messageValue);
	}

	@KafkaListener(
		topics = "KAFKA-SAMPLE",
		groupId = "test-group02",
		properties = {
			"max.poll.interval.ms:60000",
			"auto.offset.reset:earliest"
		}
	)
	public void concurrentTopicListener(String messageValue){
		log.info(messageValue);
	}

	@KafkaListener(
		topics = "KAFKA-SAMPLE",
		groupId = "test-group03",
		concurrency = "3"
	)
	public void listenSpecificPartition(ConsumerRecord<String, String> record){
		log.info(record.toString());
	}
}

package io.study.springkafkastart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleKafkaProducerRunner implements CommandLineRunner {

	@Autowired
	private KafkaTemplate<Integer, String> template;

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<10; i++){
			template.send("spring-kafka-test", String.format("테스트메시지/%s", i));
			System.exit(0);
		}
	}
}

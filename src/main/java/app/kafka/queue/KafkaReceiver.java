package app.kafka.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import app.kafka.constants.KafkaConfig;

@Component
public class KafkaReceiver {

	private static Consumer<String, String> consumer;

	@PostConstruct
	public static void init() {
		consumer = KafkaReceiver.createConsumer();
		System.out.println("Consumer initialized");
	}

	public static Consumer<String, String> createConsumer() {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_BROKERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfig.GROUP_ID_CONFIG);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConfig.MAX_POLL_RECORDS);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaConfig.OFFSET_RESET_EARLIER);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		final Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Collections.singletonList(KafkaConfig.TOPIC_NAME));
		return consumer;
	}

	public static synchronized List receiveMessage() {
		List list = new ArrayList();
		if (consumer != null) {
			final ConsumerRecords<String, String> consumerRecords = consumer.poll(KafkaConfig.POLL_TIMEOUT);
			if (consumerRecords.count() > 0) {
				for (Iterator<ConsumerRecord<String, String>> it = consumerRecords.iterator(); it.hasNext();) {
					ConsumerRecord record = it.next();
					list.add(record.value());
				}
			}
			consumer.commitAsync();
		}
		return list;
	}

}

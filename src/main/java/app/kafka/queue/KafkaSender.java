package app.kafka.queue;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import app.kafka.constants.KafkaConfig;

@Component
public class KafkaSender {

	private static Producer<String, String> producer;

	@PostConstruct
	public static void init() {
		producer = KafkaSender.createProducer();
		System.out.println("Producer initialized");
	}

	public static Producer<String, String> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_BROKERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConfig.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<String, String>(props);
	}

	public static synchronized void sendMessage(String key, String msg) {
		if (producer != null) {
			final ProducerRecord<String, String> record = new ProducerRecord<String, String>(KafkaConfig.TOPIC_NAME,
					key, msg);
			try {
				producer.send(record);
				System.out.println("Record sent: " + msg);
			} catch (Exception e) {
				System.out.println("Error in sending record" + e);
			}
		}
	}

}
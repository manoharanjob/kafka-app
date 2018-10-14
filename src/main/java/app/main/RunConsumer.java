package app.main;

import java.util.List;

import app.kafka.queue.KafkaReceiver;

public class RunConsumer {

	public static void main(String[] args) {
		KafkaReceiver.init();

		List records = KafkaReceiver.receiveMessage();

		if (records.isEmpty())
			System.out.println("Record Empty");

		records.forEach(record -> System.out.println("Record Received: " + record));
	}

}

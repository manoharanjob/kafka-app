package app.kafka.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.kafka.biserializer.BiSerializer;
import app.kafka.dao.model.PriceItem;
import app.kafka.queue.KafkaReceiver;

@RestController
public class ReceiverController {

	@GetMapping(value = "/receiver")
	public @ResponseBody String receiveMessage() {
		List list = new ArrayList();
		List<String> records = KafkaReceiver.receiveMessage();
		for (String msg : records) {
			list.add(BiSerializer.deserialize(msg, PriceItem.class));
		}

		return "Message Received: " + list;
	}

	@GetMapping(value = "/receiver/simple")
	public @ResponseBody String receiveSimpleMessage() {
		List<String> records = KafkaReceiver.receiveMessage();

		return "Message Received: " + records;
	}

}
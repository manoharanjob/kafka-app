package app.kafka.spring.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.kafka.biserializer.BiSerializer;
import app.kafka.dao.model.PriceItem;
import app.kafka.queue.KafkaSender;

@RestController
public class SenderController {

	@GetMapping(value = "/sender")
	public @ResponseBody String sendMessage() {
		PriceItem item = new PriceItem("1", "Item 1", "PE", "Pending", "Item text", new Date());
		String msg = BiSerializer.serialize(item);
		KafkaSender.sendMessage("Key", msg);

		return "Message Sent: " + item;
	}

	@GetMapping(value = "/sender/{msg}")
	public @ResponseBody String sendMessage(@PathVariable("msg") String msg) {
		KafkaSender.sendMessage("Key", msg);

		return "Message Sent: " + msg;
	}
}
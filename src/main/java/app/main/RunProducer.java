package app.main;

import java.util.Date;

import app.kafka.biserializer.BiSerializer;
import app.kafka.dao.model.PriceItem;
import app.kafka.queue.KafkaSender;

public class RunProducer {

	public static void main(String[] args) {
		KafkaSender.init();
		
		// Sample text message
		KafkaSender.sendMessage("Key", "Text Message");
		
		// Sample Custom object
		PriceItem item = new PriceItem("1", "Item 1", "PE", "New", "Item text", new Date());
		String msg = BiSerializer.serialize(item);
		KafkaSender.sendMessage("Key", msg);
	}

}

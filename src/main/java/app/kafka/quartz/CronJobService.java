package app.kafka.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.kafka.biserializer.BiSerializer;
import app.kafka.constants.KafkaConfig;
import app.kafka.dao.PriceItemDAO;
import app.kafka.dao.model.PriceItem;
import app.kafka.queue.KafkaSender;

@Service
public class CronJobService {

	@Autowired
	private PriceItemDAO priceItemDAO;
	@Autowired
	private KafkaSender kafkaSender;

	public void executeJob() {
		List<PriceItem> list = priceItemDAO.findByRecordStatus("New");

		System.out.println("Records: " + list);
		for (PriceItem priceItem : list) {
			String msg = BiSerializer.serialize(priceItem);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
		}
	}
}
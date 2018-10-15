package app.kafka.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.kafka.biserializer.BiSerializer;
import app.kafka.constants.KafkaConfig;
import app.kafka.dao.PriceAsgnDAO;
import app.kafka.dao.PriceItemDAO;
import app.kafka.dao.PriceItemParamDAO;
import app.kafka.dao.PriceListDAO;
import app.kafka.dao.RsRcDAO;
import app.kafka.dao.model.PriceAsgn;
import app.kafka.dao.model.PriceItem;
import app.kafka.dao.model.PriceItemParam;
import app.kafka.dao.model.PriceList;
import app.kafka.dao.model.RsRc;
import app.kafka.queue.KafkaSender;

@Service
public class CronJobService {

	@Autowired
	private KafkaSender kafkaSender;
	@Autowired
	PriceItemDAO priceItemDAO;
	@Autowired
	PriceItemParamDAO priceItemParamDAO;
	@Autowired
	PriceListDAO priceListDAO;
	@Autowired
	PriceAsgnDAO priceAsgnDAO;
	@Autowired
	RsRcDAO rsRcDAO;

	public void executeJob() {
		// PriceItem pull from DB and publish to kafka
		List<PriceItem> priceItemList = priceItemDAO.findByRecordStatus("Pending");
		for (PriceItem priceItem : priceItemList) {
			String msg = BiSerializer.serialize(priceItem);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
			priceItem.setRecordStatus("Processed");
			priceItemDAO.saveOrUpdate(priceItem);
		}

		// PriceItemParam pull from DB and publish to kafka
		List<PriceItemParam> priceItemParamList = priceItemParamDAO.findByRecordStatus("Pending");
		for (PriceItemParam priceItemParam : priceItemParamList) {
			String msg = BiSerializer.serialize(priceItemParam);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
			priceItemParam.setRecordStatus("Processed");
			priceItemParamDAO.saveOrUpdate(priceItemParam);
		}

		// PriceList pull from DB and publish to kafka
		List<PriceList> priceLists = priceListDAO.findByRecordStatus("Pending");
		for (PriceList priceList : priceLists) {
			String msg = BiSerializer.serialize(priceList);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
			priceList.setRecordStatus("Processed");
			priceListDAO.saveOrUpdate(priceList);
		}

		// PriceAsgn pull from DB and publish to kafka
		List<PriceAsgn> priceAsgnList = priceAsgnDAO.findAll();
		for (PriceAsgn priceAsgn : priceAsgnList) {
			String msg = BiSerializer.serialize(priceAsgn);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
			// priceAsgn.setRecordStatus("Processed");
			// priceAsgnDAO.saveOrUpdate(priceAsgn);
		}

		// RsRc pull from DB and publish to kafka
		List<RsRc> rsrcList = rsRcDAO.findAll();
		for (RsRc rsrc : rsrcList) {
			String msg = BiSerializer.serialize(rsrc);
			kafkaSender.sendMessage(KafkaConfig.TOPIC_NAME, msg);
			// rsrc.setRecordStatus("Processed");
			// rsRcDAO.saveOrUpdate(rsrc);
		}
	}
}
package app.kafka.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
public class DatabaseController {

	@Autowired()
	PriceItemDAO priceItemDAO;
	@Autowired()
	PriceItemParamDAO priceItemParamDAO;
	@Autowired()
	PriceListDAO priceListDAO;
	@Autowired()
	PriceAsgnDAO priceAsgnDAO;
	@Autowired()
	RsRcDAO rsRcDAO;

	@GetMapping(value = "/priceitem/save")
	public @ResponseBody String priceItemSave() {
		PriceItem priceItem = new PriceItem("1", "Item 1", "PE", "New", "Item text", new Date());
		priceItemDAO.save(priceItem);

		return "Message Saved: " + priceItem;
	}

	@GetMapping(value = "/priceitem/find")
	public @ResponseBody String priceItemFind() {
		List<PriceItem> list = priceItemDAO.findAll();

		return "Message Found: " + list;
	}

	@GetMapping(value = "/priceitemparam/save")
	public @ResponseBody String priceItemParamSave() {
		PriceItemParam priceItemParam = new PriceItemParam("PriceParam", "Required", "Priority", new Date(), new Date(),
				"dispOrd", "New", new Date());
		priceItemParamDAO.save(priceItemParam);

		return "Message Saved: " + priceItemParam;
	}

	@GetMapping(value = "/priceitemparam/find")
	public @ResponseBody String priceItemParamFind() {
		List<PriceItemParam> list = priceItemParamDAO.findAll();

		return "Message Found: " + list;
	}

	@GetMapping(value = "/pricelist/save")
	public @ResponseBody String priceListSave() {
		PriceList priceList = new PriceList("priceListId", "priceListExtId", "priceListName", "priceListStatus",
				new Date(), new Date(), "priceListType", "New", new Date());
		priceListDAO.save(priceList);

		return "Message Saved: " + priceList;
	}

	@GetMapping(value = "/pricelist/find")
	public @ResponseBody String priceListFind() {
		List<PriceList> list = priceListDAO.findAll();

		return "Message Found: " + list;
	}

	@GetMapping(value = "/priceasgn/save")
	public @ResponseBody String priceAsgnSave() {
		PriceAsgn priceAsgn = new PriceAsgn("priceAsgnId", "priceListExtId", "priceItem", "priceCompId", "rs", "effdt",
				"recordSeq", "recordName", "valueAmount", "tieredFlag", new Date());
		priceAsgnDAO.save(priceAsgn);

		return "Message Saved: " + priceAsgn;
	}

	@GetMapping(value = "/priceasgn/find")
	public @ResponseBody String priceAsgnFind() {
		List<PriceAsgn> list = priceAsgnDAO.findAll();

		return "Message Found: " + list;
	}

	@GetMapping(value = "/rsrc/save")
	public @ResponseBody String rsrcSave() {
		RsRc rsRc = new RsRc("rsCd", "rsDesc", "priceCurrency", "efftdt", "recordSeq", "recordName", "stepRecordSeq",
				"stepLowValue", "stepHighValue", new Date());
		rsRcDAO.save(rsRc);

		return "Message Saved: " + rsRc;
	}

	@GetMapping(value = "/rsrc/find")
	public @ResponseBody String rsrcFind() {
		List<RsRc> list = rsRcDAO.findAll();

		return "Message Found: " + list;
	}

}
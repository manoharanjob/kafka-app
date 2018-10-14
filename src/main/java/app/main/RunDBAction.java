package app.main;

import java.util.Date;
import java.util.List;

import app.kafka.dao.PriceItemDAO;
import app.kafka.dao.model.PriceItem;

public class RunDBAction {

	public static void main(String[] args) {
		PriceItemDAO p = new PriceItemDAO();

		PriceItem item = new PriceItem("1", "Item 1", "PE", "New", "Item text", new Date());
		
		p.save(item);
		
		List<PriceItem> list = p.findAll();
		for(PriceItem pitem: list) {
			System.out.println(pitem);
		}
	} 
}
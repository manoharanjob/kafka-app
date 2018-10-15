package app.kafka.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.kafka.dao.hibernate.HibernateDAO;
import app.kafka.dao.model.PriceItem;

@Repository
public class PriceItemDAO {

	public PriceItemDAO() {
	}

	public void save(PriceItem object) {
		HibernateDAO.save(object);
	}

	public void saveOrUpdate(PriceItem object) {
		HibernateDAO.saveOrUpdate(object);
	}
	
	public List<PriceItem> findByPriceItemId(String priceItemId) {
		return HibernateDAO.find("FROM PriceItem WHERE priceItemId=?", new Object[] { priceItemId });
	}

	public List<PriceItem> findByRecordStatus(String recordStatus) {
		return HibernateDAO.find("FROM PriceItem WHERE recordStatus=?", new Object[] { recordStatus });
	}

	public List<PriceItem> findAll() {
		return HibernateDAO.find("FROM PriceItem");
	}

	public Class getBeanClass() {
		return PriceItem.class.getClass();
	}
}

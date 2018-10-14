package app.kafka.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.kafka.dao.hibernate.HibernateDAO;
import app.kafka.dao.model.PriceList;

@Repository
public class PriceListDAO {

	public PriceListDAO() {
	}

	public void save(PriceList object) {
		HibernateDAO.save(object);
	}

	public List<PriceList> findByPriceListId(String priceListId) {
		return HibernateDAO.find("FROM PriceList WHERE priceListId=?", new Object[] { priceListId });
	}

	public List<PriceList> findByRecordStatus(String recordStatus) {
		return HibernateDAO.find("FROM PriceList WHERE recordStatus=?", new Object[] { recordStatus });
	}

	public List<PriceList> findAll() {
		return HibernateDAO.find("FROM PriceList");
	}

	public Class getBeanClass() {
		return PriceList.class.getClass();
	}
}

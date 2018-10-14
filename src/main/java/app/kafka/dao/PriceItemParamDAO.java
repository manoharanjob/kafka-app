package app.kafka.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.kafka.dao.hibernate.HibernateDAO;
import app.kafka.dao.model.PriceItemParam;

@Repository
public class PriceItemParamDAO {

	public PriceItemParamDAO() {
	}

	public void save(PriceItemParam object) {
		HibernateDAO.save(object);
	}

	public List<PriceItemParam> findByPriceItemId(String priceItemId) {
		return HibernateDAO.find("FROM PriceItemParam WHERE priceItemId=?", new Object[] { priceItemId });
	}

	public List<PriceItemParam> findByRecordStatus(String recordStatus) {
		return HibernateDAO.find("FROM PriceItemParam WHERE recordStatus=?", new Object[] { recordStatus });
	}

	public List<PriceItemParam> findAll() {
		return HibernateDAO.find("FROM PriceItemParam");
	}

	public Class getBeanClass() {
		return PriceItemParam.class.getClass();
	}
}

package app.kafka.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.kafka.dao.hibernate.HibernateDAO;
import app.kafka.dao.model.PriceAsgn;

@Repository
public class PriceAsgnDAO {

	public PriceAsgnDAO() {
	}

	public void save(PriceAsgn object) {
		HibernateDAO.save(object);
	}

	public void saveOrUpdate(PriceAsgn object) {
		HibernateDAO.saveOrUpdate(object);
	}

	public List<PriceAsgn> findByPriceAsgnId(String priceAsgnId) {
		return HibernateDAO.find("FROM PriceAsgn WHERE priceAsgnId=?", new Object[] { priceAsgnId });
	}

	public List<PriceAsgn> findAll() {
		return HibernateDAO.find("FROM PriceAsgn");
	}

	public Class getBeanClass() {
		return PriceAsgn.class.getClass();
	}
}

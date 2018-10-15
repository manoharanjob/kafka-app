package app.kafka.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.kafka.dao.hibernate.HibernateDAO;
import app.kafka.dao.model.RsRc;

@Repository
public class RsRcDAO {

	public RsRcDAO() {
	}

	public void save(RsRc object) {
		HibernateDAO.save(object);
	}

	public void saveOrUpdate(RsRc object) {
		HibernateDAO.saveOrUpdate(object);
	}
	
	public List<RsRc> findByRsCd(String rscd) {
		return HibernateDAO.find("FROM RsRc WHERE rsCd=?", new Object[] { rscd });
	}

	public List<RsRc> findAll() {
		return HibernateDAO.find("FROM RsRc");
	}

	public Class getBeanClass() {
		return RsRcDAO.class.getClass();
	}
}

package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IInfectDao;
import model.BeanCompany;
import model.BeanInfect;
import util.HibernateUtil;
@Repository
public class InfectDao implements IInfectDao {


	@Override
	public List<BeanInfect> loadAllGasInfect() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanInfect where StationType=31";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanInfect> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanInfect> loadAllWaterInfect() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanInfect where StationType=32";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanInfect> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public BeanInfect searchInfect(String InfectCode) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanInfect where InfectCode=?";
		Query qry = session.createQuery(hql);
		qry.setString(0, InfectCode);
		@SuppressWarnings("unchecked")
		BeanInfect result = (BeanInfect) qry.list().get(0);
		tx.commit();
		return result;
	}

	@Override
	public Map<String, String> loadAllInfect() {
		Map<String, String>  Infect =new HashMap<String, String>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanInfect";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanInfect> result = qry.list();
		for(int i=0;i<result.size();i++){
			Infect.put(result.get(i).getInfectCode(), result.get(i).getInfectName());
		}
		tx.commit();
		return Infect;
	}

}

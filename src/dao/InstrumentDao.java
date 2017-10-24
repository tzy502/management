package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IInstrumentDao;
import model.BeanInstrument;

import util.HibernateUtil;
@Repository
public class InstrumentDao implements IInstrumentDao {

	@Override
	public void addInstrument(BeanInstrument Instrument) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Instrument);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanInstrument SearchInstrument(int InstrumentId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanInstrument where InstrumentId = '" + InstrumentId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanInstrument)Document;
	}

	@Override
	public List<BeanInstrument> loadAllInstrument() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanInstrument ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanInstrument> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryInstrument(BeanInstrument Instrument) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Instrument);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelInstrument(int InstrumentId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanInstrument bc=new BeanInstrument();
		bc.setInstrumentId(InstrumentId);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(bc);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}

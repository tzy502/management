package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ICarrepairDao;
import model.BeanCarrepair;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class CarrepairDao implements ICarrepairDao {

	@Override
	public void addCarrepair(BeanCarrepair Carrepair) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println(Carrepair.getCarrepairnumber());
			session.save(Carrepair);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanCarrepair SearchCarrepair(int CarrepairId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanCarrepair where CarrepairId = '" + CarrepairId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanCarrepair)Document;
	}

	@Override
	public List<BeanCarrepair> loadAllCarrepair(String carId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanCarrepair where carId="+carId;
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanCarrepair> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryCarrepair(BeanCarrepair Carrepair) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Carrepair);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelCarrepair(int CarrepairId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanCarrepair bc=new BeanCarrepair();
		bc.setCarrepairId(CarrepairId);
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

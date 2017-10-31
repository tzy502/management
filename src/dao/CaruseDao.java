package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ICaruseDao;
import model.BeanCaruse;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class CaruseDao implements ICaruseDao {

	@Override
	public void addCaruse(BeanCaruse Caruse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Caruse);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanCaruse SearchCaruse(int CaruseId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanCaruse where CaruseId = '" + CaruseId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanCaruse)Document;
	}

	@Override
	public List<BeanCaruse> loadAllCaruse(String carId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanCaruse where carId='"+carId+"'";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanCaruse> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryCaruse(BeanCaruse Caruse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Caruse);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelCaruse(int CaruseId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanCaruse bc=new BeanCaruse();
		bc.setCaruseId(CaruseId);
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

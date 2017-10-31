package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ICarDao;
import model.BeanCar;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class CarDao implements ICarDao {

	@Override
	public void addCar(BeanCar Car) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Car);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanCar SearchCar(String CarId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanCar where CarId = '" + CarId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanCar)Document;
	}

	@Override
	public List<BeanCar> loadAllCar() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanCar ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanCar> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryCar(BeanCar Car) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Car);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelCar(String CarId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanCar bc=new BeanCar();
		bc.setCarId(CarId);
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

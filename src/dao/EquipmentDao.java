package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IEquipmentDao;
import model.BeanEquipment;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class EquipmentDao implements IEquipmentDao {

	@Override
	public void addEquipment(BeanEquipment Equipment) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("dao");
			session.save(Equipment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanEquipment SearchEquipment(int EquipmentId) {
		// TODO 自动生成的方法存根
		System.out.println("d");
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanEquipment where EquipmentId = '" + EquipmentId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanEquipment)Document;
	}

	@Override
	public List<BeanEquipment> loadAllEquipment(int stationId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanEquipment where stationId=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, stationId);
		@SuppressWarnings("unchecked")
		List<BeanEquipment> result = qry.list();
		tx.commit();
		System.out.println(result.size());
		return result;
	}

	@Override
	public void modifryEquipment(BeanEquipment Equipment) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Equipment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelEquipment(BeanEquipment Equipment){

	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(Equipment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}

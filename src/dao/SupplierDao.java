package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ISupplierDao;
import model.BeanSupplier;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class SupplierDao implements ISupplierDao {

	@Override
	public void addSupplier(BeanSupplier Supplier) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Supplier);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSupplier SearchSupplier(int SupplierId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanSupplier where SupplierId = '" + SupplierId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanSupplier)Document;
	}

	@Override
	public List<BeanSupplier> loadAllSupplier() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanSupplier ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanSupplier> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifrySupplier(BeanSupplier Supplier) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Supplier);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelSupplier(int SupplierId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanSupplier bc=new BeanSupplier();
		bc.setSupplierId(SupplierId);
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

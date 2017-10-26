package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ISupplieritemDao;
import model.BeanSupplieritem;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class SupplieritemDao implements ISupplieritemDao {

	@Override
	public void addSupplieritem(BeanSupplieritem Supplieritem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Supplieritem);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSupplieritem SearchSupplieritem(int SupplieritemId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanSupplieritem where SupplieritemId = '" + SupplieritemId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanSupplieritem)Document;
	}

	@Override
	public List<BeanSupplieritem> loadAllSupplieritem(int SupplierId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanSupplieritem where supplierId="+SupplierId;
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanSupplieritem> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifrySupplieritem(BeanSupplieritem Supplieritem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Supplieritem);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelSupplieritem(int SupplieritemId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanSupplieritem bc=new BeanSupplieritem();
		bc.setSupplieritemId(SupplieritemId);
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

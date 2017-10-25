package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ICostDao;
import model.BeanCost;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class CostDao implements ICostDao {

	@Override
	public void addCost(BeanCost Cost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Cost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanCost SearchCost(int CostId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanCost where CostId = '" + CostId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanCost)Document;
	}

	@Override
	public List<BeanCost> loadAllCost() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanCost ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanCost> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryCost(BeanCost Cost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Cost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelCost(int CostId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanCost bc=new BeanCost();
		bc.setCostId(CostId);
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

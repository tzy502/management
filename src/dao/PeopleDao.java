package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IPeopleDao;
import model.BeanPeople;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class PeopleDao implements IPeopleDao {

	@Override
	public void addPeople(BeanPeople People) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(People);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanPeople SearchPeople(int PeopleId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanPeople where PeopleId = '" + PeopleId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanPeople)Document;
	}

	@Override
	public List<BeanPeople> loadAllPeople() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanPeople ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanPeople> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryPeople(BeanPeople People) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(People);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelPeople(int PeopleId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanPeople bc=new BeanPeople();
		bc.setPeopleId(PeopleId);
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

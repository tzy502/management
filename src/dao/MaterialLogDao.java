package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IMaterialLogDao;
import model.BeanMaterialLog;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class MaterialLogDao implements IMaterialLogDao {

	@Override
	public void addMaterialLog(BeanMaterialLog MaterialLog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(MaterialLog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanMaterialLog SearchMaterialLog(int MaterialLogId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanMaterialLog where MaterialLogId = '" + MaterialLogId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanMaterialLog)Document;
	}

	@Override
	public List<BeanMaterialLog> loadAllMaterialLog() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMaterialLog ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanMaterialLog> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryMaterialLog(BeanMaterialLog MaterialLog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(MaterialLog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelMaterialLog(int MaterialLogId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanMaterialLog bc=new BeanMaterialLog();
		bc.setMateriallogId(MaterialLogId);
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

	@Override
	public List<BeanMaterialLog> loadUserMaterialLog(String userId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMaterialLog "
				+ "where userId=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		
		List<BeanMaterialLog> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanMaterialLog> loadMaterialMaterialLog(int MaterialId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMaterialLog "
				+ "where materialId=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, MaterialId);
		@SuppressWarnings("unchecked")
		List<BeanMaterialLog> result = qry.list();
		tx.commit();
		return result;
	}

}

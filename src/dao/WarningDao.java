package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IWarningDao;
import model.BeanWarning;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class WarningDao implements IWarningDao {

	@Override
	public void addWarning(BeanWarning Warning) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Warning);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanWarning SearchWarning(int WarningId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanWarning where WarningId = '" + WarningId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanWarning)Document;
	}

	@Override
	public List<BeanWarning> loadAllWarning(Timestamp start,Timestamp end) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanWarning   "
				+ "where warningtime>? and warningtime<? "
				+ "ORDER BY warningId DESC";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, start);
		qry.setParameter(1, end);
		@SuppressWarnings("unchecked")
		List<BeanWarning> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryWarning(BeanWarning Warning) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Warning);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelWarning(int WarningId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanWarning bc=new BeanWarning();
		bc.setWarningId(WarningId);
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
	public boolean checkWarning(int stationId, String InfectCode, int type) {
		// TODO Auto-generated method stub

		long now=System.currentTimeMillis();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanWarning "
				+ "where stationId=? and InfectCode=? and type=?    "
				+ "order BY warningtime desc";

		Query qry = session.createQuery(hql);

		qry.setParameter(0, stationId);
		qry.setParameter(1, InfectCode);
		qry.setParameter(2, type);

		List<BeanWarning> result=null;
		result = qry.list();
		tx.commit();

		
		if(result.size()!=0){
			long item= now-result.get(0).getWarningtime().getTime();
	System.out.println(item);
			if(item>86400001){
				return true;
			}
			else{
				return false;			
			}
		}
		else{
			return true;
		}


	}

}

package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IMissionLogDao;
import model.BeanMissionLog;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class MissionLogDao implements IMissionLogDao {

	@Override
	public void addMissionLog(BeanMissionLog MissionLog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(MissionLog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanMissionLog SearchMissionLog(int MissionLogId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanMissionLog where missionlogId = '" + MissionLogId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanMissionLog)Document;
	}

	@Override
	public List<BeanMissionLog> loadAllMissionLog(int SupplierId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMissionLog where missionId="+SupplierId;
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanMissionLog> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryMissionLog(BeanMissionLog MissionLog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(MissionLog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelMissionLog(int MissionLogId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanMissionLog bc=new BeanMissionLog();
		bc.setMissionlogId(MissionLogId);
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

package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IMissionDao;
import model.BeanMission;
import util.HibernateUtil;
@Repository
public class MissionDao implements IMissionDao {
	@Override
	public void addMission(BeanMission Mission) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Mission);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanMission SearchMission(int MissionId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanMission where Missionid = '" + MissionId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanMission)Document;
	}

	@Override
	public List<BeanMission> loadAllMission() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}
	
	@Override
	public void modifryMission(BeanMission Mission) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Mission);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelMission(int MissionId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanMission bc=new BeanMission();
		bc.setMissionid(MissionId);
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
	public List<BeanMission> loadMission(int stationId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where stationid="+stationId;
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanMission> loadUserMission(String userId,int type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where userid=? and type=? and status=1";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, type);//1自动0手动
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanMission> loadunfinishMission(String userId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where userid=? and (status=5 OR status=2)";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);

		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}
	@Override
	public List<BeanMission> loadnewMission(String userId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where userid=? and status=4 ";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);

		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}
	@Override
	public List<BeanMission> loadALLUserMission(String userId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where userid=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void overtimeMission() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql = "UPDATE mission"
				+ "set `status`=4"
				+ "WHERE enddate < now()";
		
		Query qry = session.createSQLQuery(sql);
		tx.commit();
	}

	@Override
	public int unfinishMission(String userId,String start,String end) {
		// TODO Auto-generated method stub
		int count=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select count(*) from BeanMission"
				+ " where userid=? and status<>3 and status<>5 and status<>6"
				+ "and startdate>? and startdate<?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, Timestamp.valueOf(start));
		qry.setParameter(2, Timestamp.valueOf(end));
		count= ((Number)qry.uniqueResult()).intValue();  
		tx.commit();
		return count;
	}

	@Override
	public int finishMission(String userId,String start,String end) {
		// TODO Auto-generated method stub
		int count=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select count(*) from BeanMission"
				+ " where userid=? and status=3 "
				+ "and startdate>? and startdate<?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, Timestamp.valueOf(start));
		qry.setParameter(2, Timestamp.valueOf(end));
		count= ((Number)qry.uniqueResult()).intValue();  
		tx.commit();
		return count;
	}

	@Override
	public int overunfinishMission(String userId,String start,String end) {
		// TODO Auto-generated method stub
		int count=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select count(*) from BeanMission"
				+ " where userid=? and  status=5"
				+ "and startdate>? and startdate<?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, Timestamp.valueOf(start));
		qry.setParameter(2, Timestamp.valueOf(end));
		count= ((Number)qry.uniqueResult()).intValue();  
		tx.commit();
		return count;
	}

	@Override
	public int overfinishMission(String userId,String start,String end) {
		// TODO Auto-generated method stub
		int count=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select count(*) from BeanMission"
				+ " where userid=? and  status=6"
				+ "and startdate>? and startdate<?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, Timestamp.valueOf(start));
		qry.setParameter(2, Timestamp.valueOf(end));
		count= ((Number)qry.uniqueResult()).intValue();  
		tx.commit();
		return count;
	}
	
}

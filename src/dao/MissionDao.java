package dao;

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
		System.out.println("d");
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanMission where MissionId = '" + MissionId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanMission)Document;
	}

	@Override
	public List<BeanMission> loadAllMission() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission ";
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
		String hql = "from BeanMission where stationid=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, stationId);
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanMission> loadUserMission(String userId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMission where userId=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<BeanMission> result = qry.list();
		tx.commit();
		return result;
	}
}

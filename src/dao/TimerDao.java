package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITimerDao;
import model.BeanTimer;
import util.HibernateUtil;
@Repository
public class TimerDao implements ITimerDao {
	@Override
	public void addTimer(BeanTimer Timer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Timer);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTimer SearchTimer(int TimerId) {
		// TODO 自动生成的方法存根
		System.out.println("d");
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTimer where timeId = '" + TimerId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanTimer)Document;
	}

	@Override
	public List<BeanTimer> loadAllTimer() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTimer";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTimer> result = qry.list();
		tx.commit();
		return result;
	}
	
	@Override
	public void modifryTimer(BeanTimer Timer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Timer);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelTimer(int TimerId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanTimer bc=new BeanTimer();
		bc.setTimeId(TimerId);
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
	public List<BeanTimer> loadTimer(int stationId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTimer where stationid="+stationId;
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTimer> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanTimer> loadUserTimer(String userId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTimer where userid=?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<BeanTimer> result = qry.list();
		tx.commit();
		return result;
	}
}

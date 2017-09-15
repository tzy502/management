package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;

import daoI.IStandardDao;
import model.BeanStandard;
@Repository
public class StandardDao implements IStandardDao {

	@Override
	public void addStandard(BeanStandard Standard) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Standard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<BeanStandard> loadStandard(int StandardId) {
		// TODO Auto-generated method stub
		List<BeanStandard> result =new ArrayList<BeanStandard>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		org.hibernate.Query qry = session.createQuery("from BeanStandard where stationid=?");
		qry.setParameter(0, StandardId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}



	@Override
	public void modifryStandard(BeanStandard Standard) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			session.update(Standard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delStandard(BeanStandard Standard) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(Standard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanStandard SearchStandard(int StandardId) {
		BeanStandard result =new BeanStandard();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		org.hibernate.Query qry = session.createQuery("from BeanStandard where StandardId=?");
		qry.setParameter(0, StandardId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanStandard) list.get(0);
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public boolean checkStandard(BeanStandard Standard) {
		// TODO Auto-generated method stub
		List<BeanStandard> result =new ArrayList<BeanStandard>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		org.hibernate.Query qry = session.createQuery("from BeanStandard where stationid=? and infectid=?");
		qry.setParameter(0, Standard.getStationid());
		qry.setParameter(1, Standard.getInfectid());
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result = list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		if(result.size()==0){
			System.out.println("asdasdafzsdfa"+result.size());
			return true;
		}
		else{
			return false;
		}
	}

	

	

	

}

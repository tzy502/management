package dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IChecklistDao;
import model.BeanChecklist;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class ChecklistDao implements IChecklistDao {

	@Override
	public void addChecklist(BeanChecklist Checklist) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Checklist);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanChecklist SearchChecklist(int ChecklistId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanChecklist where checklistId = '" + ChecklistId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanChecklist)Document;
	}

	@Override
	public List<BeanChecklist> loadChecklisthistory(int StationId,int type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanChecklist where checklisttype=? and stationId=?";
		Query qry = session.createQuery(hql);
		qry.setInteger(0, type);
		qry.setInteger(1, StationId);
		@SuppressWarnings("unchecked")
		List<BeanChecklist> result = qry.list();
		System.out.println(result.size());
		tx.commit();
		return result;
	}
	@Override
	public  List<BeanChecklist> loadChecklist(int StationId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String sql 	="	select a.*"
					+"	from checklist a"
					+"	 inner join"
					+"	 (select checklisttype,"
					+"	        max(checklisttime) 'maxgdtime'"
					+"	  from checklist "
					+"		where stationId=?"
					+"	  group by checklisttype) b on a.checklisttype=b.checklisttype and a.checklisttime=b.maxgdtime"
					+"	order by checklisttype";
		

	
//		Query qry = session.createQuery(hql);
		SQLQuery qry = session.createSQLQuery(sql).addEntity(BeanChecklist.class);  
		qry.setInteger(0, StationId);
		@SuppressWarnings("unchecked")
		List<BeanChecklist> result = qry.list();
		tx.commit();
		return result;
	}
	@Override
	public void modifryChecklist(BeanChecklist Checklist) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Checklist);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelChecklist(int ChecklistId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanChecklist bc=new BeanChecklist();
		bc.setChecklistId(ChecklistId);
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
	public int totallist(String userId, String start, String end) {
		// TODO Auto-generated method stub
		int count=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select count(*) from BeanChecklist"
				+ " where userid=? "
				+ "and checklisttime>? and checklisttime<?";
		Query qry = session.createQuery(hql);
		qry.setParameter(0, userId);
		qry.setParameter(1, Timestamp.valueOf(start));
		qry.setParameter(2, Timestamp.valueOf(end));
		count= ((Number)qry.uniqueResult()).intValue();  
		tx.commit();
		return count;
	}

}

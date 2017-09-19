package dao;

import java.util.List;

import org.hibernate.Query;
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
		System.out.println("d");
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanChecklist where checklistId = '" + ChecklistId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanChecklist)Document;
	}

	@Override
	public List<BeanChecklist> loadAllChecklist() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanChecklist ";
		Query qry = session.createQuery(hql);
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

}

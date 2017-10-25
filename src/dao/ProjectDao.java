package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IProjectDao;
import model.BeanProject;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class ProjectDao implements IProjectDao {

	@Override
	public void addProject(BeanProject Project) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanProject SearchProject(int ProjectId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanProject where ProjectId = '" + ProjectId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanProject)Document;
	}

	@Override
	public List<BeanProject> loadAllProject() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanProject ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanProject> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryProject(BeanProject Project) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelProject(int ProjectId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanProject bc=new BeanProject();
		bc.setProjectId(ProjectId);
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

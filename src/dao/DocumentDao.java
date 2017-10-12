package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IDocumentDao;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class DocumentDao implements IDocumentDao {

	@Override
	public void addDocument(BeanDocument Document) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Document);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanDocument SearchDocument(int DocumentId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanDocument where DocumentId = '" + DocumentId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanDocument)Document;
	}

	@Override
	public List<BeanDocument> loadDocument(String DocumentName) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanDocument where DocumentName like '%" + DocumentName + "%'";
		hql += " order by DocumentId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanDocument> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanDocument> loadAllDocument() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanDocument ";
		hql += " order by DocumentId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanDocument> result = qry.list();
		tx.commit();
		return result;
	}
	@Override
	public void modifryDocument(BeanDocument Document) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Document);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delDocument(BeanDocument Document) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(Document);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<BeanDocument> loadDocument(int level) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanDocument where level>="+level+"";
		hql += " order by DocumentId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanDocument> result = qry.list();
		tx.commit();
		return result;
	}


	

}

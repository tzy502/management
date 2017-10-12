package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ICompanyDao;
import model.BeanCompany;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class CompanyDao implements ICompanyDao {

	@Override
	public void addCompany(BeanCompany Company) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Company);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanCompany SearchCompany(int CompanyId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanCompany where CompanyId = '" + CompanyId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanCompany)Document;
	}

	@Override
	public List<BeanCompany> loadAllCompany() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanCompany ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanCompany> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryCompany(BeanCompany Company) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Company);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelCompany(int CompanyId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanCompany bc=new BeanCompany();
		bc.setCompanyid(CompanyId);
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

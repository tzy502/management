package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IMaterialDao;
import model.BeanMaterial;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class MaterialDao implements IMaterialDao {

	@Override
	public void addMaterial(BeanMaterial Material) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Material);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanMaterial SearchMaterial(int MaterialId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanMaterial where MaterialId = '" + MaterialId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanMaterial)Document;
	}

	@Override
	public List<BeanMaterial> loadAllMaterial() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanMaterial ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanMaterial> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryMaterial(BeanMaterial Material) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Material);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelMaterial(int MaterialId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanMaterial bc=new BeanMaterial();
		bc.setMaterialId(MaterialId);
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

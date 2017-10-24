package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITrainDao;
import model.BeanTrain;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class TrainDao implements ITrainDao {

	@Override
	public void addTrain(BeanTrain Train) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Train);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTrain SearchTrain(int TrainId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTrain where TrainId = '" + TrainId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanTrain)Document;
	}

	@Override
	public List<BeanTrain> loadAllTrain() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTrain ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTrain> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTrain(BeanTrain Train) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Train);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelTrain(int TrainId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanTrain bc=new BeanTrain();
		bc.setTrainId(TrainId);
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

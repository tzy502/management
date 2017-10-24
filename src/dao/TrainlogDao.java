package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITrainlogDao;
import model.BeanTrainlog;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class TrainlogDao implements ITrainlogDao {

	@Override
	public void addTrainlog(BeanTrainlog Trainlog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Trainlog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTrainlog SearchTrainlog(int TrainlogId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTrainlog where TrainlogId = '" + TrainlogId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanTrainlog)Document;
	}

	@Override
	public List<BeanTrainlog> loadAllTrainlog() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTrainlog ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTrainlog> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTrainlog(BeanTrainlog Trainlog) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Trainlog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelTrainlog(int TrainlogId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanTrainlog bc=new BeanTrainlog();
		bc.setTrainId(TrainlogId);
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

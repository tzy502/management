package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITrainuserDao;
import model.BeanTrainuser;
import model.BeanDocument;
import util.HibernateUtil;
@Repository
public class TrainuserDao implements ITrainuserDao {

	@Override
	public void addTrainuser(BeanTrainuser Trainuser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Trainuser);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTrainuser SearchTrainuser(int TrainuserId) {
		// TODO 自动生成的方法存根

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTrainuser where TrainuserId = '" + TrainuserId + "'";
		Query qry = s.createQuery(hql);
		Object Document = qry.uniqueResult();
		tx.commit();
		return (BeanTrainuser)Document;
	}

	@Override
	public List<BeanTrainuser> loadAllTrainuser() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTrainuser ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTrainuser> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTrainuser(BeanTrainuser Trainuser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Trainuser);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelTrainuser(int TrainuserId) {
		// TODO Auto-generated method stub
		// TODO 自动生成的方法存根
		BeanTrainuser bc=new BeanTrainuser();
		bc.setTrainuserId(TrainuserId);
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

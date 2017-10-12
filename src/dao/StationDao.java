package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import util.DBUtil;
import util.DbException;
import util.HibernateUtil;

import daoI.IStationDao;
import model.BeanData;
import model.BeanStation;
@Repository
public class StationDao implements IStationDao {

	@Override
	public void addStation(BeanStation Station) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.save(Station);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanStation SearchStation(int StationId) {
		// TODO Auto-generated method stub
		BeanStation result =new BeanStation();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		org.hibernate.Query qry = session.createQuery("from BeanStation where StationId=?");
		qry.setParameter(0, StationId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		
		result =(BeanStation)list.get(0);
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}


	@Override
	public List<BeanStation> loadAllStation() {
		// TODO Auto-generated method stub
		List<BeanStation> result =new ArrayList<BeanStation>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanStation");
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
	public void modifryStation(BeanStation Station) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Station);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelStation(BeanStation Station) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

			session.delete(Station);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<BeanStation> loadwaterStation() {
		List<BeanStation> result =new ArrayList<BeanStation>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanStation where type=32");
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
	public List<BeanStation> loadgasStation() {
		List<BeanStation> result =new ArrayList<BeanStation>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanStation where type=31");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}
	public List<BeanStation> loadbasestation() throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT MN,StationName,StationType,StationAdd FROM HJ212_Station";

			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();	
			List<BeanStation> result =new ArrayList<BeanStation>();	
			while(rs.next()){
				BeanStation bs=new BeanStation();
				bs.setMN(rs.getString(1));
				bs.setStationname(rs.getString(2));
				bs.setType(rs.getString(3));
				String add=rs.getString(4);
				bs.setCity(add.substring(0, 2));
				bs.setArea(add.substring(3, 5));
				bs.setCompanyid(1);
				bs.setPrincipal("admin");
				result.add(bs);
			}
			rs.close();
			pst.execute();
			pst.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import daoI.IDataDao;
import model.BeanData;
import util.DBUtil;
import util.DbException;
@Repository
public class DataDao implements IDataDao {

	@Override
	public List<BeanData> loadnewdate(String MN) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from HJ212_"+MN+"_MIN where "
					+ "mTime=(select mTime from HJ212_"+MN+"_MIN order BY mTime desc LIMIT 1)";

			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;	
			List<BeanData> result =new ArrayList<BeanData>();
			while(rs.next()){
				BeanData bd=new BeanData();
				bd.setmTime(rs.getTimestamp(1));
				bd.setInfectCode(rs.getString(2));
				float   a =rs.getFloat(3);
				float b=(float)(Math.round(a*100))/100;
				bd.setInfectValue(b);


				result.add(bd);
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

	@Override
	public List<BeanData> loaddate(String MN)throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(0, "HJ212_"+MN+"_MIN");
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;	
			List<BeanData> result =new ArrayList<BeanData>();
			while(rs.next()){
				BeanData bd=new BeanData();
				bd.setmTime(rs.getTimestamp(1));
				bd.setInfectCode(rs.getString(2));
				bd.setInfectValue(rs.getFloat(3));
				result.add(bd);
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

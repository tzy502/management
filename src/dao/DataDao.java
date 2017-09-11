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
import model.BeanGas;
import model.BeanStation;
import model.BeanWater;
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
	public List<BeanGas> loadgas(BeanStation bs, Timestamp Start, Timestamp end) throws DbException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select mTime,"+
					"sum(case InfectCode when '02' then InfectAvgValue end)  as '02',"+
					"sum(case InfectCode when '01' then InfectAvgValue end)  as '01',"+
					"sum(case InfectCode when '03' then InfectAvgValue end)  as '03',"+
					"sum(case InfectCode when '01-Zs' then InfectAvgValue end)  as '01-Zs',"+
					"sum(case InfectCode when '02-Zs' then InfectAvgValue end)  as '02-Zs',"+
					"sum(case InfectCode when '03-Zs' then InfectAvgValue end)  as '03-Zs',"+
					"sum(case InfectCode when 'S01' then InfectAvgValue end)  as 'S01',"+
					"sum(case InfectCode when 'S02' then InfectAvgValue end)  as 'S02',"+
					"sum(case InfectCode when 'S03' then InfectAvgValue end)  as 'S03',"+
					"sum(case InfectCode when 'S08' then InfectAvgValue end)  as 'S08',"+
					"sum(case InfectCode when 'B02' then InfectAvgValue end)  as 'B02',"+
					"sum(case InfectCode when 'S05' then InfectAvgValue end)  as 'S05'"+
					"from HJ212_HOUR"+
					"where"+
					"MN=? AND mTime>? and mTime<?"+
					"group by mTime;";

			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;	
			List<BeanGas> result =new ArrayList<BeanGas>();
			while(rs.next()){
				BeanGas bd=new BeanGas();
				bd.setG02(rs.getFloat(1));
				bd.setG01(rs.getFloat(2));
				bd.setG03(rs.getFloat(3));
				bd.setG01Zs(rs.getFloat(4));
				bd.setG02Zs(rs.getFloat(5));
				bd.setG03Zs(rs.getFloat(6));
				bd.setgS01(rs.getFloat(7));
				bd.setgS02(rs.getFloat(8));
				bd.setgS03(rs.getFloat(9));
				bd.setgS08(rs.getFloat(10));
				bd.setgB02(rs.getFloat(11));
				bd.setSg05(rs.getFloat(12));
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
	public List<BeanWater> loadwater(BeanStation bs, Timestamp start, Timestamp end) throws DbException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select mTime,"
					+ "sum(case InfectCode when '011' then InfectAvgValue end)  as '011',"
					+ "sum(case InfectCode when '001' then InfectAvgValue end)  as '001',"
					+ "sum(case InfectCode when '060' then InfectAvgValue end)  as '060',"
					+ "sum(case InfectCode when '065' then InfectAvgValue end)  as '065',"
					+ "sum(case InfectCode when '42' then InfectAvgValue end)  as '42',"
					+ "sum(case InfectCode when 'B01' then InfectAvgValue end)  as 'B01'"
					+ "from HJ212_HOUR"
					+ "where "
					+ "MN=? and mTime>? and mTime<?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(0, bs.getMN());
			pst.setTimestamp(1, start);
			pst.setTimestamp(2, start);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;	
			List<BeanWater>  result =new ArrayList<BeanWater>();
			while(rs.next()){
				BeanWater bd=new BeanWater();
				bd.setStationId(bs.getStationid());
				bd.setStationname(bs.getStationname());
				bd.setTime(rs.getTimestamp(1));
				bd.setW011(rs.getFloat(2));
				bd.setW001(rs.getFloat(3));
				bd.setW060(rs.getFloat(4));
				bd.setW065(rs.getFloat(5));
				bd.setW42(rs.getFloat(6));
				bd.setwB01(rs.getFloat(7));
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

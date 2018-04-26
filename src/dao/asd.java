package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BeanData;
import model.BeanGas;
import model.BeanStation;
import model.BeanWater;
import util.DBUtil;
import util.DbException;

public class asd {

	public static void main(String[] args) throws DbException {
		// TODO Auto-generated method stub
		List<BeanStation> result =new ArrayList<BeanStation>();
		StationDao sd=new StationDao();
		DataDao dd=new DataDao();
		result=sd.loadwaterStation();
		String date="2018-04-03";
		int flag=0;
		for(int i=flag;i<result.size();i++) {
			adddata(result.get(i).getMN());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		
	}

	
	public static void adddata(String MN) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			int id=0;

			String sql="DELETE\r\n" + 
					"FROM db"+MN+"\r\n" + 
					"WHERE InfectCode='02' OR InfectCode='01' OR InfectCode='03' OR InfectCode='01-Zs' OR InfectCode='02-Zs' OR InfectCode='03-Zs' OR InfectCode='S01' \r\n" + 
					" OR InfectCode='S02'  OR InfectCode='S03'  OR InfectCode='S08'  OR InfectCode='B02'  OR InfectCode='S05' \r\n" + 
					"";

			System.out.print(sql);
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.execute();
			pst.close();
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


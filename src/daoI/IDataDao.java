package daoI;

import java.sql.Timestamp;
import java.util.List;

import model.BeanData;
import model.BeanGas;
import model.BeanStation;
import model.BeanWater;
import util.DbException;
public interface IDataDao {
	public List<BeanData> loadnewdate(String MN)throws DbException;//弃用
	public List<BeanData> loaddate(String MN,String InfectCode, Timestamp start, Timestamp end)throws DbException;
	public List<BeanGas> loadgas(BeanStation bs,Timestamp Start,Timestamp end)throws DbException;
	public List<BeanWater> loadwater(BeanStation bs,Timestamp Start,Timestamp end)throws DbException;
	public BeanGas loadnewgasdate(String MN)throws DbException;
	public BeanWater loadnewawterdate(String MN)throws DbException;
}

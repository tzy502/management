package daoI;

import java.sql.Timestamp;
import java.util.List;

import model.BeanData;
import model.BeanGas;
import model.BeanStation;
import model.BeanWater;
import util.DbException;
public interface IDataDao {
	public List<BeanData> loadnewdate(String MN)throws DbException;
	public List<BeanGas> loadgas(BeanStation bs,Timestamp Start,Timestamp end)throws DbException;
	public List<BeanWater> loadwater(BeanStation bs,Timestamp Start,Timestamp end)throws DbException;
}

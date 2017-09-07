package daoI;

import java.util.List;

import model.BeanData;
import util.DbException;
public interface IDataDao {
	public List<BeanData> loadnewdate(String MN)throws DbException;
	public List<BeanData> loaddate(String MN)throws DbException;
}

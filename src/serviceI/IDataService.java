package serviceI;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanData;
import model.BeanGas;
import model.BeanWater;
import util.BaseException;
import util.DbException;
@Component
public interface IDataService {
	public List<BeanGas> loadnewgasdata()throws BaseException ;
	public List<BeanWater> loadnewwaterdata()throws BaseException ;
	public List<BeanGas> loadgasdata(int StationId,Timestamp start,Timestamp end)throws BaseException ;
	public List<BeanWater> loadwaterdata(int StationId,Timestamp start,Timestamp end)throws BaseException ;
	public List<BeanData> loaddate(int StationId,String InfectCode, Timestamp start, Timestamp end)throws DbException;
	public boolean checkdata(String MN, String InfectCode, float value) throws DbException;
	public void addwaterdata(BeanWater BeanWater);
	public void addgasdata(BeanGas Beangas);
}

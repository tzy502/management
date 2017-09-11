package serviceI;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanData;
import model.BeanGas;
import model.BeanWater;
import util.BaseException;
@Component
public interface IDataService {
	public List<BeanGas> loadnewgasdata()throws BaseException ;
	public List<BeanWater> loadnewwaterdata()throws BaseException ;
	public List<BeanGas> loadgasdata(int StationId,Timestamp start,Timestamp end)throws BaseException ;
	public List<BeanWater> loadwaterdata(int StationId,Timestamp start,Timestamp end)throws BaseException ;
}

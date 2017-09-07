package serviceI;
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
	public List<BeanGas> loadgasdata(String HM)throws BaseException ;
	public List<BeanWater> loadwaterdata(String HM)throws BaseException ;
}

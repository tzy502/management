package serviceI;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanData;
import model.BeanGas;
import model.BeanInfect;
import model.BeanWater;
import util.BaseException;
@Component
public interface IInfectService {
	public List<BeanInfect> load(int type)throws BaseException ;
	public BeanInfect search(String InfectCode)throws BaseException ;
}

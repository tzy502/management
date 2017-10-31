package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanCarrepair;
import util.BaseException;
@Component
public interface ICarrepairService {
	public void addCarrepair(BeanCarrepair Carrepair)throws BaseException;
	
	public BeanCarrepair SearchCarrepair(int compayid)throws BaseException;
	
	public List<BeanCarrepair> loadAllCarrepair(String carId)throws BaseException;
	
		
	public void modifryCarrepair(BeanCarrepair Carrepair)throws BaseException;
	
	public void DelCarrepair(int CarrepairId)throws BaseException;
	public boolean check(BeanCarrepair Carrepair) throws BaseException;
}

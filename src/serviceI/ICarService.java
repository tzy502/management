package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanCar;
import util.BaseException;
@Component
public interface ICarService {
	public void addCar(BeanCar Car)throws BaseException;
	
	public BeanCar SearchCar(String carId)throws BaseException;
	
	public List<BeanCar> loadAllCar()throws BaseException;
	
		
	public void modifryCar(BeanCar Car)throws BaseException;
	
	public void DelCar(String carId)throws BaseException;
	public boolean check(BeanCar Car) throws BaseException;
}

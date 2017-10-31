package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanCaruse;
import util.BaseException;
@Component
public interface ICaruseService {
	public void addCaruse(BeanCaruse Caruse)throws BaseException;
	
	public BeanCaruse SearchCaruse(int Caruseid)throws BaseException;
	
	public List<BeanCaruse> loadAllCaruse(String carId)throws BaseException;
	
		
	public void modifryCaruse(BeanCaruse Caruse)throws BaseException;
	
	public void DelCaruse(int CaruseId)throws BaseException;
	public boolean check(BeanCaruse Caruse) throws BaseException;
}

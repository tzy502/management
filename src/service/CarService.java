package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ICarDao;
import model.BeanCar;
import serviceI.ICarService;
import util.BaseException;
@Service
public class CarService implements ICarService {
	@Resource
	private ICarDao cd;
	@Override
	public void addCar(BeanCar Car) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Car)){
			cd.addCar(Car);
		}
		
	}

	@Override
	public BeanCar SearchCar(String compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanCar bc=cd.SearchCar(compayid);
		return bc;
	}

	@Override
	public List<BeanCar> loadAllCar() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCar> resutl =cd.loadAllCar();
		return resutl;
	}

	@Override
	public void modifryCar(BeanCar Car) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Car)){
			cd.modifryCar(Car);
		}
	}

	@Override
	public void DelCar(String CarId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelCar(CarId);
	}
	public boolean check(BeanCar Car) throws BaseException{

		return true;
	}
}

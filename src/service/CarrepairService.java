package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ICarrepairDao;
import model.BeanCarrepair;
import serviceI.ICarrepairService;
import util.BaseException;
@Service
public class CarrepairService implements ICarrepairService {
	@Resource
	private ICarrepairDao cd;
	@Override
	public void addCarrepair(BeanCarrepair Carrepair) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Carrepair)){
			cd.addCarrepair(Carrepair);
		}
		
	}

	@Override
	public BeanCarrepair SearchCarrepair(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanCarrepair bc=cd.SearchCarrepair(compayid);
		return bc;
	}

	@Override
	public List<BeanCarrepair> loadAllCarrepair(String carId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCarrepair> resutl =cd.loadAllCarrepair(carId);
		return resutl;
	}

	@Override
	public void modifryCarrepair(BeanCarrepair Carrepair) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Carrepair)){
			cd.modifryCarrepair(Carrepair);
		}
	}

	@Override
	public void DelCarrepair(int CarrepairId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelCarrepair(CarrepairId);
	}
	public boolean check(BeanCarrepair Carrepair) throws BaseException{

		return true;
	}
}

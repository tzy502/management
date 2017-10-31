package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ICaruseDao;
import model.BeanCaruse;
import serviceI.ICaruseService;
import util.BaseException;
@Service
public class CaruseService implements ICaruseService {
	@Resource
	private ICaruseDao cd;
	@Override
	public void addCaruse(BeanCaruse Caruse) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Caruse)){
			cd.addCaruse(Caruse);
		}
		
	}

	@Override
	public BeanCaruse SearchCaruse(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanCaruse bc=cd.SearchCaruse(compayid);
		return bc;
	}

	@Override
	public List<BeanCaruse> loadAllCaruse(String carId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCaruse> resutl =cd.loadAllCaruse(carId);
		return resutl;
	}

	@Override
	public void modifryCaruse(BeanCaruse Caruse) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Caruse)){
			cd.modifryCaruse(Caruse);
		}
	}

	@Override
	public void DelCaruse(int CaruseId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelCaruse(CaruseId);
	}
	public boolean check(BeanCaruse Caruse) throws BaseException{
		return true;
	}
}

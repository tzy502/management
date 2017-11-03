package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IPeopleDao;
import model.BeanPeople;
import serviceI.IPeopleService;
import util.BaseException;
@Service
public class PeopleService implements IPeopleService {
	@Resource
	private IPeopleDao cd;
	@Override
	public void addPeople(BeanPeople People) throws BaseException {
		// TODO Auto-generated method stub
		if(check(People)){
			cd.addPeople(People);
		}
		
	}

	@Override
	public BeanPeople SearchPeople(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanPeople bc=cd.SearchPeople(compayid);
		return bc;
	}

	@Override
	public List<BeanPeople> loadAllPeople() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanPeople> resutl =cd.loadAllPeople();
		return resutl;
	}

	@Override
	public void modifryPeople(BeanPeople People) throws BaseException {
		// TODO Auto-generated method stub
		if(check(People)){
			cd.modifryPeople(People);
		}
	}

	@Override
	public void DelPeople(int PeopleId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelPeople(PeopleId);
	}
	public boolean check(BeanPeople People) throws BaseException{

		return true;
	}
}

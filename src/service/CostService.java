package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ICostDao;
import model.BeanCost;
import serviceI.ICostService;
import util.BaseException;
@Service
public class CostService implements ICostService {
	@Resource
	private ICostDao cd;
	@Override
	public void addCost(BeanCost Cost) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Cost)){
			cd.addCost(Cost);
		}
		
	}

	@Override
	public BeanCost SearchCost(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanCost bc=cd.SearchCost(compayid);
		return bc;
	}

	@Override
	public List<BeanCost> loadAllCost(int projectId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCost> resutl =cd.loadAllCost(projectId);
		return resutl;
	}

	@Override
	public void modifryCost(BeanCost Cost) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Cost)){
			cd.modifryCost(Cost);
		}
	}

	@Override
	public void DelCost(int CostId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelCost(CostId);
	}
	public boolean check(BeanCost Cost) throws BaseException{
		
		return true;
	}
}

package service;

import java.util.List;

import javax.annotation.Resource;
import daoI.IInfectDao;
import model.BeanInfect;
import serviceI.IInfectService;
import util.BaseException;

import org.springframework.stereotype.Service;
@Service
public class InfectService implements IInfectService {
	@Resource
	private IInfectDao iid;

	@Override
	public List<BeanInfect> load(int type) throws BaseException {
		// TODO Auto-generated method stub
		if(type==31){
			return iid.loadAllGasInfect() ;
		}else		{
			return iid.loadAllWaterInfect();
		}
		
	}

	@Override
	public BeanInfect search(String InfectCode) throws BaseException {
		// TODO Auto-generated method stub
		return iid.searchInfect(InfectCode);
	}

}

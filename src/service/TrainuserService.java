package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ITrainuserDao;
import model.BeanTrainuser;
import serviceI.ITrainuserService;
import util.BaseException;
@Service
public class TrainuserService implements ITrainuserService {
	@Resource
	private ITrainuserDao cd;
	@Override
	public void addTrainuser(BeanTrainuser Trainuser) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Trainuser)){
			cd.addTrainuser(Trainuser);
		}
		
	}

	@Override
	public BeanTrainuser SearchTrainuser(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanTrainuser bc=cd.SearchTrainuser(compayid);
		return bc;
	}

	@Override
	public List<BeanTrainuser> loadAllTrainuser(int trainId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTrainuser> resutl =cd.loadAllTrainuser(trainId);
		return resutl;
	}

	@Override
	public void modifryTrainuser(BeanTrainuser Trainuser) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Trainuser)){
			cd.modifryTrainuser(Trainuser);
		}
	}

	@Override
	public void DelTrainuser(int TrainuserId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelTrainuser(TrainuserId);
	}
	public boolean check(BeanTrainuser Trainuser) throws BaseException{

		return true;
	}
}

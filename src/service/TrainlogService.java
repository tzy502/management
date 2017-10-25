package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ITrainlogDao;
import model.BeanTrainlog;
import serviceI.ITrainlogService;
import util.BaseException;
@Service
public class TrainlogService implements ITrainlogService {
	@Resource
	private ITrainlogDao cd;
	@Override
	public void addTrainlog(BeanTrainlog Trainlog) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Trainlog)){
			cd.addTrainlog(Trainlog);
		}
		
	}

	@Override
	public BeanTrainlog SearchTrainlog(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanTrainlog bc=cd.SearchTrainlog(compayid);
		return bc;
	}

	@Override
	public List<BeanTrainlog> loadAllTrainlog(int trainId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTrainlog> resutl =cd.loadAllTrainlog(trainId);
		return resutl;
	}

	@Override
	public void modifryTrainlog(BeanTrainlog Trainlog) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Trainlog)){
			cd.modifryTrainlog(Trainlog);
		}
	}

	@Override
	public void DelTrainlog(int TrainlogId) throws BaseException {
		
		// TODO Auto-generated method stub
		System.out.println("s"+TrainlogId);
		cd.DelTrainlog(TrainlogId);
	}
	public boolean check(BeanTrainlog Trainlog) throws BaseException{
	
		return true;
	}
}

package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ITrainDao;
import daoI.ITrainlogDao;
import daoI.ITrainuserDao;
import model.BeanTrain;
import serviceI.ITrainService;
import util.BaseException;
@Service
public class TrainService implements ITrainService {
	@Resource
	private ITrainDao td;
	@Resource
	private ITrainuserDao tud;
	@Resource
	private ITrainlogDao tld;
	@Override
	public void addTrain(BeanTrain Train) throws BaseException {
		// TODO Auto-generated method stub

			td.addTrain(Train);
		
		
	}

	@Override
	public BeanTrain SearchTrain(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanTrain bc=td.SearchTrain(compayid);
		return bc;
	}

	@Override
	public List<BeanTrain> loadAllTrain() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTrain> resutl =td.loadAllTrain();
		return resutl;
	}

	@Override
	public void modifryTrain(BeanTrain Train) throws BaseException {
		// TODO Auto-generated method stub

			td.modifryTrain(Train);
	
	}

	@Override
	public void DelTrain(int TrainId) throws BaseException {
		// TODO Auto-generated method stub
		td.DelTrain(TrainId);
//		tud.DelTrain(TrainId);
//		tld.DelTrainlog(TrainId);
	}

}

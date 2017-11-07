package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IMissionLogDao;
import model.BeanMissionLog;
import serviceI.IMissionLogService;
import util.BaseException;
@Service
public class MissionLogService implements IMissionLogService {
	@Resource
	private IMissionLogDao cd;
	@Override
	public void addMissionLog(BeanMissionLog MissionLog) throws BaseException {
		// TODO Auto-generated method stub
		if(check(MissionLog)){
			cd.addMissionLog(MissionLog);
		}
		
	}

	@Override
	public BeanMissionLog SearchMissionLog(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanMissionLog bc=cd.SearchMissionLog(compayid);
		return bc;
	}

	@Override
	public List<BeanMissionLog> loadAllMissionLog(int SupplierId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanMissionLog> resutl =cd.loadAllMissionLog(SupplierId);
		return resutl;
	}

	@Override
	public void modifryMissionLog(BeanMissionLog MissionLog) throws BaseException {
		// TODO Auto-generated method stub
		if(check(MissionLog)){
			cd.modifryMissionLog(MissionLog);
		}
	}

	@Override
	public void DelMissionLog(int MissionLogId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelMissionLog(MissionLogId);
	}
	public boolean check(BeanMissionLog MissionLog) throws BaseException{

		return true;
	}
}

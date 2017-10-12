package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IMissionDao;
import model.BeanMission;
import serviceI.IMissionService;
import util.BaseException;
@Service
public class MissionService implements IMissionService {
	@Resource
	private IMissionDao md;
	
	@Override
	public void addMission(BeanMission Mission) throws BaseException {
		// TODO Auto-generated method stub
		md.addMission(Mission);
	}

	@Override
	public BeanMission SearchMission(int Missionid) throws BaseException {
		// TODO Auto-generated method stub
		return md.SearchMission(Missionid);
	}

	@Override
	public List<BeanMission> loadAllMission() throws BaseException {
		// TODO Auto-generated method stub
		return md.loadAllMission();
	}

	@Override
	public void modifryMission(BeanMission Mission) throws BaseException {
		// TODO Auto-generated method stub
		md.modifryMission(Mission);
	}
	@Override
	public List<BeanMission> loadMission(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		return md.loadMission(StationId);
	}
	@Override
	public void DelMission(int MissionId) throws BaseException {
		// TODO Auto-generated method stub
		md.DelMission(MissionId);
	}

	@Override
	public boolean checkMission(BeanMission Mission) throws BaseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BeanMission> loaduserMission(String UserId,int type) throws BaseException {
		// TODO Auto-generated method stub
		return md.loadUserMission(UserId,type);
	}

	@Override
	public List<BeanMission> loadALLUserMission(String userId) {
		// TODO Auto-generated method stub
		return md.loadAllMission();
	}

	@Override
	public List<BeanMission> loadunfinishMission(String userId) {
		// TODO Auto-generated method stub
		return md.loadunfinishMission(userId);
	}

	@Override
	public List<BeanMission> loadnewMission(String userId) {
		// TODO Auto-generated method stub
		return md.loadnewMission(userId);
	}



}

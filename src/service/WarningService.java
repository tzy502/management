package service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IInfectDao;
import daoI.IMissionDao;
import daoI.IStationDao;
import daoI.ITimerDao;
import daoI.IWarningDao;
import model.BeanInfect;
import model.BeanMission;
import model.BeanStation;
import model.BeanWarning;
import serviceI.IWarningService;
import util.BaseException;
@Service
public class WarningService implements IWarningService {
	@Resource
	private IMissionDao imd;
	@Resource
	private IWarningDao iwd;
	@Resource
	private IInfectDao iid;
	@Resource
	private IStationDao isd;
	Map<String, String>  Infect =new HashMap<String, String>();
	@Override
	public void addWarning(BeanWarning Warning) throws BaseException {
		// TODO Auto-generated method stub
		Infect=iid.loadAllInfect();
		String type=null;
		if(Warning.getType()==1){
			 type="达到报警";
		}
		else{
			 type="达到预警";
		}
		BeanStation bs=new BeanStation();
		bs=isd.SearchStation(Warning.getStationId());	
		Timestamp now = new Timestamp(System.currentTimeMillis()); 

		iwd.addWarning(Warning);
		BeanMission bm=new BeanMission();
		String missionname=bs.getStationname()+Infect.get(Warning.getInfectCode())+type+"（系统自动报警）";
		bm.setMissionname(missionname);
		bm.setStationid(Warning.getStationId());
		bm.setStartdate(now);
		bm.setDescription(bs.getStationname()+Infect.get(Warning.getInfectCode())+type);
		bm.setUserid(bs.getPrincipal());
		bm.setStatus(1);
		Timestamp end =now;
		end.setDate(now.getDate()+7);
		bm.setEnddate(end);
		bm.setType(3);
		imd.addMission(bm);
	}

	@Override
	public BeanWarning SearchWarning(int WarningId) throws BaseException {
		// TODO Auto-generated method stub
		return iwd.SearchWarning(WarningId);
	}

	@Override
	public List<BeanWarning> loadAllWarning() throws BaseException {
		// TODO Auto-generated method stub
		return iwd.loadAllWarning();
	}

	@Override
	public void modifryWarning(BeanWarning Warning) throws BaseException {
		// TODO Auto-generated method stub
			iwd.modifryWarning(Warning);
	}

	@Override
	public void DelWarning(int WarningId) throws BaseException {
		// TODO Auto-generated method stub
		iwd.DelWarning(WarningId);
	}

	@Override
	public boolean check(BeanWarning Warning) throws BaseException {
		// TODO Auto-generated method stub
		return false;
	}

}
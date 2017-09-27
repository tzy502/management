package serviceI;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanMission;
import util.BaseException;
@Component
public interface IMissionService {
	public void addMission(BeanMission Mission)throws BaseException;	
	public BeanMission SearchMission(int Missionid)throws BaseException;	
	public List<BeanMission> loadAllMission()throws BaseException;	
	public List<BeanMission> loadMission(int StationId)throws BaseException;	
	public List<BeanMission> loaduserMission(String UserId)throws BaseException;
	public void modifryMission(BeanMission Mission)throws BaseException	;
	public void DelMission(int MissionId)throws BaseException;
	public boolean checkMission(BeanMission Mission)throws BaseException;
}

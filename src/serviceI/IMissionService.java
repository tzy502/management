package serviceI;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanMission;
import util.BaseException;
@Component
public interface IMissionService {
	public void addMission(BeanMission Mission)throws BaseException;	
	public BeanMission SearchMission(int Missionid)throws BaseException;	
	public List<BeanMission> loadAllMission()throws BaseException;	
	public List<BeanMission> loadMission(int StationId,Timestamp start,Timestamp end)throws BaseException;	
	public List<BeanMission> loadstationMission(int StationId)throws BaseException;	
	public List<BeanMission> loaduserMission(String UserId,int type)throws BaseException;
	public void modifryMission(BeanMission Mission)throws BaseException	;
	public void DelMission(int MissionId)throws BaseException;
	public boolean checkMission(BeanMission Mission)throws BaseException;
	public List<BeanMission> loadALLUserMission(String userId,Timestamp start,Timestamp end);
	public List<BeanMission> loadunfinishMission(String userId);
	public List<BeanMission> loadnewMission(String userId);
	public void overtimeMission();
}

package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanMissionLog;
import util.BaseException;
@Component
public interface IMissionLogService {
	public void addMissionLog(BeanMissionLog MissionLog)throws BaseException;
	
	public BeanMissionLog SearchMissionLog(int MissionLogId)throws BaseException;
	
	public List<BeanMissionLog> loadAllMissionLog(int MissionId)throws BaseException;
	
		
	public void modifryMissionLog(BeanMissionLog MissionLog)throws BaseException;
	
	public void DelMissionLog(int MissionLogId)throws BaseException;
	public boolean check(BeanMissionLog MissionLog) throws BaseException;
}

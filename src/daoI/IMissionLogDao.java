package daoI;

import java.util.List;

import model.BeanMissionLog;

public interface IMissionLogDao {
	public void addMissionLog(BeanMissionLog MissionLog);

	public BeanMissionLog SearchMissionLog(int MissionLogId);

	public List<BeanMissionLog> loadAllMissionLog(int MissionId);

	public void modifryMissionLog(BeanMissionLog MissionLog);

	public void DelMissionLog(int MissionLogId);

}

package daoI;

import java.sql.Timestamp;
import java.util.List;

import model.BeanMission;

public interface IMissionDao {
	public void addMission(BeanMission Mission);

	public BeanMission SearchMission(int MissionId);

	public List<BeanMission> loadAllMission();
	public List<BeanMission> loadstationMission(int stationId);
	public List<BeanMission> loadMission(int stationId,Timestamp start,Timestamp end);
	public List<BeanMission> loadUserMission(String userId,int type);
	public List<BeanMission> loadALLNoFinishUserMission(String userId,Timestamp start,Timestamp end);
	public List<BeanMission> loadALLFinishUserMission(String userId,Timestamp start,Timestamp end);
	public List<BeanMission> loadunfinishMission(String userId);
	public void modifryMission(BeanMission Mission);
	public List<BeanMission> loadnewMission(String userId);
	public void overtimeMission();
	public void DelMission(int MissionId);
	public int unfinishMission(String userId,String start,String end);
	public int finishMission(String userId,String start,String end);
	public int overunfinishMission(String userId,String start,String end);
	public int overfinishMission(String userId,String start,String end);
}

package daoI;

import java.util.List;

import model.BeanMission;

public interface IMissionDao {
	public void addMission(BeanMission Mission);
	//添加角色
	public BeanMission SearchMission(int MissionId);
	//搜索角色
	public List<BeanMission> loadAllMission();
	//搜索角色
	public List<BeanMission> loadMission(int stationId);
	public List<BeanMission> loadUserMission(String userId);
	public void modifryMission(BeanMission Mission);
	//修改角色
	public void DelMission(int MissionId);
	//删除角色

}

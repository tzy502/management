package daoI;

import java.util.List;

import model.BeanTimer;

public interface ITimerDao {
	public void addTimer(BeanTimer Timer);
	//添加角色
	public BeanTimer SearchTimer(int timerId);
	//搜索角色
	public List<BeanTimer> loadAllTimer();
	//搜索角色
	public List<BeanTimer> loadTimer(int stationId);
	public List<BeanTimer> loadUserTimer(String userId);
	public void modifryTimer(BeanTimer Timer);
	//修改角色
	public void DelTimer(int timerId);
	//删除角色

}

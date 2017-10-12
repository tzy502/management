package daoI;

import java.util.List;

import model.BeanTimer;

public interface ITimerDao {
	public void addTimer(BeanTimer Timer);

	public BeanTimer SearchTimer(int timerId);

	public List<BeanTimer> loadAllTimer();

	public List<BeanTimer> loadTimer(int stationId);
	public List<BeanTimer> loadUserTimer(String userId);
	public void modifryTimer(BeanTimer Timer);

	public void DelTimer(int timerId);

	public List<BeanTimer> loadmission(int timer);

}

package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ITimerDao;
import model.BeanTimer;
import serviceI.ITimerService;
import util.BaseException;
@Service
public class TimerService implements ITimerService {
	@Resource
	private ITimerDao md;
	
	@Override
	public void addTimer(BeanTimer Timer) throws BaseException {
		// TODO Auto-generated method stub
		md.addTimer(Timer);		
	}

	@Override
	public BeanTimer SearchTimer(int Timerid) throws BaseException {
		// TODO Auto-generated method stub
		return md.SearchTimer(Timerid);
	}

	@Override
	public List<BeanTimer> loadAllTimer() throws BaseException {
		// TODO Auto-generated method stub
		return md.loadAllTimer();
	}

	@Override
	public void modifryTimer(BeanTimer Timer) throws BaseException {
		// TODO Auto-generated method stub
		md.modifryTimer(Timer);
	}
	@Override
	public List<BeanTimer> loadTimer(int StationId) throws BaseException {
		// TODO Auto-generated method stub
		return md.loadTimer(StationId);
	}
	@Override
	public void DelTimer(int TimerId) throws BaseException {
		// TODO Auto-generated method stub
		md.DelTimer(TimerId);
	}

	@Override
	public boolean checkTimer(BeanTimer Timer) throws BaseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BeanTimer> loaduserTimer(String UserId) throws BaseException {
		// TODO Auto-generated method stub
		return md.loadUserTimer(UserId);
	}



}

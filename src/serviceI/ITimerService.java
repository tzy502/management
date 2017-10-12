package serviceI;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTimer;
import util.BaseException;
@Component
public interface ITimerService {
	public void addTimer(BeanTimer Timer)throws BaseException;	
	public BeanTimer SearchTimer(int Timerid)throws BaseException;	
	public List<BeanTimer> loadAllTimer()throws BaseException;	
	public List<BeanTimer> loadTimer(int StationId)throws BaseException;	
	public List<BeanTimer> loaduserTimer(String UserId)throws BaseException;
	public void modifryTimer(BeanTimer Timer)throws BaseException	;
	public void DelTimer(int TimerId)throws BaseException;
	public boolean checkTimer(BeanTimer Timer)throws BaseException;
	public List<BeanTimer> loadmission(int timer) ;
}

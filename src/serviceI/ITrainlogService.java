package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTrainlog;
import util.BaseException;
@Component
public interface ITrainlogService {
	public void addTrainlog(BeanTrainlog Trainlog)throws BaseException;
	
	public BeanTrainlog SearchTrainlog(int compayid)throws BaseException;
	
	public List<BeanTrainlog> loadAllTrainlog(int trainId)throws BaseException;
	
		
	public void modifryTrainlog(BeanTrainlog Trainlog)throws BaseException;
	
	public void DelTrainlog(int TrainlogId)throws BaseException;

}

package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTrainuser;
import util.BaseException;
@Component
public interface ITrainuserService {
	public void addTrainuser(BeanTrainuser Trainuser)throws BaseException;
	
	public BeanTrainuser SearchTrainuser(int TrainuserId)throws BaseException;
	
	public List<BeanTrainuser> loadAllTrainuser(int trainId)throws BaseException;
	
		
	public void modifryTrainuser(BeanTrainuser Trainuser)throws BaseException;
	
	public void DelTrainuser(int TrainuserId)throws BaseException;
	public boolean check(BeanTrainuser Trainuser) throws BaseException;
}

package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTrain;
import util.BaseException;
@Component
public interface ITrainService {
	public void addTrain(BeanTrain Train)throws BaseException;
	
	public BeanTrain SearchTrain(int compayid)throws BaseException;
	
	public List<BeanTrain> loadAllTrain()throws BaseException;
	
		
	public void modifryTrain(BeanTrain Train)throws BaseException;
	
	public void DelTrain(int TrainId)throws BaseException;
}

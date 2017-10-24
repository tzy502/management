package daoI;

import java.util.List;

import model.BeanTrain;

public interface ITrainDao {
	public void addTrain(BeanTrain Train);

	public BeanTrain SearchTrain(int TrainId);

	public List<BeanTrain> loadAllTrain();

	public void modifryTrain(BeanTrain Train);

	public void DelTrain(int TrainId);

}

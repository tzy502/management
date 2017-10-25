package daoI;

import java.util.List;

import model.BeanTrainuser;

public interface ITrainuserDao {
	public void addTrainuser(BeanTrainuser Trainuser);

	public BeanTrainuser SearchTrainuser(int TrainuserId);

	public List<BeanTrainuser> loadAllTrainuser(int trainId);

	public void modifryTrainuser(BeanTrainuser Trainuser);

	public void DelTrainuser(int TrainuserId);

	public void DelTrain(int TrainId);
}

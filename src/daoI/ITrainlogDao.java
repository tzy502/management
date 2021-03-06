package daoI;

import java.util.List;

import model.BeanTrainlog;

public interface ITrainlogDao {
	public void addTrainlog(BeanTrainlog Trainlog);

	public BeanTrainlog SearchTrainlog(int TrainlogId);

	public List<BeanTrainlog> loadAllTrainlog(int trainId);

	public void modifryTrainlog(BeanTrainlog Trainlog);

	public void DelTrainlog(int TrainlogId);

	public void DelTrain(int TrainId);
}

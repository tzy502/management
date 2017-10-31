package daoI;

import java.util.List;

import model.BeanCarrepair;

public interface ICarrepairDao {
	public void addCarrepair(BeanCarrepair Carrepair);

	public BeanCarrepair SearchCarrepair(int CarrepairId);

	public List<BeanCarrepair> loadAllCarrepair(String carId);

	public void modifryCarrepair(BeanCarrepair Carrepair);

	public void DelCarrepair(int CarrepairId);

}

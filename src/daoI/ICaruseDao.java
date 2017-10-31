package daoI;

import java.util.List;

import model.BeanCaruse;

public interface ICaruseDao {
	public void addCaruse(BeanCaruse Caruse);

	public BeanCaruse SearchCaruse(int CaruseId);

	public List<BeanCaruse> loadAllCaruse(String carId);

	public void modifryCaruse(BeanCaruse Caruse);

	public void DelCaruse(int CaruseId);

}

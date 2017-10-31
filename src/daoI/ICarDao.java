package daoI;

import java.util.List;

import model.BeanCar;

public interface ICarDao {
	public void addCar(BeanCar Car);

	public BeanCar SearchCar(String CarId);

	public List<BeanCar> loadAllCar();

	public void modifryCar(BeanCar Car);

	public void DelCar(String CarId);

}

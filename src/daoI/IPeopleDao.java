package daoI;

import java.util.List;

import model.BeanPeople;

public interface IPeopleDao {
	public void addPeople(BeanPeople People);

	public BeanPeople SearchPeople(int PeopleId);

	public List<BeanPeople> loadAllPeople();

	public void modifryPeople(BeanPeople People);

	public void DelPeople(int PeopleId);

}

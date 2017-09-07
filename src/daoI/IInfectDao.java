package daoI;

import java.util.List;

import model.BeanCompany;
import model.BeanInfect;

public interface IInfectDao {
	public List<BeanInfect> loadAllGasInfect();
	public List<BeanInfect> loadAllWaterInfect();
	public BeanInfect searchInfect(String InfectCode);

}

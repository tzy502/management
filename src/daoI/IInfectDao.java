package daoI;

import java.util.List;
import java.util.Map;

import model.BeanCompany;
import model.BeanInfect;

public interface IInfectDao {
	public List<BeanInfect> loadAllGasInfect();
	public List<BeanInfect> loadAllWaterInfect();
	public BeanInfect searchInfect(String InfectCode);
	public Map<String,String> loadAllInfect();
	
}

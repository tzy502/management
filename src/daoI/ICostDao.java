package daoI;

import java.util.List;

import model.BeanCost;

public interface ICostDao {
	public void addCost(BeanCost Cost);

	public BeanCost SearchCost(int CostId);

	public List<BeanCost> loadAllCost(int projectId);

	public void modifryCost(BeanCost Cost);

	public void DelCost(int CostId);

}

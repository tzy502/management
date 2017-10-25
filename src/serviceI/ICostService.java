package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanCost;
import util.BaseException;
@Component
public interface ICostService {
	public void addCost(BeanCost Cost)throws BaseException;
	
	public BeanCost SearchCost(int compayid)throws BaseException;
	
	public List<BeanCost> loadAllCost()throws BaseException;
	
		
	public void modifryCost(BeanCost Cost)throws BaseException;
	
	public void DelCost(int CostId)throws BaseException;
	public boolean check(BeanCost Cost) throws BaseException;
}

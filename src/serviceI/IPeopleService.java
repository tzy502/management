package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanPeople;
import util.BaseException;
@Component
public interface IPeopleService {
	public void addPeople(BeanPeople People)throws BaseException;
	
	public BeanPeople SearchPeople(int compayid)throws BaseException;
	
	public List<BeanPeople> loadAllPeople()throws BaseException;
	
		
	public void modifryPeople(BeanPeople People)throws BaseException;
	
	public void DelPeople(int PeopleId)throws BaseException;
	public boolean check(BeanPeople People) throws BaseException;
}

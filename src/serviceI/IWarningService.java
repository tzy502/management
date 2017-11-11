package serviceI;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanWarning;
import util.BaseException;
@Component
public interface IWarningService {
	public void addWarning(BeanWarning Warning)throws BaseException;	
	public BeanWarning SearchWarning(int warningId)throws BaseException;	
	public List<BeanWarning> loadAllWarning(Timestamp start,Timestamp end)throws BaseException;			
	public void modifryWarning(BeanWarning Warning)throws BaseException;
	public void DelWarning(int WarningId)throws BaseException;
	public boolean check(BeanWarning Warning) throws BaseException;
}

package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanMaterialLog;
import util.BaseException;
@Component
public interface IMaterialLogService {
	public void addMaterialLog(BeanMaterialLog MaterialLog)throws BaseException;
	
	public BeanMaterialLog SearchMaterialLog(int MaterialLogId)throws BaseException;
	
	public List<BeanMaterialLog> loadAllMaterialLog()throws BaseException;
	
	public List<BeanMaterialLog> loadUserMaterialLog(String userId);
	
	public List<BeanMaterialLog> loadMaterialMaterialLog(int MaterialId);
		
	public void modifryMaterialLog(BeanMaterialLog MaterialLog)throws BaseException;
	
	public void DelMaterialLog(int MaterialLogId)throws BaseException;

}

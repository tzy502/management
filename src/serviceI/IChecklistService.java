package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanChecklist;
import util.BaseException;
@Component
public interface IChecklistService {
	public void addChecklist(BeanChecklist Checklist)throws BaseException;
	
	public BeanChecklist SearchChecklist(int compayid)throws BaseException;
	
	public List<BeanChecklist> loadChecklisthistory(int StationId,int type);
	public List<BeanChecklist> loadChecklist(int StationId)throws BaseException;
		
	public void modifryChecklist(BeanChecklist Checklist)throws BaseException;
	
	public void DelChecklist(int ChecklistId)throws BaseException;

}

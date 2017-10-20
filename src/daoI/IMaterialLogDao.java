package daoI;

import java.util.List;

import model.BeanMaterialLog;

public interface IMaterialLogDao {
	public void addMaterialLog(BeanMaterialLog MaterialLog);

	public BeanMaterialLog SearchMaterialLog(int MaterialLogId);

	public List<BeanMaterialLog> loadAllMaterialLog();
	
	public List<BeanMaterialLog> loadUserMaterialLog(String userId);
	
	public List<BeanMaterialLog> loadMaterialMaterialLog(int MaterialId);

	public void modifryMaterialLog(BeanMaterialLog MaterialLog);

	public void DelMaterialLog(int MaterialLogId);

}

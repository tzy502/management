package daoI;

import java.util.List;

import model.BeanChecklist;

public interface IChecklistDao {
	public void addChecklist(BeanChecklist Checklist);
	//添加角色
	public BeanChecklist SearchChecklist(int ChecklistId);
	//搜索角色
	public List<BeanChecklist> loadChecklisthistory(int StationId,int type);
	//搜索角色
	public void modifryChecklist(BeanChecklist Checklist);
	//修改角色
	public void DelChecklist(int ChecklistId);
	//删除角色
	public List<BeanChecklist> loadChecklist(int StationId);
	public int totallist(String userId,String start,String end);
}

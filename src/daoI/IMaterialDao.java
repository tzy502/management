package daoI;

import java.util.List;

import model.BeanMaterial;

public interface IMaterialDao {
	public void addMaterial(BeanMaterial Material);
	//添加角色
	public BeanMaterial SearchMaterial(int MaterialId);
	//搜索角色
	public List<BeanMaterial> loadAllMaterial();
	//搜索角色
	public void modifryMaterial(BeanMaterial Material);
	//修改角色
	public void DelMaterial(int MaterialId);
	//删除角色
}

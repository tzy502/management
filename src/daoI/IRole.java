package daoI;

import java.util.List;

import model.BeanRole;

public interface IRole {
	public void addRole(BeanRole Role);
	//添加角色
	public BeanRole SearchRole(int RoleId);
	//搜索角色
	public List<BeanRole> loadRole(int RoleId);
	//搜索角色
	public List<BeanRole> loadAllRole();
	//搜索角色
	public void modifryRole(BeanRole Role);
	//修改角色
	public void DelRole(BeanRole Role);
	//删除角色
}

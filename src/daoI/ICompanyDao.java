package daoI;

import java.util.List;

import model.BeanCompany;

public interface ICompanyDao {
	public void addCompany(BeanCompany Company);
	//添加角色
	public BeanCompany SearchCompany(int CompanyId);
	//搜索角色
	public List<BeanCompany> loadAllCompany();
	//搜索角色
	public void modifryCompany(BeanCompany Company);
	//修改角色
	public void DelCompany(int CompanyId);
	//删除角色
}

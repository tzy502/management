package daoI;

import java.util.List;

import model.BeanStandard;

public interface IStandardDao {
	public void addStandard(BeanStandard Standard);
	//添加角色
	public List<BeanStandard> loadStandard(int StandardId);
	//搜索角色
	public BeanStandard SearchStandard(int StandardId);
	public void modifryStandard(BeanStandard Standard);
	//修改角色
	public void delStandard(BeanStandard Standard);
	public boolean checkStandard(BeanStandard Standard);
}

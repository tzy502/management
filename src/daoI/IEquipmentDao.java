package daoI;

import java.util.List;

import model.BeanEquipment;

public interface IEquipmentDao {
	public void addEquipment(BeanEquipment Equipment);
	//添加角色
	public BeanEquipment SearchEquipment(int EquipmentId);
	//搜索角色
	public List<BeanEquipment> loadAllEquipment(int stationId);
	//搜索角色
	public void modifryEquipment(BeanEquipment Equipment);
	//修改角色
	public void DelEquipment(BeanEquipment Equipment);
	//删除角色
}

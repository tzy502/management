package daoI;

import java.util.List;

import model.BeanInstrument;

public interface IInstrumentDao {
	public void addInstrument(BeanInstrument Instrument);
	//添加角色
	public BeanInstrument SearchInstrument(int InstrumentId);
	//搜索角色
	public List<BeanInstrument> loadAllInstrument();
	//搜索角色
	public void modifryInstrument(BeanInstrument Instrument);
	//修改角色
	public void DelInstrument(int InstrumentId);
	//删除角色
}

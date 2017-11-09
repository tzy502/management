package daoI;

import java.util.List;

import model.BeanData;
import model.BeanStation;
import util.DbException;

public interface IStationDao {
	public void addStation(BeanStation Station);
	//添加角色
	public BeanStation SearchStation(int StationId);
	//搜索角色
	public List<BeanStation> loadAllStation();
	
	public List<BeanStation> loadwaterStation();
	public List<BeanStation> loadgasStation();
	public List<BeanStation> loadnobaseStation();
	public List<String> loadcity();
	public List<BeanStation> loadStation(String area,String city);
	public List<String> loadarea();
	//搜索角色
	public void modifryStation(BeanStation Station);
	//修改角色
	public void DelStation(BeanStation Station);
	//删除角色
	public List<BeanStation> loadbasestation() throws DbException ;
}

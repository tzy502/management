package daoI;

import java.sql.Timestamp;
import java.util.List;

import model.BeanWarning;

public interface IWarningDao {
	public void addWarning(BeanWarning Warning);

	public BeanWarning SearchWarning(int WarningId);

	public List<BeanWarning> loadAllWarning(Timestamp start,Timestamp end);

	public void modifryWarning(BeanWarning Warning);

	public void DelWarning(int WarningId);

	public boolean checkWarning(int stationId,String InfectCode,int type);
}

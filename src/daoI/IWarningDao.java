package daoI;

import java.util.List;

import model.BeanWarning;

public interface IWarningDao {
	public void addWarning(BeanWarning Warning);

	public BeanWarning SearchWarning(int WarningId);

	public List<BeanWarning> loadAllWarning();

	public void modifryWarning(BeanWarning Warning);

	public void DelWarning(int WarningId);

}

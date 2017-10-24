package daoI;

import java.util.List;

import model.BeanCompany;

public interface ICompanyDao {
	public void addCompany(BeanCompany Company);

	public BeanCompany SearchCompany(int CompanyId);

	public List<BeanCompany> loadAllCompany();

	public void modifryCompany(BeanCompany Company);

	public void DelCompany(int CompanyId);

}

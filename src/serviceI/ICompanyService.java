package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanCompany;
import util.BaseException;
@Component
public interface ICompanyService {
	public void addCompany(BeanCompany Company)throws BaseException;
	
	public BeanCompany SearchCompany(int compayid)throws BaseException;
	
	public List<BeanCompany> loadAllCompany()throws BaseException;
	
		
	public void modifryCompany(BeanCompany Company)throws BaseException;
	
	public void DelCompany(int CompanyId)throws BaseException;
}

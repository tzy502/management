package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ICompanyDao;
import model.BeanCompany;
import serviceI.ICompanyService;
import util.BaseException;
@Service
public class CompanyService implements ICompanyService {
	@Resource
	private ICompanyDao cd;
	@Override
	public void addCompany(BeanCompany Company) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Company)){
			cd.addCompany(Company);
		}
		
	}

	@Override
	public BeanCompany SearchCompany(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanCompany bc=cd.SearchCompany(compayid);
		return bc;
	}

	@Override
	public List<BeanCompany> loadAllCompany() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCompany> resutl =cd.loadAllCompany();
		return resutl;
	}

	@Override
	public void modifryCompany(BeanCompany Company) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Company)){
			cd.modifryCompany(Company);
		}
	}

	@Override
	public void DelCompany(int CompanyId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelCompany(CompanyId);
	}
	public boolean check(BeanCompany Company) throws BaseException{
		if(Company.getBoss().isEmpty()){
			throw new BaseException("公司负责人不能为空");
		}
		if(Company.getCompanyaddress().isEmpty()){
			throw new BaseException("公司地址不能为空");
		}
		if(Company.getCompanyname().isEmpty()){
			throw new BaseException("公司名不能为空");
		}
		if(Company.getTEL().isEmpty()){
			throw new BaseException("联系电话不能为空");
		}
		return true;
	}
}

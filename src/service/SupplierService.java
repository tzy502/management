package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ISupplierDao;
import model.BeanSupplier;
import serviceI.ISupplierService;
import util.BaseException;
@Service
public class SupplierService implements ISupplierService {
	@Resource
	private ISupplierDao cd;
	@Override
	public void addSupplier(BeanSupplier Supplier) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Supplier)){
			cd.addSupplier(Supplier);
		}
		
	}

	@Override
	public BeanSupplier SearchSupplier(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanSupplier bc=cd.SearchSupplier(compayid);
		return bc;
	}

	@Override
	public List<BeanSupplier> loadAllSupplier() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanSupplier> resutl =cd.loadAllSupplier();
		return resutl;
	}

	@Override
	public void modifrySupplier(BeanSupplier Supplier) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Supplier)){
			cd.modifrySupplier(Supplier);
		}
	}

	@Override
	public void DelSupplier(int SupplierId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelSupplier(SupplierId);
	}
	public boolean check(BeanSupplier Supplier) throws BaseException{

		return true;
	}
}

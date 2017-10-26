package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.ISupplieritemDao;
import model.BeanSupplieritem;
import serviceI.ISupplieritemService;
import util.BaseException;
@Service
public class SupplieritemService implements ISupplieritemService {
	@Resource
	private ISupplieritemDao cd;
	@Override
	public void addSupplieritem(BeanSupplieritem Supplieritem) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Supplieritem)){
			cd.addSupplieritem(Supplieritem);
		}
		
	}

	@Override
	public BeanSupplieritem SearchSupplieritem(int compayid) throws BaseException {
		// TODO Auto-generated method stub
		BeanSupplieritem bc=cd.SearchSupplieritem(compayid);
		return bc;
	}

	@Override
	public List<BeanSupplieritem> loadAllSupplieritem(int SupplierId) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanSupplieritem> resutl =cd.loadAllSupplieritem(SupplierId);
		return resutl;
	}

	@Override
	public void modifrySupplieritem(BeanSupplieritem Supplieritem) throws BaseException {
		// TODO Auto-generated method stub
		if(check(Supplieritem)){
			cd.modifrySupplieritem(Supplieritem);
		}
	}

	@Override
	public void DelSupplieritem(int SupplieritemId) throws BaseException {
		// TODO Auto-generated method stub
		cd.DelSupplieritem(SupplieritemId);
	}
	public boolean check(BeanSupplieritem Supplieritem) throws BaseException{

		return true;
	}
}

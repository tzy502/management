package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSupplieritem;
import util.BaseException;
@Component
public interface ISupplieritemService {
	public void addSupplieritem(BeanSupplieritem Supplieritem)throws BaseException;
	
	public BeanSupplieritem SearchSupplieritem(int SupplieritemId)throws BaseException;
	
	public List<BeanSupplieritem> loadAllSupplieritem(int supplierid)throws BaseException;
	
		
	public void modifrySupplieritem(BeanSupplieritem Supplieritem)throws BaseException;
	
	public void DelSupplieritem(int SupplieritemId)throws BaseException;
	public boolean check(BeanSupplieritem Supplieritem) throws BaseException;
}

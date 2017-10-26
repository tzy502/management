package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSupplier;
import util.BaseException;
@Component
public interface ISupplierService {
	public void addSupplier(BeanSupplier Supplier)throws BaseException;
	
	public BeanSupplier SearchSupplier(int supplierid)throws BaseException;
	
	public List<BeanSupplier> loadAllSupplier()throws BaseException;
	
		
	public void modifrySupplier(BeanSupplier Supplier)throws BaseException;
	
	public void DelSupplier(int SupplierId)throws BaseException;
	public boolean check(BeanSupplier Supplier) throws BaseException;
}

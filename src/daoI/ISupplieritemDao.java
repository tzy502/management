package daoI;

import java.util.List;

import model.BeanSupplieritem;

public interface ISupplieritemDao {
	public void addSupplieritem(BeanSupplieritem Supplieritem);

	public BeanSupplieritem SearchSupplieritem(int SupplieritemId);

	public List<BeanSupplieritem> loadAllSupplieritem(int SupplierId);

	public void modifrySupplieritem(BeanSupplieritem Supplieritem);

	public void DelSupplieritem(int SupplieritemId);

}

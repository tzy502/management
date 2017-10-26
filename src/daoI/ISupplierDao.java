package daoI;

import java.util.List;

import model.BeanSupplier;

public interface ISupplierDao {
	public void addSupplier(BeanSupplier Supplier);

	public BeanSupplier SearchSupplier(int SupplierId);

	public List<BeanSupplier> loadAllSupplier();

	public void modifrySupplier(BeanSupplier Supplier);

	public void DelSupplier(int SupplierId);

}

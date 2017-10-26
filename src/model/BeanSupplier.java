package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class BeanSupplier {
	private int supplierId;
	private String suppliername;
	private String supplierTEL;
	private String supplieraddress;
	private String supplieruser;
	@Id
	@Column(name = "supplierId")
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	@Column(name = "suppliername")
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	@Column(name = "supplierTEL")
	public String getSupplierTEL() {
		return supplierTEL;
	}
	public void setSupplierTEL(String supplierTEL) {
		this.supplierTEL = supplierTEL;
	}
	@Column(name = "supplieraddress")
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	@Column(name = "supplieruser")
	public String getSupplieruser() {
		return supplieruser;
	}
	public void setSupplieruser(String supplieruser) {
		this.supplieruser = supplieruser;
	}
	
	
}

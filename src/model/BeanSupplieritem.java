package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "supplieritem")
public class BeanSupplieritem {
	private int supplieritemId;
	private int supplierId;
	private String supplieritemname;
	private double supplieritemprice;
	private Timestamp supplieritemtime;
	private String supplieritemtassess;
	@Id
	@Column(name = "supplieritemId")
	public int getSupplieritemId() {
		return supplieritemId;
	}
	public void setSupplieritemId(int supplieritemId) {
		this.supplieritemId = supplieritemId;
	}
	@Column(name = "supplieritemname")
	public String getSupplieritemname() {
		return supplieritemname;
	}
	public void setSupplieritemname(String supplieritemname) {
		this.supplieritemname = supplieritemname;
	}
	@Column(name = "supplieritemprice")
	public double getSupplieritemprice() {
		return supplieritemprice;
	}
	public void setSupplieritemprice(double supplieritemprice) {
		this.supplieritemprice = supplieritemprice;
	}
	@Column(name = "supplieritemtime")
	public Timestamp getSupplieritemtime() {
		return supplieritemtime;
	}
	public void setSupplieritemtime(Timestamp supplieritemtime) {
		this.supplieritemtime = supplieritemtime;
	}
	@Column(name = "supplieritemtassess")
	public String getSupplieritemtassess() {
		return supplieritemtassess;
	}
	public void setSupplieritemtassess(String supplieritemtassess) {
		this.supplieritemtassess = supplieritemtassess;
	}
	@Column(name = "supplierId")
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	
}

package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class BeanCar {
	private String carId;
	private String cartype;
	private int price;
	private Timestamp carbuytime;
	private Timestamp carinsurancetime;//保险过期时间
	private int displacement;//排气量
	@Id
	@Column(name = "carId")	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	@Column(name = "cartype")	
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	@Column(name = "price")	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Column(name = "carbuytime")	
	public Timestamp getCarbuytime() {
		return carbuytime;
	}
	public void setCarbuytime(Timestamp carbuytime) {
		this.carbuytime = carbuytime;
	}
	@Column(name = "carinsurancetime")	
	public Timestamp getCarinsurancetime() {
		return carinsurancetime;
	}
	public void setCarinsurancetime(Timestamp carinsurancetime) {
		this.carinsurancetime = carinsurancetime;
	}
	@Column(name = "displacement")	
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
}

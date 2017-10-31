package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrepair")
public class BeanCarrepair {
	private int carrepairId;
	private Timestamp carrepairtime;
	private String carrepairreason;
	private float carrepairnumber;//维修花费
	private String carId;

	@Id
	@Column(name = "carrepairId")
	public int getCarrepairId() {
		return carrepairId;
	}
	public void setCarrepairId(int carrepairId) {
		this.carrepairId = carrepairId;
	}
	@Column(name = "carrepairtime")
	public Timestamp getCarrepairtime() {
		return carrepairtime;
	}
	public void setCarrepairtime(Timestamp carrepairtime) {
		this.carrepairtime = carrepairtime;
	}
	@Column(name = "carrepairreason")
	public String getCarrepairreason() {
		return carrepairreason;
	}
	public void setCarrepairreason(String carrepairreason) {
		this.carrepairreason = carrepairreason;
	}
	@Column(name = "carrepairnumber")
	public float getCarrepairnumber() {
		return carrepairnumber;
	}
	public void setCarrepairnumber(float carrepairnumber) {
		this.carrepairnumber = carrepairnumber;
	}
	@Column(name = "carId")
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class BeanEquipment {
	private int equipmentid;
	private int stationId;
	private String model;//型号
	private String	grade;//编号
	private String	number;//标号
	private String	effect;//作用
	
	@Id
	@Column(name = "equipmentid")	
	public int getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(int equipment) {
		this.equipmentid = equipment;
	}
	
	@Column(name = "stationId")	
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Column(name = "model")	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "grade")	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Column(name = "number")	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name = "effect")	
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	
}

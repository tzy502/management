package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "infect")
public class BeanInfect {
	private String InfectName;
	private String InfectCode;
	private int StationType;
	
	@Column(name = "InfectName")	
	public String getInfectName() {
		return InfectName;
	}
	public void setInfectName(String infectName) {
		InfectName = infectName;
	}
	@Id
	@Column(name = "InfectCode")	
	public String getInfectCode() {
		return InfectCode;
	}
	public void setInfectCode(String infectCode) {
		InfectCode = infectCode;
	}
	@Column(name = "StationType")	
	public int getStationType() {
		return StationType;
	}
	public void setStationType(int stationType) {
		StationType = stationType;
	}

}

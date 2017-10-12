package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "warning")
public class BeanWarning {
	int warningId;
	int stationId;
	String InfectCode;
	int type;
	Timestamp warningtime;
	@Id
	@Column(name = "warningId")
	public int getWarningId() {
		return warningId;
	}
	public void setWarningId(int warningId) {
		this.warningId = warningId;
	}
	@Column(name = "stationId")
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Column(name = "InfectCode")
	public String getInfectCode() {
		return InfectCode;
	}
	public void setInfectCode(String infectCode) {
		InfectCode = infectCode;
	}
	@Column(name = "type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name = "warningtime")
	public Timestamp getWarningtime() {
		return warningtime;
	}
	public void setWarningtime(Timestamp warningtime) {
		this.warningtime = warningtime;
	}
	
}

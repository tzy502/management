package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "instrument")
public class BeanInstrument {
	private int instrumentId;
	private String  instrumentname;
	private Timestamp buytime ;
	private Timestamp firstusetime; 
	private Timestamp lastusetime ;
	private Timestamp calibrationtime; 
	private int status;
	private int calibrationcycle;
	@Id
	@Column(name = "instrumentId")	
	public int getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}
	@Column(name = "instrumentname")	
	public String getInstrumentname() {
		return instrumentname;
	}
	public void setInstrumentname(String instrumentname) {
		this.instrumentname = instrumentname;
	}
	@Column(name = "buytime")
	public Timestamp getBuytime() {
		return buytime;
	}
	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}
	@Column(name = "firstusetime")
	public Timestamp getFirstusetime() {
		return firstusetime;
	}
	public void setFirstusetime(Timestamp firstusetime) {
		this.firstusetime = firstusetime;
	}
	@Column(name = "lastusetime")
	public Timestamp getLastusetime() {
		return lastusetime;
	}
	public void setLastusetime(Timestamp lastusetime) {
		this.lastusetime = lastusetime;
	}
	@Column(name = "calibrationtime")
	public Timestamp getCalibrationtime() {
		return calibrationtime;
	}
	public void setCalibrationtime(Timestamp calibrationtime) {
		this.calibrationtime = calibrationtime;
	}
	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "calibrationcycle")
	public int getCalibrationcycle() {
		return calibrationcycle;
	}
	public void setCalibrationcycle(int calibrationcycle) {
		this.calibrationcycle = calibrationcycle;
	} 

}

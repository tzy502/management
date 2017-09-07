package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "standard")
public class BeanStandard {
	private int standardid;
	private int stationid;
	private String infectid;
	private int vaule;
	
	@Id
	@Column(name = "standardid")
	public int getStandardid() {
		return standardid;
	}
	public void setStandardid(int standardid) {
		this.standardid = standardid;
	}
	@Column(name = "stationid")
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	@Column(name = "infectid")
	public String getInfectid() {
		return infectid;
	}
	public void setInfectid(String infectid) {
		this.infectid = infectid;
	}
	@Column(name = "vaule")
	public int getVaule() {
		return vaule;
	}
	public void setVaule(int vaule) {
		this.vaule = vaule;
	}
	
}

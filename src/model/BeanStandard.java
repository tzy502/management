package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "standard")
public class BeanStandard {
	private int standardid;
	private int stationId;
	private String infectid;
	private float minvaule;
	private float maxvaule;
	private float maxalarm;
	private float minalarm;
	@Id
	@Column(name = "standardid")
	public int getStandardid() {
		return standardid;
	}
	public void setStandardid(int standardid) {
		this.standardid = standardid;
	}
	@Column(name = "stationId")
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Column(name = "infectid")
	public String getInfectid() {
		return infectid;
	}
	public void setInfectid(String infectid) {
		this.infectid = infectid;
	}
	@Column(name = "minvaule")
	public float getMinvaule() {
		return minvaule;
	}
	public void setMinvaule(float minxvaule) {
		this.minvaule = minxvaule;
	}
	@Column(name = "maxvaule")
	public float getMaxvaule() {
		return maxvaule;
	}
	public void setMaxvaule(float maxvaule) {
		this.maxvaule = maxvaule;
	}
	@Column(name = "maxalarm")
	public float getMaxalarm() {
		return maxalarm;
	}
	public void setMaxalarm(float maxalarm) {
		this.maxalarm = maxalarm;
	}
	@Column(name = "minalarm")
	public float getMinalarm() {
		return minalarm;
	}
	public void setMinalarm(float minalarm) {
		this.minalarm = minalarm;
	}
	

	
}

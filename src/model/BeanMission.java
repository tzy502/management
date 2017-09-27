package model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "mission")
public class BeanMission {
	private int missionid;
	private String userid;
	private int stationid;
	private Timestamp date;
	private String status;
	private String description;
	@Id
	@Column(name = "missionid")
	public int getMissionid() {
		return missionid;
	}
	public void setMissionid(int missionid) {
		this.missionid = missionid;
	}
	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name = "stationid")
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	@Column(name = "date")
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

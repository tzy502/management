package model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "mission")
public class BeanMission {
	private int Missionid;
	private String userid;
	private int stationid;
	private Timestamp date;
	private int status;
	private String description;
	final  int UnViewed=1;
	final  int Viewed=2;
	final  int Solved=3;
	@Id
	@Column(name = "missionid")
	public int getMissionid() {
		return Missionid;
	}
	public void setMissionid(int missionid) {
		this.Missionid = missionid;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUnViewed() {
		return UnViewed;
	}
	public int getViewed() {
		return Viewed;
	}
	public int getSolved() {
		return Solved;
	}
	
}

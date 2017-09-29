package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "mission")
public class BeanMission {
	private int missionid;
	private String userid;
	private int stationid;
	private Timestamp startdate;
	private Timestamp enddate;
	private int status;
	private String description;
	private String missionname;
	@Id
	@Column(name = "missionid")
	public int getMissionid() {
		return missionid;
	}
	public  void setMissionid(int missionid) {
		this.missionid = missionid;
	}
	
	@Column(name = "missionname")
	public String getMissionname() {
		return missionname;
	}
	public void setMissionname(String missionname) {
		this.missionname = missionname;
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
	
	
	@Column(name = "startdate")	
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	
	
	@Column(name = "enddate")
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
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
	

	
}

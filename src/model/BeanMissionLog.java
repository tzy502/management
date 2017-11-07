package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "missionlog")
public class BeanMissionLog {
	private int missionlogId;
	private int missionId;
	private String missionlogdetail;
	private Timestamp missionlogtime;
	private String user;
	@Id
	@Column(name = "missionlogId")	
	public int getMissionlogId() {
		return missionlogId;
	}
	public void setMissionlogId(int missionlogId) {
		this.missionlogId = missionlogId;
	}
	@Column(name = "missionlogdetail")
	public String getMissionlogdetail() {
		return missionlogdetail;
	}
	public void setMissionlogdetail(String missionlogdetail) {
		this.missionlogdetail = missionlogdetail;
	}
	@Column(name = "missionlogtime")
	public Timestamp getMissionlogtime() {
		return missionlogtime;
	}
	public void setMissionlogtime(Timestamp missionlogtime) {
		this.missionlogtime = missionlogtime;
	}
	@Column(name = "user")
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Column(name = "missionId")
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	
}

package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;
@Entity
@Table(name = "checklist")
public class BeanChecklist {
	private int checklistId;
	private Timestamp checklisttime;
	private int checklisttype;
	private String checklistcheckbox;
	private String checklistinput;
	private int stationId;
	private String userId;
	@Id
	@Column(name = "checklistId")	
	public int getChecklistId() {
		return checklistId;
	}
	public void setChecklistId(int checklistId) {
		this.checklistId = checklistId;
	}
	@Column(name = "checklisttime")	
	public Timestamp getChecklisttime() {
		return checklisttime;
	}
	public void setChecklisttime(Timestamp checklisttime) {
		this.checklisttime = checklisttime;
	}
	@Column(name = "checklisttype")	
	public int getChecklisttype() {
		return checklisttype;
	}
	public void setChecklisttype(int checklisttype) {
		this.checklisttype = checklisttype;
	}

	@Column(name = "stationId")	
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Column(name = "userId")	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name = "checklistcheckbox")
	public String getChecklistcheckbox() {
		return checklistcheckbox;
	}
	public void setChecklistcheckbox(String checklistcheckbox) {
		this.checklistcheckbox = checklistcheckbox;
	}
	@Column(name = "checklistinput")
	public String getChecklistinput() {
		return checklistinput;
	}
	public void setChecklistinput(String checklistinput) {
		this.checklistinput = checklistinput;
	}
	
}

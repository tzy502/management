package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "timer")
public class BeanTimer {
	private int timeId;
	private int stationId;
	private int timer;
	private String timername;
	private String timerdescription;
	private Timestamp starttime;
	@Id
	@Column(name = "timeId")
	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	@Column(name = "stationId")
	public int getStationId() {
		return stationId;
	}
	
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	@Column(name = "timer")
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	@Column(name = "timername")
	public String getTimername() {
		return timername;
	}	
	public void setTimername(String timername) {
		this.timername = timername;
	}
	@Column(name = "timerdescription")
	public String getTimerdescription() {
		return timerdescription;
	}
	public void setTimerdescription(String timerdescription) {
		this.timerdescription = timerdescription;
	}
	@Column(name = "starttime")
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	
	
}

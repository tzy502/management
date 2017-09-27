package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "time")
public class BeanTime {
	private int timeId;
	private int stationId;
	private int timer;
	final static int DAY=1;
	final static int WEEKDAY=2;
	final static int MONTH=3;
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
	
}

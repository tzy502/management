package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caruse")
public class BeanCaruse {
	private int caruseId;
	private String caruseuser;
	private Timestamp begintime;
	private Timestamp endtime;
	private String begin;
	private String end;
	private String remark;
	private String carId;
	@Id
	@Column(name = "caruseId")
	public int getCaruseId() {
		return caruseId;
	}
	public void setCaruseId(int caruseId) {
		this.caruseId = caruseId;
	}
	@Column(name = "caruseuser")
	public String getCaruseuser() {
		return caruseuser;
	}
	public void setCaruseuser(String caruseuser) {
		this.caruseuser = caruseuser;
	}
	@Column(name = "begintime")
	public Timestamp getBegintime() {
		return begintime;
	}
	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}
	@Column(name = "endtime")
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	@Column(name = "begin")
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	@Column(name = "end")
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "carId")
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
}

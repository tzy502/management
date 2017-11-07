package model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "station")
public class BeanStation{
	public int stationId;//id
	public String stationname;//站点名称
	public int type;//类型
	public String city;//所在城市
	public String area;//所在区
	public String status;//站点现状
	public String address;//详细地址
	public String remarks; //备注
	public String principal;//负责任ID
	public String MN;
	public String IP;
	public int base;
	@Id
	@Column(name = "stationId")
	public int getStationid() {
		return stationId;
	}
	public void setStationid(int stationid) {
		this.stationId = stationid;
	}
	
	@Column(name = "stationname")
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	
	
	@Column(name = "type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "area")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column(name = "principal")
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	@Column(name = "MN")
	public String getMN() {
		return MN;
	}
	public void setMN(String mN) {
		MN = mN;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "IP")
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}

	@Column(name = "base")
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	
}

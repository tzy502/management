package model;

import java.sql.Timestamp;

public class BeanWater {
	private int stationId;
	private String stationname;
	private Timestamp time;//时间
	private String MN;
	private float w011;
	private float w001;
	private float wB01;
	private float w060;
	private float w065;
	private float w42;
	
	public float getW011() {
		return w011;
	}
	public void setW011(float w011) {
		this.w011 = w011;
	}
	public float getW001() {
		return w001;
	}
	public void setW001(float w001) {
		this.w001 = w001;
	}
	public float getwB01() {
		return wB01;
	}
	public void setwB01(float wB01) {
		this.wB01 = wB01;
	}
	public float getW060() {
		return w060;
	}
	public void setW060(float w060) {
		this.w060 = w060;
	}
	public float getW065() {
		return w065;
	}
	public void setW065(float w065) {
		this.w065 = w065;
	}
	public float getW42() {
		return w42;
	}
	public void setW42(float w42) {
		this.w42 = w42;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getMN() {
		return MN;
	}
	public void setMN(String mN) {
		MN = mN;
	}
	
}

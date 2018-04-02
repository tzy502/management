package model;

import java.sql.Timestamp;

public class BeanGas {
	private int stationId;
	private String stationname;
	private Timestamp time;//时间
	private float g02;//实测SO2
	private float g01;//实测烟尘
	private float g03;//实测NOx
	private float g01Zs;//折算烟尘
	private float g02Zs;//折算SO2
	private float g03Zs;//折算NOx
	private float gS01;//氧气含量
	private float gS02;//烟气流速
	private float gS03;//烟气温度
	private float gS08;//烟气压力
	private float gB02;//标匡流量
	private float Sg05;//烟气湿度
	private String MN;//烟气湿度
	public BeanGas(){
		float g02=-1;//实测SO2
		float g01=-2;//实测烟尘
		float g03=-1;//实测NOx
		float g01Zs=-1;//折算烟尘
		float g02Zs=-1;//折算SO2
		float g03Zs=-1;//折算NOx
		float gS01=-1;//氧气含量
		float gS02=-1;//烟气流速
		float gS03=-1;//烟气温度
		float gS08=-1;//烟气压力
		float gB02=-1;//标匡流量
		float Sg05=-1;
	}
	
	public String getStationname() {
		return stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public float getG02() {
		return g02;
	}
	public void setG02(float g02) {
		this.g02 = g02;
	}
	public float getG01() {
		return g01;
	}
	public void setG01(float g01) {
		this.g01 = g01;
	}
	public float getG03() {
		return g03;
	}
	public void setG03(float g03) {
		this.g03 = g03;
	}
	public float getG01Zs() {
		return g01Zs;
	}
	public void setG01Zs(float g01Zs) {
		this.g01Zs = g01Zs;
	}
	public float getG02Zs() {
		return g02Zs;
	}
	public void setG02Zs(float g02Zs) {
		this.g02Zs = g02Zs;
	}
	public float getG03Zs() {
		return g03Zs;
	}
	public void setG03Zs(float g03Zs) {
		this.g03Zs = g03Zs;
	}
	public float getgS01() {
		return gS01;
	}
	public void setgS01(float gS01) {
		this.gS01 = gS01;
	}
	public float getgS02() {
		return gS02;
	}
	public void setgS02(float gS02) {
		this.gS02 = gS02;
	}
	public float getgS03() {
		return gS03;
	}
	public void setgS03(float gS03) {
		this.gS03 = gS03;
	}
	public float getgS08() {
		return gS08;
	}
	public void setgS08(float gS08) {
		this.gS08 = gS08;
	}
	public float getgB02() {
		return gB02;
	}
	public void setgB02(float gB02) {
		this.gB02 = gB02;
	}
	public float getSg05() {
		return Sg05;
	}
	public void setSg05(float sg05) {
		Sg05 = sg05;
	}

	public String getMN() {
		return MN;
	}

	public void setMN(String mN) {
		MN = mN;
	}

}

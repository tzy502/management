package model;

import java.sql.Timestamp;

public class BeanData {
	private Timestamp mTime;
	private String InfectCode;
	private float InfectValue;
	public Timestamp getmTime() {
		return mTime;
	}
	public void setmTime(Timestamp mTime) {
		this.mTime = mTime;
	}
	public String getInfectCode() {
		return InfectCode;
	}
	public void setInfectCode(String infectCode) {
		InfectCode = infectCode;
	}
	public float getInfectValue() {
		return InfectValue;
	}
	public void setInfectValue(float infectValue) {
		InfectValue = infectValue;
	}
	
}

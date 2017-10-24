package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainlog")
public class BeanTrainlog {
	private int trainlogId;	
	private int trainId;
	private String traindetail;
	@Id
	@Column(name = "trainlogId")
	public int getTrainlogId() {
		return trainlogId;
	}
	public void setTrainlogId(int trainlogId) {
		this.trainlogId = trainlogId;
	}
	@Column(name = "trainId")
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	@Column(name = "traindetail")
	public String getTraindetail() {
		return traindetail;
	}
	public void setTraindetail(String traindetail) {
		this.traindetail = traindetail;
	}
	
}

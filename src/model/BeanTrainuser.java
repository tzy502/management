package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainuser")
public class BeanTrainuser {
	private int trainuserId;	
	private int trainId;
	private String userId;
	@Id
	@Column(name = "trainuserId")
	public int getTrainuserId() {
		return trainuserId;
	}
	public void setTrainuserId(int trainuserId) {
		this.trainuserId = trainuserId;
	}
	@Column(name = "trainId")
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiallog")
public class BeanMaterialLog {
	private int materiallogId;
	private int materialId;
	private String userId;
	private int num;
	private Timestamp date;
	@Id
	@Column(name = "materiallogId")
	public int getMateriallogId() {
		return materiallogId;
	}
	public void setMateriallogId(int materiallogId) {
		this.materiallogId = materiallogId;
	}
	@Column(name = "materialId")
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name = "num")
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Column(name = "date")
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}

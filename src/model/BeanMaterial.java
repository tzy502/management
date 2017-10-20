package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class BeanMaterial {
	int materialId;
	String materialname;
	String materialuse;//介绍
	int materialover;//余额
	@Id
	@Column(name = "materialId")	
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	@Column(name = "materialname")
	public String getMaterialname() {
		return materialname;
	}
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	@Column(name = "materialuse")
	public String getMaterialuse() {
		return materialuse;
	}
	public void setMaterialuse(String materialuse) {
		this.materialuse = materialuse;
	}
	@Column(name = "materialover")
	public int getMaterialover() {
		return materialover;
	}
	public void setMaterialover(int materialover) {
		this.materialover = materialover;
	}
	
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class BeanRole {
	private int roleId;
	private int level;
	private String roleName;
	private String roleIntroduction;
	@Id
	@Column(name = "roleId")
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Column(name = "roleName")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name = "roleIntroduction")
	public String getRoleIntroduction() {
		return roleIntroduction;
	}
	public void setRoleIntroduction(String roleIntroduction) {
		this.roleIntroduction = roleIntroduction;
	}
	@Column(name = "level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	

	
}

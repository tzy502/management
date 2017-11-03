package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class BeanPeople {
	private int peopleId;
	private String department;
	private String post;
	private String name;
	private int gender;//男1 女0
	private Timestamp entrytime;
	private String education;
	private String profession;
	private Timestamp graduationtime;
	private String graduationschool;
	private String job;
	private String IDcard;
	@Id
	@Column(name = "peopleId")	
	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}
	@Column(name = "department")	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(name = "post")	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Column(name = "name")	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "gender")	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Column(name = "entrytime")	
	public Timestamp getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(Timestamp entrytime) {
		this.entrytime = entrytime;
	}
	@Column(name = "education")	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	@Column(name = "profession")	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Column(name = "graduationtime")	
	public Timestamp getGraduationtime() {
		return graduationtime;
	}
	public void setGraduationtime(Timestamp graduationtime) {
		this.graduationtime = graduationtime;
	}
	@Column(name = "graduationschool")	
	public String getGraduationschool() {
		return graduationschool;
	}
	public void setGraduationschool(String graduationschool) {
		this.graduationschool = graduationschool;
	}
	@Column(name = "job")	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Column(name = "IDcard")	
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}
	
}

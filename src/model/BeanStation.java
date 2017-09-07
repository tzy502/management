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
	public int companyid;//所属公司ID
	public String type;//类型
	public String city;//所在城市
	public String area;//所在区
	public String areaid;//行政区代码
	public String codeA;//站位编码A
	public String codeB;//站位编码B
	public String level;//控制级别
	public String industry;//行业
	public String togo;//排放去向
	public String pollution;//纳污区域
	public String model;//排放模式
	public String unit;//运维单位
	public String status;//站点现状
	public String regulatoryauthorities;//监管部门
	public int longitude;//经度
	public int latitude;//纬度
	public String address;//详细地址
	public String ability;//设计处理能力
	public String acceptance;//验收验收时间
	public String assessment;//是否监督考核
	public String remarks; //备注
	public String principal;//负责任ID
	public String MN;
	
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
	
	@Column(name = "companyid")
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
	
	@Column(name = "areaid")
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	
	@Column(name = "codeA")
	public String getCodeA() {
		return codeA;
	}
	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}
	
	@Column(name = "codeB")
	public String getCodeB() {
		return codeB;
	}
	public void setCodeB(String codeB) {
		this.codeB = codeB;
	}
	
	@Column(name = "level")
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column(name = "industry")
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Column(name = "togo")
	public String getTogo() {
		return togo;
	}
	public void setTogo(String togo) {
		this.togo = togo;
	}
	
	@Column(name = "pollution")
	public String getPollution() {
		return pollution;
	}
	public void setPollution(String pollution) {
		this.pollution = pollution;
	}
	
	@Column(name = "model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "regulatoryauthorities")
	public String getRegulatoryauthorities() {
		return regulatoryauthorities;
	}
	public void setRegulatoryauthorities(String regulatoryauthorities) {
		this.regulatoryauthorities = regulatoryauthorities;
	}
	
	@Column(name = "longitude")
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	@Column(name = "latitude")
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "ability")
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	
	@Column(name = "acceptance")
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	
	@Column(name = "assessment")
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
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
	
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class BeanDocument {
	private int documentid;
	private String documentname;
	private String path;
	private int level;
	@Id
	@Column(name = "documentid")
	public int getDocumentid() {
		return documentid;
	}
	public void setDocumentid(int documentid) {
		this.documentid = documentid;
	}

	@Column(name = "documentname")
	public String getDocumentname() {
		return documentname;
	}
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	@Column(name = "path")
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "level")
	public int getlevel() {
		return level;
	}
	public void setlevel(int level) {
		this.level = level;
	}

}

package model;

import dao.ChecklistDao;
import dao.MissionDao;

public class BeanAssess {
	MissionDao md=new MissionDao();
	ChecklistDao cd=new ChecklistDao();
	String userId;
	int finish;//未超时完成
	int unfinish;//未超时未完成
	int overfinish;//超时完成
	int overunfiish;//超时未完成
	int total;
	int checklist;
	String str;
	public BeanAssess(String userId,String start,String end){
		this.userId=userId;
		this.finish=md.finishMission(userId,start,end);
		this.unfinish=md.unfinishMission(userId,start,end);
		this.overfinish=md.overfinishMission(userId,start,end);
		this.overunfiish=md.overunfinishMission(userId,start,end);
		this.total=finish+unfinish+overfinish+overunfiish;
		this.checklist=cd.totallist(userId, start, end);
		int n=9;
		start=start.substring(0,start.length()-n);
		end=end.substring(0,end.length()-n);
		this.str="从"+start+"到"+end;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getChecklist() {
		return checklist;
	}

	public void setChecklist(int checklist) {
		this.checklist = checklist;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	public int getUnfinish() {
		return unfinish;
	}
	public void setUnfinish(int unfinish) {
		this.unfinish = unfinish;
	}
	public int getOverfinish() {
		return overfinish;
	}
	public void setOverfinish(int overfinish) {
		this.overfinish = overfinish;
	}
	public int getOverunfiish() {
		return overunfiish;
	}
	public void setOverunfiish(int overunfiish) {
		this.overunfiish = overunfiish;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}

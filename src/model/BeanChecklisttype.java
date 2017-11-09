package model;

import java.util.HashMap;
import java.util.Map;

public class BeanChecklisttype {
	Map<Integer,String> map=new HashMap<Integer,String>(9);
	public BeanChecklisttype(){
		map.put(1, "废水污染源在线监测设备日常巡检记录表");
		map.put(2, "刷卡排污总量控制系统维护记录");
		map.put(3, "刷卡排污总量控制系统维护记录");
		map.put(4, "刷卡污染源在线监测系统维修记录表");
		map.put(5, "烟气污染源在线监测设备日常巡检记录表");
		map.put(6, "烟气污染源在线监测设备校准校验记录表");
		map.put(7, "在线监测系统实样比对校核记录表（废水）");
		map.put(8, "在线监测系统实样比对校核记录表（废气）");
		map.put(9, "设备问题追踪单");
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	
}

package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanMissionLog;
import serviceI.IMissionLogService;
import util.BaseException;

@Controller
public class MissionLogController {
	@Autowired
	private IMissionLogService iss;
	@RequestMapping(value = "/addmissionlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addmissionlog(BeanMissionLog bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			String missionlogdetail=new String(bm.getMissionlogdetail().getBytes("ISO-8859-1"),"UTF-8");
			String user=new String(bm.getUser().getBytes("ISO-8859-1"),"UTF-8");
			String time=request.getParameter("time");
			bm.setMissionlogdetail(missionlogdetail);
			bm.setUser(user);
			bm.setMissionlogtime(Timestamp.valueOf(time));
			iss.addMissionLog(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrymissionlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrymissionlog(BeanMissionLog bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			String missionlogdetail=new String(bm.getMissionlogdetail().getBytes("ISO-8859-1"),"UTF-8");
			String user=new String(bm.getUser().getBytes("ISO-8859-1"),"UTF-8");
			String time=request.getParameter("time");
			bm.setMissionlogdetail(missionlogdetail);
			bm.setUser(user);
			bm.setMissionlogtime(Timestamp.valueOf(time));
			iss.modifryMissionLog(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delmissionlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delmissionlog(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("missionlogId"));
			iss.DelMissionLog(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllmissionlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllmissionlog(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		int id=Integer.valueOf(js.getString("missionId"));
		JSONArray json = new JSONArray();
		List<BeanMissionLog> result =new ArrayList<BeanMissionLog>();
		try {
			result=iss.loadAllMissionLog(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("missionlogId", result.get(i).getMissionlogId());
				String detail;
				if(result.get(i).getMissionlogdetail().length()>20){
					 detail=result.get(i).getMissionlogdetail().substring(0,20);
					 detail+="...";
				}
				else{
					 detail=result.get(i).getMissionlogdetail();
				}
				
				
				jo.put("missionlogdetail", detail);
				jo.put("missionlogtime", result.get(i).getMissionlogtime());
				jo.put("user", result.get(i).getUser());		
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json.toString());
		
		return json.toString();
	}
	@RequestMapping(value = "/searchmissionlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchmissionlog(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionlogId"));
		BeanMissionLog result=new BeanMissionLog();
		JSONObject jo = new JSONObject();
		try {
			result=iss.SearchMissionLog(id);	
			jo.put("missionlogId", result.getMissionlogId());
			jo.put("missionlogdetail", result.getMissionlogdetail());
			jo.put("missionlogtime", result.getMissionlogtime());
			jo.put("user", result.getUser());		
			jo.put("missionId", result.getMissionId());	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

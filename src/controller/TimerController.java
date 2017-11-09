package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanMission;
import model.BeanStation;
import model.BeanTimer;
import serviceI.IStationService;
import serviceI.ITimerService;
import serviceI.IUserService;
import util.BaseException;

@Controller
public class TimerController {
	@Autowired
	private IStationService iss;
	@Autowired
	private IUserService ius;
	@Autowired
	private ITimerService its;
	static Map<Integer,String> timer=new HashMap<Integer,String>(5);
	static {
		timer.put(1, "每日");
		timer.put(2, "每周");
		timer.put(3, "每月");
		
		}
	@RequestMapping(value = "/addtimer.do", produces = "application/json; charset=utf-8") 	
	public String addtimer(BeanTimer bt,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
	
		try {
			String timername=new String(bt.getTimername().getBytes("ISO-8859-1"),"UTF-8"); 
			String timerdescription=new String(bt.getTimerdescription().getBytes("ISO-8859-1"),"UTF-8"); 
			bt.setTimerdescription(timerdescription);
			bt.setTimername(timername);
			bt.setStarttime(Timestamp.valueOf(request.getParameter("start")));
			
			its.addTimer(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifrytimer.do", produces = "application/json; charset=utf-8") 	
	public String modifrytimer(BeanTimer bt,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			String timername=new String(bt.getTimername().getBytes("ISO-8859-1"),"UTF-8"); 
			String timerdescription=new String(bt.getTimerdescription().getBytes("ISO-8859-1"),"UTF-8"); 
			bt.setTimerdescription(timerdescription);
			bt.setTimername(timername);
			bt.setStarttime(Timestamp.valueOf(request.getParameter("start")));
			its.modifryTimer(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/deltimer.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("timerId"));
		try {
			its.DelTimer(id);
			} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/searchtimer.do", produces = "application/json; charset=utf-8") 	
	@ResponseBody
	public String searchtimer(@RequestBody String params) throws JSONException
	{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("timerId"));
		JSONArray jsonarraylist = new JSONArray();
		BeanTimer result =new BeanTimer();
		JSONObject jo = new JSONObject();
		try {
			result=its.SearchTimer(id);
		
			jo.put("timeId",result.getTimeId());
			jo.put("stationId", result.getStationId());
			jo.put("stationname", iss.SearchStation(result.getStationId()).getStationname());
			jo.put("timername", timer.get(result.getTimer()));
			jo.put("timer", result.getTimer());
			jo.put("timename", result.getTimername());
			jo.put("timerdescription", result.getTimerdescription());
			jo.put("starttime", result.getStarttime());	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
	@RequestMapping(value = "/loadUsertimer.do", produces = "application/json; charset=utf-8") 	
	@ResponseBody
	public String loadUsertimer(@RequestBody String params) throws JSONException
	{
		JSONObject json = new JSONObject(params);
		String id=json.getString("userId");
		JSONArray jsonarraylist = new JSONArray();
		List<BeanTimer> result =new ArrayList<BeanTimer>();
		try {
			result=its.loaduserTimer(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("timeId",result.get(i).getTimeId());
				jo.put("stationId", result.get(i).getStationId());
				jo.put("timername", timer.get(result.get(i).getTimer()));
				jo.put("timer", result.get(i).getTimer());
				jo.put("timename", result.get(i).getTimername());
				jo.put("timerdescription", result.get(i).getTimerdescription());
				jsonarraylist.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarraylist.toString();
	}
	@RequestMapping(value = "/loadtimer.do", produces = "application/json; charset=utf-8") 	
	@ResponseBody
	public String loadtimer(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		String city=js.getString("city");
		String area=js.getString("area");
		if(city.equals("all")){
			city=null;
		}
		if(area.equals("all")){
			area=null;
		}
		List<BeanTimer> result =new ArrayList<BeanTimer>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		JSONArray jsonarray = new JSONArray();
		try {
			
			station=iss.loadStation(area, city);
			for(int j=0;j<station.size();j++){
				JSONArray jsonarraylist = new JSONArray();
				result=its.loadTimer(station.get(j).getStationid());
				if(result.size()==0){
					JSONObject jo = new JSONObject();
					jo.put("timeId",0);
					jo.put("stationId", station.get(j).getStationid());
					jsonarraylist.put(jo);
				}
				for(int i=0;i<result.size();i++){
					JSONObject jo = new JSONObject();
					jo.put("timeId",result.get(i).getTimeId());
					jo.put("stationId", result.get(i).getStationId());
					jo.put("timername", timer.get(result.get(i).getTimer()));
					jo.put("timer", result.get(i).getTimer());
					jo.put("timename", result.get(i).getTimername());
					jo.put("timerdescription", result.get(i).getTimerdescription());
					jsonarraylist.put(jo);
				}
				jsonarray.put(jsonarraylist);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	
}

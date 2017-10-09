package controller;

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
		timer.put(1, "每日一次");
		timer.put(2, "每周一次");
		timer.put(3, "每月一次");
		
		}
	@RequestMapping(value = "/addtimer.do", produces = "application/json; charset=utf-8") 	
	public String addtimer(BeanTimer bt,HttpServletRequest request) throws JSONException{
		System.out.println(bt.getTimername());
		try {
			bt.setStarttime(Timestamp.valueOf(request.getParameter("start")));
			its.addTimer(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifrytimer.do", produces = "application/json; charset=utf-8") 	
	public String modifrytimer(BeanTimer bt) throws JSONException{
		try {
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
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			its.DelTimer(id);
			} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
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
	public String loadtimer() throws JSONException{
		List<BeanTimer> result =new ArrayList<BeanTimer>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		JSONArray jsonarray = new JSONArray();
		try {
			
			station=iss.loadAllStation();
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

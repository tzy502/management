package controller;


import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanMission;
import model.BeanStation;
import serviceI.IMissionService;
import serviceI.IStationService;
import serviceI.IUserService;
import util.BaseException;


@Controller
public class MissionController {
	@Autowired
	private IMissionService ims;
	@Autowired
	private IStationService iss;
	@Autowired
	private IUserService ius;
	static Map<Integer,String> staus=new HashMap<Integer,String>(5);
	static {
		staus.put(1, "未查看");
		staus.put(2, "已查看");
		staus.put(3, "已完成");
		staus.put(4, "任务已有修改但未查看");
		staus.put(5, "超时未完成");
		staus.put(6, "超时完成");
		
		}
	
	@RequestMapping(value = "/addmission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addMission(BeanMission bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		bm.setEnddate(Timestamp.valueOf(request.getParameter("end")));
		String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 
		bm.setStartdate(Timestamp.valueOf(start));
		bm.setStatus(1);
		bm.setType(1);
		String missionname=new String(bm.getMissionname().getBytes("ISO-8859-1"),"UTF-8"); 
		String description=new String(bm.getDescription().getBytes("ISO-8859-1"),"UTF-8"); 
		bm.setMissionname(missionname);
		bm.setDescription(description);
		try {

			ims.addMission(bm);

		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifryMission.do", produces = "application/json; charset=utf-8") 
	public String modifryMission(BeanMission bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			String missionname=new String(bm.getMissionname().getBytes("ISO-8859-1"),"UTF-8"); 
			String description=new String(bm.getDescription().getBytes("ISO-8859-1"),"UTF-8"); 
			bm.setMissionname(missionname);
			bm.setDescription(description);
			bm.setEnddate(Timestamp.valueOf(request.getParameter("end")));
			bm.setStatus(4);
			bm.setStartdate(ims.SearchMission(bm.getMissionid()).getStartdate());
			ims.modifryMission(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			ims.DelMission(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/viewMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String viewMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			BeanMission bm=ims.SearchMission(id);
			if(bm.getStatus()==1||bm.getStatus()==4){
				bm.setStatus(2);
				ims.modifryMission(bm);
			}

		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/endMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String endMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			BeanMission bm=ims.SearchMission(id);
			if(bm.getStatus()!=5){
				bm.setStatus(3);
			}else{
				bm.setStatus(6);
			}
			
			ims.modifryMission(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/searchMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		JSONObject jo = new JSONObject();
		BeanMission result=new BeanMission();
		try {
			result=ims.SearchMission(id);
			jo.put("Missionid", result.getMissionid());
			jo.put("userid", result.getUserid());
			jo.put("username", ius.searchUser(result.getUserid()).getUserName());
			jo.put("stationId", result.getStationid());
			jo.put("startdate", result.getStartdate());
			jo.put("enddate", result.getEnddate());
			jo.put("status",result.getStatus() );
			jo.put("statusname",staus.get(result.getStatus()) );
			jo.put("description", result.getDescription());
			jo.put("missionname", result.getMissionname());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
	@RequestMapping(value = "/loadUserMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadUserMission(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String id=json.getString("userId");
		JSONArray jsonarraylist = new JSONArray();
		try {
			List<BeanMission> result =new ArrayList<BeanMission>();
			
			result=ims.loadALLUserMission(id);
			
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("Missionid", result.get(i).getMissionid());
				jo.put("userid", result.get(i).getUserid());
				jo.put("username", ius.searchUser(result.get(i).getUserid()).getUserName());
				jo.put("stationId", result.get(i).getStationid());
				jo.put("startdate", result.get(i).getStartdate());
				jo.put("enddate", result.get(i).getEnddate());
				jo.put("status",result.get(i).getStatus() );
				jo.put("statusname",staus.get(result.get(i).getStatus()) );
				jo.put("description", result.get(i).getDescription());
				jo.put("missionname", result.get(i).getMissionname());
				jsonarraylist.put(jo);
			}		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarraylist.toString();
	}
	@RequestMapping(value = "/loadALLMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadALLMission() throws JSONException{
		
		List<BeanMission> result =new ArrayList<BeanMission>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		JSONArray jsonarray = new JSONArray();
		try {
			station=iss.loadAllStation();
			for(int j=0;j<station.size();j++){
				JSONArray jsonarraylist = new JSONArray();
				result=ims.loadMission(station.get(j).getStationid());
				if(result.size()==0){
					JSONObject jo = new JSONObject();
					jo.put("Missionid",0);
					jo.put("stationId", station.get(j).getStationid());
					jsonarraylist.put(jo);
				}
					
				for(int i=0;i<result.size();i++){
					if(result.get(i).getStatus()!=3&&result.get(i).getStatus()!=6){
						JSONObject jo = new JSONObject();
						jo.put("Missionid", result.get(i).getMissionid());
						jo.put("userid", result.get(i).getUserid());
						jo.put("username", ius.searchUser(result.get(i).getUserid()).getUserName());
						jo.put("stationId", result.get(i).getStationid());
						jo.put("startdate", result.get(i).getStartdate());
						jo.put("enddate", result.get(i).getEnddate());
						jo.put("statusname",staus.get(result.get(i).getStatus()) );
						jo.put("description", result.get(i).getDescription());
						jo.put("missionname", result.get(i).getMissionname());
						jo.put("status",result.get(i).getStatus() );
						jsonarraylist.put(jo);
					}

				}	
				jsonarray.put(jsonarraylist);
			}				
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	@RequestMapping(value = "/loadStationMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadStationMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("StationId"));
		JSONArray jsonarraylist = new JSONArray();
		try {
			List<BeanMission> result =new ArrayList<BeanMission>();
			result=ims.loadMission(id);	
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("Missionid", result.get(i).getMissionid());
				jo.put("userid", result.get(i).getUserid());
				jo.put("username", ius.searchUser(result.get(i).getUserid()).getUserName());
				jo.put("stationId", result.get(i).getStationid());
				jo.put("startdate", result.get(i).getStartdate());
				jo.put("enddate", result.get(i).getEnddate());
				jo.put("status",result.get(i).getStatus() );
				jo.put("statusname",staus.get(result.get(i).getStatus()) );
				jo.put("description", result.get(i).getDescription());
				jo.put("missionname", result.get(i).getMissionname());
				jsonarraylist.put(jo);
			}		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarraylist.toString();
	}

}


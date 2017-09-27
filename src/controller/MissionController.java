package controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

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
	@RequestMapping(value = "/addMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addMission(BeanMission bm) throws JSONException{
		try {

			ims.addMission(bm);

		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifryMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryMission(BeanMission bm) throws JSONException{
		try {
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
		return "ok";
	}
	@RequestMapping(value = "/viewMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String viewMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			BeanMission bm=ims.SearchMission(id);
			bm.setStatus(2);
			ims.modifryMission(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/endMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String endMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("missionId"));
		try {
			BeanMission bm=ims.SearchMission(id);
			bm.setStatus(3);
			ims.modifryMission(bm);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/loadUserMission.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadUserMission(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		String id=json.getString("userId");
		JSONArray jsonarraylist = new JSONArray();
		try {
			List<BeanMission> result =new ArrayList<BeanMission>();
			result=ims.loaduserMission(id);		
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("Missionid", result.get(i).getMissionid());
				jo.put("userid", result.get(i).getUserid());
				jo.put("username", ius.searchUser(result.get(i).getUserid()).getUserName());
				jo.put("stationId", result.get(i).getStationid());
				jo.put("startdate", result.get(i).getStartdate());
				jo.put("enddate", result.get(i).getEnddate());
				jo.put("status", result.get(i).getStationid());
				jo.put("description", result.get(i).getDescription());
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
		List<BeanStation> station =new ArrayList<BeanStation>();
		List<BeanMission> result =new ArrayList<BeanMission>();
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
					if(result.get(i).getStatus()!=3){
						JSONObject jo = new JSONObject();
						jo.put("Missionid", result.get(i).getMissionid());
						jo.put("userid", result.get(i).getUserid());
						jo.put("username", ius.searchUser(result.get(i).getUserid()).getUserName());
						jo.put("stationId", result.get(i).getStationid());
						jo.put("startdate", result.get(i).getStartdate());
						jo.put("enddate", result.get(i).getEnddate());
						jo.put("status", result.get(i).getStationid());
						jo.put("description", result.get(i).getDescription());
						jsonarraylist.put(jo);
					}

				}	
				jsonarray.put(jsonarraylist);
			}				
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonarray.toString());
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
				jo.put("status", result.get(i).getStationid());
				jo.put("description", result.get(i).getDescription());
				jsonarraylist.put(jo);
			}		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarraylist.toString();
	}
}

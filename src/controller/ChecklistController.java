package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanChecklist;
import model.BeanChecklisttype;
import model.BeanStation;
import serviceI.IChecklistService;
import serviceI.IStationService;
import serviceI.IUserService;
import util.BaseException;


@Controller
public class ChecklistController {
	@Autowired
	private IChecklistService ics;
	@Autowired
	private IStationService iss;
	@Autowired
	private IUserService ius;
	@RequestMapping(value = "/addChecklist.do") 
	@ResponseBody
	public String addChecklist(BeanChecklist bc) throws JSONException, UnsupportedEncodingException{
		try {
			String input=new String(bc.getChecklistinput().getBytes("ISO-8859-1"),"UTF-8"); 	
			bc.setChecklistinput(input);
			ics.addChecklist(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}
	@RequestMapping(value = "/modifryChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryChecklist(BeanChecklist bc) throws JSONException, UnsupportedEncodingException{
		try {
			String input=new String(bc.getChecklistinput().getBytes("ISO-8859-1"),"UTF-8"); 	
			bc.setChecklistinput(input);
			bc.setStationId(ics.SearchChecklist(bc.getChecklistId()).getStationId());

			ics.modifryChecklist(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/searchChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchChecklist(@RequestBody String params) throws JSONException, UnsupportedEncodingException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("checklistId"));
		JSONObject jo = new JSONObject();
		BeanChecklist result=new BeanChecklist();
		try {
			result=ics.SearchChecklist(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jo.put("checklistId", result.getChecklistId());
		jo.put("Checklisttime",result.getChecklisttime());
		jo.put("Checklisttype", result.getChecklisttype());
		jo.put("checklistcheckbox", result.getChecklistcheckbox()); 
		jo.put("checklistinput",result.getChecklistinput() );
		jo.put("StationId", result.getStationId());
		jo.put("userId", result.getUserId());
		return jo.toString();
	}
	@RequestMapping(value = "/delChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delChecklist(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("checklistId"));
		try {
			ics.DelChecklist(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/loadChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadChecklist(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int type=Integer.valueOf(json.getString("type"));
		List<BeanChecklist> result =new ArrayList<BeanChecklist>();
		List<BeanStation> station =new ArrayList<BeanStation>();
		JSONArray jsonarraylist = new JSONArray();
		BeanChecklisttype bcl=new BeanChecklisttype();
		try {
			station=iss.loadStation(type);		
			for(int j=0;j<station.size();j++){

				result=ics.loadChecklist(station.get(j).getStationid());
				JSONArray jsonarray = new JSONArray();
				if(result.size()==0){
					JSONObject jo = new JSONObject();
					jo.put("stationId",station.get(j).getStationid());
					jo.put("checklistId",0);
					jo.put("Checklisttype", 0);
					jo.put("Checklisttime", 0);
					jo.put("userId", 0);
					jsonarray.put(jo);
				}

				for(int i=0;i<result.size();i++){
					JSONObject jo = new JSONObject();
					jo.put("stationId",station.get(j).getStationid());
					jo.put("checklistId",result.get(i).getChecklistId());
					jo.put("Checklisttype",result.get(i).getChecklisttype());
					jo.put("Checklisttypename", bcl.getMap().get(result.get(i).getChecklisttype()));
					jo.put("Checklisttime", result.get(i).getChecklisttime().toString());
					jo.put("userId",ius.searchUser(result.get(i).getUserId()).getUserName() );
					jsonarray.put(jo);

				}
				jsonarraylist.put(jsonarray);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonarraylist.toString();
	}
	@RequestMapping(value = "/loadChecklisthistory.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadChecklisthistory(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int type=Integer.valueOf(json.getString("type"));
		int id=Integer.valueOf(json.getString("stationId"));
		List<BeanChecklist> result =new ArrayList<BeanChecklist>();
		JSONArray jsonarraylist = new JSONArray();
		BeanChecklisttype bcl=new BeanChecklisttype();
		result=ics.loadChecklisthistory(id, type);
		System.out.println(result.size());
		try {
			JSONObject j1 = new JSONObject();
			j1.put("name", iss.SearchStation(id).getStationname());
			jsonarraylist.put(j1);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("checklistId",result.get(i).getChecklistId());
				jo.put("Checklisttype",result.get(i).getChecklisttype());
				jo.put("Checklisttypename", bcl.getMap().get(result.get(i).getChecklisttype()));
				jo.put("Checklisttime", result.get(i).getChecklisttime().toString());
				jo.put("userId",ius.searchUser(result.get(i).getUserId()).getUserName() );
				jsonarraylist.put(jo);		
			
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonarraylist.toString());
		return jsonarraylist.toString();
	}

}

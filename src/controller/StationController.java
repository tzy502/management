package controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.StationDao;
import model.BeanStation;
import model.BeanUser;
import service.CompanyService;
import serviceI.IStationService;
import serviceI.IUserService;
import util.BaseException;

@Controller
public class StationController {
	@Autowired
	private IStationService iss;
	@Autowired
	private IUserService ius;
	@Autowired
	private CompanyService ics;
	static Map<Integer,String> type=new HashMap<Integer,String>(5);
	static {
		type.put(31, "气");
		type.put(32, "水");


	}
	@RequestMapping(value = "/loadAllStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllStation() throws JSONException{
		List<BeanStation> result =new ArrayList<BeanStation>();
		JSONArray json = new JSONArray();
		try {
			result =iss.loadAllStation();
			//查最后一次运维时间

			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("stationId",result.get(i).getStationid());
				jo.put("type", type.get(result.get(i).getType()));
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());			
				jo.put("status",result.get(i).getStatus());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				jo.put("IP", result.get(i).getIP());
				BeanUser user=null;
				user=ius.searchUser(result.get(i).getPrincipal());
				if(user!=null){
					String name =user.getUserName();
					jo.put("name",name);
				}
				else{
					jo.put("name", "暂无负责人");
				}
				if(result.get(i).getBase()==1){
					jo.put("data", "有监控数据");
				}else{
					jo.put("data", "无监控数据");
				}

				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/SearchStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchStation(@RequestBody String params) throws JSONException{
		BeanStation bs=new BeanStation();
		JSONObject json = new JSONObject(params);
		int StationId=Integer.valueOf(json.getString("stationId"));
		JSONObject jo = new JSONObject();
		try {
			bs=iss.SearchStation(StationId);
			jo.put("type", type.get(bs.getType()));
			jo.put("stationname",bs.getStationname());
			jo.put("city", bs.getCity());
			jo.put("area",bs.getArea());			
			jo.put("status",bs.getStatus());
			jo.put("remarks",bs.getRemarks());
			jo.put("principal",bs.getPrincipal());
			jo.put("IP", bs.getIP());
			BeanUser user=null;
			user=ius.searchUser(bs.getPrincipal());
			if(user!=null){
				String name =user.getUserName();
				jo.put("name",name);
			}
			else{
				jo.put("name", "暂无负责人");
			}
			if(bs.getBase()==1){
				jo.put("data", "有监控数据");
			}else{
				jo.put("data", "无监控数据");
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jo.toString());
		return jo.toString();
	}
	@RequestMapping(value = "/addStation.do") 
	@ResponseBody
	public String  addStation(BeanStation bs,HttpServletRequest request) throws JSONException{
		bs.setType(Integer.valueOf(request.getParameter("type")));
		try {
			iss.addStation(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());

			return jo.toString();
		}
		return null;
	}
	@RequestMapping(value = "/modifryStation.do") 
	@ResponseBody
	public void modifryStation(BeanStation bs,@RequestParam("stationId") int stationId,HttpServletRequest request) throws JSONException{

		bs.setType(Integer.valueOf(request.getParameter("type")));
		bs.setStationid(stationId);
		StationDao sd=new StationDao();
		sd.modifryStation(bs);

	}
	@RequestMapping(value = "/delStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public void delStation(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int StationId=Integer.valueOf(json.getString("StationId"));
		try {
			iss.DelStation(StationId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/loadwaterStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadwaterStation() throws JSONException{
		List<BeanStation> result =new ArrayList<BeanStation>();
		JSONArray json = new JSONArray();
		try {
			result =iss.loadStation(32);
			//查最后一次运维时间

			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("stationId",result.get(i).getStationid());
				jo.put("type", type.get(result.get(i).getType()));
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());			
				jo.put("status",result.get(i).getStatus());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				jo.put("IP", result.get(i).getIP());
				BeanUser user=null;
				user=ius.searchUser(result.get(i).getPrincipal());
				if(user!=null){
					String name =user.getUserName();
					jo.put("name",name);
				}
				else{
					jo.put("name", "暂无负责人");
				}
				if(result.get(i).getBase()==1){
					jo.put("data", "有监控数据");
				}else{
					jo.put("data", "无监控数据");
				}
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/loadgasStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadgasStation() throws JSONException{
		List<BeanStation> result =new ArrayList<BeanStation>();
		JSONArray json = new JSONArray();
		try {
			result =iss.loadStation(31);
			//查最后一次运维时间

			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("stationId",result.get(i).getStationid());
				jo.put("type", type.get(result.get(i).getType()));
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());			
				jo.put("status",result.get(i).getStatus());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				jo.put("IP", result.get(i).getIP());
				BeanUser user=null;
				user=ius.searchUser(result.get(i).getPrincipal());
				if(user!=null){
					String name =user.getUserName();
					jo.put("name",name);
				}
				else{
					jo.put("name", "暂无负责人");
				}
				if(result.get(i).getBase()==1){
					jo.put("data", "有监控数据");
				}else{
					jo.put("data", "无监控数据");
				}
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/loadcityandarea.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadcityandarea() throws JSONException{
		List<String> area =new ArrayList<String>();
		List<String> city =new ArrayList<String>();
		area=iss.loadarea();
		city=iss.loadcity();
		JSONArray jsonarea = new JSONArray();
		JSONArray jsoncity = new JSONArray();
		JSONArray result = new JSONArray();
		for(int i=0;i<area.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("area", area.get(i));
			jsonarea.put(jo);
		}
		for(int i=0;i<city.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("city", city.get(i));
			jsoncity.put(jo);
		}
		result.put(jsonarea);
		result.put(jsoncity);
		System.out.println(result.toString());
		return result.toString();
	}
	@RequestMapping(value = "/loadStation.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadStation(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		String city=js.getString("city");
		String area=js.getString("area");
		if(city.equals("all")){
			city=null;
		}
		if(area.equals("all")){
			area=null;
		}
		
		List<BeanStation> result =new ArrayList<BeanStation>();
		JSONArray json = new JSONArray();

		result =iss.loadStation(area, city);
		//查最后一次运维时间
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("stationId",result.get(i).getStationid());
			jo.put("stationname",result.get(i).getStationname());	
			json.put(jo);
		}

		return json.toString();
	}
}

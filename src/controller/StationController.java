package controller;

import java.util.ArrayList;
import java.util.List;

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
				jo.put("companyid",result.get(i).getCompanyid() );
				jo.put("type", result.get(i).getType());
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());
				jo.put("areaid",result.get(i).getAreaid());
				jo.put("codeA",result.get(i).getCodeA());
				jo.put("codeB",result.get(i).getCodeB());
				jo.put("level",result.get(i).getLevel());
				jo.put("industry",result.get(i).getIndustry());
				jo.put("togo",result.get(i).getTogo());
				jo.put("pollution",result.get(i).getPollution());
				jo.put("model",result.get(i).getModel());
				jo.put("unit",result.get(i).getUnit());
				jo.put("status",result.get(i).getStatus());
				jo.put("regulatoryauthorities",result.get(i).getRegulatoryauthorities());
				jo.put("longitude",result.get(i).getLongitude());
				jo.put("latitude",result.get(i).getLatitude());
				jo.put("address",result.get(i).getAddress());
				jo.put("ability",result.get(i).getAbility());
				jo.put("acceptance",result.get(i).getAcceptance());
				jo.put("assessment",result.get(i).getAssessment());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				String name =ius.searchUser(result.get(i).getPrincipal()).getUserName();
				jo.put("name",name);
				jo.put("last", "");
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
			
			jo.put("stationId",bs.getStationid());
			jo.put("companyid",bs.getCompanyid() );
			jo.put("companyname",ics.SearchCompany(bs.getCompanyid()).getCompanyname() );
			jo.put("type", bs.getType());
			jo.put("stationname",bs.getStationname());
			jo.put("city", bs.getCity());
			jo.put("area",bs.getArea());
			jo.put("areaid",bs.getAreaid());
			jo.put("codeA",bs.getCodeA());
			jo.put("codeB",bs.getCodeB());
			jo.put("level",bs.getLevel());
			jo.put("industry",bs.getIndustry());
			jo.put("togo",bs.getTogo());
			jo.put("pollution",bs.getPollution());
			jo.put("model",bs.getModel());
			jo.put("unit",bs.getUnit());
			jo.put("status",bs.getStatus());
			jo.put("regulatoryauthorities",bs.getRegulatoryauthorities());
			jo.put("longitude",bs.getLongitude());
			jo.put("latitude",bs.getLatitude());
			jo.put("address",bs.getAddress());
			jo.put("ability",bs.getAbility());
			jo.put("acceptance",bs.getAcceptance());
			jo.put("assessment",bs.getAssessment());
			jo.put("remarks",bs.getRemarks());
			jo.put("principal",bs.getPrincipal());
			String name =ius.searchUser(bs.getPrincipal()).getUserName();
			jo.put("name",name);
			jo.put("last", "");
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
	@RequestMapping(value = "/addStation.do") 
	@ResponseBody
	public String  addStation(BeanStation bs) throws JSONException{

		
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
	public void modifryStation(BeanStation bs,@RequestParam("stationId") int stationId) throws JSONException{

		
		bs.setStationid(stationId);
		 StationDao sd=new StationDao();
		 sd.modifryStation(bs);
//		try {
//			sd.modifryStation(bs);
//		} catch (BaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
				jo.put("companyid",result.get(i).getCompanyid() );
				jo.put("type", result.get(i).getType());
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());
				jo.put("areaid",result.get(i).getAreaid());
				jo.put("codeA",result.get(i).getCodeA());
				jo.put("codeB",result.get(i).getCodeB());
				jo.put("level",result.get(i).getLevel());
				jo.put("industry",result.get(i).getIndustry());
				jo.put("togo",result.get(i).getTogo());
				jo.put("pollution",result.get(i).getPollution());
				jo.put("model",result.get(i).getModel());
				jo.put("unit",result.get(i).getUnit());
				jo.put("status",result.get(i).getStatus());
				jo.put("regulatoryauthorities",result.get(i).getRegulatoryauthorities());
				jo.put("longitude",result.get(i).getLongitude());
				jo.put("latitude",result.get(i).getLatitude());
				jo.put("address",result.get(i).getAddress());
				jo.put("ability",result.get(i).getAbility());
				jo.put("acceptance",result.get(i).getAcceptance());
				jo.put("assessment",result.get(i).getAssessment());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				String name =ius.searchUser(result.get(i).getPrincipal()).getUserName();
				jo.put("name",name);
				jo.put("last", "");
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
				jo.put("companyid",result.get(i).getCompanyid() );
				jo.put("type", result.get(i).getType());
				jo.put("stationname",result.get(i).getStationname());
				jo.put("city", result.get(i).getCity());
				jo.put("area",result.get(i).getArea());
				jo.put("areaid",result.get(i).getAreaid());
				jo.put("codeA",result.get(i).getCodeA());
				jo.put("codeB",result.get(i).getCodeB());
				jo.put("level",result.get(i).getLevel());
				jo.put("industry",result.get(i).getIndustry());
				jo.put("togo",result.get(i).getTogo());
				jo.put("pollution",result.get(i).getPollution());
				jo.put("model",result.get(i).getModel());
				jo.put("unit",result.get(i).getUnit());
				jo.put("status",result.get(i).getStatus());
				jo.put("regulatoryauthorities",result.get(i).getRegulatoryauthorities());
				jo.put("longitude",result.get(i).getLongitude());
				jo.put("latitude",result.get(i).getLatitude());
				jo.put("address",result.get(i).getAddress());
				jo.put("ability",result.get(i).getAbility());
				jo.put("acceptance",result.get(i).getAcceptance());
				jo.put("assessment",result.get(i).getAssessment());
				jo.put("remarks",result.get(i).getRemarks());
				jo.put("principal",result.get(i).getPrincipal());
				String name =ius.searchUser(result.get(i).getPrincipal()).getUserName();
				jo.put("name",name);
				jo.put("last", "");
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
}

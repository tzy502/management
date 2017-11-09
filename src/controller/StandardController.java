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
import org.springframework.web.bind.annotation.ResponseBody;


import model.BeanStandard;
import serviceI.IInfectService;
import serviceI.IStandardService;
import util.BaseException;

@Controller
public class StandardController {
	@Autowired
	private IStandardService iss;
	@Autowired
	private IInfectService iis;
	@RequestMapping(value = "/addStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addStandard(BeanStandard bs) throws JSONException{
		
		try {
		
			iss.addStandard(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());
		
			return jo.toString();
		}
		
		return null;
	}
	@RequestMapping(value = "/modifryStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryStandard(BeanStandard bs) throws JSONException{
		JSONObject jo = new JSONObject();
		try {
			System.out.println("123");
			iss.modifryStandard(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			
			jo.put("msg", e.getMessage());
	
			return jo.toString();
		
		}
		return null;
	}
	@RequestMapping(value = "/loadStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchallStandard(@RequestBody String params) throws JSONException, BaseException{
	
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("stationId"));
		List<BeanStandard> result=new ArrayList<BeanStandard>();
		JSONArray jsonarray = new JSONArray();
		try {
			result=iss.loadStandard(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("standardid", result.get(i).getStandardid());
			jo.put("infectid", result.get(i).getInfectid());
			jo.put("name", iis.search(result.get(i).getInfectid()).getInfectName());
			jo.put("maxvaule", String.valueOf(result.get(i).getMaxvaule()));	
			jo.put("minvaule", String.valueOf(result.get(i).getMinvaule()));
			jo.put("maxalarm", String.valueOf(result.get(i).getMaxalarm()));	
			jo.put("minalarm", String.valueOf(result.get(i).getMinalarm()));
			jsonarray.put(jo);	
			}  

		return jsonarray.toString();
	}
	@RequestMapping(value = "/SearchStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchStandard(@RequestBody String params) throws JSONException, BaseException{
	
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("standardid"));
		BeanStandard result=new BeanStandard();
		result=iss.SearchStandard(id);
		JSONObject jo = new JSONObject();
		jo.put("standardid", result.getStandardid());
		jo.put("infectid", result.getInfectid());
		jo.put("name", iis.search(result.getInfectid()).getInfectName());
		jo.put("maxvaule", String.valueOf(result.getMaxvaule()));	
		jo.put("minvaule", String.valueOf(result.getMinvaule()));
		jo.put("maxalarm", String.valueOf(result.getMaxalarm()));	
		jo.put("minalarm", String.valueOf(result.getMinalarm()));
		jo.put("stationId", result.getStationId());	
		
		return jo.toString();
	}
	@RequestMapping(value = "/delStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delStandard(@RequestBody String params) throws JSONException{
	
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("standardid"));
		try {
			iss.delStandard(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

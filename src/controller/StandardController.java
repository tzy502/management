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
		}
		return null;
	}
	@RequestMapping(value = "/modifryStandard.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryStandard(BeanStandard bs) throws JSONException{
		try {
			System.out.println(bs.getVaule()+"modifryStandard");
			iss.modifryStandard(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			jo.put("vaule", String.valueOf(result.get(i).getVaule()));	
			jsonarray.put(jo);	
			}  
		System.out.println("SearchStandard"+jsonarray);
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
		jo.put("vaule", String.valueOf(result.getVaule()));	
		jo.put("stationid", result.getStationid());	
		
		return jo.toString();
	}
}

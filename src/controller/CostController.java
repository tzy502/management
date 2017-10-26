package controller;

import java.util.ArrayList;
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

import model.BeanCost;
import serviceI.ICostService;
import serviceI.IProjectService;
import util.BaseException;

@Controller
public class CostController {
	@Autowired
	private ICostService ics;
	@Autowired
	private IProjectService ips;
	@RequestMapping(value = "/addcost.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addcost(BeanCost bc,HttpServletRequest request) throws JSONException{
		int flag=Integer.valueOf(request.getParameter("type"));
		bc.setCost(bc.getCost()*flag);
		try {
			ics.addCost(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrycost.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrycost(BeanCost bc,HttpServletRequest request) throws JSONException{
		int flag=Integer.valueOf(request.getParameter("type"));
		bc.setCost(bc.getCost()*flag);
		try {
			ics.modifryCost(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delcost.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delcost(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("costId"));
			ics.DelCost(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllcost.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllcost(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		int id=Integer.valueOf(js.getString("projectId"));
		JSONArray json = new JSONArray();
		List<BeanCost> result =new ArrayList<BeanCost>();
		float total=0;
		try {
			result=ics.loadAllCost(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("costId", result.get(i).getCostId());
				jo.put("costname", result.get(i).getCostname());
				jo.put("cost",String.valueOf(result.get(i).getCost()));
				total+=result.get(i).getCost();
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		jo.put("total", String.valueOf(total));
		json.put(jo);
		System.out.println(json.toString());
		return json.toString();
	}
	@RequestMapping(value = "/searchcost.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchcost(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("costId"));
		BeanCost result=new BeanCost();
		JSONObject jo = new JSONObject();
		try {
			result=ics.SearchCost(id);
			jo.put("costId", result.getCostId());
			jo.put("costname", result.getCostname());
			jo.put("projectId", result.getProjectId());
			jo.put("cost",String.valueOf(result.getCostId()));
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import daoI.ICompanyDao;
import model.BeanCompany;
import serviceI.ICompanyService;
import util.BaseException;
@Controller
public class CompanyController {
	@Autowired
	private ICompanyService ics;
	@RequestMapping(value = "/loadAllCompany.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllCompany() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanCompany> result =new ArrayList<BeanCompany>();
		try {
			result=ics.loadAllCompany();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("companyId", result.get(i).getCompanyid());
			jo.put("companyname", result.get(i).getCompanyname());
			jo.put("companyaddress", result.get(i).getCompanyaddress());
			jo.put("TEL", result.get(i).getTEL());
			jo.put("boss", result.get(i).getBoss());
			json.put(jo);
		}
		return json.toString();
	}
	@RequestMapping(value = "/addCompany.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addCompany(BeanCompany bc) throws JSONException{
		try {
			ics.addCompany(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());
			System.out.println(jo.toString());
			return jo.toString();
		}
		return null;
	}
	@RequestMapping(value = "/modifryCompany.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryCompany(BeanCompany bc) throws JSONException{
		try {
			System.out.println(bc.getCompanyid()+"from controller");
			ics.modifryCompany(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());
			System.out.println(jo.toString());
			return jo.toString();
		}
		return null;
	}
	@RequestMapping(value = "/delCompany.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delCompany(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("companyId"));
			ics.DelCompany(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/SearchCompany.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchCompany(@RequestBody String params) throws JSONException{
		System.out.println("asd");
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("companyId"));
		JSONObject jo = new JSONObject();
		BeanCompany result=new BeanCompany();	
		try {
			result=ics.SearchCompany(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jo.put("companyId", result. getCompanyid());
		jo.put("companyname", result. getCompanyname());
		jo.put("companyaddress", result. getCompanyaddress());
		jo.put("TEL", result. getTEL());
		jo.put("boss", result. getBoss());
		return jo.toString();
		
	}
}

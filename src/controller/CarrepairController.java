package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import model.BeanCarrepair;
import serviceI.ICarrepairService;
import util.BaseException;

@Controller
public class CarrepairController {
	@Autowired
	private ICarrepairService ics;
	@RequestMapping(value = "/addcarrepair.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addcarrepair(BeanCarrepair bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		System.out.println(bc.getCarrepairnumber());
		String carrepairreason=new String(bc.getCarrepairreason().getBytes("ISO-8859-1"),"UTF-8"); 
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		bc.setCarId(carId);
		bc.setCarrepairreason(carrepairreason);
		String time=request.getParameter("time");
		time+=" 00:00:00";
		bc.setCarrepairtime(Timestamp.valueOf(time));
		try {
			ics.addCarrepair(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrycarrepair.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrycarrepair(BeanCarrepair bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String carrepairreason=new String(bc.getCarrepairreason().getBytes("ISO-8859-1"),"UTF-8"); 
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		bc.setCarId(carId);
		bc.setCarrepairreason(carrepairreason);
		String time=request.getParameter("time");
		time+=" 00:00:00";
		bc.setCarrepairtime(Timestamp.valueOf(time));
		try {
			ics.modifryCarrepair(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delcarrepair.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delcarrepair(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("carrepairId"));
			ics.DelCarrepair(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllcarrepair.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllcarrepair(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		String id=js.getString("carId");
		JSONArray json = new JSONArray();
		List<BeanCarrepair> result =new ArrayList<BeanCarrepair>();
		try {
			result=ics.loadAllCarrepair(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();	
				jo.put("carrepairId",result.get(i).getCarrepairId());
				jo.put("carrepairtime",result.get(i).getCarrepairtime());
				jo.put("carrepairreason",result.get(i).getCarrepairreason());
				jo.put("carrepairnumber",result.get(i).getCarrepairnumber());
				jo.put("carId",result.get(i).getCarId());
				
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json.toString());
		
		return json.toString();
	}
	@RequestMapping(value = "/searchcarrepair.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchcarrepair(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("carrepairId"));
		BeanCarrepair result=new BeanCarrepair();
		JSONObject jo = new JSONObject();
		try {
			result=ics.SearchCarrepair(id);		
			jo.put("carrepairId",result.getCarrepairId());
			jo.put("carrepairtime",result.getCarrepairtime());
			jo.put("carrepairreason",result.getCarrepairreason());
			jo.put("carrepairnumber",result.getCarrepairnumber());
			jo.put("carId",result.getCarId());
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

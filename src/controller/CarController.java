package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
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

import model.BeanCar;
import serviceI.ICarService;
import util.BaseException;

@Controller
public class CarController {
	@Autowired
	private ICarService ics;
	@RequestMapping(value = "/addcar.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addcar(BeanCar bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		String cartype=new String(bc.getCartype().getBytes("ISO-8859-1"),"UTF-8"); 
		bc.setCarId(carId);
		bc.setCartype(cartype);
		String buy=request.getParameter("buy");
		buy+=" 00:00:00";
		String insurance=request.getParameter("insurance");
		insurance+=" 00:00:00";
		bc.setCarbuytime(Timestamp.valueOf(buy));
		bc.setCarinsurancetime(Timestamp.valueOf(insurance));
		try {
			ics.addCar(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrycar.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrycar(BeanCar bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		String cartype=new String(bc.getCartype().getBytes("ISO-8859-1"),"UTF-8"); 
		bc.setCarId(carId);
		bc.setCartype(cartype);
		String buy=request.getParameter("buy");
		buy+=" 00:00:00";
		String insurance=request.getParameter("insurance");
		insurance+=" 00:00:00";
		bc.setCarbuytime(Timestamp.valueOf(buy));
		bc.setCarinsurancetime(Timestamp.valueOf(insurance));
		try {
			ics.modifryCar(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delcar.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delcar(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			String id=json.getString("carId");
			ics.DelCar(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllcar.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllcar() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanCar> result =new ArrayList<BeanCar>();
		try {
			result=ics.loadAllCar();
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("carId", result.get(i).getCarId());
				jo.put("cartype", result.get(i).getCartype());
				jo.put("carbuytime", result.get(i).getCarbuytime());
				jo.put("carinsurancetime", result.get(i).getCarinsurancetime());
				jo.put("displacement", result.get(i).getDisplacement());	
				jo.put("price",String.valueOf(result.get(i).getPrice()));	
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json.toString();
	}
	@RequestMapping(value = "/searchcar.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchcar(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		String id=json.getString("carId");
		BeanCar result=new BeanCar();
		JSONObject jo = new JSONObject();
		try {
			result=ics.SearchCar(id);		
			jo.put("carId", result.getCarId());
			jo.put("cartype", result.getCartype());
			jo.put("carbuytime", result.getCarbuytime());
			jo.put("carinsurancetime", result.getCarinsurancetime());
			jo.put("displacement", result.getDisplacement());	
			jo.put("price",String.valueOf(result.getPrice()));	
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return jo.toString();
	}
}

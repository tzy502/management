package controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import model.BeanCompany;
import model.BeanData;
import model.BeanGas;
import model.BeanWater;
import serviceI.IDataService;
import util.BaseException;
import util.DbException;

@Controller
public class DataController {
	@Autowired
	private IDataService ids;
	@RequestMapping(value = "/loadnewgasdata.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadnewgasdata() throws JSONException{

		JSONArray json = new JSONArray();
		List<BeanGas> result =new ArrayList<BeanGas>();
		try {
			result=ids.loadnewgasdata();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k=0;
		for(int i=0;i<result.size();i++){
			BeanGas bg=new BeanGas();
			int max=i;

			long diffent;
			for(int j=i;j<result.size();j++){
				
				k++;

				diffent=result.get(max).getTime().getTime()-result.get(j).getTime().getTime();
				if(diffent<0){
					max=j;
					
				}
			}
			bg=result.get(max);
			result.set(max, result.get(i));
			result.set(i, bg);
			
		}
		
		
		
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
	
			jo.put("stationId", result.get(i).getStationId());
			jo.put("stationname", result.get(i).getStationname());
			jo.put("time", String.valueOf(result.get(i).getTime()));
			jo.put("g02", String.valueOf(result.get(i).getG02()));
			jo.put("g01",String.valueOf( result.get(i).getG01()));
			jo.put("g03",String.valueOf( result.get(i).getG03()));
			jo.put("g01Zs",String.valueOf( result.get(i).getG01Zs()));
			jo.put("g02Zs",String.valueOf( result.get(i).getG02Zs()));
			jo.put("g03Zs",String.valueOf( result.get(i).getG03Zs()));
			jo.put("gS01", String.valueOf(result.get(i).getgS01()));
			jo.put("gS02", String.valueOf(result.get(i).getgS02()));
			jo.put("gS03", String.valueOf(result.get(i).getgS03()));
			jo.put("gS08", String.valueOf(result.get(i).getgS08()));
			jo.put("gB02", String.valueOf(result.get(i).getgB02()));
			jo.put("Sg05", String.valueOf(result.get(i).getSg05()));

			json.put(jo);			
		}

		return json.toString();
	}
	@RequestMapping(value = "/loadnewwaterdata.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadnewwaterdata() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanWater> result =new ArrayList<BeanWater>();
		try {
			result=ids.loadnewwaterdata();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//排序
		for(int i=0;i<result.size();i++){
			BeanWater bg=new BeanWater();
			int max=i;
		
			
			long diffent;
			for(int j=i;j<result.size();j++){
				diffent=result.get(max).getTime().getTime()-result.get(j).getTime().getTime();
				if(diffent<0){
					max=j;
					
				}
			}
			bg=result.get(max);
			result.set(max, result.get(i));
			result.set(i, bg);
			
		}
		
		
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("stationId", result.get(i).getStationId());
			jo.put("stationname", result.get(i).getStationname());
			jo.put("time", String.valueOf(result.get(i).getTime()));
			jo.put("w011",String.valueOf(result.get(i).getW011()) );
			jo.put("w001", String.valueOf(result.get(i).getW001()));
			jo.put("wB01", String.valueOf(result.get(i).getwB01()));
			jo.put("w060", String.valueOf(result.get(i).getW060()));
			jo.put("w065", String.valueOf(result.get(i).getW065()));
			jo.put("w42", String.valueOf(result.get(i).getW42()));
			json.put(jo);			
		}


		return json.toString();
	}
	@RequestMapping(value = "/loadoldwaterdata.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadoldwaterdata(@RequestBody String params) throws JSONException{
		JSONArray jsonarray = new JSONArray();
		JSONObject json = new JSONObject(params);
		Timestamp start=Timestamp.valueOf(json.getString("start"));
		Timestamp end=Timestamp.valueOf(json.getString("end"));
		int StationId=json.getInt("StationId");
		int endnum;
		List<BeanWater> result =new ArrayList<BeanWater>();
		try {
			result=ids.loadwaterdata(StationId, start, end);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.size()<100){
			endnum=result.size();
		}else{
			endnum=100;
		}
		for(int i=0;i<endnum;i++){
			JSONObject jo = new JSONObject();
			jo.put("stationId", result.get(i).getStationId());
			jo.put("stationname", result.get(i).getStationname());
			jo.put("time", String.valueOf(result.get(i).getTime()));
			jo.put("w011",String.valueOf(result.get(i).getW011()) );
			jo.put("w001", String.valueOf(result.get(i).getW001()));
			jo.put("wB01", String.valueOf(result.get(i).getwB01()));
			jo.put("w060", String.valueOf(result.get(i).getW060()));
			jo.put("w065", String.valueOf(result.get(i).getW065()));
			jo.put("w42", String.valueOf(result.get(i).getW42()));
			jsonarray.put(jo);			
		}
		return jsonarray.toString();
	}
	@RequestMapping(value = "/loadoldgasdata.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadoldgasdata(@RequestBody String params) throws JSONException{
		
		JSONArray jsonarray = new JSONArray();
		JSONObject json = new JSONObject(params);

		Timestamp start=Timestamp.valueOf(json.getString("start"));
		Timestamp end=Timestamp.valueOf(json.getString("end"));
		int endnum;
		int StationId=json.getInt("StationId");

		List<BeanGas> result =new ArrayList<BeanGas>();
		try {
			result=ids.loadgasdata(StationId, start, end);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.size()<100){
			endnum=result.size();
		}else{
			endnum=100;
		}
		for(int i=0;i<endnum;i++){
			JSONObject jo = new JSONObject();
			jo.put("stationId", result.get(i).getStationId());
			jo.put("stationname", result.get(i).getStationname());
			jo.put("time", String.valueOf(result.get(i).getTime()));
			jo.put("g02", String.valueOf(result.get(i).getG02()));
			jo.put("g01",String.valueOf( result.get(i).getG01()));
			jo.put("g03",String.valueOf( result.get(i).getG03()));
			jo.put("g01Zs",String.valueOf( result.get(i).getG01Zs()));
			jo.put("g02Zs",String.valueOf( result.get(i).getG02Zs()));
			jo.put("g03Zs",String.valueOf( result.get(i).getG03Zs()));
			jo.put("gS01", String.valueOf(result.get(i).getgS01()));
			jo.put("gS02", String.valueOf(result.get(i).getgS02()));
			jo.put("gS03", String.valueOf(result.get(i).getgS03()));
			jo.put("gS08", String.valueOf(result.get(i).getgS08()));
			jo.put("gB02", String.valueOf(result.get(i).getgB02()));
			jo.put("Sg05", String.valueOf(result.get(i).getSg05()));
			jsonarray.put(jo);			
		}
		return jsonarray.toString();
	}
	@RequestMapping(value = "/loaddata.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loaddata(@RequestBody String params) throws JSONException{
		JSONArray jsonarray = new JSONArray();
		JSONObject json = new JSONObject(params);
		int StationId=json.getInt("StationId");
		String InfectCode=json.getString("InfectCode");
		Timestamp start=Timestamp.valueOf(json.getString("start"));
		Timestamp end=Timestamp.valueOf(json.getString("end"));
		List<BeanData> result =new ArrayList<BeanData>();
		try {
			result=ids.loaddate(StationId, InfectCode,start,end);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("mTime", result.get(i).getmTime());
			jo.put("InfectCode",result.get(i).getInfectCode());
			jo.put("InfectValue",String.valueOf(result.get(i).getInfectValue()));
			jsonarray.put(jo);
		}
		return jsonarray.toString();
	}
		
		
}

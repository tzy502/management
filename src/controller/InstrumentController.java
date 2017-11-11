package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanInstrument;
import serviceI.IInstrumentService;
import util.BaseException;

@Controller
public class InstrumentController {
	@Autowired
	private IInstrumentService iis;
	static Map<Integer,String> staus=new HashMap<Integer,String>(5);
	static {
		staus.put(1, "正常");
		staus.put(2, "出错");
		staus.put(3, "维修");	
		}
	@RequestMapping(value = "/addinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addinstrument (BeanInstrument bi,HttpServletRequest request) throws NumberFormatException, JSONException, UnsupportedEncodingException{
		String buy=request.getParameter("buy");
		buy+=" 00:00:00";
		bi.setBuytime(Timestamp.valueOf(buy));
		String name=new String(bi.getInstrumentname().getBytes("ISO-8859-1"),"UTF-8"); 
		bi.setInstrumentname(name);
		bi.setStatus(1);
		try {
			iis.addInstrument(bi);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifryinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String modifryinstrument (BeanInstrument bi,HttpServletRequest request) throws NumberFormatException, JSONException, UnsupportedEncodingException{
		String name=new String(bi.getInstrumentname().getBytes("ISO-8859-1"),"UTF-8"); 
		bi.setInstrumentname(name);
		String buy=request.getParameter("buy");
		System.out.println(buy+"123");
		buy+="00:00:00";
		String calibration=request.getParameter("calibration");
		calibration+="00:00:00";
		String first=request.getParameter("first");
		System.out.println(first);
		first+="00:00:00";
		System.out.println(first);
		String last=request.getParameter("last");
		last+="00:00:00";
		bi.setBuytime(Timestamp.valueOf(buy));
		bi.setFirstusetime(Timestamp.valueOf(first));
		bi.setLastusetime(Timestamp.valueOf(last));
		bi.setCalibrationtime(Timestamp.valueOf(calibration));
		
		try {
			iis.modifryInstrument(bi);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/delinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delinstrument (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("instrumentId"));
		try {
			iis.DelInstrument(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	@RequestMapping(value = "/searchinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String searchinstrument (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("instrumentId"));
		JSONObject jo = new JSONObject();
		BeanInstrument result=new BeanInstrument();
		try {
			result=iis.SearchInstrument(id);
			jo.put("instrumentId", result.getInstrumentId());
			jo.put("instrumentname", result.getInstrumentname());
			jo.put("buytime", result.getBuytime());
			jo.put("firstusetime", result.getFirstusetime());
			jo.put("lastusetime", result.getLastusetime());
			jo.put("calibrationtime", result.getCalibrationtime());
			jo.put("status", result.getStatus());
			jo.put("calibrationcycle", result.getCalibrationcycle());	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return jo.toString();
	}
	@RequestMapping(value = "/loadinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String loadinstrument (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarraylist = new JSONArray();
		List<BeanInstrument> result =new ArrayList<BeanInstrument>();
		try {
			result=iis.loadAllInstrument();
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("instrumentId", result.get(i).getInstrumentId());
				jo.put("instrumentname", result.get(i).getInstrumentname());
				jo.put("buytime", result.get(i).getBuytime());
				if(result.get(i).getFirstusetime()==null){
					jo.put("firstusetime","暂未");
				}else{
					jo.put("firstusetime", result.get(i).getFirstusetime());
				}			

				if(result.get(i).getFirstusetime()==null){
					jo.put("calibrationtime","暂未");
				}else{
					jo.put("calibrationtime", result.get(i).getCalibrationtime());
				}	
				
				if(result.get(i).getFirstusetime()==null){
					jo.put("lastusetime","暂未");
				}else{
					jo.put("lastusetime", result.get(i).getLastusetime());
				}	
				jo.put("status", staus.get(result.get(i).getStatus()));
				jo.put("calibrationcycle", result.get(i).getCalibrationcycle());				
				jsonarraylist.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarraylist.toString();
	}
	@RequestMapping(value = "/useinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public void useinstrument (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("instrumentId"));

		try {
			BeanInstrument bi=iis.SearchInstrument(id);
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date()); 
			if(bi.getFirstusetime()==null){
				bi.setFirstusetime(Timestamp.valueOf(now));
				bi.setLastusetime(Timestamp.valueOf(now));
			}else{
				bi.setLastusetime(Timestamp.valueOf(now));
			}
			iis.modifryInstrument(bi);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/calibrationinstrument.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public void calibrationinstrument (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
	
		int id=Integer.valueOf(json.getString("instrumentId"));
		try {
			BeanInstrument bi=iis.SearchInstrument(id);
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date()); 
			bi.setCalibrationtime(Timestamp.valueOf(now));
			iis.modifryInstrument(bi);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

		
}

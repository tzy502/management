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

import model.BeanCaruse;
import serviceI.ICaruseService;
import util.BaseException;

@Controller
public class CaruseController {
	@Autowired
	private ICaruseService iss;
	@RequestMapping(value = "/addcaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addcaruse(BeanCaruse bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		String caruseuser=new String(bc.getCaruseuser().getBytes("ISO-8859-1"),"UTF-8"); 
		String begin=new String(bc.getBegin().getBytes("ISO-8859-1"),"UTF-8"); 
		String end=new String(bc.getEnd().getBytes("ISO-8859-1"),"UTF-8"); 
		String begintime=request.getParameter("time");
		System.out.println(begintime);
		begintime+=" 00:00:00";
		bc.setCarId(carId);
		bc.setBegintime(Timestamp.valueOf(begintime));
		bc.setBegin(begin);
		bc.setEnd(end);
		bc.setCaruseuser(caruseuser);		
		try {
			iss.addCaruse(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrycaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrycaruse(BeanCaruse bc,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String carId=new String(bc.getCarId().getBytes("ISO-8859-1"),"UTF-8"); 
		String caruseuser=new String(bc.getCaruseuser().getBytes("ISO-8859-1"),"UTF-8"); 
		String begin=new String(bc.getBegin().getBytes("ISO-8859-1"),"UTF-8"); 
		String end=new String(bc.getEnd().getBytes("ISO-8859-1"),"UTF-8"); 
		String remark=null;
		System.out.println(bc.getRemark());
		if(bc.getRemark()!=null){
			
			remark=new String(bc.getRemark().getBytes("ISO-8859-1"),"UTF-8"); 
			bc.setRemark(remark);
		}
		String begintime=request.getParameter("begintime1");
		begintime+=" 00:00:00";
		String endtime=request.getParameter("endtime1");
		if(endtime!=null){
			bc.setEndtime(Timestamp.valueOf(endtime));
		}
		bc.setCarId(carId);
		bc.setBegintime(Timestamp.valueOf(begintime));
		bc.setBegin(begin);
		bc.setEnd(end);

		bc.setCaruseuser(caruseuser);
		
		try {
			iss.modifryCaruse(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delcaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delcaruse(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("caruseId"));
			iss.DelCaruse(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/endcaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String endcaruse(@RequestBody String params) throws JSONException{
		try {
			BeanCaruse bc=new BeanCaruse();
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("caruseId"));
			bc=iss.SearchCaruse(id);
			bc.setEndtime(new Timestamp(System.currentTimeMillis()));
			iss.modifryCaruse(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllcaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllcaruse(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		String id=js.getString("carId");
		JSONArray json = new JSONArray();
		List<BeanCaruse> result =new ArrayList<BeanCaruse>();
		try {
			result=iss.loadAllCaruse(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("caruseId", result.get(i).getCaruseId());
				jo.put("caruseuser", result.get(i).getCaruseuser());
				jo.put("begintime", result.get(i).getBegintime());
				jo.put("endtime", result.get(i).getEndtime());
				jo.put("begin", result.get(i).getBegin());
				jo.put("end", result.get(i).getEnd());
				jo.put("remark", result.get(i).getRemark());
				jo.put("carId", result.get(i).getCarId());				
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json.toString();
	}
	@RequestMapping(value = "/searchcaruse.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchcaruse(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("caruseId"));
		BeanCaruse result=new BeanCaruse();
		JSONObject jo = new JSONObject();
		try {
			result=iss.SearchCaruse(id);	
			jo.put("caruseId", result.getCaruseId());
			jo.put("caruseuser", result.getCaruseuser());
			jo.put("begintime", result.getBegintime());
			jo.put("endtime", result.getEndtime());
			jo.put("begin", result.getBegin());
			jo.put("end", result.getEnd());
			jo.put("remark", result.getRemark());
			jo.put("carId", result.getCarId());	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import model.BeanEquipment;
import model.BeanTrain;
import serviceI.ITrainService;
import serviceI.ITrainlogService;
import serviceI.ITrainuserService;
import util.BaseException;

@Controller
public class TrainController {
	@Autowired
	private ITrainService its;
	@Autowired
	private ITrainuserService itus;
	@Autowired
	private ITrainlogService itls;
	@RequestMapping(value = "/addTrain.do", produces = "application/json; charset=utf-8") 
	public String addTrain(BeanTrain bt,HttpServletRequest request) throws JSONException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		String begin=request.getParameter("begin");
		String end=request.getParameter("end");
		bt.setBegintime(sdf.parse(begin));
		bt.setEndtime(sdf.parse(end));
		try {
			its.addTrain(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifryTrain.do", produces = "application/json; charset=utf-8") 
	public String modifryTrain(BeanTrain bt,HttpServletRequest request) throws JSONException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
		String begin=request.getParameter("begin");
		String end=request.getParameter("end");
		bt.setBegintime(sdf.parse(begin));
		bt.setEndtime(sdf.parse(end));
		try {
			its.modifryTrain(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delTrain.do", produces = "application/json; charset=utf-8") 
	public String delTrain(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("trainId"));
		try {
			its.DelTrain(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/endTrain.do", produces = "application/json; charset=utf-8") 
	public String endTrain(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("trainId"));
		String result=json.getString("trainId");
		Date now=new Date();
		
		try {
			BeanTrain bt=new BeanTrain();
			bt=its.SearchTrain(id);
			bt.setEndtime(now);
			bt.setResult(result);
			its.modifryTrain(bt);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/loadTrain.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadTrain() throws JSONException, ParseException{
		JSONArray jsonarrary = new JSONArray();
		List<BeanTrain> result =new ArrayList<BeanTrain>();
		try {
			result=its.loadAllTrain();
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("trainId", result.get(i).getTrainId());
				jo.put("trainname", result.get(i).getTrainname());
				jo.put("begintime", result.get(i).getBegintime());
				jsonarrary.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonarrary.toString();
	}
	@RequestMapping(value = "/searchTrain.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchTrain(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("trainId"));
		BeanTrain result =new BeanTrain();
		JSONObject jo = new JSONObject();
		try {
			result=its.SearchTrain(id);
		
			jo.put("trainId", result.getTrainId());
			jo.put("trainname", result.getTrainname());
			jo.put("begintime", result.getBegintime());
			jo.put("endtime", result.getEndtime());
			jo.put("detail", result.getDetail());
			if(result.getResult()==null){
				jo.put("result","");
			}else{
				jo.put("result",result.getResult());
			}
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jo.toString();
	}
}

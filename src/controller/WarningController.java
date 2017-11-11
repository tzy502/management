package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import daoI.IInfectDao;
import model.BeanWarning;
import serviceI.IStationService;
import serviceI.IWarningService;
import util.BaseException;

@Controller
public class WarningController {
	@Autowired
	private IWarningService iws;
	@Resource
	private IInfectDao iid;
	@Autowired
	private IStationService iss;
	Map<String, String>  Infect =new HashMap<String, String>();
	@RequestMapping(value = "/loadwarning.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadwarning(@RequestBody String params)throws JSONException{
		JSONObject json = new JSONObject(params);
		String strstart=json.getString("start");
		Timestamp start;
		if(strstart.equals("")==true){
			start=Timestamp.valueOf("2000-1-1 00:00:00");
			System.out.println(start);
		}else{
			start=Timestamp.valueOf(strstart);
			System.out.println(start);
		}
		String strend=json.getString("end");
		Timestamp end;
		if(strend.equals("")==true){
			end=Timestamp.valueOf("2050-1-1 00:00:00");
			System.out.println(end);
		}else{
			 end=Timestamp.valueOf(strend);
			 System.out.println(end);
		}
		Infect=iid.loadAllInfect();
		List<BeanWarning>  result =new ArrayList<BeanWarning>();
		JSONArray jsonarraylist = new JSONArray();
		try {
			result=iws.loadAllWarning(start,end);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("warningId", result.get(i).getWarningId());
				jo.put("stationId", result.get(i).getStationId());
				jo.put("stationname", iss.SearchStation(result.get(i).getStationId()).getStationname());
				jo.put("InfectCode", Infect.get(result.get(i).getInfectCode()));
				if(result.get(i).getType()==1){
					jo.put("type", "报警");
				}
				else{
					jo.put("type", "预警");
				}
				
				jo.put("warningtime", result.get(i).getWarningtime());
				jsonarraylist.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonarraylist.toString();
	}
}

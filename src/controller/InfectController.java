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

import model.BeanInfect;
import service.InfectService;
import service.StationService;
import util.BaseException;

@Controller
public class InfectController {
	@Autowired
	private InfectService ifs;
	@Autowired
	private StationService iss;
	@RequestMapping(value = "/loadInfect.do" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String loadAllequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarrary = new JSONArray();
		JSONObject json = new JSONObject(params);
		int stationId =Integer.valueOf(json.getString("stationId"));
		List<BeanInfect> result =new ArrayList<BeanInfect>();
		try {
			if(iss.SearchStation(stationId).getType().equals("31")){
				result=ifs.load(32);
			}
			else{
				result=ifs.load(31);
			}
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("InfectName", result.get(i).getInfectName());
			jo.put("InfectCode", result.get(i).getInfectCode());
			jsonarrary.put(jo);
		}
		return jsonarrary.toString();
	
	}
}

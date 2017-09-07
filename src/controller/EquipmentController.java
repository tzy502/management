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

import model.BeanEquipment;
import serviceI.IEquipmentService;
import util.BaseException;

@Controller
public class EquipmentController {
	@Autowired 
	private IEquipmentService ies;
	@RequestMapping("loadAllequipment.do")
	@ResponseBody
	public String loadAllequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarrary = new JSONArray();
		JSONObject json = new JSONObject(params);
		int stationId =Integer.valueOf(json.getString("stationId"));
		
		List<BeanEquipment> result =new ArrayList<BeanEquipment>();
		
		try {
			result=ies.loadAllEquipment(stationId);
			System.out.println(result.size());
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("equipmentid", result.get(i).getEquipmentid());
				jo.put("stationid",  result.get(i).getStationid());
				jo.put("model",  result.get(i).getModel());
				jo.put("grade",  result.get(i).getGrade());
				jo.put("number",  result.get(i).getNumber());
				jo.put("effect",  result.get(i).getEffect());
				jsonarrary.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonarrary.toString();
	
	}
	@RequestMapping("modifryequipment.do")
	@ResponseBody
	public void modifryequipment (BeanEquipment be) throws NumberFormatException, JSONException{
		try {
			System.out.println(be.getEquipmentid());
			
			ies.modifryEquipment(be);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("addequipment.do")
	@ResponseBody
	public void addequipment (BeanEquipment be) throws NumberFormatException, JSONException{
		try {
			System.out.println("addqeuas;djfnajsdof");
			ies.addEquipment(be);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("delequipment.do")
	@ResponseBody
	public void delequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarrary = new JSONArray();
		JSONObject json = new JSONObject(params);
		int equipmentid =Integer.valueOf(json.getString("equipmentid"));
		System.out.println(equipmentid);
		try {
			ies.DelEquipment(equipmentid);
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("Searchequipment.do")
	@ResponseBody
	public String  Searchequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarrary = new JSONArray();
		JSONObject json = new JSONObject(params);
		int equipmentid =Integer.valueOf(json.getString("equipmentid"));
		JSONObject jo = new JSONObject();
		System.out.println(equipmentid);
		try {
			BeanEquipment be=new BeanEquipment();
			be=ies.SearchEquipment(equipmentid);
			
			jo.put("equipmentid", be.getEquipmentid());
			jo.put("stationid",  be.getStationid());
			jo.put("model",  be.getModel());
			jo.put("grade",  be.getGrade());
			jo.put("number",  be.getNumber());
			jo.put("effect",  be.getEffect());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

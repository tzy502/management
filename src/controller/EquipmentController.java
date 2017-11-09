package controller;

import java.io.UnsupportedEncodingException;
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
	@RequestMapping(value = "loadAllequipment.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String loadAllequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONArray jsonarrary = new JSONArray();
		JSONObject json = new JSONObject(params);
		int stationId =Integer.valueOf(json.getString("stationId"));
		
		List<BeanEquipment> result =new ArrayList<BeanEquipment>();
		
		try {
			result=ies.loadAllEquipment(stationId);

			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("equipmentid", result.get(i).getEquipmentid());
				jo.put("stationId",  result.get(i).getStationId());
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
	public String modifryequipment (BeanEquipment be) throws NumberFormatException, JSONException, UnsupportedEncodingException{
		try {
			String effect=new String(be.getEffect().getBytes("ISO-8859-1"),"UTF-8"); 
			be.setEffect(effect);
			ies.modifryEquipment(be);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());

			return jo.toString();
		}
		return null;
	}
	@RequestMapping("addequipment.do")
	@ResponseBody
	public String addequipment (BeanEquipment be) throws NumberFormatException, JSONException, UnsupportedEncodingException{
		try {
			String effect=new String(be.getEffect().getBytes("ISO-8859-1"),"UTF-8"); 
			be.setEffect(effect);
			
			ies.addEquipment(be);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());

			return jo.toString();
		}
		return null;
	}
	@RequestMapping("delequipment.do")
	@ResponseBody
	public void delequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
		int equipmentid =Integer.valueOf(json.getString("equipmentid"));

		try {
			ies.DelEquipment(equipmentid);
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "Searchequipment.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String  Searchequipment (@RequestBody String params) throws NumberFormatException, JSONException{
		JSONObject json = new JSONObject(params);
		int equipmentid =Integer.valueOf(json.getString("equipmentid"));
		JSONObject jo = new JSONObject();

		try {
			BeanEquipment be=new BeanEquipment();
			be=ies.SearchEquipment(equipmentid);
			
			jo.put("equipmentid", be.getEquipmentid());
			jo.put("stationId",  be.getStationId());
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

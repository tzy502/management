package controller;

import java.io.UnsupportedEncodingException;
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

import model.BeanCompany;
import model.BeanMaterial;
import model.BeanMaterial;
import serviceI.IMaterialService;
import util.BaseException;

@Controller
public class MaterialController {
	@Autowired
	private IMaterialService ims;
	@RequestMapping(value = "/addMaterial.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addMaterial(BeanMaterial bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String Materialname=new String (bm.getMaterialname().getBytes("ISO-8859-1"),"UTF-8");
		String Materialuse=new String (bm.getMaterialuse().getBytes("ISO-8859-1"),"UTF-8");
		bm.setMaterialname(Materialname);
		bm.setMaterialuse(Materialuse);
		bm.setMaterialover(0);
		try {
			ims.addMaterial(bm,request.getParameter("userId"));
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifryMaterialover.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryMaterialover(BeanMaterial bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			ims.modifryMaterialover(bm,request.getParameter("userId"));		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/modifryMaterial.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryMaterial(BeanMaterial bm,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		String Materialname=new String (bm.getMaterialname().getBytes("ISO-8859-1"),"UTF-8");
		String Materialuse=new String (bm.getMaterialuse().getBytes("ISO-8859-1"),"UTF-8");
		bm.setMaterialname(Materialname);
		bm.setMaterialuse(Materialuse);	
		try {
			ims.modifryMaterial(bm);		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/delMaterial.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delMaterial(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("materialId"));
			ims.DelMaterial(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}
	@RequestMapping(value = "/loadMaterial.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadMaterial() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanMaterial> result =new ArrayList<BeanMaterial>();
		try {
			result=ims.loadAllMaterial();
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("materialId", result.get(i).getMaterialId());
				jo.put("materialname", result.get(i).getMaterialname());
				jo.put("materialover", result.get(i).getMaterialover());
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();	
	}
	@RequestMapping(value = "/SearchMaterial.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchMaterial(@RequestBody String params) throws JSONException{
	
		JSONObject jo = new JSONObject();
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("materialId"));
		BeanMaterial result =new BeanMaterial();
		try {
			result=ims.SearchMaterial(id);
	
			jo.put("materialId", result.getMaterialId());
			jo.put("materialname", result.getMaterialname());
			jo.put("materialuse", result.getMaterialuse());
			jo.put("materialover", result.getMaterialover());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return jo.toString();	
	}
}

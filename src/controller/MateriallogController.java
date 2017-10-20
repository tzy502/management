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
import model.BeanMaterialLog;
import model.BeanMaterial;
import serviceI.IMaterialLogService;
import serviceI.IMaterialService;
import serviceI.IUserService;
import util.BaseException;

@Controller
public class MateriallogController {
	@Autowired
	private IMaterialLogService imls;
	@Autowired
	private IMaterialService ims;
	@Autowired
	private IUserService ius;
	@RequestMapping(value = "/loaduserMateriallog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loaduserMateriallog(@RequestBody String params) throws JSONException{
		JSONArray jsonarry = new JSONArray();
		JSONObject json = new JSONObject(params);
		String id=json.getString("userId");
		List<BeanMaterialLog> result =new ArrayList<BeanMaterialLog>();
		try {
			result=imls.loadUserMaterialLog(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("materialname",ims.SearchMaterial(result.get(i).getMaterialId()).getMaterialname());
				jo.put("username", ius.searchUser(id).getUserName());
				jo.put("num", result.get(i).getNum());
				jo.put("date", result.get(i).getDate());
				jsonarry.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarry.toString();	
	}
	@RequestMapping(value = "/loadMaterialMateriallog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadMaterialMateriallog(@RequestBody String params) throws JSONException{
		JSONArray jsonarry = new JSONArray();
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("materialId"));
		List<BeanMaterialLog> result =new ArrayList<BeanMaterialLog>();
		try {
			result=imls.loadMaterialMaterialLog(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("materialname",ims.SearchMaterial(result.get(i).getMaterialId()).getMaterialname());
				jo.put("userId",ius.searchUser(result.get(i).getUserId()).getUserName() );
				if(result.get(i).getNum()<0){
					jo.put("num", "取出了"+(-1*result.get(i).getNum())+"件");
				}else{
					jo.put("num", "新增了"+result.get(i).getNum()+"件");
				}
				jo.put("date", result.get(i).getDate());
				jsonarry.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarry.toString();	
	}
}

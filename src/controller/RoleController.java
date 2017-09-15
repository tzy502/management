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

import model.BeanRole;
import service.RoleService;
import serviceI.IRoleService;
import util.BaseException;

@Controller
public class RoleController {
	@Autowired
	private IRoleService irs;
	@RequestMapping(value = "/addRole.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addRole(@RequestBody String params) throws JSONException{
		System.out.println("正在添加 来自c");
		JSONObject json = new JSONObject(params);
		String rolename=json.getString("roleName");
		String roleIntroduction=json.getString("roleIntroduction");
		int level=Integer.valueOf((String)json.get("level"));
		try {
			irs.addRole(rolename,roleIntroduction,level);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());
			System.out.println(jo.toString());
			return jo.toString();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllRole.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllRole() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanRole> result =new ArrayList<BeanRole>();
		try {
			result=irs.loadAllRole();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("roleId", result.get(i).getRoleId());
			jo.put("roleName", result.get(i).getRoleName());
			jo.put("level", result.get(i).getLevel());
			if(result.get(i).getRoleIntroduction()==null){
				jo.put("roleIntroduction", "");	
			}
			else{
				jo.put("roleIntroduction", result.get(i).getRoleIntroduction());
			}
			json.put(jo);
		}
		
		return json.toString();
	}
	@RequestMapping(value = "/delRole.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delRole(@RequestBody String params) throws JSONException{
		JSONObject jsonobject = new JSONObject(params);
		int roleId=Integer.valueOf((String)jsonobject.get("roleId"));
		System.out.println("from c role    "+roleId);
		try {
			irs.DelRole(roleId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonobject.toString();
	}
	@RequestMapping(value = "/SearchlRole.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchRole(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		System.out.println("searchRole");
		int roleId=Integer.valueOf((String)json.get("roleId"));
		BeanRole br=new BeanRole();
		try {
			br=irs.SearchRole(roleId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		jo.put("roleId", br.getRoleId());
		jo.put("roleName", br.getRoleName());
		jo.put("level", br.getLevel());
		if(br.getRoleIntroduction()==null){
			jo.put("roleIntroduction", "");	
		}
		else{
			jo.put("roleIntroduction", br.getRoleIntroduction());
		}
		return jo.toString();
	}
	@RequestMapping(value = "/modifryRole.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryRole(@RequestBody String params) throws JSONException{
		System.out.println("search");
		JSONObject json = new JSONObject(params);
		int roleId=Integer.valueOf((String)json.get("roleId"));		
		String rolename=json.getString("roleName");
		String roleIntroduction=json.getString("roleIntroduction");
		int level=Integer.valueOf((String)json.get("level"));
		try {
			irs.modifryRole(roleId, rolename,roleIntroduction, level);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("msg", e.getMessage());
			System.out.println(jo.toString());
			return jo.toString();
		}
		return null;
		
	}
}

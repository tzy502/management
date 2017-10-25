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

import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;

@Controller
public class ProjectController {
	@Autowired
	private IProjectService ips;
	@RequestMapping(value = "/addproject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addproject(BeanProject bp) throws JSONException, UnsupportedEncodingException{
		try {
			
			String projectname=new String(bp.getProjectname().getBytes("ISO-8859-1"),"UTF-8"); 
			bp.setProjectname(projectname);
			ips.addProject(bp);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifryproject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryproject(BeanProject bp) throws JSONException, UnsupportedEncodingException{
		try {
			String projectname=new String(bp.getProjectname().getBytes("ISO-8859-1"),"UTF-8"); 
			bp.setProjectname(projectname);
			ips.modifryProject(bp);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delproject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delproject(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("projectId"));
			ips.DelProject(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllproject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllproject() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanProject> result =new ArrayList<BeanProject>();
		try {
			result=ips.loadAllProject();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("projectId", result.get(i).getProjectId());
			jo.put("projectname", result.get(i).getProjectname());

			json.put(jo);
		}
		return json.toString();
	}
	@RequestMapping(value = "/searchproject.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchproject(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("projectId"));
		BeanProject result=new BeanProject();
		JSONObject jo = new JSONObject();
		try {
			result=ips.SearchProject(id);		
			jo.put("projectId", result.getProjectId());
			jo.put("projectname", result.getProjectname());

		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return jo.toString();
	}
}

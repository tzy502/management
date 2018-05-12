package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
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

import model.BeanPeople;
import serviceI.IPeopleService;
import util.BaseException;

@Controller
public class PeopleController {
	@Autowired
	private IPeopleService ips;
	@RequestMapping(value = "/addpeople.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addpeople(BeanPeople bp,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			
			String department=new String(bp.getDepartment().getBytes("ISO-8859-1"),"UTF-8"); 
			String post=new String(bp.getPost().getBytes("ISO-8859-1"),"UTF-8"); 
			String name=new String(bp.getName().getBytes("ISO-8859-1"),"UTF-8"); 
			String education=new String(bp.getEducation().getBytes("ISO-8859-1"),"UTF-8"); 
			String profession=new String(bp.getProfession().getBytes("ISO-8859-1"),"UTF-8"); 
			String graduationschool=new String(bp.getGraduationschool().getBytes("ISO-8859-1"),"UTF-8"); 
			String job=new String(bp.getJob().getBytes("ISO-8859-1"),"UTF-8"); 
			bp.setPost(post);
			bp.setName(name);
			bp.setEducation(education);
			bp.setProfession(profession);
			bp.setGraduationschool(graduationschool);
			bp.setJob(job);
			bp.setDepartment(department);
			String entrytime=request.getParameter("entry");
			entrytime+=" 00:00:00";
			bp.setEntrytime(Timestamp.valueOf(entrytime));
			String graduationtime=request.getParameter("graduation");
			graduationtime+=" 00:00:00";
			System.out.print(graduationtime);
			
			bp.setGraduationtime(Timestamp.valueOf(graduationtime));
			ips.addPeople(bp);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrypeople.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrypeople(BeanPeople bp,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			String department=new String(bp.getDepartment().getBytes("ISO-8859-1"),"UTF-8"); 
			String post=new String(bp.getPost().getBytes("ISO-8859-1"),"UTF-8"); 
			String name=new String(bp.getName().getBytes("ISO-8859-1"),"UTF-8"); 
			String education=new String(bp.getEducation().getBytes("ISO-8859-1"),"UTF-8"); 
			String profession=new String(bp.getProfession().getBytes("ISO-8859-1"),"UTF-8"); 
			String graduationschool=new String(bp.getGraduationschool().getBytes("ISO-8859-1"),"UTF-8"); 
			String job=new String(bp.getJob().getBytes("ISO-8859-1"),"UTF-8"); 
			bp.setPost(post);
			bp.setName(name);
			bp.setEducation(education);
			bp.setProfession(profession);
			bp.setGraduationschool(graduationschool);
			bp.setJob(job);
			bp.setDepartment(department);
			String entrytime=request.getParameter("entry");
			entrytime+=" 00:00:00";
			bp.setEntrytime(Timestamp.valueOf(entrytime));
			String graduationtime=request.getParameter("graduation");
			graduationtime+=" 00:00:00";
			bp.setGraduationtime(Timestamp.valueOf(graduationtime));
			ips.modifryPeople(bp);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delpeople.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delpeople(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("peopleId"));
			ips.DelPeople(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllpeople.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllpeople() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanPeople> result =new ArrayList<BeanPeople>();
		try {
			result=ips.loadAllPeople();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("peopleId", result.get(i).getPeopleId());
			jo.put("department", result.get(i).getDepartment());
			jo.put("post", result.get(i).getPost());
			jo.put("name", result.get(i).getName());

			json.put(jo);
		}
		return json.toString();
	}
	@RequestMapping(value = "/searchpeople.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchpeople(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("peopleId"));
		BeanPeople result=new BeanPeople();
		JSONObject jo = new JSONObject();
		try {
			result=ips.SearchPeople(id);		
			jo.put("peopleId", result.getPeopleId());
			jo.put("department", result.getDepartment());
			jo.put("post", result.getPost());
			jo.put("name", result.getName());
			jo.put("gender", result.getGender());
			jo.put("entrytime", result.getEntrytime());
			jo.put("education", result.getEducation());
			jo.put("profession", result.getProfession());
			jo.put("graduationtime", result.getGraduationtime());
			jo.put("graduationschool", result.getGraduationschool());
			jo.put("job", result.getJob());
			jo.put("IDcard", result.getIDcard());
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return jo.toString();
	}
}

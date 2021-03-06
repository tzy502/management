package controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import daoI.IStationDao;
import model.BeanAssess;
import model.BeanMission;
import model.BeanTimer;
import model.BeanUser;
import serviceI.IMissionService;
import serviceI.IRoleService;
import serviceI.ITimerService;
import serviceI.IUserService;
import timer.Timing;
import util.BaseException;

@Controller  
public class UserController {
	@Autowired
	private IUserService IUserService;
	@Autowired
	private  IStationDao isd;
	@Autowired
	private  ITimerService its;
	@Autowired
	private  IMissionService ims;
	@Autowired
	private  IRoleService irs;
	//登录
	@RequestMapping(value = "/login.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String login(@RequestBody String params) throws JSONException{  
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		String password = (String) json.get("password");
		JSONObject jo = new JSONObject();
		BeanUser user = new BeanUser();
		try {

			user = IUserService.login(userId, password);
			jo.put("msg","succ");
			jo.put("userId", user.getUserId());
			jo.put("level",irs.SearchRole(user.getRoleId()).getLevel());
			jo.put("userName", user.getUserName());
			jo.put("userPhone", user.getUserPhone());
			jo.put("userMail", user.getUserMail());
			jo.put("rolename", irs.SearchRole(user.getRoleId()).getRoleName());
		} catch (BaseException e) {
			// TODO �Զ����ɵ� catch ��
			jo.put("msg", e.getMessage());
			return jo.toString(); 
		}

		return jo.toString(); 
	}



	//修改用户
	@RequestMapping(value = "/updateUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updateUser(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		String userName = (String) json.get("userName");
		int roleId = Integer.valueOf((String) json.get("roleId"));
		String userPhone = (String) json.get("userPhone");
		String userMail = (String) json.get("userMail");
		JSONObject jo = new JSONObject();
		try {
			IUserService.updateUser(userId,userName, roleId , userPhone,userMail);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}

	//查找用户
	@RequestMapping(value = "/searchUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchUser(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		BeanUser user = null;
		try {
			user = IUserService.searchUser(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("userId", user.getUserId());
		jo.put("userName", user.getUserName());
		jo.put("userPhone", user.getUserPhone());
		jo.put("roleId", user.getRoleId());
		jo.put("userMail", user.getUserMail());
		jo.put("msg", "succ");
		return jo.toString();  
	}


	/** 导出所有用户
	 * 发送：user
	 * */
	@RequestMapping(value = "/loadAllUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllUser() throws JSONException{
		List<BeanUser> users = null;
		JSONArray json = new JSONArray();
		try {
			users = IUserService.loadAllUser();
			
			for(int i = 0; i < users.size(); i++){
				JSONObject jo = new JSONObject();
				jo.put("userId", users.get(i).getUserId());
				jo.put("userName", users.get(i).getUserName());
				jo.put("userRole", users.get(i).getRoleId());
				jo.put("userRoleName", irs.SearchRole(users.get(i).getRoleId()).getRoleName());
				jo.put("userPhone", users.get(i).getUserPhone());
				jo.put("userMail", users.get(i).getUserMail());
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return json.toString();
	}

	/** 删除用户 
	 * 接收：userId
	 * 发送：succ(成功)
	 * */
	@RequestMapping(value = "/deleteUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String deleteUser(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		try {
			IUserService.delUser(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}

	/** 
	 *	注册
	 * */
	@RequestMapping(value = "/register.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String register(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		String userName = (String) json.get("userName");
		
		String userPhone = (String) json.get("userPhone");
		String password = (String) json.get("password");
		String userMail = (String) json.get("userMail");
		JSONObject jo = new JSONObject();
		try {
			IUserService.register(userId, password, userName, 2, userPhone,userMail);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}

	//重置密码
	@RequestMapping(value = "/resetPassword.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String resetPassword(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		try {
			IUserService.resetPassword(userId);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}

	//修改密码
	@RequestMapping(value = "/changePassword.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String changePassword(@RequestBody String params) throws JSONException{
		
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		String oldPassword = (String) json.get("oldPassword");
		String newPassword = (String) json.get("newPassword");
		
		JSONObject jo = new JSONObject();
		try {
			IUserService.changePassword(userId, oldPassword, newPassword);
		} catch (BaseException e) {
			// TODO 自动生成的 catch 块
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		jo.put("msg", "succ");
		return jo.toString();  
	}

	@RequestMapping(value = "/loadmain.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadmain(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		String userId = (String) json.get("userId");
		JSONObject jo = new JSONObject();
		try {
			int newmission=ims.loaduserMission(userId, 1).size();
			int newautomission=ims.loaduserMission(userId, 2).size();
			int newwarning=ims.loaduserMission(userId, 3).size();
			int unfinish=ims.loadunfinishMission(userId).size();
			int newmessage=ims.loadnewMission(userId).size();
			jo.put("newmission", newmission);
			jo.put("newautomission", newautomission);
			jo.put("newwarning", newwarning);
			jo.put("unfinish", unfinish);
			jo.put("newmessage", newmessage);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			jo.put("msg", e.getMessage());
			return jo.toString();
		}
		return jo.toString();
	}
	@RequestMapping(value = "/AssessUser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String AssessUser(@RequestBody String params) throws JSONException{  
		List<BeanUser> users;
		JSONObject json = new JSONObject(params);
		String userId = json.getString("userId");
		int year=Integer.valueOf(json.getString("year"));
		int date=Integer.valueOf(json.getString("date"));
		BeanAssess ba=IUserService.AssessUser(userId, year, date);
		BeanUser user;
		JSONObject jo = new JSONObject();
		try {
			user = IUserService.searchUser(userId);
			String str=ba.getStr()+user.getUserName()+"用户一共运维"+ba.getChecklist()+"次，同时给此用户布置了"+ba.getTotal()+"次运维任务，其中"+ba.getFinish()+"件任务已经完成；"
					+ba.getOverfinish()+"件任务超时完成完成；目前仍有"+ba.getUnfinish()+"件任务未完成；同时"+ba.getOverunfiish()+"件任务已超过预先规定结束时间但并未完成";
			jo.put("userName", user.getUserName());
			jo.put("total", ba.getTotal());
			jo.put("finish", ba.getFinish());
			jo.put("overfinish", ba.getOverfinish());
			jo.put("unoverfinish", ba.getOverunfiish());
			jo.put("unfinish", ba.getUnfinish());
			jo.put("str", str);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jo.toString());
			return jo.toString();
	}
	
	
}


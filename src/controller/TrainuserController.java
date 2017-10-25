package controller;

import java.sql.Timestamp;
import java.text.ParseException;
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

import model.BeanTrainuser;
import serviceI.ITrainService;
import serviceI.ITrainuserService;
import serviceI.IUserService;
import util.BaseException;

@Controller
public class TrainuserController {
	@Autowired
	private ITrainService its;
	@Autowired
	private ITrainuserService itus;
	@Autowired
	private IUserService ius;
	@RequestMapping(value = "/addtrainuser.do", produces = "application/json; charset=utf-8") 
	public String addtrainuser(BeanTrainuser btl,HttpServletRequest request) throws JSONException{		
		try {
			itus.addTrainuser(btl);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrytrainuser.do", produces = "application/json; charset=utf-8") 
	public String modifrytrainuser(BeanTrainuser btl,HttpServletRequest request) throws JSONException{		
		try {
			itus.modifryTrainuser(btl);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delTrainuser.do", produces = "application/json; charset=utf-8") 
	public String delTrainuser(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("trainId"));
		System.out.println(id);
		try {
			itus.DelTrainuser(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	@RequestMapping(value = "/loadTrainuser.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadTrainuser(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		JSONArray jsonarrary = new JSONArray();
		int id=Integer.valueOf(json.getString("trainId"));
		try {
			List<BeanTrainuser> result =new ArrayList<BeanTrainuser>();
			result=itus.loadAllTrainuser(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("trainuserId", result.get(i).getTrainuserId());
				jo.put("trainId", result.get(i).getTrainId());
				jo.put("userId", result.get(i).getUserId());
				jo.put("username", ius.searchUser(result.get(i).getUserId()).getUserName());
				jsonarrary.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarrary.toString();
	}
}

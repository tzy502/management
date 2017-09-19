package controller;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanChecklist;
import serviceI.IChecklistService;
import util.BaseException;


@Controller
public class ChecklistController {
	@Autowired
	private IChecklistService ics;
	@RequestMapping(value = "/addChecklist.do") 
	@ResponseBody
	public String addChecklist(BeanChecklist bc) throws JSONException, UnsupportedEncodingException{
		try {
			String input=new String(bc.getChecklistinput().getBytes("ISO-8859-1"),"UTF-8"); 
		
			bc.setChecklistinput(input);
			ics.addChecklist(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifryChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifryChecklist(BeanChecklist bc) throws JSONException{
		try {
			bc.setStationId(ics.SearchChecklist(bc.getChecklistId()).getStationId());
			ics.modifryChecklist(bc);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/searchChecklist.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchChecklist(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("checklistId"));
		JSONObject jo = new JSONObject();
		BeanChecklist result=new BeanChecklist();
		try {
			result=ics.SearchChecklist(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jo.put("checklistId", result.getChecklistId());
		jo.put("Checklisttime",result.getChecklisttime());
		jo.put("Checklisttype", result.getChecklisttype());
		jo.put("checklistcheckbox", result.getChecklistcheckbox());
		jo.put("checklistinput", result.getChecklistinput());
		jo.put("StationId", result.getStationId());
		jo.put("userId", 	result.getUserId());
		return jo.toString();
	}
}

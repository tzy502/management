package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import model.BeanTrain;
import model.BeanTrainlog;
import serviceI.ITrainService;
import serviceI.ITrainlogService;
import util.BaseException;

@Controller
public class TrainlogController {
	@Autowired
	private ITrainService its;
	@Autowired
	private ITrainlogService itls;
	@RequestMapping(value = "/addtrainlog.do", produces = "application/json; charset=utf-8") 
	public String addtrainlog(BeanTrainlog btl,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{		
		btl.setTraintime(Timestamp.valueOf(request.getParameter("time")));
		String traindetail=new String(btl.getTraindetail().getBytes("ISO-8859-1"),"UTF-8"); 
		btl.setTraindetail(traindetail);
		try {
			itls.addTrainlog(btl);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrytrainlog.do", produces = "application/json; charset=utf-8") 
	public String modifrytrainlog(BeanTrainlog btl,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{		
		btl.setTraintime(Timestamp.valueOf(request.getParameter("time")));
		String traindetail=new String(btl.getTraindetail().getBytes("ISO-8859-1"),"UTF-8"); 
		btl.setTraindetail(traindetail);
		try {
			itls.modifryTrainlog(btl);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delTrainlog.do", produces = "application/json; charset=utf-8") 
	public String delTrainlog(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("trainId"));
		System.out.println(id);
		try {
			itls.DelTrainlog(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	@RequestMapping(value = "/loadTrainlog.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadTrainlog(@RequestBody String params) throws JSONException, ParseException{
		JSONObject json = new JSONObject(params);
		JSONArray jsonarrary = new JSONArray();
		int id=Integer.valueOf(json.getString("trainId"));
		try {
			List<BeanTrainlog> result =new ArrayList<BeanTrainlog>();
			result=itls.loadAllTrainlog(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("trainlogId", result.get(i).getTrainlogId());
				jo.put("trainId", result.get(i).getTrainId());
				jo.put("traintime", result.get(i).getTraintime().toString());
				jo.put("traindetail", result.get(i).getTraindetail());		
				jsonarrary.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarrary.toString();
	}
}

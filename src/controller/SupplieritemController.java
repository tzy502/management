package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import model.BeanSupplieritem;
import serviceI.ISupplieritemService;
import util.BaseException;

@Controller
public class SupplieritemController {
	@Autowired
	private ISupplieritemService iss;
	@RequestMapping(value = "/addsupplieritem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addsupplieritem(BeanSupplieritem bs,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			bs.setSupplieritemtime(Timestamp.valueOf(request.getParameter("time")));
			String supplieritemtassess=new String(bs.getSupplieritemtassess().getBytes("ISO-8859-1"),"UTF-8");
			String supplieritemname=new String(bs.getSupplieritemname().getBytes("ISO-8859-1"),"UTF-8"); 
			bs.setSupplieritemname(supplieritemname);
			bs.setSupplieritemtassess(supplieritemtassess);
			iss.addSupplieritem(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrysupplieritem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrysupplieritem(BeanSupplieritem bs,HttpServletRequest request) throws JSONException, UnsupportedEncodingException{
		try {
			bs.setSupplieritemtime(Timestamp.valueOf(request.getParameter("time")));
			String supplieritemtassess=new String(bs.getSupplieritemtassess().getBytes("ISO-8859-1"),"UTF-8");
			String supplieritemname=new String(bs.getSupplieritemname().getBytes("ISO-8859-1"),"UTF-8"); 
			bs.setSupplieritemname(supplieritemname);
			bs.setSupplieritemtassess(supplieritemtassess);
			iss.modifrySupplieritem(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delsupplieritem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delsupplieritem(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("supplieritemId"));
			iss.DelSupplieritem(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllsupplieritem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllsupplieritem(@RequestBody String params) throws JSONException{
		JSONObject js = new JSONObject(params);
		int id=Integer.valueOf(js.getString("supplierId"));
		JSONArray json = new JSONArray();
		List<BeanSupplieritem> result =new ArrayList<BeanSupplieritem>();
		try {
			result=iss.loadAllSupplieritem(id);
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("supplieritemId", result.get(i).getSupplieritemId());
				jo.put("supplierId", result.get(i).getSupplierId());
				jo.put("supplieritemname", result.get(i).getSupplieritemname());
				jo.put("supplieritemprice", String.valueOf(result.get(i).getSupplieritemprice()));
				jo.put("supplieritemtime", result.get(i).getSupplieritemtime());
				jo.put("supplieritemtassess", result.get(i).getSupplieritemtassess());		
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json.toString();
	}
	@RequestMapping(value = "/searchsupplieritem.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchsupplieritem(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("supplieritemId"));
		BeanSupplieritem result=new BeanSupplieritem();
		JSONObject jo = new JSONObject();
		try {
			result=iss.SearchSupplieritem(id);		
			jo.put("supplieritemId", result.getSupplieritemId());
			jo.put("supplierId", result.getSupplierId());
			jo.put("supplieritemname", result.getSupplieritemname());
			jo.put("supplieritemprice", String.valueOf(result.getSupplieritemprice()));
			jo.put("supplieritemtime", result.getSupplieritemtime());
			jo.put("supplieritemtassess", result.getSupplieritemtassess());		
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}

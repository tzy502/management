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

import model.BeanSupplier;
import serviceI.ISupplierService;
import util.BaseException;

@Controller
public class SupplierController {
	@Autowired
	private ISupplierService iss;
	@RequestMapping(value = "/addsupplier.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addsupplier(BeanSupplier bs) throws JSONException, UnsupportedEncodingException{
		try {
			
			String suppliername=new String(bs.getSuppliername().getBytes("ISO-8859-1"),"UTF-8"); 
			String supplieraddress=new String(bs.getSupplieraddress().getBytes("ISO-8859-1"),"UTF-8");
			String supplieruser=new String(bs.getSupplieruser().getBytes("ISO-8859-1"),"UTF-8");
			bs.setSupplieraddress(supplieraddress);
			bs.setSupplieruser(supplieruser);
			bs.setSuppliername(suppliername);
			iss.addSupplier(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/modifrysupplier.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String modifrysupplier(BeanSupplier bs) throws JSONException, UnsupportedEncodingException{
	
		try {
			String suppliername=new String(bs.getSuppliername().getBytes("ISO-8859-1"),"UTF-8"); 
			String supplieraddress=new String(bs.getSupplieraddress().getBytes("ISO-8859-1"),"UTF-8");
			String supplieruser=new String(bs.getSupplieruser().getBytes("ISO-8859-1"),"UTF-8");
			bs.setSupplieraddress(supplieraddress);
			bs.setSupplieruser(supplieruser);
			bs.setSuppliername(suppliername);
			iss.modifrySupplier(bs);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/delsupplier.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String delsupplier(@RequestBody String params) throws JSONException{
		try {
			JSONObject json = new JSONObject(params);
			int id=Integer.valueOf(json.getString("supplierId"));
			iss.DelSupplier(id);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadAllsupplier.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllsupplier() throws JSONException{
		JSONArray json = new JSONArray();
		List<BeanSupplier> result =new ArrayList<BeanSupplier>();
		try {
			result=iss.loadAllSupplier();
			for(int i=0;i<result.size();i++){
				JSONObject jo = new JSONObject();
				jo.put("supplierId", result.get(i).getSupplierId());
				jo.put("suppliername", result.get(i).getSuppliername());
				jo.put("supplierTEL", result.get(i).getSupplierTEL());
				jo.put("supplieraddress", result.get(i).getSupplieraddress());
				jo.put("supplieruser", result.get(i).getSupplieruser());			
				json.put(jo);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json.toString();
	}
	@RequestMapping(value = "/searchsupplier.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchsupplier(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int id=Integer.valueOf(json.getString("supplierId"));
		BeanSupplier result=new BeanSupplier();
		JSONObject jo = new JSONObject();
		try {
			result=iss.SearchSupplier(id);		
			jo.put("supplierId", result.getSupplierId());
			jo.put("suppliername", result.getSuppliername());
			jo.put("supplierTEL", result.getSupplierTEL());
			jo.put("supplieraddress", result.getSupplieraddress());
			jo.put("supplieruser", result.getSupplieruser());	
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return jo.toString();
	}
}

package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import model.BeanDocument;
import model.BeanRole;
import service.RoleService;
import serviceI.IDocumentService;
import serviceI.IRoleService;
import util.BaseException;

@Controller
public class DocumentController {
	@Autowired
	private IDocumentService ids;
	@RequestMapping("uploadDocument.do")
	@ResponseBody
	public void upload(HttpServletRequest request)throws ServletException, IOException{
		
		System.out.println(request.getParameter("documentname"));
		System.out.println(request.getParameter("level"));
		//文件上传下载
		 long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        String path=null;
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                { 	
                	
                    path="E:/"+new String( file.getOriginalFilename() .getBytes("iso8859-1") , "utf-8"); 
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
            
            try {
				ids.addDocument(request.getParameter("documentname"), path, Integer.valueOf(request.getParameter("level")));
			} catch (NumberFormatException | BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
		
		
	}
	@RequestMapping(value = "/loaddoc.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loaddoc(@RequestBody String params) throws JSONException{
		JSONArray jsonarrary = new JSONArray();
		System.out.println("loaddoc");
		JSONObject json = new JSONObject(params);
		int level=Integer.valueOf((String)json.get("level"));
		BeanDocument bd=new BeanDocument();		
		List<BeanDocument> result=new ArrayList<BeanDocument>();
		try {
			result=ids.loadDocument(level);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("documentid", result.get(i).getDocumentid());
			jo.put("documentname", result.get(i).getDocumentname());
			jo.put("path", result.get(i).getPath());
			jo.put("level", result.get(i).getlevel());
			jsonarrary.put(jo);
		}
		return jsonarrary.toString();
	}
	@RequestMapping("download.do")
	@ResponseBody
	public ResponseEntity<byte[]> download(HttpServletRequest request)throws ServletException, IOException{
		int docid=Integer.valueOf(request.getParameter("documentid"));
		
		String path=null;
		try {
			path = ids.SearchDocument(docid).getPath();
			String name=ids.SearchDocument(docid).getDocumentname();
			String fileExtName = path.substring(path.lastIndexOf("."));
			name=name+fileExtName;
			File file=new File(path);
			
			HttpHeaders headers = new HttpHeaders();    
			String fileName=new String(name.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
			headers.setContentDispositionFormData("attachment", fileName);   
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
					headers, HttpStatus.CREATED);  
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		return null;
	}
	@RequestMapping(value = "/SearchDoc.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String SearchDoc(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int documentid=Integer.valueOf((String)json.get("documentid"));
		BeanDocument bd=new BeanDocument();
		try {
			bd=ids.SearchDocument(documentid);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		jo.put("documentid", bd.getDocumentid());
		jo.put("documentname", bd.getDocumentname());
		jo.put("path", bd.getPath());
		jo.put("level", bd.getlevel());
				
		return jo.toString();
	}
	@RequestMapping(value = "/modirfyDocument.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public void modirfyDocument(@RequestBody String params,BeanDocument bd,HttpServletRequest reques) throws JSONException{
		try {
			ids.modifryDocument(bd.getDocumentid(), bd.getDocumentname(), bd.getPath(), bd.getlevel());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/delDocument.do", produces = "application/json; charset=utf-8") 
	@ResponseBody 
	public String delDocument(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int documentid=Integer.valueOf((String)json.get("documentid"));
		try {
			ids.DelDocument(documentid);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
}



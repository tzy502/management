<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加项目</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container" id = 'form-item-add'>
	<form class="form form-horizontal" id="add" >
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">项目名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="项目名称" id="projectname" name="projectname">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">成本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label id="total" name=total></label>
		</div>
	</div>
	<input type="hidden" id="projectId" name="projectId">
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
		 <span class="l">
		 <a href="javascript:;" onclick="add()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加成本</a>
	 </span>  
		<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">成本</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="200">名字</th>	
				<th width="200">详细支出</th>	
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-cost'>
		</tbody>		
	</table>

	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">

function GetRequest() {   
	   var url = location.search; 
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}   
var Request = new Object(); 
Request = GetRequest(); 
var projectId =Request['projectId']; 
$(function(){ 
	$('body').on('click','#delete',function(event){
		var costId = this.name;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"costId":costId,
			}
			$.ajax({
				type: 'POST',
				url: "/management/delcost.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
					layer.msg('删除失败!',{icon:1,time:15000});
					window.location.reload();
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.reload();
				},
			});		
		});
	});
	var params={
			"projectId": projectId
	}
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/searchproject.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 	   
	        	$("#projectId").val(data.projectId);
	        	$("#projectname").val(data.projectname);
	        }
	})
	$.ajax({  
		 type: "post",    
	        async: true,    
	        url: "/management/loadAllcost.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 	   
	        	console.log(data)
	        	var str = "";  
	        	var length=data.length
	    		for(var i = 0; i < (length-1); i++){  
	       			str += "<tr class='text-c'>"+
					"<td>"+(i+1)+"</td>"+
					"<td>"+data[i].costname+"</td>"+
					"<td>"+data[i].cost+"</td>"+
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'delete' href='javascript:;' name='"+data[i].costId+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a>"+
					"</td>"
					"</tr>";
					str+=""
					var total="<label>"+data[length-1].total+"元</label>"
	       			$("#tbody-cost").html(str);  
					$("#total").html(total);  
					
	    		}
	        }
	})

}
)
function add(){
	var Request = new Object(); 
	Request = GetRequest(); 
	var projectId =Request['projectId']; 
	var url="cost_add.jsp?projectId="+projectId;
	layer_show('添加成本',url,'400','250');
	
}
</script> 

</body>
</html>
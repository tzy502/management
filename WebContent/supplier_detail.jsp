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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="供应商名称" id="suppliername" name="suppliername">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商地址：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="供应商地址" id="supplieraddress" name="supplieraddress">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商电话：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="供应商电话" id="supplierTEL" name="supplierTEL">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商联系人：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="供应商联系人" id="supplieruser" name="supplieruser">
		</div>
	</div>
	<input type="hidden" id="supplierId" name="supplierId">
<center>
</center>
	</form>
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
	 <span class="l">
		 <a href="javascript:;" onclick="add('添加商品','supplieritem_add.jsp','400','350')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加商品</a>
	 </span>  
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">商品记录</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="150">商品名</th>	
				<th width="150">购买时间</th>	
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-log'>
		</tbody>		
	</table>
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
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i]
					.split("=")[1]);
		}
	}
	return theRequest;
}
var Request = new Object();
Request = GetRequest();
var supplierId = Request["supplierId"];

var params={
		"supplierId":supplierId,

}
	
	$(document).ready(function() {
		$('body').on('click','#delete',function(event){
			var supplieritemId = this.name;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"supplieritemId":supplieritemId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delsupplieritem.do", 
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
		
		
		
	$('body').on('click','#update',function(event){
		layer_show('商品编辑','supplieritem_modifry.jsp?supplieritemId='+this.name,'400','350');
	}); 
	$('body').on('click','#detail',function(event){
		layer_show('商品编辑','supplieritem_detail.jsp?supplieritemId='+this.name,'400','350');
	}); 
		$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/management/searchsupplier.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8", 
	        success: function(data) { 	        	
	        	$("#suppliername").val(data.suppliername);
	        	$("#supplieraddress").val(data.supplieraddress);
	        	$("#supplierTEL").val(data.supplierTEL);
	        	$("#supplieruser").val(data.supplieruser);
	        	$("#supplierId").val(data.supplierId);
	        }	        
		})
		console.log(supplierId)
		var str="";
			$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/management/loadAllsupplieritem.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8", 
	        success: function(data) { 	    
	        	console.log(data)
	        	for(var i = 0; i < data.length; i++){ 
		        	var supplieritemtime=data[i].supplieritemtime;
		        	supplieritemtime=supplieritemtime.replace(/00:00:00.0/,"");
		        	console.log(supplieritemtime)
					str += "<tr class='text-c'>"+
					"<td>"+(i+1)+"</td>"+
					"<td>"+data[i].supplieritemname+"</td>"+
					"<td>"+supplieritemtime+"</td>"+
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'detail' href='javascript:;'title=\"详情\" name='"+data[i].supplieritemId+"'>"+
					"<i class='Hui-iconfont'>&#xe720;</i>"+
					"</a>"+	
					"<a style='text-decoration:none' id = 'update' href='javascript:;'title=\"更新\" name='"+data[i].supplieritemId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
					"</a>"+
					"<a style='text-decoration:none' id = 'delete' href='javascript:;'title=\"删除\" name='"+data[i].supplieritemId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a>"+			

					"</td>"+
					"</tr>";
				
	        	}
	        	
	        	$("#tbody-log").html(str);  
	        }
			})
	})


function add(title,url,w,h){
	url+="?supplierId="+supplierId;
	layer_show(title,url,w,h);
}
</script> 

</body>
</html>
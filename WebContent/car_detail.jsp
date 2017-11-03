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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车牌：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" readonly="readonly" value="" placeholder="车牌" id="carId" name="carId">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车辆类型：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"readonly="readonly"  value="" placeholder="车辆类型" id="cartype" name="cartype">
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>购买价格：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" readonly="readonly" value="" style='width:100%' placeholder="购买价格" id="price" name="price">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>购买时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text"  class="input-text" readonly="readonly" value="" placeholder="购买时间"	id="buy" name="buy">	
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>保险过期时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text"  class="input-text" readonly="readonly" value="" placeholder="保险过期时间" 	id="insurance" name="insurance">	
		</div>
	</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排气量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="number" class="input-text" value="" style='width:100%' placeholder="排气量" id="displacement" name="displacement">
		</div>
	</div>
<div class="mt-15 mb-15">
		<hr/>
	</div>	
	 <span class="l">
		 <a href="javascript:;" onclick="add('新增车辆使用','caruse_add.jsp','400','350')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 新增车辆使用</a>
	 </span>  
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">使用记录</th>
			</tr>
			<tr class="text-c">
				<th width="10%">序号</th>
				<th width="15%">车牌</th>	
				<th width="15%">使用人</th>	
				<th width="25%">开始地点</th>
				<th width="25%">开始时间</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-use'>
		</tbody>		
	</table>
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
	 <span class="l">
		 <a href="javascript:;" onclick="add('添加维修记录','carrepair_add.jsp','400','350')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加维修记录</a>
	 </span>  
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">维修记录</th>
			</tr>
			<tr class="text-c">
				<th width="10%">序号</th>
				<th width="15%">车牌</th>	
				<th width="15%">维修开始时间</th>	
				<th width="15%">维修花费</th>
				<th width="35%">维修原因</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-repair'>
		</tbody>		
	</table>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"	src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
	 url=decodeURI(url)
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
var carId = Request["carId"];
var params={
		"carId":carId,
}
	
$(document).ready(function() {
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/management/searchcar.do",  
        data: JSON.stringify(params),
        dataType: "json", 
        contentType: "application/json; charset=utf-8", 
        success: function(data) { 	        	
			var carbuytime=data.carbuytime;
			carbuytime=carbuytime.replace(/ 00:00:00.0/,"");
			var carinsurancetime=data.carinsurancetime;
			carinsurancetime=carinsurancetime.replace(/ 00:00:00.0/,"");
        	$("#carId").val(data.carId);
        	$("#cartype").val(data.cartype);
        	$("#buy").val(carbuytime);
        	$("#insurance").val(carinsurancetime);
        	$("#displacement").val(data.displacement);
        	$("#price").val(data.price);
        	
        }
	})
		$('body').on('click','#deleteuse',function(event){
			var carId = this.name;
			layer.confirm('确认要删除吗？',function(){
				
				var params={
				    	"caruseId":carId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delcaruse.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
				
						window.location.reload()
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						window.location.reload()
					},
				});		
			});
		});
	$('body').on('click','#enduse',function(event){
		var carId = this.name;
		layer.confirm('车辆已经归还？',function(){

			var params={
			    	"caruseId":carId,
			}
			$.ajax({
				type: 'POST',
				url: "/management/endcaruse.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
			
					window.location.reload()
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.reload()
				},
			});		
		});
	});
	
	
	
		$('body').on('click','#updateuse',function(event){
			layer_show('车辆使用编辑','caruse_modifry.jsp?caruseId='+this.name,'500','450');
		}); 
		$('body').on('click','#detailuse',function(event){
			layer_show('车辆使用详情','caruse_detail.jsp?caruseId='+this.name,'500','450');
		}); 
		
		$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/management/loadAllcaruse.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8", 
			error:function(data) {
			
			},
	        success: function(data) { 	        	
				var str="" 
		    		for(var i = 0; i < data.length; i++){     	
		    			var begintime=data[i].begintime;
		    			begintime=begintime.replace(/ 00:00:00.0/,"");
		       			str += "<tr class='text-c'>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+data[i].carId+"</td>"+
						"<td>"+data[i].caruseuser+"</td>"+
						"<td>"+data[i].begin+"</td>"+
						"<td>"+begintime+"</td>"+			
						"<td class='td-manage'>"+
						"<a style='text-decoration:none' id = 'enduse' href='javascript:;'	title=\"车辆使用完成\" name='"+data[i].caruseId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e4;</i>"+
						"</a>"+
						"<a style='text-decoration:none' id = 'detailuse' href='javascript:;'	title=\"详情\" name='"+data[i].caruseId+"'>"+
						"<i class='Hui-iconfont'>&#xe720;</i>"+
						"</a>"+
						"<a style='text-decoration:none' id = 'updateuse' href='javascript:;' title=\"编辑\" name='"+data[i].caruseId+"'>"+
						"<i class='Hui-iconfont'>&#xe6df;</i>"+
						"</a>"+
						"<a style='text-decoration:none' id = 'deleteuse' href='javascript:;' title=\"删除 \"name='"+data[i].caruseId+"'>"+
							"<i class='Hui-iconfont'>&#xe6e2;</i>"+
						"</a>"+					
						"</td>"
						"</tr>";
						str+=""			
		    		}
				$("#tbody-use").html(str); 
	        }
		});
		//use完成
		$('body').on('click','#deleterepair',function(event){
			var carId = this.name;
			layer.confirm('确认要删除吗？',function(){
		
				var params={
				    	"carrepairId":carId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delcarrepair.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
				
						window.location.reload()
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						window.location.reload()
					},
				});		
			});
		});

	
		$('body').on('click','#updaterepair',function(event){
			layer_show('车辆使用编辑','carrepair_modifry.jsp?carrepairId='+this.name,'500','450');
		}); 
		$('body').on('click','#detailrepair',function(event){
			layer_show('车辆使用详情','carrepair_detail.jsp?carrepairId='+this.name,'500','450');
		}); 
		
		$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/management/loadAllcarrepair.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8", 
			error:function(data) {
			
			},
	        success: function(data) { 	        	
				var str="" 
		    		for(var i = 0; i < data.length; i++){     	
		    			var carrepairtime=data[i].carrepairtime;
		    			carrepairtime=carrepairtime.replace(/ 00:00:00.0/,"");
		       			str += "<tr class='text-c'>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+data[i].carId+"</td>"+
						"<td>"+carrepairtime+"</td>"+	
						"<td>"+data[i].carrepairnumber+"</td>"+
						"<td>"+data[i].carrepairreason+"</td>"+
								
						"<td class='td-manage'>"+
						"<a style='text-decoration:none' id = 'detailrepair' href='javascript:;'	title=\"详情\" name='"+data[i].carrepairId+"'>"+
						"<i class='Hui-iconfont'>&#xe720;</i>"+
						"</a>"+
						"<a style='text-decoration:none' id = 'updaterepair' href='javascript:;' title=\"编辑\" name='"+data[i].carrepairId+"'>"+
						"<i class='Hui-iconfont'>&#xe6df;</i>"+
						"</a>"+
						"<a style='text-decoration:none' id = 'deleterepair' href='javascript:;' title=\"删除 \"name='"+data[i].carrepairId+"'>"+
							"<i class='Hui-iconfont'>&#xe6e2;</i>"+
						"</a>"+					
						"</td>"
						"</tr>";
						str+=""			
		    		}
				$("#tbody-repair").html(str); 
	        }
		});
})

function add(title,url,w,h){
	var Id=encodeURIComponent(carId);
	console.log(carId+"   "+Id)
	url+="?carId="+Id;
	layer_show(title,url,w,h);
	
}
</script> 

</body>
</html>
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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>培训名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="培训名称" id="trainname" name="trainname">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开始时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" value="" placeholder="开始时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd '})"
					id="begin" name="begin">	
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>结束时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<input type="text" style='width:40%' class="input-text" value="" placeholder="结束时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd '})"	
					id="end" name="end">	
		</div>
	</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>详情：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea name="detail" id='detail'  cols="" rows="" class="textarea" ></textarea>					
		</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>结果：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea name="result" id='result'  cols="" rows="" class="textarea" ></textarea>					
		</div>
	</div>
		<div class="row cl">
		<div class="form-label col-xs-4 col-sm-3">
			<input class="btn btn-primary radius" type="button" onclick="end()"
				value="&nbsp;&nbsp;结束项目&nbsp;&nbsp;">			
		</div>
	</div>
	<input type="hidden" id="trainId" name="trainId">
	</form>
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
		 <span class="l">
		 <a href="javascript:;" onclick="add('添加参与人员','trainuser_add.jsp','400','250')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加培训计划</a>
	 </span>  
		<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">参与人员</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="200">姓名</th>	
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-user'>
		</tbody>		
	</table>
	<div class="mt-15 mb-15">
		<hr/>
	</div>	
	 <span class="l">
		 <a href="javascript:;" onclick="add('添加培训计划','trainlog_add.jsp','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加培训计划</a>
	 </span>  
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">培训记录</th>
			</tr>
			<tr class="text-c">
				<th width="40">序号</th>
				<th width="150">时间</th>	
				<th width="150">记录</th>	
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody id = 'tbody-log'>
		</tbody>		
	</table>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
	$('body').on('click','#deletelog',function(event){
		var trainId = this.name;
		
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"trainId":trainId,
			}
			console.log(params)
			$.ajax({
				type: 'POST',
				url: "/management/delTrainlog.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
					layer.msg('删除失败!',{icon:1,time:15000});
					window.location.reload()
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.reload()
				},
			});		
		});
	});
	$('body').on('click','#deleteuser',function(event){
		var trainId = this.name;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"trainId":trainId,
			}
			console.log(params)
			$.ajax({
				type: 'POST',
				url: "/management/delTrainuser.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
					layer.msg('删除失败!',{icon:1,time:15000});
					window.location.reload()
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.reload()
				},
			});		
		});
	});
	$(document)	.ready(function() {
		
		var Request = new Object();
		Request = GetRequest();
		var trainId = Request['trainId'];
		
		var params = {
			"trainId" : trainId,
		}
		$.ajax({
			type : "post",
			async : true,
			url : "/management/searchTrain.do",
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				$("#trainId").val(data.trainId);
				$("#trainname").val(data.trainname);
    			var begintime=data.begintime;
    			begintime=begintime.replace(/00:00:00.0/,"");
				$("#begin").val(begintime);
    			var endtime=data.endtime;
    			endtime=endtime.replace(/00:00:00.0/,"");
				$("#end").val(endtime);
				$("#detail").val(data.detail);
				$("#result").val(data.result);
				
			},
			error : function(data) {
				console.log(data.msg);
			},
		});
	
		var str="";
		$.ajax({
			type : "post",
			async : true,
			url : "/management/loadTrainlog.do",
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				for(var i = 0; i < data.length; i++){   
	    			var traintime=data[i].traintime;
	    			traintime=traintime.replace(/00:00:00.0/,"");
					str += "<tr class='text-c'>"+
					"<td>"+(i+1)+"</td>"+
					"<td>"+traintime+"</td>"+
					"<td>"+data[i].traindetail+"</td>"+
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'deletelog' href='javascript:;' name='"+data[i].trainlogId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a>"+			
					"</td>"+
					"</tr>";
				}
				$("#tbody-log").html(str);  
				
			},
			error : function(data) {
				console.log(data.msg);
			},
		});
		var userstr=""
		$.ajax({
			type : "post",
			async : true,
			url : "/management/loadTrainuser.do",
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				for(var i = 0; i < data.length; i++){   
					userstr += "<tr class='text-c'>"+
					"<td>"+(i+1)+"</td>"+
					"<td>"+data[i].username+"</td>"+
					"<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'deleteuser' href='javascript:;' name='"+data[i].trainuserId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a>"+			
					"</td>"+
					"</tr>";
				}
				$("#tbody-user").html(userstr);  
			},
			error : function(data) {
				console.log(data.msg);
			},
		});
	})
	function add(title,url,w,h){		
		var Request = new Object();
		Request = GetRequest();
		var trainId = Request['trainId'];
		url=url+"?trainId="+trainId;
		layer_show(title,url,w,h);
	
}
	function end(){
		var Request = new Object();
		Request = GetRequest();
		var trainId = Request['trainId'];
		var url="train_end.jsp?trainId="+trainId;	
		layer_show("结束总结",url,300,200);
		
	}
</script> 

</body>
</html>
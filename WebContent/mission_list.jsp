+<%@ page language="java" contentType="text/html; charset=utf-8"
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 运维任务  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<article class="page-container" id = 'form-item-add'>
	<div class="text-c" id="serachdiv" name="serachdiv">
	
			<select class="select"  style='width:10%' 	name="city" id="city"></select>市
			<select class="select"  style='width:10%' 	name="area" id="area"></select>区
		<button type="submit" class="btn btn-success size-S" id="search" name="search" onclick = "search();"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	
	</div>
	<br/>
		<ul id="Huifold1" name="Huifold1" class="Huifold">

		</ul>
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
function getCookie(Name){
	var search = Name + "="//查询检索的值
	   var returnvalue = "";//返回值
	   if (document.cookie.length > 0) {
	     sd = document.cookie.indexOf(search);
	     if (sd!= -1) {
	        sd += search.length;
	        end = document.cookie.indexOf(";", sd);
	        if (end == -1)
	         end = document.cookie.length;
	         //unescape() 函数可对通过 escape() 编码的字符串进行解码。
	        returnvalue=unescape(document.cookie.substring(sd, end))
	      }
	   } 
	   return returnvalue;
}
	$('body').on('click','#update',function(event){
		layer_show('运维任务修改','mission_modifry.jsp?missionId='+this.name,'800','500');
	}); 
	$('body').on('click','#detail',function(event){	
		layer_show('运维任务详情','mission_detail.jsp?missionId='+this.name,'800','500');
	}); 
	$('body').on('click','#delete',function(event){
		var missionId = this.name;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"missionId":missionId,
			}
			$.ajax({
				type: 'POST',
				url: "/management/delMission.do", 
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				error:function(data) {
					layer.msg('删除失败!',{icon:1,time:15000});
				},
				success: function(data){
					layer.msg('已删除!',{icon:1,time:15000});
					window.location.href = 'mission_list.jsp';
				},
			});		
		});
	});

	$(document).ready(function (){		
		var level =getCookie("level");
		if(level==1){
			
			$.ajax({    
		        type: "post",    
		        async: false,    
		        url: "/management/loadcityandarea.do",  
		        dataType: "json", 
		        contentType: "application/json; charset=utf-8",   
		        error: function(data){  
		        	alert("出错了！！:"+data.msg);
		        } , 
		        success: function(data) { 
		        	console.log(data)
		        	var str = ""; 
					str += "<option value='all' selected> 请选择</option>"
		        	for(var i=0;i<data[0].length;i++){
						str += "<option value='"+data[0][i].area+"' >"
						+ data[0][i].area
						+ "</option>"
		        	}
		        	$("#area").html(str);  
		        	 str = ""; 
						str += "<option value='all' selected> 请选择</option>"
		        	for(var i=0;i<data[1].length;i++){
						str += "<option value='"+data[1][i].city+"' >"
						+ data[1][i].city
						+ "</option>"
		        	}
		        	$("#city").html(str);  
		        }
		    });
			adminlist()
		}else{
			$("#serachdiv").css("display","none");
			userlist()
		
		}
		
		

	})
	function search(){

		adminlist()
	}
	
	function userlist(){
		var str="";
		str+="<table class='table table-border table-bordered table-bg'>"
			+"<thead>"
			+"<tr class='text-c'>"
			+"<th width='5%'>编号</th>"
			+"<th width='15%'>负责人</th>"		
			+"<th width='30%'>运维任务名</th>"			
			+"<th width='20%'>预计结束时间</th>"	
			+"<th width='20%'>状态</th>"
			+"<th width='10%'>操作</th>"
			+"</tr>"
			+"</thead>";
			var userId = getCookie("userId");
			var params={
			    	"userId":userId,
			}
		$.ajax({    
	        type: "post",    
	        async: false,    
	        url: "/management/loadUserMission.do",  
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) {         
	    		for(var k=0;k<data.length;k++){
	    			str+="<tr class='text-c'>"+
	    			"<td>"+(k+1)+"</td>"+
	    			"<td>"+data[k].username+"</td>"+
	    			"<td>"+data[k].missionname+"</td>"+
	    			"<td>"+data[k].enddate+"</td>"+
	    			"<td>"+data[k].statusname+"</td>"+
	    			"<td class='td-manage'>"+
	    			"<a style='text-decoration:none' id = 'detail' href='javascript:;' name='"+data[k].Missionid+"'>"+
	    				"<i class='Hui-iconfont'>&#xe720;</i>"+
	    			"</a>"+
	    				"</td>"
	    			+"</tr>"
	    		}
	      		str+="</table>"
	    		} 	
	       
	    });
		 $("#Huifold1").html(str);
	}
	function adminlist(){
		
		var params = {
				"city":$("#city").val(),
				"area":$("#area").val(),
		}	


	//加载页面数据
	 station=[];
		var str = "";  
	$.ajax({    
        type: "post",    
        async: false,    
        url: "/management/loadStation.do",  
		data : JSON.stringify(params),
		dataType : "json",
		contentType : "application/json; charset=utf-8", 
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	for(var i = 0; i < data.length; i++){
					station.push(data[i]);	
					
        	}
        	
        }
    });	
	console.log(station)
	var mission=[];
	$.ajax({    
        type: "post",    
        async: false,    
        url: "/management/loadALLMission.do",  
		data : JSON.stringify(params),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) {         
        	for(var i = 0; i < data.length; i++){     		
        			mission.push(data[i]);
        	 	}
        	
        }
    });
	console.log(mission)
	for(var i = 0; i < station.length; i++){
		 str+="<li class='item'>"
				+"<h4>"+station[i].stationname+"<b>+</b></h4>"
			    +"<div class='info'>"
				+"<div class=\"cl pd-5 bg-1 bk-gray mt-20\">"
				+" <span class=\"l\">"
				+"	 <a href=\"javascript:;\" onclick=\"add('"+station[i].stationId+"')\" class=\"btn btn-primary radius\"><i class=\"Hui-iconfont\">&#xe600;</i> 添加运维任务</a>"
				+"	 <a href=\"javascript:;\" onclick=\"history('"+station[i].stationId+"')\" class=\"btn btn-primary radius\"> 历史记录</a>"

				+" </span>"  
				+"  </div>"
			    
			    
		var item = -1;
		for(var j = 0; j < mission.length; j++){	
			if(station[i].stationId==mission[j][0].stationId){
				item=1;
				break;
			}	
		}

		if(mission[j][0].Missionid!=0){
		str+="<table class='table table-border table-bordered table-bg'>"
		+"<thead>"
		+"<tr class='text-c'>"
		+"<th width='5%'>编号</th>"
		+"<th width='15%'>负责人</th>"		
		+"<th width='30%'>运维任务名</th>"			
		+"<th width='20%'>预计结束时间</th>"	
		+"<th width='20%'>状态</th>"
		+"<th width='10%'>操作</th>"
		+"</tr>"
		+"</thead>"
		for(var k=0;k<mission[j].length;k++){
			str+="<tr class='text-c'>"+
			"<td>"+(k+1)+"</td>"+
			"<td>"+mission[j][k].username+"</td>"+
			"<td>"+mission[j][k].missionname+"</td>"+
			"<td>"+mission[j][k].enddate+"</td>"+
			"<td>"+mission[j][k].statusname+"</td>"+
			"<td class='td-manage'>"+
			"<a style='text-decoration:none' id = 'detail' href='javascript:;' name='"+mission[j][k].Missionid+"'>"+
				"<i class='Hui-iconfont'>&#xe720;</i>"+
			"</a>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' name='"+mission[j][k].Missionid+"'>"+
				"<i class='Hui-iconfont'>&#xe6df;</i>"+
			"</a>"+
				"<a style='text-decoration:none' id = 'delete' href='javascript:;' name='"+mission[j][k].Missionid+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
				"</a>"+
				"</td>"

			+"</tr>"
		}
  		str+="</table>"
		}
		else{
			
			str+="暂无运维任务"
			
		}
		
  		str+="</div>"
    		+" </li>" ;	
	}

	$("#Huifold1").html(str);  
	$(function(){
		$.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",1,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
	});
	}	
	
function add(stationId){
	var url="mission_add.jsp?StationId="+stationId;	
	layer_show("添加文档",url,800,500);
	
}
function history(stationId){
	var url="mission_history.jsp?StationId="+stationId;	
	layer_show("添加文档",url,800,500);
	
}
</script> 

</body>
</html>
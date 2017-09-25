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
	function checklisttable(checklist){
		var String=""
		for(var i;i<checklist.length;i++)
		return String;
	}
	$(document).ready(function (){

		$('body').on('click','#delete',function(event){
			var StationId = this.title;
			layer.confirm('确认要删除吗？',function(){
				var params={
				    	"StationId":StationId,
				}
				$.ajax({
					type: 'POST',
					url: "/management/delStation.do", 
					data: JSON.stringify(params),
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					error:function(data) {
						layer.msg('删除失败!',{icon:1,time:15000});
						window.location.href = 'station_list.jsp';
					},
					success: function(data){
						layer.msg('已删除!',{icon:1,time:15000});
						window.location.href = 'station_list.jsp';
					},
				});		
			});
		});
		
		
	
	$('body').on('click','#update',function(event){
		layer_show('检测站编辑','station_modifry.jsp?stationid='+this.title,'800','500');
	}); 
	$('body').on('click','#datail',function(event){
		layer_show('检测站详情','station_detail.jsp?stationid='+this.title,'800','500');
	}); 
	//加载页面数据
	 station=[];
		var str = "";  
	$.ajax({    
        type: "post",    
        async: false,    
        url: "/management/loadgasStation.do",  
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	for(var i = 0; i < data.length; i++){
					station.push(data[i]);	
					
        	}
        	
        }
    });

	var allchecklist=[];
	var params = {
			"type" : 31,
		}
	$.ajax({    
        type: "post",    
        async: false,    
        url: "/management/loadChecklist.do",  
		data : JSON.stringify(params),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        
        	for(var i = 0; i < data.length; i++){     		
        		allchecklist.push(data[i]);	    		
    	}
        	
        }
    });

	for(var i = 0; i < station.length; i++){
		 str+="<li class='item'>"
				+"<h4>"+station[i].stationname+"<b>+</b></h4>"
			    +"<div class='info'>"
			    
		var item = -1;
		for(var j = 0; j < allchecklist.length; j++){	
			if(station[i].stationId==allchecklist[j][0].stationId){					
				break;
			}	
		}
		if(allchecklist[j][0].checklistId!=0){
		str+="<table class='table table-border table-bordered table-bg'>"
		+"<thead>"
		+"<tr class='text-c'>"
		+"<th width='40%'>文档名(最新创建)</th>"
		+"<th width='40%'>最后编写时间</th>"		
		+"<th width='10%'>编辑人</th>"			
		+"<th width='10%'>操作</th>"
		+"</tr>"
		+"</thead>"
		for(var k=0;k<allchecklist[j].length;k++){
			str+="<tr class='text-c'>"+
			"<td>"+allchecklist[j][k].Checklisttypename+"</td>"+
			"<td>"+allchecklist[j][k].Checklisttime+"</td>"+
			"<td>"+allchecklist[j][k].userId+"</td>"+
			"<td class='td-manage'>"+
			"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+allchecklist[j][k].checklistId+"'>"+
			"<i class='Hui-iconfont'>&#xe6df;</i>"+
			"</a>"+
			"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+allchecklist[j][k].checklistId+"'>"+
				"<i class='Hui-iconfont'>&#xe6e2;</i>"+
			"</a>"+
			"</td>"
			+"</tr>"
		}
  		str+="</table>"
		}
		else{
			str+="暂无数据"
		}
		
  		str+="</div>"
    		+" </li>" ;	
	}

	$("#Huifold1").html(str);  
	$(function(){
		$.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",1,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
	});

})
	/*


		  
		    <h4>标题3<b>+</b></h4>
		    <div class="info">asfdasdfas</div>
		  </li>
	
	*/

function add(title,url,w,h){
	layer_show(title,url,w,h);
	
}
</script> 

</body>
</html>
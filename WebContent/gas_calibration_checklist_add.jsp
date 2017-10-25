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
<title></title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
<table class="table table-border table-bordered" id = 'checklist'>
 	 <tr>
    <td width="75">站点名称 </td>
    <td width="270" colspan="6"><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'></td>
    <td width="81" colspan="4">校准时间 </td>
    <td width="265" colspan="6"><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'> </td>
  </tr>
  <tr>
    <td width="75">测量单元 </td>
    <td width="80"> 设备厂家 </td>
    <td width="190" colspan="5"><input type='text' value=''  id = 'input1' class='input-text radius size-S'></td>
    <td width="81" colspan="4">设备型号 </td>
    <td width="137" colspan="5"><input type='text' value=''id = 'input2' class='input-text radius size-S'></td>
    <td width="128">校准结论 </td>
  </tr>
  <tr>
    <td width="75" rowspan="5"><strong>SO2</strong><br />
      传感器 </td>
    <td width="81" colspan="2">检测原理 </td>
    <td width="81" colspan="2"><input type='text' value=''  id = 'input3' class='input-text radius size-S'></td>
    <td width="81">测量量程 </td>
    <td width="81" colspan="2"><input type='text' value='' id = 'input4' class='input-text radius size-S'></td>
    <td width="81" colspan="6">测量单位 </td>
    <td width="82" colspan="2"><input type='text' value='' id = 'input5' class='input-text radius size-S'></td>
    <td width="128" rowspan="5">&nbsp;
		<textarea name="" id='input8' cols="" rows="" class="textarea" ></textarea>
     	 校准系数： <br />
        K:<input type='text' value='' id = 'input6' class='input-text radius size-S'>
        b:<input type='text' value='' id = 'input7' class='input-text radius size-S'>
              </td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">零点校准 </td>
    <td width="125" colspan="2">零气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input8' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input9' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input10' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">量程校准 </td>
    <td width="125" colspan="2">标气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input11' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input12' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input13' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="75" rowspan="5"><strong>NO</strong><br />
      传感器 </td>
    <td width="80">检测原理 </td>
    <td width="82" colspan="3"><input type='text' value=''  id = 'input14' class='input-text radius size-S'></td>
    <td width="81">测量量程 </td>
    <td width="90" colspan="3"><input type='text' value=''  id = 'input5' class='input-text radius size-S'></td>
    <td width="72" colspan="4">测量单位 </td>
    <td width="83" colspan="3"><input type='text' value=''  id = 'input16' class='input-text radius size-S'></td>
    <td width="128" rowspan="5" valign="top">&nbsp;
    		<textarea name="" id='input17' cols="" rows="" class="textarea" ></textarea>
     	 校准系数： <br />
        K:<input type='text' value='' id = 'input18' class='input-text radius size-S'>
        b:<input type='text' value='' id = 'input19' class='input-text radius size-S'>
              </td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">零点校准 </td>
    <td width="125" colspan="2">零气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input20' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input21' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input22' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">量程校准 </td>
    <td width="125" colspan="2">标气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input23' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input24' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input25' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="75" rowspan="5"><strong>O2</strong><br />
      传感器 </td>
    <td width="80">检测原理 </td>
    <td width="82" colspan="3"><input type='text' value=''  id = 'input26' class='input-text radius size-S'></td>
    <td width="81">测量量程 </td>
    <td width="90" colspan="3"><input type='text' value=''  id = 'input27' class='input-text radius size-S'></td>
    <td width="73" colspan="5">测量单位 </td>
    <td width="82" colspan="2"><input type='text' value=''  id = 'input28' class='input-text radius size-S'></td>
    <td width="128" rowspan="5">
		<textarea name="" id='input29' cols="" rows="" class="textarea" ></textarea>
     	 校准系数： <br />
        K:<input type='text' value='' id = 'input30' class='input-text radius size-S'>
        b:<input type='text' value='' id = 'input31' class='input-text radius size-S'>
              </td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">零点校准 </td>
    <td width="125" colspan="2">零气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input32' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input33' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input34' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="119" colspan="3" rowspan="2">量程校准 </td>
    <td width="125" colspan="2">标气浓度 </td>
    <td width="114" colspan="6">校准前测试值 </td>
    <td width="130" colspan="4">校准后测试值 </td>
  </tr>
  <tr>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input35' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><input type='text' value=''  id = 'input36' class='input-text radius size-S'></td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input37' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="75" rowspan="2">  粉尘仪 </td>
    <td width="80">检测原理 </td>
    <td width="82" colspan="3"><input type='text' value=''  id = 'input38' class='input-text radius size-S'></td>
    <td width="81">测量量程 </td>
    <td width="90" colspan="3"><input type='text' value=''  id = 'input39' class='input-text radius size-S'></td>
    <td width="74" colspan="6">测量单位 </td>
    <td width="80"><input type='text' value=''  id = 'input40' class='input-text radius size-S'></td>
    <td width="128" rowspan="2"><textarea name="" id='input41' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="119" colspan="3"><strong>K</strong>值 </td>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input42' class='input-text radius size-S'></td>
    <td width="114" colspan="6"><strong>b</strong>值 </td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input43' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="75" rowspan="2">流速仪 </td>
    <td width="80">检测原理 </td>
    <td width="82" colspan="3"><input type='text' value=''  id = 'input44' class='input-text radius size-S'></td>
    <td width="81">测量量程 </td>
    <td width="92" colspan="4"><input type='text' value=''  id = 'input45' class='input-text radius size-S'></td>
    <td width="73" colspan="5">测量单位 </td>
    <td width="80"><input type='text' value=''  id = 'input46' class='input-text radius size-S'></td>
    <td width="128" rowspan="2">
    <textarea name="" id='input47' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="119" colspan="3">零点校准前 </td>
    <td width="125" colspan="2"><input type='text' value=''  id = 'input48' class='input-text radius size-S'></td>
    <td width="114" colspan="6">零点校准后 </td>
    <td width="130" colspan="4"><input type='text' value=''  id = 'input49' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="75">备  注 </td>
    <td width="617" colspan="16">
    <textarea name="" id='input50' cols="" rows="" class="textarea" ></textarea> 注：校准系数仅用于有次项功能的仪器 </td>
  </tr>
  <tr>
    <td width="73">维 护 人 </td>
    <td width="309" colspan="6"><input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'></td>
    <td width="99" colspan="5">远   程 </td>
    <td width="234" colspan="5"><input type='text'  value='' name='remotely' id = 'remotely' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="73">确认企业 </td>
    <td width="309" colspan="6"><input type='text'   value='' name='companyname' id = 'companyname' class='input-text radius size-S'></td>
    <td width="99" colspan="5">审   核 </td>
    <td width="234" colspan="5"><input type='text' value='' name='audit' id = 'audit' class='input-text radius size-S'></td>
  </tr>
</table>

<div class="row cl">
		<div class="form-label col-xs-4 col-sm-3">
			<input class="btn btn-primary radius" type="button" onclick = "add()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/icheck/icheck.css"></script> 

<script type="text/javascript">
var j = 0;
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
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"S" : this.getMilliseconds()
	//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1,
					(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
							.substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
function GetRequest() {   
	   var url = location.search; 
	   url=decodeURI(url)
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


$(document).ready(function (){
	
		var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
		$("#time").val(now);
		var userName = getCookie("userName");
		$("#username").val(userName);
		var Request = new Object(); 
		Request = GetRequest(); 
		StationId = Request['StationId'];	
		$("#StationId").val(StationId);
		stationname = Request['stationname'];	
		$("#stationname").val(stationname);


    })
	



		function add(){
			var inputs = document.getElementsByTagName("input");//获取所有的input标签对象

	
			var checked = [];//初始化空数组，用来存放checkbox对象。
			for(var i=0;i<inputs.length;i++){
			  var obj = inputs[i];
			  if(obj.type=='checkbox'){
				  if($("#"+inputs[i].id).is(':checked'))				 
				  checked.push(inputs[i].id);
			  }
			}
			var input ={
					"id":"",
					"value":""
					
			}
			var inputtext = new Array();//初始化空数组，用来存放checkbox对象。

			
			for(var i=0;i<inputs.length;i++){
			  var obj = inputs[i];
			  if(obj.type=='text'){					  
				  inputtext.push({id:obj.id,value:obj.value});	
			  }
			}
			
			$("textarea").each(function(){			
				inputtext.push({id:$(this).attr("id"),value:$(this).val()});	
			});
		
		
			var input=JSON.stringify(inputtext);
			var params={
					"checked":checked,	
			}		
			var checklistcheckbox=JSON.stringify(params);
			var Request = new Object(); 
			Request = GetRequest(); 
	
			StationId = Request['StationId'];	


			var userId = getCookie("userId");
		
			var form = new FormData();
			form.append("stationId",StationId)
			form.append("userId",userId)
			form.append("checklisttype",6)
			
			
			var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
		
			
			form.append("checklisttime",now)
			form.append("checklistcheckbox",checklistcheckbox)
			form.append("checklistinput",input)

		    $.ajax({    
				type: 'POST',
				url: "/management/addChecklist.do", 
				data:form, 
		        async: false,
		        processData:false,
		        contentType:false,
				success: function(data){	
					if(data.msg!=null){
						alert(data.msg);					
					}
					else{layer.msg('已添加!',{icon:1,time:15000});}
			
				},
				error:function(data) {
					alert(data.msg);
					console.log(data.msg);
				},
			});
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index); 
		}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
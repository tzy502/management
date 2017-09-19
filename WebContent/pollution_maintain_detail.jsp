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
		    <td width="117">站点名称 </td>
		    <td width="274" colspan="2" valign="top"><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'></td>
		    <td width="80">维修时间 </td>
		    <td width="199" colspan="2"><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="117">故障起始时间 </td>
		    <td width="553" colspan="5"><input type='text'  id = 'input1' onClick="WdatePicker()" class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="117">故障现象 </td>
		    <td width="553" colspan="5">
		     <textarea name="" id='input2' cols="" rows="" class="textarea" ></textarea>
		    </td>
		  </tr>
		  <tr>
		    <td width="117" rowspan="2">原因分析 </td>
		    <td width="405" colspan="4" rowspan="2">
				 <textarea name="" id='input3' cols="" rows="" class="textarea" ></textarea>
				</td>
		    <td width="148">配件更换记录 </td>
		  </tr>
		  <tr>
		    <td width="148" rowspan="3">
 					<textarea name="" id='input4' cols="" rows="" class="textarea" ></textarea>

			</td>
		  </tr>
		  <tr>
		    <td width="117">维修记录 </td>
		    <td width="405" colspan="4"> <textarea name="" id='input5' cols="" rows="" class="textarea" ></textarea></td>
		  </tr>
		  <tr>
		    <td width="117">维修结果 </td>
		    <td width="405" colspan="4">
		    		<input type="checkbox" id="input6">
		<label for="input11">已修复</label>
		    		    		<input type="checkbox" id="input7">
		<label for="input11">未修复</label>
		</td>
		  </tr>
		  <tr>
		    <td width="117">故障恢复时间 </td>
		    <td width="553" colspan="5"><input type='text'  id = 'input8' onClick="WdatePicker()" class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="117">备  注 </td>
		    <td width="553" colspan="5" valign="top"><textarea name="" id='input9' cols="" rows="" class="textarea" ></textarea></td>
		  </tr>
		  <tr>
		    <td width="117">维修人 </td>
		    <td width="261"> 	<input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'>
</td>
		    <td width="93" colspan="2">远   程 </td>
		    <td width="199" colspan="2"><input type='text'   value='' name='remotely' id = 'remotely' class='input-text radius size-S'>
</td>
		  </tr>
		  <tr>
		    <td width="117">确认企业 </td>
		    <td width="261"><input type='text'   value='' name='companyname' id = 'companyname' class='input-text radius size-S'>
</td>
		    <td width="93" colspan="2">审   核 </td>
		    <td width="199" colspan="2"><input type='text'   value='' name='audit' id = 'audit' class='input-text radius size-S'>
</td>
		  </tr>
			</table>
	

	</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
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
	var Request = new Object();
	Request = GetRequest();
	var checklistId = Request['checklistId'];

	var params = {
		"checklistId" : checklistId,
	}
	
	$(document).ready(function (){
		$.ajax({
			type : "post",
			async : true,
			url : "/management/searchChecklist.do",
			data : JSON.stringify(params),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			error : function(data) {
				alert("出错了！！ :" + data.msg);
			},
	        success: function(data) { 
	
				var obj=JSON.parse(data.checklistcheckbox);		
				for(var i = 0; i < obj.checked.length; i++){ 
					console.log(obj.checked[i]);
					var checked = document.getElementById(obj.checked[i])
					checked.checked = true;
				}
				
				var input=JSON.parse(data.checklistinput);	
				
				for(var i = 0; i < input.length; i++){ 
					console.log(input[i].id);					
					$("#"+input[i].id).val(input[i].value);					
				}
				
				
	        }
	    })
	})
	
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
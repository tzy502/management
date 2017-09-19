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
	<form class="form form-horizontal" id="form-admin-add">

	<table class="table table-border table-bordered" id = 'checklist'>
		   <tr>
      <td width="77">站点名称 </td>
      <td width="246" colspan="7"><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'></td>
      <td width="82" colspan="3">校准时间 </td>
      <td width="175" colspan="6"><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'></td>
      <td width="132">校准结论 </td>
    </tr>
    <tr>
      <td width="77" rowspan="3">COD仪 </td>
      <td width="83" colspan="2">  设备厂家  </td>
      <td width="163" colspan="5">
    	  <input type='text'   value='' name='COD1' id = 'COD1' class='input-text radius size-S'>
      </td>
      <td width="82" colspan="3">设备型号 </td>
      <td width="175" colspan="6">
      	<input type='text'   value='' name='COD2' id = 'COD2' class='input-text radius size-S'>
	   </td>
      <td width="132" rowspan="3">
      <textarea name="" id='COD3' cols="" rows="" class="textarea" ></textarea>
   
      </td>
    </tr>
    <tr>
      <td width="123" colspan="3">				
           <input type="checkbox" id="COD4">
			 <label for="COD4">比色法 </label>
         </td>
      <td width="123" colspan="4"> 
        <input type="checkbox" id="COD5">
			 <label for="COD5">滴定法 </label>
			   </td>
      <td width="123" colspan="4"> 
        <input type="checkbox" id="COD6">
			 <label for="COD6">电化学法   </label>
			 </td>
      <td width="134" colspan="4"> 
        <input type="checkbox" id="COD7">
			 <label for="COD7">燃烧法（TOC）   </label>
			 </td>
    </tr>
    <tr>
      <td width="123" colspan="3"> （恒大仪器） <br />
             K<input type='text'  style='width:20%'   id = 'COD8' class='input-text radius size-S'> 
             b <input type='text'  style='width:20%'   id = 'COD9' class='input-text radius size-S'><br />
     		   （哈希仪器） <br />
      		  斜率：
      		  <input type='text'  style='width:40%'   id = 'COD10' class='input-text radius size-S'>
      		  </td>
      <td width="123" colspan="4"> 重铬酸钾浓度:<br />
       <input type='text'  style='width:20%'   id = 'COD11' class='input-text radius size-S'>mol/L<br />
        空白值：<input type='text'  style='width:40%'   id = 'COD12' class='input-text radius size-S'> <br />
        亚铁铵值：<input type='text'  style='width:40%'   id = 'COD13' class='input-text radius size-S'> </td>
      <td width="123" colspan="4"> 标液浓度：<input type='text'  style='width:20%'   id = 'COD14' class='input-text radius size-S'><br />
        0<input type='text'  style='width:40%'   id = 'COD15' class='input-text radius size-S'><br />
        1/2标样：<input type='text'  style='width:40%'   id = 'COD16' class='input-text radius size-S'><br />
        标样：<input type='text'  style='width:40%'   id = 'COD16' class='input-text radius size-S'>
   </td>
      <td width="134" colspan="4"> 标液浓度： <br />
        <input type='text'    id = 'COD17' class='input-text radius size-S'><br />
        峰面积： <br />
        <input type='text'    id = 'COD17' class='input-text radius size-S'><br />
        相对误差CV:<br />
       <input type='text'    id = 'COD18' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="77" rowspan="4"> pH仪  </td>
      <td width="83" colspan="2">设备厂家  </td>
      <td width="196" colspan="6"> <input type='text'    id = 'PH1' class='input-text radius size-S'></td>
      <td width="71" colspan="3"> 设备型号  </td>
      <td width="153" colspan="5"> <input type='text'    id = 'PH2' class='input-text radius size-S'></td>
      <td width="132" rowspan="4">
 
      <textarea name="" id='PH3' cols="" rows="" class="textarea" ></textarea>
      </td>
    </tr>
    <tr>
      <td width="164" colspan="5">标液浓度</td>
      <td width="164" colspan="5">校准前数据 </td>
      <td width="175" colspan="6">校准后数据 </td>
    </tr>
    <tr>
      <td width="164" colspan="5"><input type='text'    id = 'PH4' class='input-text radius size-S'></td>
      <td width="164" colspan="5"><input type='text'    id = 'PH5' class='input-text radius size-S'></td>
      <td width="175" colspan="6"><input type='text'    id = 'PH6' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="164" colspan="5"><input type='text'    id = 'PH7' class='input-text radius size-S'></td>
      <td width="164" colspan="5"><input type='text'    id = 'PH8' class='input-text radius size-S'></td>
      <td width="175" colspan="6"><input type='text'    id = 'PH9' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="77" rowspan="4"> NH3-N仪  </td>
      <td width="83" colspan="2"> 设备厂家  </td>
      <td width="196" colspan="6"><input type='text'    id = 'NH3-N1' class='input-text radius size-S'></td>
      <td width="71" colspan="3"> 设备型号 </td>
      <td width="153" colspan="5"><input type='text'    id = 'NH3-N2' class='input-text radius size-S'></td>
      <td width="132" rowspan="4">
    <textarea name="" id='NH3-N3' cols="" rows="" class="textarea" ></textarea>
   
      </td>
    </tr>
    <tr>
      <td width="66" rowspan="2">氨气敏<br/>电极法</td>
      <td width="83" colspan="3">标液浓度  </td>
      <td width="59" colspan="2">Ua </td>
      <td width="70" colspan="2">Ub </td>
      <td width="71" colspan="3">电极斜率  </td>
      <td width="79" colspan="4">Uo </td>
      <td width="74">srel</td>
    </tr>
    <tr>
      <td width="83" colspan="3"> A:  <input type='text'  style='width:20%'   id = 'NH3-N4' class='input-text radius size-S'>
      B: <input type='text'  style='width:20%'   id = 'NH3-N5' class='input-text radius size-S'> </td>
      <td width="59" colspan="2"><input type='text'    id = 'NH3-N6' class='input-text radius size-S'></td>
      <td width="70" colspan="2"><input type='text'    id = 'NH3-N7' class='input-text radius size-S'></td>
      <td width="71" colspan="3"><input type='text'    id = 'NH3-N8' class='input-text radius size-S'></td>
      <td width="79" colspan="4"><input type='text'    id = 'NH3-N9' class='input-text radius size-S'></td>
      <td width="74"><input type='text'    id = 'NH3-N10' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="66">  比色法  </td>
      <td width="83" colspan="3"><input type='text'    id = 'NH3-N11' class='input-text radius size-S'></td>
       <td width="66">校准系数 </td>
      <td width="288" colspan="11"><input type='text'    id = 'NH3-N12' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="77" rowspan="5"> 总磷 <br />
       								 总氮仪  </td>
      <td width="83" colspan="2"> 设备厂家  </td>
      <td width="201" colspan="7"><input type='text'    id = 'PN1' class='input-text radius size-S'></td>
      <td width="74" colspan="3"> 设备型号  </td>
      <td width="144" colspan="4"><input type='text'    id = 'PN2' class='input-text radius size-S'></td>
      <td width="132" rowspan="5">
   
          <textarea name="" id='PN3' cols="" rows="" class="textarea" ></textarea>

    </tr>
    <tr>
      <td width="66" rowspan="2"> 岛津4110 </td>
      <td width="218" colspan="8"> TN吸光度基准  </td>
      <td width="218" colspan="7"> TP吸光度基准  </td>
    </tr>
    <tr>
      <td width="218" colspan="8">  零  点：<input type='text'  style='width:60%'   id = 'PN4' class='input-text radius size-S'><br />
        满量程：<input type='text'  style='width:60%'   id = 'PN5' class='input-text radius size-S'>　  </td>
      <td width="218" colspan="7">  零  点：<input type='text'  style='width:60%'   id = 'PN6' class='input-text radius size-S'> <br />
        满量程：<input type='text'  style='width:60%'   id = 'PN7' class='input-text radius size-S'>　  </td>
    </tr>
    <tr>
      <td width="66" rowspan="2"> DKK </td>
      <td width="218" colspan="8">TN校准系数  </td>
      <td width="218" colspan="7">TP校准系数  </td>
    </tr>
    <tr>
      <td width="218" colspan="8">  零点系数：<input type='text'  style='width:60%'   id = 'PN8' class='input-text radius size-S'> <br />
        标准系数：<input type='text'  style='width:60%'   id = 'PN9' class='input-text radius size-S'></td>
      <td width="218" colspan="7">  零点系数：<input type='text'  style='width:60%'   id = 'PN10' class='input-text radius size-S'><br />
        标准系数：<u><input type='text'  style='width:60%'   id = 'PN11' class='input-text radius size-S'></td>
    </tr>
    <tr>
      <td width="77"> 备  注  </td>
      <td width="635" colspan="17">
      <textarea name="" id='Remarks' cols="" rows="" class="textarea" ></textarea>
      
      

    </tr>
    <tr>
      <td width="77"> 维护人  </td>
      <td width="278" colspan="8"><input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'></td>
      <td width="97" colspan="4"> 远   程  </td>
      <td width="259" colspan="7"><input type='text'   value='' name='remotely' id = 'remotely' class='input-text radius size-S'>
</td>
    </tr>
    <tr>
      <td width="77"> 确认企业  </td>
      <td width="278" colspan="8"><input type='text'   value='' name='companyname' id = 'companyname' class='input-text radius size-S'>
</td>
      <td width="97" colspan="4"> 审   核  </td>
      <td width="259" colspan="7"><input type='text'    value='' name='audit' id = 'audit' class='input-text radius size-S'>
</td>
    </tr>
		</table>	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick = "add()" value="  提交  ">
		</div>
	</div>
	</form>
	<input type='hidden'  value='' name='StationId' id = 'StationId'>
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
			$("#StationId").val(data.StationId);
			
        }
    })
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
			  if(obj.type=='text'||obj.type=='textarea'){				
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
	
				
		
			var userId = getCookie("userId");
		
			var form = new FormData();
			
			form.append("checklistId",checklistId)
			form.append("stationId",$("#StationId").val())
			form.append("userId",userId)
			form.append("checklisttype",2)
			var now=new Date().Format("yyyy-MM-dd hh:mm:ss");
			form.append("checklisttime",now)
			form.append("checklistcheckbox",checklistcheckbox)
			form.append("checklistinput",input)
			
		    $.ajax({    
				type: 'POST',
				url: "/management/modifryChecklist.do", 
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
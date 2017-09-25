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
		    <td width="99">企业名称 </td>
		    <td width="175" colspan="2"><input type='text' value=''  id = 'input1' class='input-text radius size-S'></td>
		    <td width="153" colspan="2">现场测定时间 </td>
		    <td  colspan="2"><input type='text' value=''  readonly="readonly"  onClick="WdatePicker()"  id = 'input2' class='input-text radius size-S'></td>
		    <td  colspan="2"><input type='text' value=''  readonly="readonly"  onClick="WdatePicker()"  id = 'input3' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99">测定单位 </td>
		    <td width="175" colspan="2"><input type='text' value=''  id = 'input4' class='input-text radius size-S'></td>
		    <td width="153" colspan="2">实验室测定时间 </td>
		    <td  colspan="2"><input type='text' value=''  readonly="readonly"  onClick="WdatePicker()"  id = 'input5' class='input-text radius size-S'></td>
		    <td  colspan="2"><input type='text' value=''  readonly="readonly"  onClick="WdatePicker()"  id = 'input6' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="16">实 <br />
		      样 <br />
		      比 <br />
		      对 <br />
		      校 <br />
		      核 </td>
		    <td width="99">监测因子 </td>
		    <td width="77">样品编号 </td>
		    <td width="103">仪器测定值 </td>
		    <td width="142" colspan="2">实验室测定值 </td>
		    <td width="86" colspan="2">绝对误差/相对误差 </td>
		    <td width="86">结果判定 </td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="3">PH</td>
		    <td width="77">① </td>
		    <td width="103"><input type='text' value=''  id = 'input7' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input8' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input9' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input10' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">② </td>
		    <td width="103"><input type='text' value=''  id = 'input11' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input12' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input13' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input14' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">③ </td>
		    <td width="103"><input type='text' value=''  id = 'input15' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input16' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input17' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input18' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="3">COD</td>
		    <td width="77">① </td>
		    <td width="103"><input type='text' value=''  id = 'input19' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input20' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input21' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input22' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">② </td>
		    <td width="103"><input type='text' value=''  id = 'input23' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input24' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input25' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input26' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">③ </td>
		    <td width="103"><input type='text' value=''  id = 'input27' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input28' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input29' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input30' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="3">NH4-N</td>
		    <td width="77">① </td>
		    <td width="103"><input type='text' value=''  id = 'input31' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input32' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input33' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input34' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">② </td>
		    <td width="103"><input type='text' value=''  id = 'input35' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input36' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input37' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input38' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">③ </td>
		    <td width="103"><input type='text' value=''  id = 'input39' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input40' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input41' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input42' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="3">TN</td>
		    <td width="77">① </td>
		    <td width="103"><input type='text' value=''  id = 'input43' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input44' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input45' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input46' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">② </td>
		    <td width="103"><input type='text' value=''  id = 'input47' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input48' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input49' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input50' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">③ </td>
		    <td width="103"><input type='text' value=''  id = 'input51' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input52' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input53' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input54' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="99" rowspan="3">TP</td>
		    <td width="77">① </td>
		    <td width="103"><input type='text' value=''  id = 'input55' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input56' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input57' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input58' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">② </td>
		    <td width="103"><input type='text' value=''  id = 'input59' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input60' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input61' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input62' class='input-text radius size-S'></td>
		  </tr>
		  <tr>
		    <td width="77">③ </td>
		    <td width="103"><input type='text' value=''  id = 'input63' class='input-text radius size-S'></td>
		    <td width="142" colspan="2"><input type='text' value=''  id = 'input64' class='input-text radius size-S'></td>
		    <td width="86" colspan="2"><input type='text' value=''  id = 'input65' class='input-text radius size-S'></td>
		    <td width="86"><input type='text' value=''  id = 'input66' class='input-text radius size-S'></td>
		  </tr>
		  		    <tr>
    <td width="99"><p align="center">&nbsp;</p></td>
    <td width="99">备注 </td>
    <td width="493" colspan="7">
   <textarea name="" id='input69' cols="" rows="" class="textarea" ></textarea>
  </tr>
		  <tr>
		    <td width="197" colspan="2">现场取样人员签字 </td>
		    <td width="180" colspan="2"><input type='text' value=''  id = 'input67' class='input-text radius size-S'></td>
		    <td width="142" colspan="2">企业签字 </td>
		    <td width="172" colspan="3"><input type='text' value=''  id = 'input68' class='input-text radius size-S'></td>
		  </tr>
			</table>
				<input type='hidden'  value='' name='StationId' id = 'StationId'>
	<p align="left">注：PH单位为无量纲，其余项目单位为（mg/L） 
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
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
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
					
							var checked = document.getElementById(obj.checked[i])
							checked.checked = true;
						}
						
						var input=JSON.parse(data.checklistinput);	
					
					
						
						for(var i = 0; i < input.length; i++){ 
											
							$("#"+input[i].id).val(input[i].value);					
						}
						
						$("#StationId").val(data.StationId)
						console.log(data.StationId);
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
			form.append("checklisttype",7)
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
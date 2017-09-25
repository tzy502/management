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
    <td colspan="3"><input type='text' value=''  id = 'input1' class='input-text radius size-S'></td>
    <td width="118">现场测定时间 </td>
    <td width="110"><input type='text' value=''  id = 'input2'  readonly="readonly"  onClick="WdatePicker()" class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input3'  readonly="readonly"  onClick="WdatePicker()" class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="37"><p align="center">实 <br />
											      样 <br />
											      比 <br />
											      对 <br />
											      校 <br />
											      核 </p></td>
    <td width="99">监测因子 </td>
    <td width="86">样品编号 </td>
    <td width="94">CEMS测定 </td>
    <td width="118">参比测定 </td>
    <td width="110">绝对误差/相对误差 </td>
    <td width="86">结果判定 </td>
  </tr>
  <tr>
    <td width="99" rowspan="6">烟尘 </td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input4' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input5' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input6' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input7' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input8' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input9' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input10' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input11' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input12' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input13' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input14' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input15' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input16' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input17' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input18' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input19' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input20' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input21' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input22' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input23' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input24' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input25' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input26' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input27' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="6">SO2</td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input28' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input29' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input30' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input31' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input32' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input33' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input34' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input35' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input36' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input37' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input38' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input39' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input40' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input41' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input42' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input43' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input44' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input45' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input46' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input47' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input48' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input49' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input50' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input51' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="6">NOX</td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input52' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input53' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input54' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input55' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input56' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input57' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input58' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input59' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input60' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input61' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input62' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input63' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input64' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input65' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input66' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input67' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input68' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input69' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input70' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input71' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input72' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input73' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input74' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input75' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="6">O2</td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input76' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input77' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input78' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input79' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input80' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input81' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input82' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input83' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input84' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input85' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input86' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input87' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input88' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input89' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input90' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input91' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input92' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input93' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input94' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input95' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input96' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input97' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input98' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input99' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="6">流速 </td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input100' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input101' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input102' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input103' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input104' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input105' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input106' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input107' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input108' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input109' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input110' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input111' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input112' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input113' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input114' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input115' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input116' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input117' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input118' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input119' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input120' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input121' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input122' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input123' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99" rowspan="6">温度 </td>
    <td width="86">① </td>
    <td width="94"><input type='text' value=''  id = 'input124' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input125' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input126' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input127' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">② </td>
    <td width="94"><input type='text' value=''  id = 'input128' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input129' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input130' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input131' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">③ </td>
    <td width="94"><input type='text' value=''  id = 'input132' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input133' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input134' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input135' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">④ </td>
    <td width="94"><input type='text' value=''  id = 'input136' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input137' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input138' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input139' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑤ </td>
    <td width="94"><input type='text' value=''  id = 'input140' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input141' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input142' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input143' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="86">⑥ </td>
    <td width="94"><input type='text' value=''  id = 'input144' class='input-text radius size-S'></td>
    <td width="118"><input type='text' value=''  id = 'input145' class='input-text radius size-S'></td>
    <td width="110"><input type='text' value=''  id = 'input146' class='input-text radius size-S'></td>
    <td width="86"><input type='text' value=''  id = 'input146' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="99"></td>
    <td width="99">备注 </td>
    <td colspan="5"><textarea name="" id='input147' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td colspan="2">现场取样人员签字 </td>
    <td colspan="2"><input type='text' value=''  id = 'input148' class='input-text radius size-S'></td>
    <td width="118">企业签字 </td>
    <td colspan="2"><input type='text' value=''  id = 'input149' class='input-text radius size-S'></td>
  </tr>
			</table>


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
		function getCookie(Name) {
			var search = Name + "="//查询检索的值
			var returnvalue = "";//返回值
			if (document.cookie.length > 0) {
				sd = document.cookie.indexOf(search);
				if (sd != -1) {
					sd += search.length;
					end = document.cookie.indexOf(";", sd);
					if (end == -1)
						end = document.cookie.length;
					//unescape() 函数可对通过 escape() 编码的字符串进行解码。
					returnvalue = unescape(document.cookie.substring(sd, end))
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
				for (var i = 0; i < strs.length; i++) {
					theRequest[strs[i].split("=")[0]] = unescape(strs[i]
							.split("=")[1]);
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
		
		$(document).ready(function() {
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
				success : function(data) {
		
					var obj = JSON.parse(data.checklistcheckbox);
					for (var i = 0; i < obj.checked.length; i++) {
						console.log(obj.checked[i]);
						var checked = document.getElementById(obj.checked[i])
						checked.checked = true;
					}
		
					var input = JSON.parse(data.checklistinput);
		
					for (var i = 0; i < input.length; i++) {
						console.log(input[i].id);
						$("#" + input[i].id).val(input[i].value);
					}
		
				}
			})
		})
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
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
    <td width="73">站点名称 </td>
    <td width="266" colspan="13"><input type='text' readonly="readonly" placeholder='站点名称' id = 'stationname' class='input-text radius size-S'></td>
    <td width="74" colspan="4">巡检时间 </td>
    <td width="169" colspan="8"><input type='text' readonly="readonly"  value='' name='time' id = 'time' class='input-text radius size-S'> </td>
    <td width="133" colspan="3">运行说明 </td>
  </tr>
  <tr>
    <td width="73">平台单元 </td>
    <td width="508" colspan="25">
    
 		<input type="checkbox" id="input1">
		<label for="input1">平台供电正检查 </label>
		<input type="checkbox" id="input2">
		<label for="input2"> 采样探头、采样杆清理 </label>
		<input type="checkbox" id="input3">
		<label for="input3">清理粉尘仪镜面 </label>
		<input type="checkbox" id="input4">
		<label for="input4">皮托管反吹气是否正常 </label>
        <br />
    	<input type="checkbox" id="input5">
		<label for="input5">各仪器输出信号检查</label>
		<input type="checkbox" id="input6">
		<label for="input6">平台控制箱牢固检查</label>
		<input type="checkbox" id="input7">
		<label for="input7">线路检查整理  </label>
	</td>
    <td width="133" colspan="3">
		<textarea name="" id='input8' cols="" rows="" class="textarea" ></textarea>
</td>
  </tr>
  <tr>
    <td width="73" rowspan="3">监测单元 </td>
    <td width="83" colspan="4">预处理 <br />
      			系  统 </td>
    <td width="426" colspan="21">
    
     	<input type="checkbox" id="input9">
		<label for="input9">系统运行正常</label>
		<input type="checkbox" id="input10">
		<label for="input10">气路接头牢固 </label>
		<input type="checkbox" id="input11">
		<label for="input11">过滤器滤芯是否变色 </label>
		<input type="checkbox" id="input12">
		<label for="input12">采样、反吹、排空电磁阀动作正常</label>
        <br />
    	<input type="checkbox" id="input13">
		<label for="input13">采样泵工作是否正常，有无异响</label>
		<input type="checkbox" id="input14">
		<label for="input14">冷凝器制冷是否正常</label>
		<input type="checkbox" id="input15">
		<label for="input15">蠕动泵排水是否正常  </label>
		  <br />
		 <input type="checkbox" id="input16">
		<label for="input16">排液锅液面正常</label>
		<input type="checkbox" id="input17">
		<label for="input17">排水、排气是否通畅 </label>
		<input type="checkbox" id="input18">
		<label for="input18">更换易耗品，标签齐全</label>
		<input type="checkbox" id="input19">
		<label for="input19">管路老化检查</label>
		<input type="checkbox" id="input20">
		<label for="input20">电路线路整洁</label>
		<br />
      冷凝器温度<input type='text' style='width:20%'  id = 'input21' class='input-text radius size-S'> ℃；
      探头加热温度<input type='text' style='width:20%'  id = 'input22' class='input-text radius size-S'> ℃；
      伴热管加热温度<input type='text' style='width:20%'  id = 'input23' class='input-text radius size-S'> ℃ <br />
      进样流量 <input type='text' style='width:30%'  id = 'input24' class='input-text radius size-S'>L/min    </td>
    <td width="133" colspan="3" valign="top"><textarea name="" id='input25' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="83" colspan="4">反吹系统 </td>
    <td width="426" colspan="21">
    	<input type="checkbox" id="input26">
		<label for="input26">供气是否正常</label>
		<input type="checkbox" id="input27">
		<label for="input27">气液分离器排水</label>
		<input type="checkbox" id="input28">
		<label for="input28">手动反吹 </label>
 			</td>
    <td width="133" colspan="3"><textarea name="" id='input29' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="83" colspan="4">主分析 <br />
    			  仪表 </td>
    <td width="426" colspan="21">
        <input type="checkbox" id="input29">
		<label for="input29">运行是否正常</label>
		<input type="checkbox" id="input30">
		<label for="input30">传感器清理</label>
		<input type="checkbox" id="input31">
		<label for="input31">仪器校准 </label>
		<input type="checkbox" id="input32">
		<label for="input32">质控样校验</label>
  <br />
      信号值记录：SO<strong>2</strong>：<input type='text' style='width:20%'  id = 'input33' class='input-text radius size-S'>
      NO:<input type='text' style='width:20%'  id = 'input34' class='input-text radius size-S'> 
      O<strong>2</strong>：<input type='text' style='width:20%'  id = 'input35' class='input-text radius size-S'> <br />
      紫外仪器光谱能量：<input type='text' style='width:20%'  id = 'input36' class='input-text radius size-S'> </td>
    <td width="133" colspan="3"><textarea name="" id='input43' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="73" rowspan="4">数据采集单元 </td>
    <td width="508" colspan="25">
         <input type="checkbox" id="input37">
		<label for="input37">运行是否正常</label>
		<input type="checkbox" id="input38">
		<label for="input38">本次运维周期数据检查，异常数据记录</label>
		<input type="checkbox" id="input39">
		<label for="input39">数采仪重启 </label>
		<input type="checkbox" id="input40">
		<label for="input40">一次仪表与数采仪数据偏差检查</label>   
    		<input type="checkbox" id="input41">
		<label for="input41">上传情况检查 </label>   
       </td>
    <td width="133" colspan="3" rowspan="4"><textarea name="" id='input42' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="69" colspan="3" rowspan="3">实时数据记录 </td>
    <td width="74" colspan="4">&nbsp;</td>
    <td width="57" colspan="2">SO<strong>2</strong></td>
    <td width="57" colspan="2">NO</td>
    <td width="57" colspan="5">O<strong>2</strong></td>
    <td width="57" colspan="3">烟尘 </td>
    <td width="57" colspan="2">流速 </td>
    <td width="79" colspan="4">标况流量 </td>
  </tr>
  <tr>
    <td width="74" colspan="4">仪器值 </td>
    <td width="57" colspan="2"><input type='text'  id = 'input43' class='input-text radius size-S'></td>
    <td width="57" colspan="2"><input type='text'  id = 'input44' class='input-text radius size-S'></td>
    <td width="57" colspan="5"><input type='text'  id = 'input45' class='input-text radius size-S'></td>
    <td width="57" colspan="3"><input type='text'  id = 'input46' class='input-text radius size-S'></td>
    <td width="57" colspan="2"><input type='text'  id = 'input47' class='input-text radius size-S'></td>
    <td width="79" colspan="4"><input type='text'  id = 'input48' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="74" colspan="4">数采仪值 </td>
    <td width="57" colspan="2"><input type='text'  id = 'input49' class='input-text radius size-S'></td>
    <td width="57" colspan="2"><input type='text'  id = 'input50' class='input-text radius size-S'></td>
    <td width="57" colspan="5"><input type='text'  id = 'input51' class='input-text radius size-S'></td>
    <td width="57" colspan="3"><input type='text'  id = 'input52' class='input-text radius size-S'></td>
    <td width="57" colspan="2"><input type='text'  id = 'input53' class='input-text radius size-S'></td>
    <td width="79" colspan="4"><input type='text'  id = 'input54' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="73">监测站房（辅助） <br />
      单元 </td>
    <td width="508" colspan="25">
          <input type="checkbox" id="input55">
		<label for="input55">输入电压检查</label>
		<input type="checkbox" id="input56">
		<label for="input56">机柜线路检查整理</label>
		<input type="checkbox" id="input57">
		<label for="input57">排水口检查清理 </label>
		<input type="checkbox" id="input58">
		<label for="input58">稳压电源运行正常 </label>
  <br />
         <input type="checkbox" id="input59">
		<label for="input59">空调运行正常</label>
		<input type="checkbox" id="input60">
		<label for="input60">灭火器在有效期内</label>
		<input type="checkbox" id="input61">
		<label for="input61">制度牌、资料架整齐清洁检查</label>
		<input type="checkbox" id="input62">
		<label for="input62">稳压电源运行正常 </label>
  <br />  
  		<input type="checkbox" id="input63">
		<label for="input63">站房清洁</label>
		<input type="checkbox" id="input64">
		<label for="input64">仪器整体除尘、清洁</label>
		<input type="checkbox" id="input65">
		<label for="input65">有效性资料齐全，标签完整 </label>
</td>
    <td width="133" colspan="3"><textarea name="" id='input66' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="73" rowspan="4">质量控制 </td>
    <td width="62">&nbsp;</td>
    <td width="150" colspan="8">SO<strong>2</strong></td>
    <td width="150" colspan="8">NO</td>
    <td width="150" colspan="8">O<strong>2</strong></td>
    <td width="133" colspan="3" rowspan="4"><textarea name="" id='input67' cols="" rows="" class="textarea" ></textarea></td>
  </tr>
  <tr>
    <td width="62">标准值 </td>
    <td width="75" colspan="4"><input type='text'  id = 'input68' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input69' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input70' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input71' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input72' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input73' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="62">检测值 </td>
    <td width="74" colspan="4"><input type='text'  id = 'input74' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input75' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input76' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input77' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input78' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input79' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="62">误  差 </td>
    <td width="74" colspan="4"><input type='text'  id = 'input80' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input81' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input82' class='input-text radius size-S'></td>
    <td width="75" colspan="4"><input type='text'  id = 'input83' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input84' class='input-text radius size-S'></td>
    <td width="74" colspan="4"><input type='text'  id = 'input85' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="73" rowspan="8">实样比对记录 </td>
    <td width="63" colspan="2">&nbsp;</td>
    <td width="297" colspan="16">SO<strong>2</strong> (mg/m<strong>3</strong>)</td>
    <td width="282" colspan="10">NO(mg/m<strong>3</strong>)</td>
  </tr>
  <tr>
    <td width="63" colspan="2">标准值 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input86' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input87' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input88' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input89' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input90' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input91' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input92' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input93' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input94' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input95' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input96' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input97' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="63" colspan="2">检测值 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input98' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input99' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input100' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input101' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input102' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input103' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input104' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input105' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input106' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input107' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input108' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input109' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="63" colspan="2">误  差 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input110' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input111' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input112' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input113' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input114' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input115' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input116' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input117' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input118' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input119' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input120' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input121' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="63" colspan="2">&nbsp;</td>
    <td width="297" colspan="16">O<strong>2</strong>(%)</td>
    <td width="282" colspan="10">流速(m/s)</td>
  </tr>
  <tr>
    <td width="63" colspan="2">标准值 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input122' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input123' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input124' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input125' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input126' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input127' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input128' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input129' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input130' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input131' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input132' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input133' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="63" colspan="2">检测值 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input134' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input135' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input136' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input137' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input138' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input139' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input140' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input141' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input142' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input143' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input144' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input145' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="63" colspan="2">误  差 </td>
    <td width="49" colspan="3"><input type='text'  id = 'input146' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input147' class='input-text radius size-S'></td>
    <td width="50" colspan="2"><input type='text'  id = 'input148' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input149' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input150' class='input-text radius size-S'></td>
    <td width="50" colspan="3"><input type='text'  id = 'input151' class='input-text radius size-S'></td>
    <td width="48" colspan="2"><input type='text'  id = 'input152' class='input-text radius size-S'></td>
    <td width="49" colspan="3"><input type='text'  id = 'input153' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input154' class='input-text radius size-S'></td>
    <td width="49" colspan="2"><input type='text'  id = 'input155' class='input-text radius size-S'></td>
    <td width="49"><input type='text'  id = 'input156' class='input-text radius size-S'></td>
    <td width="37"><input type='text'  id = 'input157' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="73">维 护 人 </td>
    <td width="309" colspan="15"><input type='text'   value='' readonly="readonly" name='username' id = 'username' class='input-text radius size-S'></td>
    <td width="99" colspan="5">远   程 </td>
    <td width="234" colspan="8"><input type='text'  value='' name='remotely' id = 'remotely' class='input-text radius size-S'></td>
  </tr>
  <tr>
    <td width="73">确认企业 </td>
    <td width="309" colspan="15"><input type='text'   value='' name='companyname' id = 'companyname' class='input-text radius size-S'></td>
    <td width="99" colspan="5">审   核 </td>
    <td width="234" colspan="8"><input type='text' value='' name='audit' id = 'audit' class='input-text radius size-S'></td>
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
checklistId=14

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
			$("#StationId").val(data.StationId)
		}
	})
})
	function add() {
		var inputs = document.getElementsByTagName("input");//获取所有的input标签对象
		var checked = [];//初始化空数组，用来存放checkbox对象。
		for (var i = 0; i < inputs.length; i++) {
			var obj = inputs[i];
			if (obj.type == 'checkbox') {
				if ($("#" + inputs[i].id).is(':checked'))
					checked.push(inputs[i].id);
			}
		}
		var input = {
			"id" : "",
			"value" : ""

		}
		var inputtext = new Array();//初始化空数组，用来存放checkbox对象。

		for (var i = 0; i < inputs.length; i++) {
			var obj = inputs[i];
			if (obj.type == 'text' || obj.type == 'textarea') {
				inputtext.push({
					id : obj.id,
					value : obj.value
				});
			}
		}
		$("textarea").each(function() {
			inputtext.push({
				id : $(this).attr("id"),
				value : $(this).val()
			});
		});

		var input = JSON.stringify(inputtext);
		var params = {
			"checked" : checked,
		}

		var checklistcheckbox = JSON.stringify(params);
		var Request = new Object();
		Request = GetRequest();

		var userId = getCookie("userId");

		var form = new FormData();

		form.append("checklistId", checklistId)

		form.append("stationId",$("#StationId").val())
		form.append("userId", userId)
		form.append("checklisttype", 5)
		var now = new Date().Format("yyyy-MM-dd hh:mm:ss");
		form.append("checklisttime", now)
		form.append("checklistcheckbox", checklistcheckbox)
		form.append("checklistinput", input)

		$.ajax({
			type : 'POST',
			url : "/management/modifryChecklist.do",
			data : form,
			async : false,
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.msg != null) {
					alert(data.msg);
				} else {
					layer.msg('已修改!', {
						icon : 1,
						time : 15000
					});
				}

			},
			error : function(data) {
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
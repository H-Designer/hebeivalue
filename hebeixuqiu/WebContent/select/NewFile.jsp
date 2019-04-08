<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript"><!-- google_ad_client = "pub-2947489232296736"; /* 728x15, 创建于 08-4-23MSDN */ google_ad_slot = "3624277373"; google_ad_width = 728; google_ad_height = 15; //--> </script> <script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"> </script>
<script type="text/javascript"><!-- google_ad_client = "pub-2947489232296736"; /* 160x600, 创建于 08-4-23MSDN */ google_ad_slot = "4367022601"; google_ad_width = 160; google_ad_height = 600; //--> </script><script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"> </script>
<HTML>
<HEAD>
<TITLE>饼图</TITLE>
<script>
function DrawPieChart()
{
var totalvalue = value1.value/360 + value2.value/360 + value3.value/360 + value4.value/360;
var per1 = value1.value/totalvalue;
var per2 = value2.value/totalvalue;
var per3 = value3.value/totalvalue;
var per4 = value4.value/totalvalue;

var per12 = per1 + per2;
var per123 = per1 + per2 + per3;

Chart.innerHTML = "<OBJECT ID='PieChart' CLASSID='
CLSID:369303C2-D7AC-11D0-89D5-00A0C90833E6' STYLE='position:relative;top:0;left:0;width:400;height:400'>
<PARAM NAME='Line0001' ALUE='SetLineColor(255, 0, 127)'><PARAM NAME='Line0002' value='SetFillStyle(1)'><PARAM NAME='Line0003' value='SetFillColor(0, 255, 80)'><PARAM NAME='Line0004'
value='Pie(-100, -100, 200, 200, 0, "+ per1 +", 0)'><PARAM NAME='Line0005' value='SetFillStyle(1)'><PARAM NAME='Line0006' value='SetFillColor(0, 0, 255)'><PARAM NAME='Line0007' value='Pie(-100, -100, 200, 200, "+ per1 + ", " + per2 + ", 0)'><PARAM NAME='Line0008' value='SetFillStyle(1)'><PARAM NAME='Line0009' value='SetFillColor(0, 128, 128)'><PARAM NAME='Line0010' value='Pie(-100, -100, 200, 200, "+per12+","+per3+", 0)'><PARAM NAME='Line0011' value='SetFillStyle(1)'><PARAM NAME='Line0012' value='SetFillColor(255, 0, 0)'><PARAM NAME='Line0013' value='Pie(-100, -100, 200, 200, "+per123+","+per4+", 0)'></OBJECT>"

}
</script>
<style>
<!--
body, p, div,td,input{font:menu;line-height: 150%}
.div { font-family: 宋体; font-size: 12px; line-height: 150% }
-->
</style>
</HEAD>
<BODY>
<table border=1 width=100%>
<tr><td id="Chart" width=50% height=400 align=center>
准备画图。。。</td>
<td width=50%>
<p align=center>
输入4个数<br>
<input id="value1" type=text size=6 value=0>
<input id="value2" type=text size=6 value=0>
<input id="value3" type=text size=6 value=0>
<input id="value4" type=text size=6 value=0>
</p>
<p align=center>
<input type=button onclick="DrawPieChart()" value="画饼图">
</p>
</td>
</tr>
</table>
</BODY>
</HTML>
<script type="text/javascript"><!-- google_ad_client = "pub-2947489232296736"; /* 728x15, 创建于 08-4-23MSDN */ google_ad_slot = "3624277373"; google_ad_width = 728; google_ad_height = 15; //--> </script> <script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"> </script>
<script type="text/javascript"><!-- google_ad_client = "pub-2947489232296736"; /* 160x600, 创建于 08-4-23MSDN */ google_ad_slot = "4367022601"; google_ad_width = 160; google_ad_height = 600; //--> </script><script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"> </script>
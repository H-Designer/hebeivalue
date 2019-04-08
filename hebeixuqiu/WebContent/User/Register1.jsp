<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/User/css/registerform.css" rel="stylesheet">

<script type="text/javascript">
	function setFocus(){
		form.username.focus();
	}
	$().ready(
			function(){
				$("#form").validate({
					rules:{
						username:{
							required:true
						},
						password1:{
							required:true,
							minlength:6
						},
						password2:{
							required:true,
							equalTo:"#password"
						},
						
						platnum:{
							required:true
						},
						pizhuntime:{
							required:true
						},
						platname:{
							required:true
						},
						pizhunwenhao:{
							required:true,
							
						},
						jishulingyu:{
							required:true,
							
						},
					},
					messages : {
						username:{
							required : "用户姓名不能为空"
						},
						password1:{
							required:"密码不能为空",
							minlength:"密码最少为6位"
						},
						password2:{
							required:"重复密码不能为空",
							equalTo:"重复密码需要和密码相同"
						},
						
						platnum:{
							required:"平台编号不为空"
						},
						pizhuntime:{
							required:"批准时间不能为空"
						},
						platname:{
							required:"平台名称不能为空"
						},
						pizhunwenhao:{
							required:"批准文号不能为空"
						},
						jihsulingyu:{
							required:"技术领域不能为空"
						},
						
					}
				});
			});
</script>
  	<script type="text/javascript">
  		function checkForm(){
  			var canSub = true;
  			//1.非空校验
  			canSub = checkNull("platformName","用户名不能为空!") && canSub;
  			canSub = checkNull("password","密码不能为空!") && canSub;
  			canSub = checkNull("password2","确认密码不能为空!") && canSub;
  			canSub = checkNull("platformId","平台编号不能为空!") && canSub;
  			canSub = checkNull("yearNumber","批准年号不能为空!") && canSub;
  			canSub = checkNull("referenceNumber","批准年号不能为空!") && canSub;
  			canSub = checkNull("filed","技术领域不能为空!") && canSub;
  			
  			//2.两次密码一致的校验
  			var psw1 = document.getElementsByName("password")[0].value;
  			var psw2 = document.getElementsByName("password2")[0].value;
  			if(psw1 != psw2){
  				document.getElementById("password2_msg").innerHTML = "<font color='red'>两次密码不一致!</font>";
  				canSub = false;
  			}
  			//两次密码不一致判断
  			
  			/*
  			//3.邮箱格式校验:sssss@xxx.xxx.xxx.xxx 
			var email = document.getElementsByName("email")[0].value;
			if( email!= null && email != "" && !/^\w+@\w+(\.\w+)+$/.test(email)){
				document.getElementById("email_msg").innerHTML = "<font color='red'>邮箱格式不正确!</font>";
  				canSub = false;
			}
  			*/
  			return canSub;
  		
  		}
  		function checkNull(name,msg){
  			document.getElementById(name+"_msg").innerHTML = "";
  			var objValue = document.getElementsByName(name)[0].value;
  			if(objValue == null || objValue == ""){
				document.getElementById(name+"_msg").innerHTML = "<font color='red'>"+msg+"</font>";
  				return false;
  			}
  			return true;
  		}
  	</script>
 </head>
 <body onload="setFocus()" marginwidth="0px" marginheight="0px" background="./Photo/timg.jpg" style="background-repeat: no-repeat;background-size: cover;" >
 <center><font size="50px">用户注册</font></center>
 <hr>
 <font>${failure }</font>
 <div align="center" >
  	<form action="${pageContext.request.contextPath}/severLet/regisSeverlet" method="POST" onsubmit="return checkForm()">
  		<table>
  			<tr>
  				<td style="font-size:20pt;color:#ff3333;font-family:宋体">用户名称:</td>
  				<td><input type="text" name="username" value="${param.username }"placeholder = "不能为空"/></td>
  				<td id="username_msg"></td>
  			</tr>
  			<tr>
				<td style="font-size:20pt;color:#ff3333;font-family:宋体">输入密码:</td>  			
				<td><input type="password" name="password1"placeholder = "不能为空"/></td>
  				<td id="password1_msg"></td>
  			</tr>
  			<tr>
  				<td style="font-size:20pt;color:#ff3333;font-family:宋体">确定密码:</td>
  				<td><input type="password" name="password2"placeholder = "不能为空"/></td>
  				<td id="password2_msg"></td>
  			</tr>
  			<tr>
  				<td style="font-size:20pt;color:#ff3333;font-family:宋体">平台名称:</td>
  				<td><input type="text" name="platname" value="${param.platname }"placeholder = "不能为空"/></td>
  				<td id="platmname_msg"></td>
  			</tr>
  			<tr>
  				<td style="font-size:20pt;color:#ff3333;font-family:宋体">平台编号:</td>
  				<td><input type="text" name="platnum" value="${param.platnum }"placeholder = "不能为空"/></td>
  				<td id="platnum_msg"></td>
  			</tr>
  			<tr>
  				<td  style="font-size:20pt;color:#ff3333;font-family:宋体">批准年号:</td>
  				<td><input type="text" name="pizhuntime" value="${param.pizhuntime }"placeholder = "不能为空"/></td>
  				<td id="pizhuntime_msg"></td>
  			</tr>
  			<tr>
  				<td  style="font-size:20pt;color:#ff3253;font-family:宋体">批准文号:</td>
  				<td><input type="text" name="pizhunwenhao" value="${param.pizhunwenhao }" placeholder = "不能为空"/></td>
  				<td id="pizhunwenhao_msg"></td>
  			</tr>
  			<tr>
  				<td style="font-size:20pt;color:#ff3333;font-family:宋体">技术领域:</td>
  				<td><input type="text" name="jishulingyu" value="${param.jishulingyu }"placeholder = "不能为空"/></td>
  				<td id="jishulingyu_msg"></td>
  			</tr>
  			<tr>
  				<td><input style="font-size:16px;" type="button" onclick="window.location.href='Login.jsp'" value="已有账号，去登陆"/></td>
  				<td align="center"><input style="font-size:20px;" type="submit" value="注册"/></td>
  			</tr>
  		</table>
  	</form>
  	</div>
  </body>
  </html>

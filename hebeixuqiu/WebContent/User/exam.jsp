<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
</head>
 
<body>
    <div align="center">请输入注册信息<form name="form1" method="post"action="reginfo.jsp">
        <table border="0"align="center">
        <tr>
         <td>请输入您的姓名：</td>
         <td><input type="text"name="name"></td>
        </tr>
        <tr>
         <td height="12">请输入您的密码：</td>
         <td height="12"><input id="password" type="password"name="password"></td>
        </tr>
        <tr>
         <td height="12">请再次输入您的密码：</td>
         <td height="12"><input id="passwordConfirm" type="password" name="passwordConfirm"></td>
        </tr>
        <tr>
         <td>请输入您的昵称：</td>
         <td><input type="text"name="nickname"></td>
        </tr>
         
    <tr>
     <td>
       <div align="right">
         <input id="sub" type="button" name="Submit" value="提交信息" >
       </div> 
     </td>
     <td>
         <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
     </td>
    </tr>
</table>
</form>
</div>
</body>
</html>
<script>
(function(){
    var sub = document.getElementById("sub");
    //初始化移入移出事件
    if(sub.addEventListener){
        sub.addEventListener("click", test);  
    }else if(sub.attachEvent){
        sub.attachEvent("onClick", test);
    }
})();
 
function test(){
    var password = document.getElementById("password");
    var passwordConfirm = document.getElementById("passwordConfirm");
    if(password.value != passwordConfirm.value)
        alert("对不起，您2次输入的密码不一致");
    else
    document.forms[0].submit();
     
}
</script>
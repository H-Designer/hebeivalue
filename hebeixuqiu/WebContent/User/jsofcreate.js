function $(id) {
	return document.getElementById(id);
}
// 中文、字母、数字、_ - 4-20

var regs = {
	userNameReg: /^(([\u4e00-\u9fa5])|[a-zA-Z0-9-_]){4,20}$/,
	pwdReg: /^.{6,20}$/,
	numReg: /\d/,
	strReg: /[a-zA-Z]/,
	tsReg: /[^\u4e00-\u9fa5a-zA-Z0-9]/,
	emailReg:/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/,
	platnumberReg:/^\d{3}-\d{8}|\d{4}-\d{7}$/,
	ratifydateReg:/^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))$/,
	ratifynumberReg:/^\d{3}-\d{3}-\d{3}$/,
	tecReg:/^电子信息|生物与新医药|航空航天|新材料|高技术服务|新能源与节能|资源与环境|先进制造与自动化$/
	//tecReg:/^(([\u4e00-\u9fa5])|[a-zA-Z0-9-_]){4,20}$/
}
window.onload = function() {
	// 用户名字母、数字、_、-、中文  \u4e00-\u9fa5  4-20
	// box   常规 box  出错的时候  box error  正确的时候  box right
	// tip   常规 tip hide  出错的时候  tip error  默认的时候  tip default
	var userName = $("userName");
	var pwd = $("pwd");
	var pwd2 = $("pwd2");
	var email = $("platformName");
	//var mobile = $("mobile");
	var ck = $("ck");
	var btn = $("btn");
	var platnumber=$("platnumber");
	var ratifydate =$("ratifydate");
	var ratifynumber=$("ratifynumber");
	var tec=$("tec");
	
	tec.onkeyup=tec.onfocus=tec.onblur=function(evt) {
		var e = evt || window.event;//e记录了当前事件的信息
		checkTec(e);
	}
	function checkTec(_e) {
		var type;
		if(_e) {//如果参数有事件信息就获得type(有onkeyup,onfocus,onblur)
			type = _e.type;
		}
		var value = tec.value;
		var box = tec.parentNode;//获得父节点
		var tip = box.nextElementSibling;//返回元素节点之后的兄弟元素节点
		var span = tip.lastElementChild;//指定元素节点最后的子元素
		if(type=="focus") {//聚焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "参考高新技术领域目录";
				return false;
			}
		}
		if(type=="blur") {//失焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}

		if(value=="") {//空值事件
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "技术领域不能为空";
			return false;
		} else if(regs.tecReg.test(value)) {//符合格式要求
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";//不符合格式要求
			tip.className = "tip error";
			span.innerHTML = "错误，按照右侧网址内容填写";
			return false;
		}
	}
	ratifynumber.onkeyup=ratifynumber.onfocus=ratifynumber.onblur=function(evt) {
		var e = evt || window.event;//e记录了当前事件的信息
		checkRatifynumber(e);
	}
	function checkRatifynumber(_e) {
		var type;
		if(_e) {//如果参数有事件信息就获得type(有onkeyup,onfocus,onblur)
			type = _e.type;
		}
		var value = ratifynumber.value;
		var box = ratifynumber.parentNode;//获得父节点
		var tip = box.nextElementSibling;//返回元素节点之后的兄弟元素节点
		var span = tip.lastElementChild;//指定元素节点最后的子元素
		if(type=="focus") {//聚焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "使用000-000-000：省市代码-平台代码-序列格式";
				return false;
			}
		}
		if(type=="blur") {//失焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}

		if(value=="") {//空值事件
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "批准文号不能为空";
			return false;
		} else if(regs.ratifynumberReg.test(value)) {//符合格式要求
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";//不符合格式要求
			tip.className = "tip error";
			span.innerHTML = "错误，按照000-000-000：省市代码-平台代码-序列";
			return false;
		}
	}
	ratifydate.onkeyup=ratifydate.onfocus=ratifydate.onblur=function(evt) {
		var e = evt || window.event;//e记录了当前事件的信息
		checkRatifydate(e);
	}
	function checkRatifydate(_e) {
		var type;
		if(_e) {//如果参数有事件信息就获得type(有onkeyup,onfocus,onblur)
			type = _e.type;
		}
		var value = ratifydate.value;
		var box = ratifydate.parentNode;//获得父节点
		var tip = box.nextElementSibling;//返回元素节点之后的兄弟元素节点
		var span = tip.lastElementChild;//指定元素节点最后的子元素
		if(type=="focus") {//聚焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "使用1000-01-01格式";
				return false;
			}
		}
		if(type=="blur") {//失焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}

		if(value=="") {//空值事件
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "日期不能为空";
			return false;
		} else if(regs.ratifydateReg.test(value)) {//符合格式要求
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";//不符合格式要求
			tip.className = "tip error";
			span.innerHTML = "错误，按照1000-01-01格式输入，注意1、3、5、7、8、10、12有31天";
			return false;
		}
	}
	userName.onkeyup=userName.onfocus=userName.onblur=function(evt) {
		var e = evt || window.event;//e记录了当前事件的信息
		checkUserName(e);
	}
	function checkUserName(_e) {
		var type;
		if(_e) {//如果参数有事件信息就获得type(有onkeyup,onfocus,onblur)
			type = _e.type;
		}
		var value = userName.value;
		var box = userName.parentNode;//获得父节点
		var tip = box.nextElementSibling;//返回元素节点之后的兄弟元素节点
		var span = tip.lastElementChild;//指定元素节点最后的子元素
		if(type=="focus") {//聚焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "支持汉字、字母、数字、“-”“_”的组合，4-20个字符";
				return false;
			}
		}
		if(type=="blur") {//失焦事件
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}

		if(value=="") {//空值事件
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "用户名不能为空";
			return false;
		} else if(regs.userNameReg.test(value)) {//符合格式要求
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";//不符合格式要求
			tip.className = "tip error";
			span.innerHTML = "格式错误，仅支持汉字、字母、数字、“-”“_”的组合";
			return false;
		}
	}
	
	email.onkeyup=email.onfocus=email.onblur=function(evt) {
		var e = evt || window.event;
		checkEmail(e);
	}
	function checkEmail(_e) {
		var type;
		if(_e) {
			type = _e.type;
		}
		var value = email.value;
		var box = email.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(type=="focus") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "请输入平台名称";
				return false;
			}
		}
		if(type=="blur") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}
		if(value=="") {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "平台名称不能为空";
			return false;
		} else if(regs.emailReg.test(value)) {
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} 
	}
	
	
	/*
	email.onkeyup=email.onfocus=email.onblur=function(evt) {
		var e = evt || window.event;
		checkEmail(e);
	}
	function checkEmail(_e) {
		var type;
		if(_e) {
			type = _e.type;
		}
		var value = email.value;
		var box = email.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(type=="focus") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "请使用xxxxxx@.163.com格式";
				return false;
			}
		}
		if(type=="blur") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}
		if(value=="") {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "邮箱不能为空";
			return false;
		} else if(regs.emailReg.test(value)) {
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "格式错误，请使用xxxxxx@.163.com格式";
			return false;
		}
	}
	*/
	platnumber.onkeyup=platnumber.onfocus=platnumber.onblur=function(evt){
		var e = evt||window.event;
		checkPlatnumber(e);
	}
	function checkPlatnumber(_e){
		var type;
		if(_e){
			type=_e.type;
		}
		var value=platnumber.value;
		var box = platnumber.parentNode;
		var tip=box.nextElementSibling;
		var span = tip.lastElementChild;
		if(type=="focus") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "请使用0511-4405222、021-87888822格式";
				return false;
			}
		}
		if(type=="blur") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;//不继续往下走
			}
		}
		if(value=="") {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "平台编号不能为空";
			return false;
		} else if(regs.platnumberReg.test(value)) {
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "格式错误，请使用0511-4405222、021-87888822格式";
			return false;
		}
	}
	/********************以上是用户名部分，以下是密码部分，类似上****************************************************/
	pwd.onkeyup=pwd.onfocus=pwd.onblur=function(evt) {
		var e = evt || window.event;
		checkPwd(e);
	}
	function checkPwd(_e) {
		var type;
		if(_e) {
			type = _e.type;
		}
		var value = pwd.value;
		var box = pwd.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(type=="focus") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "建议使用字母、数字和符号两种以上的组合,6-20个字符";
				return false;
			}
		}
		if(type=="blur") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip hide";
				return false;
			}
		}

		if(value=="") {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "密码不能为空";
			return false;
		} else if(regs.pwdReg.test(value)) {
			box.className = "box right";
			var level = getPwdLevel(value);
			switch(level) {
				case 1:
					tip.className = "tip ruo";
					break;
				case 2:
					tip.className = "tip zhong";
					break;
				case 3:
					tip.className = "tip qiang";
					break;
			}
			return true;
			// 弱  中  强
			// 字母、数字、特殊字符
			// level 1弱 2中  3强
			// tip ruo zhong qiang
			// jkj343?
			// tip.className = ""
		} else {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "密码长度应在6-20个字符之间";
			return false;
		}
	}
	pwd2.onkeyup=pwd2.onfocus=pwd2.onblur=function(evt) {
		var e = evt || window.event;
		checkPwd2(e);
	}
	function checkPwd2(_e) {
		var type;
		if(_e) {
			type = _e.type;
		}
		var value1 = pwd.value;
		var value = pwd2.value;
		var box = pwd2.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(type=="focus") {
			if(value=="") {
				box.className = "box";
				tip.className = "tip default";
				span.innerHTML = "请再次输入密码";
				return false;
			}
		}
		if(value == "") {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "请再次输入密码";
			return false;
		} else if(value1 == value) {
			box.className = "box right";
			tip.className = "tip hide";
			return true;
		} else {
			box.className = "box error";
			tip.className = "tip error";
			span.innerHTML = "两次密码不一致";
			return false;
		}
	}
	btn.onclick = function() {
		var box = ck.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(ck.checked) {
			if(checkUserName()&&checkPwd()&&checkPwd2()) {
				alert("可以注册");
			} else {
				return false;
			}
		} else {
			tip.className = "tip error";
			span.innerHTML = "请同意协议";
			return false;
		}
	}
	ck.onclick = function() {
		var box = ck.parentNode;
		var tip = box.nextElementSibling;
		var span = tip.lastElementChild;
		if(ck.checked) {
			tip.className = "tip hide";
		}
	}
}
function getPwdLevel(pwd) {
	var level = 0;
	var numReg=true, strReg=true, tsReg=true;
	for(var i=0; i<pwd.length; i++) {
		if(numReg&&regs.numReg.test(pwd[i])) {//test测试参数是否匹配正则表达式
			level++;
			numReg = false;
			continue;
		}
		if(strReg&&regs.strReg.test(pwd[i])) {
			level++;
			strReg = false;
			continue;
		}
		if(tsReg&&regs.tsReg.test(pwd[i])) {
			level++;
			tsReg = false;
		}
	}
	return level;
}
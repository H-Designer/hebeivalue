<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    

    <title>多条件检索</title>
    <script type="text/javascript" src="./js/jquery-1.4.2.min.js.下载"></script>
    <script type="text/javascript" src="./js/gb.ResultPage.min.js.下载"></script>
	<body>
	<form action="${pageContext.request.contextPath }/severLet/mulSeverlet" method="post">
        <table>
            <input id="txt_i" value="0" type="hidden" name="txt_i">
            <input id="txt_c" value="3" type="hidden" name="txt_c">
            <tbody><tr id="hidden_logical_txt" style="display:none">
                <td>
                    <select id="{key}_logical" name="{key}_logical">
                        <option value="and" selected="">并且</option>
                        <option value="or">或者</option>
                        <option value="not">不含</option>
                    </select>
                </td>
            </tr>
            <tr id="txt_1" class="mainKey">
                <td class="aomBtn">
                    <a href="javascript:AddRowEx(&#39;txt&#39;,&#39;txt_i&#39;,&#39;txt_c&#39;);">
                        <img src="./images/jia.gif" border="0">
                    </a><a href="javascript:DeleteRowSaveID(&#39;txt&#39;,&#39;txt_i&#39;,&#39;txt_c&#39;);">
                        <img src="./images/jian.gif" border="0">
                    </a>
                </td>
                <td>
                  (
                  <select id="txt_1_sel" name="txt_1_sel" onchange="disableWordTimes(this);return false;" class="selectW1">
                        <option value="platname" selected="">平台名称</option>
                        <option value="PingtaiLevel">平台级别</option>
                        <option value="location">所在省市</option>
                        <!--  
                        <option value="AB">摘要</option>
                        <option value="FT">全文</option>
                        <option value="RF">参考文献</option>
                        <option value="CLC$=|?">中图分类号</option>
                        -->
                    </select>
                    <input value="" id="txt_1_value1" name="txt_1_value1" size="10" maxlength="120" type="text" onfocus="if(KeywordVal(this.value)==false) this.value=&#39;&#39;;document.getElementById(&#39;currentid&#39;).value=this.id;" onkeypress="SignVal(this,&#39;sign&#39;,event)" onpaste="return SignVal(this,&#39;value&#39;,event)" onkeyup="SignVal1(this)">
                    
               
                    <select id="txt_1_relation" name="txt_1_relation">
                        <option value="#CNKI_AND" selected="">并含</option>
                        <option value="#CNKI_OR">或含</option>
                        <option value="#CNKI_NOT">不含</option>
                    </select>
                    <input value="" id="txt_1_value2" name="txt_1_value2" size="10" maxlength="120" type="text" onfocus="if(KeywordVal(this.value)==false) this.value=&#39;&#39;;document.getElementById(&#39;currentid&#39;).value=this.id;" onkeypress="SignVal(this,&#39;sign&#39;,event)" onpaste="return SignVal(this,&#39;value&#39;,event)" onkeyup="SignVal1(this)">
                    
                     <select id="txt_1_special1" name="txt_1_special1" onchange="">
                        <option value="%">模糊</option>
                        <option value="=" selected="">精确</option>
                    </select>
                    )
                </td>
            </tr><tr id="txt_2" class="mainKey">
                <td>
                    <select id="txt_2_logical" name="txt_2_logical">
                        <option value="and" selected="">并且</option>
                        <option value="or">或者</option>
                        <option value="not">不含</option>
                    </select>
                </td>
            
                
                <td>
                  (
                  <select id="txt_2_sel" name="txt_2_sel" onchange="disableWordTimes(this);return false;" class="selectW1">
                        <option value="platname" selected="">平台名称</option>
                        <option value="PingtaiLevel">平台级别</option>
                        <option value="location">所在省市</option>
                        <!--  
                        <option value="AB">摘要</option>
                        <option value="FT">全文</option>
                        <option value="RF">参考文献</option>
                        <option value="CLC$=|?">中图分类号</option>
                        -->
                    </select>
                    <input value="" id="txt_2_value1" name="txt_2_value1" size="10" maxlength="120" type="text" onfocus="if(KeywordVal(this.value)==false) this.value=&#39;&#39;;document.getElementById(&#39;currentid&#39;).value=this.id;" onkeypress="SignVal(this,&#39;sign&#39;,event)" onpaste="return SignVal(this,&#39;value&#39;,event)" onkeyup="SignVal1(this)">
                   
               
                    <select id="txt_2_relation" name="txt_2_relation">
                        <option value="#CNKI_AND" selected="">并含</option>
                        <option value="#CNKI_OR">或含</option>
                        <option value="#CNKI_NOT">不含</option>
                    </select>
                    <input value="" id="txt_2_value2" name="txt_2_value2" size="10" maxlength="120" type="text" onfocus="if(KeywordVal(this.value)==false) this.value=&#39;&#39;;document.getElementById(&#39;currentid&#39;).value=this.id;" onkeypress="SignVal(this,&#39;sign&#39;,event)" onpaste="return SignVal(this,&#39;value&#39;,event)" onkeyup="SignVal1(this)">
                    
                     <select id="txt_2_special1" name="txt_2_special1" onchange="">
                        <option value="%">模糊</option>
                        <option value="=" selected="">精确</option>
                    </select>
                    )
                </td>
            </tr>
            <tr>
            	<td><input type="submit" value="查询"></td>
            </tr>
        </tbody>
        </table>
        </form>
</body>
</html>
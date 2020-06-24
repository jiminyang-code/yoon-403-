<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");

	response.setHeader("Cache-Contro", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expries", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset = utf-8">
<title>style test</title>

<!--<link href = "./test_main.css" rel = "stylesheet" type = "text/css">-->

<script language="JavaScript" type="text/JavaScript">
var xhrObject;

function createXHR() 
{
	if (window.ActiveXObject) 
	{
		xhrObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(window.XMLHttpRequest)
}
xhrObject = new XMLHttpRequest();
}
}
function getData() 
{	
	//alert("3");
	var form_name = "form_main";
	var user_id = document.forms[form_name].elements["txt_user_id"].value;
	
	createXHR();
	
	var url = "./testFile.jsp;"
	
	var reqparam = "user_id=" + user_id;
	xhrObject.onreadystatechange = resGetData;
	xhrObject.open("Post",url,"true");
	xhrObject.setPequestHeader("Content-Type","application/x-www-form-urlencoded;charset = utf-8")
	xhrObject.send(reqparam);
}

// function resGetData() {
// 	if (xhrObject.readyState == 4) {
// 		if (xhrObject.eadyState == 200) {
// 		var result = xhrObject.responseText;
// 		var objRes = eval("("+result+")");
// 		var num = objRes.datas.length;
// 		var res = "<table cellpadding = '3' cellspacing = '0' border = '1' width = '980'>";
// 		var resDiv = document.getElementById("div_res");
		 
// 		if (num < 1) {
// 			res += "<tr><td width : '980' height : '100' align : 'center' style = 'fotn-size : 50;'>검색 결과가 없습니다.</td></tr>";
// 		} else {
// 			for (var i=0; i<num; i++) {
// 				var user_id = objRes.datas[i].ID;
// 				var user_name = objRes.datas[i].NAME;
// 				var user_phone = objRes.datas[i].PHONE;
				
// 				res += "<tr>";
// 				res += "<td width = '980' height = '100' align = 'center' style = 'font-size : 50' bgcolor = '#D0E6FC'>"+ user_id +"</td>";
// 			  	res += "</tr>"
				
// 			  	res += "<tr>";
// 				res += "<td width = '980' height = '100' align = 'center' style = 'font-size : 50' bgcolor = '#FFFFCC'><br>+ user_name +"<br></td>";
// 			    res += "</tr>";
				
// 				res += "<tr>";
// 				res += "<td width = '980' height = '100' align = 'center' style = 'font-size : 50' bgcolor = '#FFFFCC'><br>+ user_phone +"<br></td>";
// 			    res += "</tr>";
// 			}
// 		}
// 		res += "</table>";
// 		resDiv.innerHTML = res;
// 	  }
//    }
// }

function searchData() 
{
	alert("2");
	var form_name = "form_main";
	var user_id = document.forms[form_name].elements["txt_user_id"].value;
	
	if (user_id == "") 
	{
		alert("user_id를 입력해주세요~^^a");
		document.forms[form_name].elements["txt_user_id"].focus();
		return;
	} 
	else 
	{
		getData();
	}
}
</script>
</head>
<body>
	<div id='div_main' width='980' height="300"
		style="visibility: visible; position: absolute; left: 0px; top: 115px; z-index: 1;">
		<table border='0' width='980' cellpadding='0' cellspacing='0'>
			<form name="form_main" onSubmit="javascript:return false;">
				<tr>
					<td width='245'></td>
					<td width='245' align='right'><input type='text'
						name='txt_user_id' size='10' value='' maxlength='10'
						style='width: 240px; font-size: 50; text-align: left;'
						onkeyup='javascript:searchData();'></td>
					<td width='245'><input type = 'submit' onClick='javascript:searchData();'>
					<!--<img src='./img/search.jpg' width='70' height='70' onClick='javascript:searchData();'>-->
					</td>
					<td width='245'></td>
				</tr>
			</form>
		</table>
	</div>
	<div id = 'div_res' width = '980' style = ""visibility : visible; position : absolute; left : 0px; top : 215px; z-index : 1;">
	<table border='1' width='980' cellpadding='10' cellspacing='0'>
		<tr>
			<td align = 'center' style = 'width : 950px; font-size : 50' bgcolor = '#FFFFCC' >결과물</td>
		</tr>
	</table>
	</div>
</body>
</html>

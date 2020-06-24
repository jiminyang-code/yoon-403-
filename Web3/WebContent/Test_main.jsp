<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>style test</title>

<script language="JavaScript" type="text/JavaScript">
	var xhrObject;

	function createXHR() {
		if (window.ActiveXObject) {
			xhrObject = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest)

		{
			//ajax객체 만들기 -> 완생 이 됨!
			xhrObject = new XMLHttpRequest();
		}
	}

	//ajax 요청 함수 (request)
	function selectBook() {
		// 			alert("나 select");

		var url = "./selectBook.jsp";

		var form_name = "form_main";
		var book_name = document.forms["form_main"].elements["book_name"].value;
		// 			var book_id = "1";

		// 			var reqparam = "book_id=" + book_id;
		var reqparam = "book_name=" + book_name;

		createXHR(); // XMLHttpRequest; -> XHR

		xhrObject.onreadystatechange = resSelectBook; //응답함수 등록(register)! 
		xhrObject.open("post", url, "true");
		xhrObject.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");
		xhrObject.send(reqparam);
		//	alert("send 함!!!")
	}

	//ajax 응답 함수(response)
	function resSelectBook() {
		if (xhrObject.readyState == 4) {
			// 				alert("4번 통과 서버주소 올바름");

			if (xhrObject.status == 200) {
				// 					alert("200번 통과 서버에서 값을 제대로 줌");

				//ajax 객체에서 받아온 값들을 처리!! 최종적으로 HTML로 변환
				var result = xhrObject.responseText; //Text 타입임
				var objRes = eval("(" + result + ")");//Text -> Json 객체 타입으로 변환
				var num = objRes.datas.length;
				var res = "<table cellpadding = '3' cellspacing = '0' border = '1' width = '980'>";
				var resDiv = document.getElementById("div_res");

				if (num < 1) {
					alert("값이 하나도 없다!");
				} else {
					for (var i = 0; i < num; ++i) {
						var bookid = objRes.datas[i].BOOKID;
						var bookname = objRes.datas[i].BOOKNAME;
						var publisher = objRes.datas[i].PUBLISHER;
						var price = objRes.datas[i].PRICE;

						// 							alert(bookid +","+bookname +","+publisher +","+price)

						res += "<tr>";
						res += "<td width = '100' height = '100' align = 'center' style = 'font-size : 50' bgcolor = '#D0E6FC'>"
								+ bookid + "</td>";
						res += "<td width = '300' align = 'center' style = 'font-size : 50' bgcolor = '#FFFFCC'><br>"
								+ bookname + "<br></td>";
						res += "<td width = '380' align = 'center' style = 'font-size : 50' bgcolor = '#FFFFCC'><br>"
								+ publisher + "<br></td>";
						res += "<td width = '280' align = 'center' style = 'font-size : 50' bgcolor = '#FFFFCC'><br>"
								+ price + "<br></td>";
						res += "</tr>";

					}

					//alert(res);
					res += "</table>";
					resDiv.innerHTML = res;

				}
			}
		}
	}

	function searchData() {
		// 			alert("안녕!");

		// 			var user_id = document.forms["form_main"].elements["txt_user_id"].value;

		// 			if(user_id == "")
		// 			{
		// 				alert("값을 입력해라!!");
		// 			}
		// 			else
		// 			{
		selectBook();
		// 			}

	}
</script>

</head>

<body>
	<div id='div_main' width='980' height="300"
		style="visibility: visible; position: absolute; left: 0px; top: 115px; z-index: 1;">

		<table border='1' width='980' cellpadding='0' cellspacing='0'>
			<form name="form_main" onSubmit="javascript : return false;">
				<tr>

					<td width='245'></td>
					<td width='245' align='right'><input type='text'
						name='book_name' size='10' value='' maxlength='10'
						style='width: 240px; font-size: 50; text-align: left;'
						onkeyup='javascript:;'></td>

					<td width='245'><img src='./img/search.gif' width='245'
						height='100' onClick='javascript:searchData();'></td>
					<td width='245'></td>

				</tr>
			</form>

		</table>
	</div>

	<div id='div_res' width='980'
		style="visibility: visible; position: absolute; left: 0px; top: 215px; z-index: 1;">
		<table border='1' width='980' cellpadding='10' cellspacing='0'>
			<tr>

				<td align='center' style='width: 950px; font-size: 50'
					bgcolor='#FFFFCC'>결과물</td>

			</tr>
		</table>
	</div>

</body>
</html>
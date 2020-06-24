
<%@ page import="java.sql.*" contentType="text/html;charset=EUC-KR" %>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
Connection dbconn=DriverManager.getConnection(url, "c##madang", "c##madang");
Statement stmt = dbconn.createStatement();

String cust_id = request.getParameter("custid");

String query ="";
query += " select ";
query += " 			customer.custid cid , name,  orderid, bookname, publisher "; 
query += " from  ";
query += " 			customer, orders, book ";
query += " where ";
query += " 			customer.custid = orders.custid ";
query += " 		and orders.bookid = book.bookid ";
query += " 		and customer.custid = "+ cust_id ;

System.out.println(query);

ResultSet myResultSet=stmt.executeQuery(query);
 if(myResultSet!=null)
 {
// 	 while(myResultSet.next())
// 	 {
%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=EUC-KR">
<title>** BOOK VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">

<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
  bordercolordark="white" bordercolorlight="#B9E0FA">  
	<tr>
		  <td width="150" height="23" bgcolor="#D2E9F9">
		   <p align="center">
		   <span style="font-size:9pt;"><b>고객 아이디</b></span></p>
		  </td>
		  <td width="150" height="23" bgcolor="#D2E9F9">
		   <p align="center">
		   <span style="font-size:9pt;"><b>고객이름</b></span></p>
		  </td>
		  <td width="150" height="23" bgcolor="#D2E9F9">
		   <p align="center">
		   <span style="font-size:9pt;"><b>주문번호</b></span></p>
		  </td>
		  <td width="150" height="23" bgcolor="#D2E9F9">
		   <p align="center">
		   <span style="font-size:9pt;"><b>책이름</b></span></p>
		  </td>
		  <td width="150" height="23" bgcolor="#D2E9F9">
		   <p align="center">
		   <span style="font-size:9pt;"><b>출판사</b></span></p>
		  </td>
		  
	</tr>

<%
	while(myResultSet.next())
	{
%>



 
 <tr>

  <td width="150">
   <p><span style="font-size:9pt;">
   <%=myResultSet.getString("CID")%></span></p>
  </td>
  
  <td width="150">
   <p><span style="font-size:9pt;">
   <%=myResultSet.getString("NAME")%></span></p>
  </td>  
  
  <td width="150">
   <p><span style="font-size:9pt;">
   <%=myResultSet.getString("ORDERID")%></span></p>
  </td>  
  
  <td width="150">
   <p><span style="font-size:9pt;">
   <%=myResultSet.getString("BOOKNAME")%></span></p>
  </td> 
  
  <td width="150">
   <p><span style="font-size:9pt;">
   <%=myResultSet.getString("PUBLISHER")%></span></p>
  </td>  

 </tr> 
 

<% 
	 }
 }
 stmt.close();
 dbconn.close();
%>  
</table>

<table cellpadding="0" cellspacing="0" width="400" height="23">
 <tr>
  <td width="150">
   <p align="right"><span style="font-size:9pt;">
   <a href="customer_list.jsp?">
   <font color="black">목록</font></a></span></p>
  </td>
 </tr>
</table>

</body>
</html>
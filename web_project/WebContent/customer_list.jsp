<%@ page import="java.sql.*" contentType="text/html;charset=EUC-KR" %>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
Connection dbconn=DriverManager.getConnection(url, "c##madang", "c##madang");
Statement stmt = dbconn.createStatement();
ResultSet myResultSet=stmt.executeQuery("SELECT custid, name, address, phone FROM customer");
%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=EUC-KR">
<title>** BOOK LIST **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
  bordercolordark="white" bordercolorlight="#B9E0FA">  
 <tr>
  
  <td width="150" height="20" bgcolor="#D2E9F9">
   <p align="center">
   <span style="font-size:8pt;"><b>�� ���̵�</b></span></p>
  </td>
  
  <td width="150" height="20" bgcolor="#D2E9F9">
   <p align="center">
   <span style="font-size:8pt;"><b>�� �̸�</b></span></p>
  </td>
  
  <td width="150" height="20" bgcolor="#D2E9F9">
   <p align="center">
   <span style="font-size:8pt;"><b>�ּ�</b></span></p>
  </td> 
  
   <td width="150" height="20" bgcolor="#D2E9F9">
   <p align="center">
   <span style="font-size:8pt;"><b>��ȭ ��ȣ</b></span></p>
  </td>
 
 </tr> 
<%
if(myResultSet!=null){
while(myResultSet.next()){
 String W_CUSTID 	= myResultSet.getString("custid");
 String W_NAME	 	= myResultSet.getString("name");
 String W_ADDRESS	= myResultSet.getString("address");
 String W_PHONE 	= myResultSet.getString("phone");
 %> 
 <tr>
  
  <td width="150" height="20" align="center">
   <p><span style="font-size:9pt;">
   <a href="cutomer_order_view.jsp?custid=<%=W_CUSTID%>">
   <font face="����ü" color="black">
   <%=W_CUSTID%></font></a></span></p>
  </td>
  
  <td width="150" height="20">
   <p align="center"><span style="font-size:9pt;">
   <font face="����ü"><%=W_NAME%></font></span></p>
  </td>
  
  <td width="150" height="20">
   <p align="center"><span style="font-size:9pt;">
   <font face="����ü"><%=W_ADDRESS%></font></span></p>
  </td>
  
  <td width="150" height="20">
   <p align="center"><span style="font-size:9pt;">
   <font face="����ü"><%=W_PHONE%></font></span></p>
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
  <td width="1350">
   <p align="right"><b><a href=customer_list.jsp>
   <font size="1" face="����ü" color="black">LIST</font></a></b></p>
  </td>
 </tr>
</table>
</body>
</html>

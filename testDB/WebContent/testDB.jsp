<%@ page contentType = "text/html; charset = EUC-KR" pageEncoding = "EUC-KR"%>
<%@ page import="db.beans.*" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*"%>

<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<% 
 
 response.setHeader("Cache-Contro","no-store");
 response.setHeader("Pragma","no-cache");
 response.setDateHeader("Expries",0); 
 
 request.setCharacterEncoding("UTF-8");
 
 QueryBean.getConnection();
 
 ArrayList resArr = new ArrayList();
 
 try {
	 resArr = QueryBean.getUserInfo();
	 }
 catch(SQLException e) {
	 out.print(e.toString());
 }
 finally {
 QueryBean.closeConnection();
 }
 
 out.println("{");
 out.println("\"datas\":[");
 
 if(resArr.size() == 0) {
	 out.println("]");
	 out.println("}");
 }
 else {
 out.print("{ ");
 out.print("\"ID\": \""            +(String)resArr.get(0) + "\",");
 out.print("\"NAME\": \""          +(String)resArr.get(1) + "\",");
 out.print("\"PHONE\": \""         +(String)resArr.get(2) + "\","); 
 out.print("\"GRADE\": \""         +(String)resArr.get(3) + "\",");
 out.print("\"WRITE_TIME\": \""       +(String)resArr.get(4) + "\" ");
 out.print("} ");
 
 for(int i = 5; i < resArr.size(); i += 5) {
	 out.print(",");
	 out.print("{ ");
	 out.print("       \"ID\": \""           +(String)resArr.get(i) + "\",");
	 out.print("       \"NAME\": \""      +(String)resArr.get(i+1) + "\",");
	 out.print("       \"PHONE\": \""     +(String)resArr.get(i+2) + "\","); 
	 out.print("       \"GRADE\": \""     +(String)resArr.get(i+3) + "\",");
	 out.print("       \"WRITE_TIME\": \""     +(String)resArr.get(i+4) + "\" ");
	
	 out.print("} ");
 }
 out.println("]");
 out.println("}");
 }
 %>











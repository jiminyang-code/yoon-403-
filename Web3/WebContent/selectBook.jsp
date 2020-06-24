<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*,java.net.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />

<%
// 	response.setHeader("Cache-Control", "no-store");
// 	response.setHeader("Pragma", "no-cache");
// 	response.setDateHeader("Expires", 0);

	request.setCharacterEncoding("UTF-8");
	



	QueryBean.getConnection();

	String book_name = (request.getParameter("book_name") == null) 
						? "축구" 
						: request.getParameter("book_name");  
	
// 	String book_name = request.getParameter("book_name");
	
// 	if(book_name == null)
// 		book_name = "";
	
	System.out.println("이름확인="+book_name);
	
	ArrayList resArr = new ArrayList();

	try {
		resArr = QueryBean.selectBook(book_name);
		
		//QueryBean.insertUserInfo();

	} catch (SQLException e) {
		out.print(e.toString());
	} finally {
		QueryBean.closeConnection();
	}

	out.println("{");
	out.println("\"datas\":[");

	if (resArr.size() == 0) {
		out.println("]");
		out.println("}");
	}else {
		out.println("{ ");
		out.println("\"BOOKID\": \""     + (String)resArr.get(0) + "\", ");
		out.println("\"BOOKNAME\": \""   + (String)resArr.get(1) + "\", ");
		out.println("\"PUBLISHER\": \""  + (String)resArr.get(2) + "\", ");
		out.println("\"PRICE\": \""      + (String)resArr.get(3) + "\" ");
		out.println("} ");
		
		for (int i = 4; i <resArr.size(); i+=4){
			out.println(",");
			out.println("{ ");
			out.println("     \"BOOKID\": \""    + (String)resArr.get(i) + "\", ");
			out.println("     \"BOOKNAME\": \""  + (String)resArr.get(i+1) + "\", ");
			out.println("     \"PUBLISHER\": \"" + (String)resArr.get(i+2) + "\", ");
			out.println("     \"PRICE\": \""     + (String)resArr.get(i+3) + "\" ");
			
			out.println("} ");
		}
		out.println("] ");
		out.println("} ");
	}
%>
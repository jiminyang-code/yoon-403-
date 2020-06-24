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

	//클라이언트에서 받아 오는 부분(현재는 javascript에서(test_main.jsp안에 있느))
	String bookid = (request.getParameter("book_id") == null) 
						? "100" 
						: request.getParameter("book_id").trim();
	
	String bookname = (request.getParameter("book_name") == null) 
			? "배구 기초" 
			: request.getParameter("book_name").trim();
	
	String publisher = (request.getParameter("publisher") == null) 
			? "마린출판사" 
			: request.getParameter("publisher").trim();
	
	String price = (request.getParameter("price") == null) 
			? "17500" 
			: request.getParameter("price").trim();
	

	
	System.out.println("책 아이디="+bookid);
	System.out.println("책 이름="+bookname);
	System.out.println("출판사="+publisher);
	System.out.println("가격="+price);
	
	int result = QueryBean.insertBook(bookid, bookname, publisher, price);
	
// 	{"RESULT_OK":"1"}
	
	out.print(" { ");
	out.print("	\"RESULT_OK\": \""+result+" \""); 
	out.print(" } ");
	
	
	
// 	ArrayList resArr = new ArrayList();

// 	try {
// 		resArr = QueryBean.selectBook(book_name);
		
// 		//QueryBean.insertUserInfo();

// 	} catch (SQLException e) {
// 		out.print(e.toString());
// 	} finally {
// 		QueryBean.closeConnection();
// 	}

// 	out.println("{");
// 	out.println("\"datas\":[");

// 	if (resArr.size() == 0) {
// 		out.println("]");
// 		out.println("}");
// 	}else {
// 		out.println("{ ");
// 		out.println("\"BOOKID\": \""     + (String)resArr.get(0) + "\", ");
// 		out.println("\"BOOKNAME\": \""   + (String)resArr.get(1) + "\", ");
// 		out.println("\"PUBLISHER\": \""  + (String)resArr.get(2) + "\", ");
// 		out.println("\"PRICE\": \""      + (String)resArr.get(3) + "\" ");
// 		out.println("} ");
		
// 		for (int i = 4; i <resArr.size(); i+=4){
// 			out.println(",");
// 			out.println("{ ");
// 			out.println("     \"BOOKID\": \""    + (String)resArr.get(i) + "\", ");
// 			out.println("     \"BOOKNAME\": \""  + (String)resArr.get(i+1) + "\", ");
// 			out.println("     \"PUBLISHER\": \"" + (String)resArr.get(i+2) + "\", ");
// 			out.println("     \"PRICE\": \""     + (String)resArr.get(i+3) + "\" ");
			
// 			out.println("} ");
// 		}
// 		out.println("] ");
// 		out.println("} ");
// 	}
%>
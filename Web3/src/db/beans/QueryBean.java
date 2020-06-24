package db.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public QueryBean() {

		conn = null;
		stmt = null;
		rs = null;
	}

	public void getConnection() {

		try {
			conn = DBConnection.getConnection();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConnection() {
			if (stmt != null) 
			{ 
				try {
					stmt.close(); 
				}catch (SQLException e) {
					e.printStackTrace();
				}
				}
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}
	
	class User{
		String userid;
		String name;
		String grade;
		String phone;
		String write_time;
	}

	public ArrayList selectBook(String book_name) throws Exception 
	{
		StringBuffer sb = new StringBuffer();
		
//		String str = "";
//		str += " SELECT ";
		
		sb.append(" SELECT ");
		sb.append("     BOOKID, BOOKNAME, PUBLISHER, PRICE ");
		sb.append(" FROM ");
		sb.append("     BOOK ");
		sb.append(" WHERE BOOKNAME LIKE '%"+ book_name +"%' ");
		
		System.out.println(sb.toString());
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();

		while (rs.next()){
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));			

		}
			System.out.println(sb.toString());
			return res;
	}
	
	public int insertBook(String bookid, String bookname, String publisher, String price) throws Exception 
	{
		StringBuffer sb = new StringBuffer();
		
		//프리 스테이트먼트 
		PreparedStatement p_stmt = null;
		
		sb.append(" INSERT INTO ");
		sb.append(" 		BOOK(BOOKID, BOOKNAME, PUBLISHER, PRICE) ");
		sb.append(" VALUES ");
		sb.append(" 		(?,?,?,?) ");
//		sb.append(" 		("+bookid+",'"+bookname+"','"+publisher+"', "+price+") ");
				
		System.out.println(sb.toString());
		
		//rs = stmt.executeQuery(sb.toString());
		//int result = stmt.executeUpdate(sb.toString());//pre로 교체!
		
		p_stmt = conn.prepareStatement(sb.toString());
		
		p_stmt.clearParameters();
//		p_stmt.setInt(1, 54);
//		p_stmt.setString(2, "농구의 역사");
//		p_stmt.setString(3, "이지출판사");
//		p_stmt.setInt(4, 35000);
		
		p_stmt.setString(1, bookid);
		p_stmt.setString(2, bookname);
		p_stmt.setString(3, publisher);
		p_stmt.setString(4, price);
		
		int result = p_stmt.executeUpdate();
		
//		ArrayList res = new ArrayList();

//		while (rs.next()){
//			res.add(rs.getString(1));
//			res.add(rs.getString(2));
//			res.add(rs.getString(3));
//			res.add(rs.getString(4));			
//		}
//			System.out.println(sb.toString());
			return result;
	}
}	
package Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bookstore // DB + 서점(책,고객)
{
	Connection con;
	Statement stmt;
	ResultSet rs;

	Book[] book1;

//	Customer[] cs1;

	public Bookstore() {
		book1 = new Book[10]; // 배열 공간만 만들어짐!
		for (int i = 0; i < 10; ++i)
			book1[i] = new Book();

//		cs1 = new Customer[5];
//		
//		for(int i=0; i<5; ++i)
//			cs1[i] = new Customer();

	}

	public void getCon() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "c##madang"; // c##추가
		String pwd = "c##madang"; // c##추가

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);

			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void selectBook() {
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");

			int index = 0;
			while (rs.next()) {
				book1[index].bookid = rs.getInt(1);
				book1[index].bookname = rs.getString(2);
				book1[index].publisher = rs.getString(3);
				book1[index].price = rs.getInt(4);

				index++;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	void selectCustomer() 
//	{  
//		String query = "SELECT * FROM customer";
//		try {
//			stmt = con.createStatement(); // 2
//			rs = stmt.executeQuery(query); // 3
//			
//			int index =0;
//			while (rs.next()) {
//				cs1[index].custid	 = rs.getInt(1);
//				cs1[index].name 	 	= rs.getString(2);
//				cs1[index].address	= rs.getString(3);
//				cs1[index].phone 	 = rs.getString(4);
//				
//				index++;
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}

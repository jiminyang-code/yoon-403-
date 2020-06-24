package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//클래스선언
public class booklist {
	// 1.멤버변수(필드)선언
	Connection con;
	Statement stmt;
    ResultSet rs;

	// 1.멤버변수(book) for use more than once
	// 1-1.변수타입
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;

	// 1-2.배열타입
//	int    bookid;
//	String bookname;
//	String publisher;
//	int    price;

 // 1-3.객체 타입 멤버 변수 만들기(객체를 만든다. cf)여기서 클래스 만드는게 아님)
// 	Book book1;
    
 // 1-4.객체배열 타입 멤버 변수 만들기
// 	Book[] book1;

	// 2.생성자(메소드)선언
	public booklist() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "c##madang"; // c##추가
		String pwd = "c##madang"; // c##추가

		// driver를 로드함
		try { // 예외처리
				// 에러의 두종류(크게보면)*컴파일타임에러 *런타임에러
				// ojdbc jar에 있는 oracledriver클래스를 링크
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 연결 객체를 생성함--> new Connection();
		try { // 예외처리
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3.(일반)메소드선언
	void sqlRun() {
		String query = "SELECT * FROM book";
		try {
			// sqlRun지역변수를 booklist클래스의 멤버변수로
			// 지역변수 -> 멤버로 상향
			Statement stmt = con.createStatement(); // 2
			ResultSet rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
//       int index = 0;
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getInt(4));
				// 1-1변수타입사용
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);

				// 1.2 배열타입 사용
//				bookid[index] 	 = rs.getInt(1);
//				bookname[index]  = rs.getString(2);
//				publisher[index] = rs.getString(3);
//				price[index] 	 = rs.getInt(4);

				// 1.3 객체타입 사용
//				book1.bookid	 = rs.getInt(1);
//				book1.bookname  = rs.getString(2);
//				book1.publisher = rs.getString(3);
//				book1.price 	 = rs.getInt(4);
				
//				book1[index].bookid	 = rs.getInt(1);
//				book1[index].bookname  = rs.getString(2);
//				book1[index].publisher = rs.getString(3);
//				book1[index].price 	 = rs.getInt(4);
//				
				// index = index+1;
//				index++;
			}
			con.close(); // 연결끊기
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	 public static void main (String args[]) { //메소드이면서 프로그램실행에 관여함
//			booklist so = new booklist();
//			so.sqlRun();
//		}
//	void printbook() {

	// 1-1 변수타입 사용 예
//	System.out.print(bookid+"\t");
//	System.out.print(bookname+"\t");
//	System.out.print(publisher+"\t");
//	System.out.println(price);

	// 1-2 배열타입 사용 예
//	for(int i=0; i<10; ++i)
//	{
//		System.out.print(bookid[i]+"\t");
//		System.out.print(bookname[i]+"\t\t");
//		System.out.print(publisher[i]+"\t\t");
//		System.out.println(price[i]);
//	}

	// 1-3 객체 타입 사용 예
//	System.out.print(book1.bookid+"\t");
//	System.out.print(book1.bookname+"\t");
//	System.out.print(book1.publisher+"\t");
//	System.out.println(book1.price);

	// 1-4.객체배열 타입 사용 예
//	for(int i=0; i<10; ++i)
//	{
//		System.out.println(book1[i].bookid+"\t"
//						+book1[i].bookname+"\t\t"
//						+book1[i].publisher+"\t\t"
//						+book1[i].price);
//	}


}

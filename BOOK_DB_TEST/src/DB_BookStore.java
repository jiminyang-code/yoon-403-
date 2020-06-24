
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//클래스 만들기, 클래스 정의(define)
public class DB_BookStore //DB + 서점(책,고객)
{
	//1.멤버 변수(==필드) 만들기, 변수 선언(declare)
	Connection con; // 데이터 베이스와 연결을 위한 객체
	Statement stmt; // SQL 문을 데이터베이스에 보내기위한 객체
	ResultSet rs; // SQL 질의에 의해 생성된 테이블을 저장하는 객체

	
	//1.멤버 변수 (book) 만들기, 만드는 이유? 여러 번 사용하기위해서!
//	//1-1.변수 타입 멤버 변수 만들기
//	int 	bookid;
//	String	bookname;
//	String	publisher;
//	int		price;
	
	//1-2.배열 타입 멤버 변수 만들기,
//	int[] 	 bookid;
//	String[] bookname	= new String[10];
//	String[] publisher  = new String[10];
//	int[]	 price		= new int[10];
	
//	//4.클래스 만들기( BookList 클래스 내부에 있는 Book이라는 클래스)
//	class Book{
//		int 	bookid;
//		String	bookname;
//		String	publisher;
//		int		price;
//	}
	//1-3.객체 타입 멤버 변수 만들기(객체를 만든다. cf)여기서 클래스 만드는게 아님)
//	Book book1;
	
	//1-4.객체배열 타입 멤버 변수 만들기
	Book[] book1;
	
	
	//2.생성자 (메소드)	만들기, 정의하다(define)
	//생성자 없음
	//생성자 다시 만듦 -> 초기화???? 
	public DB_BookStore()
	{
		//bookid = new int[10];
		//book1 = new Book(); //1-3.객체타입
		//1-4.객체 배열 타입 초기화
		book1 = new Book[10]; //배열 공간만 만들어짐!
		
//		book1[0] = new Book();
//		book1[1] = new Book();
//		book1[2] = new Book();
//		book1[3] = new Book();
//		book1[4] = new Book();
//		book1[5] = new Book();
		
		//객체배열 Book[] 안에 객체 new Book()를 10개 만든다.
		for(int i=0; i<10; ++i)
		{
			book1[i] = new Book();
		}
		
	}
	
	
	//3.일반 메소드
 	public void getCon() 
	{	
		//멤버변수???는 아니다! Booklist생성자메소드 지역의 "지역변수"
 		//데이터베이스에 연결하기 위한 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결문자열
		String userid = "c##madang"; //데이터베이스 userid
		String pwd = "c##madang"; //데이터베이스 pwd

		//하는일 1.드라이버 로드
		try {// 예외 처리? 에러를 처리하는 거!
			//에러는 2종류가 있다 . 첫번째. 컴파일 에러, 두번째 런타임 에러
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar에 있는   OracleDriver 클래스를 링크 //드라이버로딩
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//하는일 2.연결 객체 생성-> new Connetion(); 
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd); //Connection 객체를 생성 //DB연결
			
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//3.(일반) 메소드 만들기, 정의하다(define)
	void selectBook() 
	{  
		try {
			//sqlRun지역의 지역변수를 BookList클래스의 멤버변수로
			//지역변수 -> 멤버로 상향
			stmt = con.createStatement(); //Statement 객체를 생성(Statement --> SQL문을 데이터베이스에 보내기위한 객체입니다.)
			String query = "SELECT * FROM book";
			rs = stmt.executeQuery(query); // rs = stmt.excuteQuery(SQL) --> SQL 질의 결과를 ResultSet에 저장합니다. //Select
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE"); 
			int index = 0;
			while (rs.next()) { //rs.next() 를 이용해서 커서를 이동합니다. ResultSet에 저장된 데이터 얻기 결과가 2개 이상인 경우 --> while(rs.next()) {} 
				
				//DB에서 값을 꺼내온다. 한컬럼을
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1.1 변수타입 사용
				//문제 1개 밖에 안남김, 계속 덮어씀, 결국 마지막 값만 담김
//				bookid 	 = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher= rs.getString(3);
//				price 	 = rs.getInt(4);
				
				//1.2 배열타입 사용
//				bookid[index] 	 = rs.getInt(1);
//				bookname[index]  = rs.getString(2);
//				publisher[index] = rs.getString(3);
//				price[index] 	 = rs.getInt(4);
				
				//1.3 객체타입 사용
//				book1.bookid	 = rs.getInt(1);
//				book1.bookname  = rs.getString(2);
//				book1.publisher = rs.getString(3);
//				book1.price 	 = rs.getInt(4);
				
				
				//1.4 ?
				book1[index].bookid	 = rs.getInt(1); //rs.getInt(“컬럼순번”)
				book1[index].bookname  = rs.getString(2); //rs.getString(“컬럼”)
				book1[index].publisher = rs.getString(3); //rs.getString(“컬럼”)
				book1[index].price 	 = rs.getInt(4); //rs.getInt(“컬럼순번”)
				
//				//index = index+1;
				index++;
		

			}
			con.close();//연결을 끊어준다 중요!
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
//	//3.메소드 만들기
//	void printBook()
//	{
//		//1-1 변수타입 사용 예
////		System.out.print(bookid+"\t");
////		System.out.print(bookname+"\t");
////		System.out.print(publisher+"\t");
////		System.out.println(price);
//		
//		//1-2 배열타입 사용 예
////		for(int i=0; i<10; ++i)
////		{
////			System.out.print(bookid[i]+"\t");
////			System.out.print(bookname[i]+"\t\t");
////			System.out.print(publisher[i]+"\t\t");
////			System.out.println(price[i]);
////		}
//		
//		//1-3 객체 타입 사용 예
////		System.out.print(book1.bookid+"\t");
////		System.out.print(book1.bookname+"\t");
////		System.out.print(book1.publisher+"\t");
////		System.out.println(book1.price);
//		
//		//1-4.객체배열 타입 사용 예
//		for(int i=0; i<10; ++i)
//		{
//			System.out.println(book1[i].bookid+"\t"
//							+book1[i].bookname+"\t\t"
//							+book1[i].publisher+"\t\t"
//							+book1[i].price);
//		}
//	}
	
}

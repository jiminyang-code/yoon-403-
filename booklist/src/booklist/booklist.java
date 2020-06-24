package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//Ŭ��������
public class booklist {
	// 1.�������(�ʵ�)����
	Connection con;
	Statement stmt;
    ResultSet rs;

	// 1.�������(book) for use more than once
	// 1-1.����Ÿ��
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;

	// 1-2.�迭Ÿ��
//	int    bookid;
//	String bookname;
//	String publisher;
//	int    price;

 // 1-3.��ü Ÿ�� ��� ���� �����(��ü�� �����. cf)���⼭ Ŭ���� ����°� �ƴ�)
// 	Book book1;
    
 // 1-4.��ü�迭 Ÿ�� ��� ���� �����
// 	Book[] book1;

	// 2.������(�޼ҵ�)����
	public booklist() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "c##madang"; // c##�߰�
		String pwd = "c##madang"; // c##�߰�

		// driver�� �ε���
		try { // ����ó��
				// ������ ������(ũ�Ժ���)*������Ÿ�ӿ��� *��Ÿ�ӿ���
				// ojdbc jar�� �ִ� oracledriverŬ������ ��ũ
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ���� ��ü�� ������--> new Connection();
		try { // ����ó��
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3.(�Ϲ�)�޼ҵ弱��
	void sqlRun() {
		String query = "SELECT * FROM book";
		try {
			// sqlRun���������� booklistŬ������ ���������
			// �������� -> ����� ����
			Statement stmt = con.createStatement(); // 2
			ResultSet rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
//       int index = 0;
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getInt(4));
				// 1-1����Ÿ�Ի��
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);

				// 1.2 �迭Ÿ�� ���
//				bookid[index] 	 = rs.getInt(1);
//				bookname[index]  = rs.getString(2);
//				publisher[index] = rs.getString(3);
//				price[index] 	 = rs.getInt(4);

				// 1.3 ��üŸ�� ���
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
			con.close(); // �������
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	 public static void main (String args[]) { //�޼ҵ��̸鼭 ���α׷����࿡ ������
//			booklist so = new booklist();
//			so.sqlRun();
//		}
//	void printbook() {

	// 1-1 ����Ÿ�� ��� ��
//	System.out.print(bookid+"\t");
//	System.out.print(bookname+"\t");
//	System.out.print(publisher+"\t");
//	System.out.println(price);

	// 1-2 �迭Ÿ�� ��� ��
//	for(int i=0; i<10; ++i)
//	{
//		System.out.print(bookid[i]+"\t");
//		System.out.print(bookname[i]+"\t\t");
//		System.out.print(publisher[i]+"\t\t");
//		System.out.println(price[i]);
//	}

	// 1-3 ��ü Ÿ�� ��� ��
//	System.out.print(book1.bookid+"\t");
//	System.out.print(book1.bookname+"\t");
//	System.out.print(book1.publisher+"\t");
//	System.out.println(book1.price);

	// 1-4.��ü�迭 Ÿ�� ��� ��
//	for(int i=0; i<10; ++i)
//	{
//		System.out.println(book1[i].bookid+"\t"
//						+book1[i].bookname+"\t\t"
//						+book1[i].publisher+"\t\t"
//						+book1[i].price);
//	}


}

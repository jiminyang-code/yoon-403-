
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//Ŭ���� �����, Ŭ���� ����(define)
public class DB_BookStore //DB + ����(å,��)
{
	//1.��� ����(==�ʵ�) �����, ���� ����(declare)
	Connection con; // ������ ���̽��� ������ ���� ��ü
	Statement stmt; // SQL ���� �����ͺ��̽��� ���������� ��ü
	ResultSet rs; // SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü

	
	//1.��� ���� (book) �����, ����� ����? ���� �� ����ϱ����ؼ�!
//	//1-1.���� Ÿ�� ��� ���� �����
//	int 	bookid;
//	String	bookname;
//	String	publisher;
//	int		price;
	
	//1-2.�迭 Ÿ�� ��� ���� �����,
//	int[] 	 bookid;
//	String[] bookname	= new String[10];
//	String[] publisher  = new String[10];
//	int[]	 price		= new int[10];
	
//	//4.Ŭ���� �����( BookList Ŭ���� ���ο� �ִ� Book�̶�� Ŭ����)
//	class Book{
//		int 	bookid;
//		String	bookname;
//		String	publisher;
//		int		price;
//	}
	//1-3.��ü Ÿ�� ��� ���� �����(��ü�� �����. cf)���⼭ Ŭ���� ����°� �ƴ�)
//	Book book1;
	
	//1-4.��ü�迭 Ÿ�� ��� ���� �����
	Book[] book1;
	
	
	//2.������ (�޼ҵ�)	�����, �����ϴ�(define)
	//������ ����
	//������ �ٽ� ���� -> �ʱ�ȭ???? 
	public DB_BookStore()
	{
		//bookid = new int[10];
		//book1 = new Book(); //1-3.��üŸ��
		//1-4.��ü �迭 Ÿ�� �ʱ�ȭ
		book1 = new Book[10]; //�迭 ������ �������!
		
//		book1[0] = new Book();
//		book1[1] = new Book();
//		book1[2] = new Book();
//		book1[3] = new Book();
//		book1[4] = new Book();
//		book1[5] = new Book();
		
		//��ü�迭 Book[] �ȿ� ��ü new Book()�� 10�� �����.
		for(int i=0; i<10; ++i)
		{
			book1[i] = new Book();
		}
		
	}
	
	
	//3.�Ϲ� �޼ҵ�
 	public void getCon() 
	{	
		//�������???�� �ƴϴ�! Booklist�����ڸ޼ҵ� ������ "��������"
 		//�����ͺ��̽��� �����ϱ� ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //���Ṯ�ڿ�
		String userid = "c##madang"; //�����ͺ��̽� userid
		String pwd = "c##madang"; //�����ͺ��̽� pwd

		//�ϴ��� 1.����̹� �ε�
		try {// ���� ó��? ������ ó���ϴ� ��!
			//������ 2������ �ִ� . ù��°. ������ ����, �ι�° ��Ÿ�� ����
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar�� �ִ�   OracleDriver Ŭ������ ��ũ //����̹��ε�
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//�ϴ��� 2.���� ��ü ����-> new Connetion(); 
		try {
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			con = DriverManager.getConnection(url, userid, pwd); //Connection ��ü�� ���� //DB����
			
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//3.(�Ϲ�) �޼ҵ� �����, �����ϴ�(define)
	void selectBook() 
	{  
		try {
			//sqlRun������ ���������� BookListŬ������ ���������
			//�������� -> ����� ����
			stmt = con.createStatement(); //Statement ��ü�� ����(Statement --> SQL���� �����ͺ��̽��� ���������� ��ü�Դϴ�.)
			String query = "SELECT * FROM book";
			rs = stmt.executeQuery(query); // rs = stmt.excuteQuery(SQL) --> SQL ���� ����� ResultSet�� �����մϴ�. //Select
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE"); 
			int index = 0;
			while (rs.next()) { //rs.next() �� �̿��ؼ� Ŀ���� �̵��մϴ�. ResultSet�� ����� ������ ��� ����� 2�� �̻��� ��� --> while(rs.next()) {} 
				
				//DB���� ���� �����´�. ���÷���
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1.1 ����Ÿ�� ���
				//���� 1�� �ۿ� �ȳ���, ��� ���, �ᱹ ������ ���� ���
//				bookid 	 = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher= rs.getString(3);
//				price 	 = rs.getInt(4);
				
				//1.2 �迭Ÿ�� ���
//				bookid[index] 	 = rs.getInt(1);
//				bookname[index]  = rs.getString(2);
//				publisher[index] = rs.getString(3);
//				price[index] 	 = rs.getInt(4);
				
				//1.3 ��üŸ�� ���
//				book1.bookid	 = rs.getInt(1);
//				book1.bookname  = rs.getString(2);
//				book1.publisher = rs.getString(3);
//				book1.price 	 = rs.getInt(4);
				
				
				//1.4 ?
				book1[index].bookid	 = rs.getInt(1); //rs.getInt(���÷�������)
				book1[index].bookname  = rs.getString(2); //rs.getString(���÷���)
				book1[index].publisher = rs.getString(3); //rs.getString(���÷���)
				book1[index].price 	 = rs.getInt(4); //rs.getInt(���÷�������)
				
//				//index = index+1;
				index++;
		

			}
			con.close();//������ �����ش� �߿�!
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
//	//3.�޼ҵ� �����
//	void printBook()
//	{
//		//1-1 ����Ÿ�� ��� ��
////		System.out.print(bookid+"\t");
////		System.out.print(bookname+"\t");
////		System.out.print(publisher+"\t");
////		System.out.println(price);
//		
//		//1-2 �迭Ÿ�� ��� ��
////		for(int i=0; i<10; ++i)
////		{
////			System.out.print(bookid[i]+"\t");
////			System.out.print(bookname[i]+"\t\t");
////			System.out.print(publisher[i]+"\t\t");
////			System.out.println(price[i]);
////		}
//		
//		//1-3 ��ü Ÿ�� ��� ��
////		System.out.print(book1.bookid+"\t");
////		System.out.print(book1.bookname+"\t");
////		System.out.print(book1.publisher+"\t");
////		System.out.println(book1.price);
//		
//		//1-4.��ü�迭 Ÿ�� ��� ��
//		for(int i=0; i<10; ++i)
//		{
//			System.out.println(book1[i].bookid+"\t"
//							+book1[i].bookname+"\t\t"
//							+book1[i].publisher+"\t\t"
//							+book1[i].price);
//		}
//	}
	
}

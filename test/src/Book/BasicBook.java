package Book;

//Ŭ���� �����, �⺻ Ŭ���� (main����)
public class BasicBook {
	// main �޼ҵ�� 1.����°ɱ�? 2.����ϴ°ɱ�? ����°Ŵ�
	public static void main(String[] args) {
		Bookstore bs = new Bookstore();// �ϻ�, �� �ٿ��� b1�� �����ϱ�? �̰��� ��ü��!

//		bs.getCon();  
//		bs.selectCustomer(); 
//		
//		for(int i=0; i<5; ++i)
//			bs.cs1[i].printCustomer();

		bs.getCon();
		bs.selectBook();

		for (int i = 0; i < 10; ++i)
			bs.book1[i].printBook();

//		Bookstore bs2 = new Bookstore();
//		bs2.getCon();
//		bs2.selectBook();
//		
//		for(int i=0; i<10; ++i)
//			bs.book1[i].printBook();

	}
}



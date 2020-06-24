package Book;

//클래스 만들기, 기본 클래스 (main포함)
public class BasicBook {
	// main 메소드는 1.만드는걸까? 2.사용하는걸까? 만드는거다
	public static void main(String[] args) {
		Bookstore bs = new Bookstore();// 완생, 이 줄에서 b1은 무엇일까? 이것은 객체다!

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



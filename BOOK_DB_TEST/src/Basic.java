
//클래스 만들기, 기본 클래스 (main포함)
public class Basic
{
	//main 메소드는 1.만드는걸까? 2.사용하는걸까? 만드는거다
	public static void main(String[] args) 
	{
		//BookList 는 클래스
		//b1은 아직 객체가 덜 된 녀석.
		DB_BookStore bs; //b1은 ?? 변수 -> 객체변수, 미생
		//밑에 BookList() 생성자를 사용한다.
		bs = new DB_BookStore();//완생, 이 줄에서 b1은 무엇일까? 이것은 객체다!
		//new + BookList() -> 자바에서 제일 중요한 "객체"
		//1. BookList 라는 클래스는 b1라는 객체변수를 만든데 사용
		//2. b1 객체는 만들었다.
		bs.getCon();
		bs.selectBook();//3.b1을 사용한다. 메소드 사용과 함께.
		
		for(int i=0;i<10;++i)
			bs.book1[i].printBook();//Book클래스로 소속 옮김
		
//		DB_BookStore b1;
//		
//		b1 = new DB_BookStore();
//		
//		b1.getCon();
//		b1.selectCustomer();
////		
		
		
		
	}
}

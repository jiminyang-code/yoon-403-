
//4.클래스 만들기(독립 클래스)
public class Book{
	
	//1.멤버변수
	int 	bookid;
	String	bookname;
	String	publisher;
	int		price;
	
	//3.메소드 만들기
	void printBook()
	{
		System.out.println(this.bookid+"\t"
						  +bookname+"\t\t"
						  +publisher+"\t\t"
						  +price);
	}
}

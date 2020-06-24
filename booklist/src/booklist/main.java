package booklist;
//main메소드(
public class main {
	public static void main (String args[]) { //메소드이면서 프로그램실행에 관여함
		booklist so = new booklist();
		so.sqlRun();
//		so.printbook();
	}

//public static void main (String args[]) { //메소드이면서 프로그램실행에 관여함
//	booklist b1; //b1 = 객체변수(인스턴스변수),(불완전한객체)
//	booklist() 생성자를 사용한다
//	b1 = new booklist(); //b1 = 객체(완전한객체)
//	b1.sqlRun();//private이여서 오류,b1을 사용한다 메소드사용과 함께
//	b1 = null;//객체소멸?
//	1.
//	2.
//	
//}
}
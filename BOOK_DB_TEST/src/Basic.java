
//Ŭ���� �����, �⺻ Ŭ���� (main����)
public class Basic
{
	//main �޼ҵ�� 1.����°ɱ�? 2.����ϴ°ɱ�? ����°Ŵ�
	public static void main(String[] args) 
	{
		//BookList �� Ŭ����
		//b1�� ���� ��ü�� �� �� �༮.
		DB_BookStore bs; //b1�� ?? ���� -> ��ü����, �̻�
		//�ؿ� BookList() �����ڸ� ����Ѵ�.
		bs = new DB_BookStore();//�ϻ�, �� �ٿ��� b1�� �����ϱ�? �̰��� ��ü��!
		//new + BookList() -> �ڹٿ��� ���� �߿��� "��ü"
		//1. BookList ��� Ŭ������ b1��� ��ü������ ���絥 ���
		//2. b1 ��ü�� �������.
		bs.getCon();
		bs.selectBook();//3.b1�� ����Ѵ�. �޼ҵ� ���� �Բ�.
		
		for(int i=0;i<10;++i)
			bs.book1[i].printBook();//BookŬ������ �Ҽ� �ű�
		
//		DB_BookStore b1;
//		
//		b1 = new DB_BookStore();
//		
//		b1.getCon();
//		b1.selectCustomer();
////		
		
		
		
	}
}

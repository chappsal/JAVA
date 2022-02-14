package book2;

import book.Book; //반드시 import : 이 때, 'public' class Book 퍼블릭이 있어야 다른 패키지에서도 import 가능 

public class BookMain {
	//기본생성자
	public static void main(String[] args) {
		
		/********** static O 멤버변수와 메서드 ***********/
		System.out.println("책 가격 : "+Book.BOOKPRICE);
		
		
		/********** static X 멤버변수와 메서드 ***********/
		Book b1 = new Book("어린왕자", "생텍쥐베리"); //변수에 담지 않으면 쓰레기 객체
		
		b1.showBookInfo();
		
		//1. b2객체를 생성 : 매개변수가 없는 생성자를 이용		
		Book b2 = new Book();
		System.out.println(b2);
		
		//2. b2가 참조하는 객체의 책제목을 "어린공주" 변경 후 출력 : 직접 접근 시도 -> 안되면 간접 접근으로
		b2.bookName = "어린공주";
		System.out.println(b2.bookName + "," + b2.getBookName());
		
		//3. b2가 참조하는 객체의 바코드 값을 얻어와 출력
		System.out.println("책 바코드: " +b2.bacode+ "," + b2.getBacode());
		
		//4. b2가 참조하는 객체의 책 저자를 변경하여 출력
		//b2.bookAutuor = "박미현"; //private 멤버이므로 접근 불가
		
		//5. b2가 참조하는 객체의 모든 멤버 변수의 값을 출력
		System.out.println(b2);
		
		
		
		
		
		
		
		
	}//main

}

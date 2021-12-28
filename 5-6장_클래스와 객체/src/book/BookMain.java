//실행용 클래스 : main() 있음 - 프로그램 실행
//라이브러리용 + 실행용 클래스

package book;
//같은 패키지에 있는 클래스는 자동 import됨(Book 클래스 import됨)
//import book.Book; //경고:자동 import되어서 쓰지 말라는 뜻
public class BookMain {
	static String s1 = "Book 만들기-1"; // 멤버변수
	String s2 = "Book 만들기-2";
	
	//public BookMain(){}
	
	public static void main(String[] args) {
		
		System.out.println("-------------------- [Book] ---------------------------");
		
		/********** static O 멤버변수와 메서드 ***********/
		//static O 멤버 변수에 접근 방법-1 : "클래스명."으로 접근 (권장)
		System.out.println("책 가격 : "+Book.BOOKPRICE); // 1.직접 접근
		System.out.println("책 가격 : "+Book.getBookprice()); // 2.간접 접근 : 접근 가능한 메서드를 통해서 
		
		
		
		//static O 멤버 변수에 접근 방법-2 : "주소."로 접근 (경고)
		Book b1 = new Book("뽀로로", "최희윤", 11);
		System.out.println("책 가격 : "+ b1.BOOKPRICE); // 1.직접 접근
		System.out.println("책 가격 : "+ b1.getBookprice()); // 2.간접 접근 : 접근 가능한 메서드를 통해서 
		
		
		
		
		/********** static X 멤버변수와 메서드 ***********/
		//static X 멤버 변수에 접근 방법 : 생성자를 호출 => 객체 생성
		//(단, string은 "문자열 상수"만으로도 객체 생성됨)
		
		//private 멤버는 다른 클래스에서 접근 불가 => 접근 가능한 메서드를 통해 간접 접근
		System.out.println("책 저자: "+ b1.getBookAuthor());
		b1.setBookAuthor("정혜정");//책 저자를 변경
		System.out.println("책 저자-2: "+ b1.getBookAuthor());
		
		//멤버 변수의 값 출력-1
		System.out.println("책 바코드=" + b1.bacode + ", 책 제목=" + b1.bookName + ", 책 저자=" + b1.getBookAuthor() + ", 책 가격=" + Book.BOOKPRICE);
		
		//멤버 변수의 값 출력-2
		b1.showBookInfo();
		
		//멤버 변수의 값 출력-3 : 객체의 값을 리턴하는 재정의된 toString() 메서드 호출	 
		//결과바뀜 : Object- book.Book@5cc7c2a6(객체 주소로 만든 16진수 해쉬코드) -> Book - 재정의된 메서드가 돌려주는 값
		System.out.println(b1); // 같은 결과
		System.out.println(b1.toString()); // (같은 결과)
		
		
		// -----------------------------------------------------------------
		
		
		System.out.println("-------------------- [BookMain] ---------------------------");
		System.out.println(BookMain.s1); // BookMain.생략가능(why? 같은 클래스안에 있으므로)
		
		
		BookMain bm = new BookMain(); //기본생성자로 객체 생성
		System.out.println(bm.s1); //bm. 생략가능 (s1은 이미 메모리에 올라가 있고 같은 클래스 안에 있으므로 )
		//System.out.println(this.s1); // this. 사용 불가(why? static 메서드 안에서는 this. 사용 불가)
		
		
		BookMain bm2 = new BookMain(); ///기본생성자로 객체 생성
		System.out.println(bm.s2);
		// book.Book@5cc7c2a6 -> Book - 재정의된 메서드가 돌려주는 값
		System.out.println(bm.toString()); 
	
		
		
	}// main 끝
	
	
	static String getS1() {
		return s1;
	}
	
	static void setS1(String s1) {
		BookMain.s1 = s1;
	}
	
	String getS2() {
		return s2;
	}
	
	void setS2(String s2) {
		this.s2 = s2;
	}
	
	@Override
	public String toString() { //BookMain. this 생략가능 : 같은 클래스 안에 있으므로
		return "BookMain [s1=" + BookMain.s1 +", s2=" + this.s2 + "]";
 	}
	
}
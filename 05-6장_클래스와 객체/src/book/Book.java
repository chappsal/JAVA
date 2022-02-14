//라이브러리용 : main()없는 클래스

/* [접근제한자] 범위) public > protected > default > private
 * 1. public : 어디서든지(패키지) 접근 가능
 * 2. protected : 같은 패키지는 접근 가능(단, 자식은 어디서든지 접근 가능(=다른 패키지의 자식이라도 접근 가능))
 * 3. 아무것도 없는 것(=default) :같은 패키지에서만 접근 가능
 * 4. private : 같은 클래스에서만 접근 가능(=다른 클래스에서 접근 불가)
 * 
 * - private 멤버 변수는 접근 가능한 메서드를 통해 간접 접근할 수 있음.
 * 
 * - class 앞에 public 있으면 어디서든지 import 가능
 * 					  없으면 같은 패키지에서만 import 가능
 * 
 * ----------------------------------------------------
 * [멤버변수에 값을 저장하는 방법]
 * 
 * 1.기본값 : 기본 타입(값을 가짐) - int(0) double(0.0) boolean(false) char('\0'=null문자)  // null문자 != null
 * 		       클래스타입(주소를 가짐) - null(참조하는 객체가 없음)
 * 2.명시적으로 초기화 : ex. int a =10; String s = "a";
 * 3.생성자를 통해 초기화 : static 없는 멤버 변수만 가능 (=static final 멤버변수는 값을 가진채로 바로 메모리에 올라감)
 * 											그런데 생성자를 통해 값을 변경하려면 오류(why? final이므로
 * 
 * ----------------------------------------------------
 * 
 * static 영역 = 정적 영역 = 데이터 영역 = 메서드 영역 : 공유
 * heap 영역 = 동적 영역 : 생성자를 통해 객체 생성
 * stack 영역 : 지역 변수;
 * 
 * ----------------------------------------------------
 * 
 * 
 * [멤버변수, 메서드]
 * 1. static 있는 것 (=클래스 변수/메서드 : 클래스 타입(주소로 접근): 공유
 *		 - book 클래스(Book.class)가 메모리에 로딩될 때 올라감
 * 	 		(이 때, static 멤버 변수는 초기화되어 올라감)
 * 		 - 만약, static 멤버 변수는 '명시적으로 초기화'하지 않으면 '기본값'으로 채워짐
 *			 그러나, final 있으면 반드시 최초의 1번은 '명시적으로 초기화 시켜줘야 함
 * 
 * 
 * 		[멤버변수에 값을 저장하는 방법]
 * 		1.기본값
 * 		2.명시적으로 초기화
 * 		3.생성자를 통해 초기화
 * 		단, static final은 생성자를 통해 초기화 안 됨 (이유:이미 값이 채워져있으므로 값 변경 불가)
 * 
 * 		- '클래스 이름'으로 접근 가능 (권장)
 * 		- '객체 주소'로도 접근 가능 (경고)
 * 
 * 
 * 
 * 
 * 2. static 없는 것 (=instance 변수/메서드): 객체 안에 존재
 * 		- 생성자를 통해 멤버 변수에 값을 채워 '객체 생성되면' 메모리에 올라감
 * 		- static 없는 멤버변수/메서드는 해당 객체 안에 존재
 * 
 * 
 * 		[static 없는 멤버변수에 값을 저장하는 방법 ]
 * 		1. 기본값
 * 		2. 명시적으로 초기화
 * 		3. 생성자를 통해 초기화
 * 		- 이 때, final 멤버변수 : 반드시 최초의 1번은 초기화(2번 또는 3번)
 * 							2. 명시적으로 초기화 : 모든 객체의 final 멤버 변수 값이 같아짐
 * 							3. 생성자를 통해 초기화 : 생성자의 매개값에 따라 각 개체 안의 final 멤버 변수의 값이 달라짐 
 * 		- 반드시 객체의 '주소로만' 접근 가능
 * 		 (this : 자신의 객체 주소, 객체 안에 존재. this로 static에 접근 가능하나 권장하지 않음)
 * 
 * 
 * 3. final 멤버 변수 : 반드시 최초의 1번은 초기화  => 값 변경 불가
 * 					변수명 : 대문자 (권장)
 * 
 * 					[초기화 방법]
 * 					1. 기본값 => 불가
 * 
 * 					2. 명시적으로 초기화 : 모든 객체의 final 멤버 변수 값이 같아짐
 * 					3. 생성자를 통해 초기화 : 생성자의 매개값에 따라 각 개체 안의 final 멤버 변수의 값이 달라짐 
 * 					=> 2,3번 중 한가지 사용
 * 
 * 4. static final 멤버 변수 : 반드시 명시적으로 초기화해야 한다
 * 							static(공유) + final(값 변경 불가) 
 * 	
 * 							
 * 5. private 멤버 변수 : 다른 클래스에서는 접근 불가 (정보 보안=캡슐화)
 * 					  [접근 방법]
 * 					  "같은 클래스 안의 접근 가능한 메서드를 통해" 간접 접근하여 값을 얻거나(=get~())
 * 					     다른 값으로 변경(=set~()) 가능
 *    -private 멤버 변수/메서드는 상속 불가
 * 
 * ----------------------------------------------------
 * 
 * [final]
 * 1. final class 클래스명 : 부모 클래스가 될 수 없음(=상속불가), 마지막 자식이므로
 * 2. final 멤버 변수 : 값 변경 불가
 * 3. final 메서드 : 재 정의 불가 
 * 
 * 
 * ----------------------------------------------------
 * 
 * 
 * [static 메서드가 되는 (붙일 수 있는) 조건]
 * 1. 조건 : 메서드()가 static 없는 멤버 변수(=instance변수)를 필요로 하지 않고
 *         "static 있는 멤버 변수 또는 매개 변수(매개값)"를 필요로 한다.
 *         이 조건을 만족해야 메서드 앞에 static을 붙일 수 있음.    
 *         
 * static 있는 멤버 변수나 메서드는 해당 클래스(Math.class)가 메모리에 올라갈 때 메모리에 올라옴
 * static 없는 멤버 변수나 메서드는 객체 생성하여 메모리에 올라올 때 그 객체 안에 존재
 * 
 */



package book;

public class Book {
	//1.멤버변수(=필드) : 속성
	public String bookName;   //책제목
	private String bookAuthor; //책저자
	
	public final int bacode; //각 책의 바코드 값을 다르게 설정하고 싶을 때 - 생성자를 통해 최초의 1번만 초기화
	
	public static final int BOOKPRICE; //책가격
	
	
	/*
	 * static 초기화 블록 : static 멤버 변수에 초기값을 적용
	 * 언제 사용? '복잡한 계산'을 하거나 '메서드 호출 결과'를 초기값으로 세팅할 때
	 */
	
	static {
		//복잡한 계산
		int hap=0;
		for(int i=1; i<=100; i++) {
			hap += i;
		}
		BOOKPRICE = hap;
		
		//메서드 호출 결과 : 반드시 static 메서드만 호출 가능
		//BOOKPRICE = hap(10,100); //=> 오류 : final이므로 값 변경 불가, BOOKPRICE = hap; 주석 처리시 오류 해제
	}
	
	/*
	 * instance 초기화 블록 : 생성자가 호출되기 직전 초기화 블록이 실행 됨
	 * 언제 사용? '복잡한 계산'을 하거나 '메서드 호출 결과'를 초기값으로 세팅할 때
	 */
	/*
	{
		System.out.println("*** 초기화 블록 ***");
		bacode = Math.abs(-12345)+10;
		//bacode += 10; // 오류 : final이므로 값 변경 불가
	}
	*/


	/*
	 * 2. 생성자 반드시 존재
	 * [생성자 역할] : 멤버 변수에 값을 채워 객체 생성
	 * -생성자는 반환 타입 x, void 자체도 없음. 객체 안에 존재하지 않음
	 * 
	 * -생성자 없으면 컴파일러가 컴파일하기 전, 자동으로 기본 생성자 삽입
	 * -생성자 {} 안에 super();가 없으면 컴파일하기 전, 자동으로 ★첫줄에 삽입
	 *  왜 첫줄? super();는 부모 생성자를 호출 => 부모 객체 생성
	 * 
	 * 
	 * 
	 * [기본생성자] 
	 * public class Book { public book() {super();} }
	 * 	      class Book {  book() {super();} }
	 * -기본 생성자는 부모 생성 => 자식의 멤버 변수에 '기본 값'으로 채워 자식 객체 생성
	 * -기본 값 :기본 타입(값을 가짐) - int(0) double(0.0) boolean(false) char('\0'=null문자)  // null문자 != null
	 * 		    클래스타입(객체의 주소를 가짐) - null(참조하는 객체가 없음)
	 * 
	 * super.부모의 멤버 변수 / 메서드 : 'super(부모의 주소)'로 접근
	 * super() 				  : '부모의 생성자' 호출
	 * 							반드시 생성자 안에서만 사용 가능
	 * 
	 * this.부모의 멤버 변수 / 메서드 : 'this(자신의 주소)'로 접근
	 * this() 				 : 생성자 안에서 '자신의 다른 생성자' 호출할 때 사용
	 * 						       매개변수가 적은 생성자 안에서, 매개변수가 많은 다른 생성자를 호출할 때 사용
	 *						       반드시 생성자 안에서만 사용 가능 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public Book() {
		super();
		bacode = 11111; //각 개체의 바코드 값 동일해짐
		//'초기화 블록 주석해제'하면 오류 => why? final 때문. 초기화 블록을 통해 초기화 후 생성자를 통해 값 변경 불가
		
	}
	
	
	public Book(String bookName, String bookAuthor) {
		//super(); 
		//this.bookName = bookName;  
		//this.bookAuthor = bookAuthor; 
		//bacode = 12345; //모든 바코드 값 동일해짐
		this(bookName, bookAuthor,12345); //매개변수가 없는 생성자 호출 , 위 여러줄을 한줄로 작성 가능
		
		/* this(); 위에는 어떠한 실행문도 있어서는 안 됨 (super도 안 됨) 
		 *  
		 * 1. this()를 이용하여 다른 생성자를 호출할 때는 첫번째 줄에 super(); 호출 불가 
		 * 	  why? 두개의 부모가 생성되므로. java는 단일 부모, 단일 상속
		 * 2. 부모 생성 후 자식의 멤버 변수에 값을 채워 자식 객체를 생성하므로. 즉, 부모->자식 순서
		 */
		
		
	}

	
	public Book(String bookName, String bookAuthor, int bacode) {
		super(); //반드시 생성자의 첫 줄에.    1.부모(Object)생성자 호출 => 부모 객체 생성
		this.bookName = bookName;  // 2.자식의 각 멤버 변수에 값을 채워 자식 객체 생성
		this.bookAuthor = bookAuthor; // this.생략불가 (멤버 변수와 매개 변수의 이름이 같아 구분하기 위해)
		this.bacode = bacode; // 매개값에 따라 바코드 값 달라짐
	}
	
	/*
	 * 3. 메서드 : 기능
	 * get~() : 멤버변수의 값을 얻어올 때
	 * set~(매개변수) : 전달 받은 매개 값으로 멤버 변수의 값을 변경할 때 
	 */
	
	
	//********* static O *********//
	//메서드 호출 결과  //메서드생성
	public static int hap(int start, int end){
		int hap=0;
		for(int i=start; i<=end; i++) {
			hap += i;
		}
		return hap;
	}

	
	public static int getBookprice() {
		return Book.BOOKPRICE; //Book.생략가능
		// (단, this는 사용불가 => static 메서드는 객체 생성 이전에 이미 메모리에 올라가 있으므로)
	}

	
	//********* static X **********
	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}

	/*
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	*/

	public int getBacode() {
		return bacode;
	}

	public void showBookInfo(){ //this. Book. 생략 가능 : 같은 클래스 안에 있어서 // b1.getBookAuthor() => this.bookAuthor() 변경 가능 :같은 클래스 안에 있어서
		System.out.println("책 바코드=" + this.bacode + ", 책 제목=" + bookName + ", 책 저자=" + this.bookAuthor + ", 책 가격=" + BOOKPRICE);
	}


	


	/*
	 * [메서드 재 정의] : 부모로부터 상속 받은 메서드를 그대로 사용하지 않고 자식 클래스에서 재정의
	 * 1. "리턴 타입과 메서드 이름(매개변수)"가 부모와 같아야 한다.
	 *  
	 * 2. ★★재 정의할 때 접근 제한자는 부모와 같거나 더 넓은 범위로 한다.
	 *    (그래야 부모의 메서드를 재 정의된 메서드로 덮어 씌워
	 *    컴파일러가 재 정의된 자식 메서드만 호출할 수 있도록 한다.)
	 *    public > protected > default > private 
	 * 
	 * 3. 예외는 부모 클래스의 메서드보다 많이 선언할 수 없다.  
	 * 										ex 1) 부모메서드() throws IOException, SQLException
	 * 							              	    자식메서드() throws IOException(o)
	 * 											    자식메서드() throws SQLException(o)
	 * 	    자식 메서드는 부모 메서드의 예외 중 '자식 예외 클래스'는 사용 가능		
	 * 										ex 2) 부모메서드() throws IOException, SQLException							
	 * 											    자식메서드() throws SocketException(O) 이유? SocketException(자식) extends IOException(부모)
	 * 							             	    자식메서드() throws Exception(X) 이유? Exception은 모든 예외의 부모
	 * 
	 * 	    재정의 메서드는 재정의된 메서드가 예외를 선언하는지 여부에 관계없이 확인되지 않은 (런타임=실행) 예외를 throws 할 수 있다.
	 * 							 			 ex 3) 부모메서드() {}
	 * 								 			       자식메서드() throws IOException
	 * 											       자식메서드() throws SocketException
	 * 											       자식메서드() throws NumberFormatException
	 * 											 =>	오류 유무는 자바 컴파일러에게 맡김
	 */	
	/* [toString() 재정의하는 이유]  
	 * Object의 toString() : book.Book@5cc7c2a6(객체 주소로 만든 16진수 해쉬코드) 
	 * -> Book 클래스에서  Object의 toString() 재정의하여 원하는 값 리턴하기 위해
	 */
	//toString() 재정의하는 방법-1 : 우클릭 -> 소스 -> 메서드 대체/구현(=overriding) -> 재정의할 메서드 선택 -> 확인
	/*
	@Override // 어노테이션 : 감시자 역할, 재정의할 때 문법적으로 맞는지 확인하여 틀리면 오류 띄움
	public String toString() throws NumberFormatException{
		return "책 바코드=" + this.bacode + ", 책 제목=" + bookName + ", 책 저자=" + this.bookAuthor + ", 책 가격=" + BOOKPRICE);;
	}
	*/
	
	//toString() 재정의하는 방법-2 : 우클릭 -> 소스 -> Generate toString() .. -> 필드 선택 -> 확인
	@Override
	public String toString() {// (ex 3) throws NumberFormatException{ : 오류없음  // throws IOException{ : 오류 발생
		return "Book [bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bacode=" + bacode + ", 책 가격 =" + BOOKPRICE + "]";
	}
	
	
	// 우클릭 - 소스 - hashCode() 및 equals() 생성
	//hashCode() 재정의 : 멤버 변수의 값으로 해쉬 코드 만듦 -> 같은 객체로 취급하여 삭제됨
	@Override
	public int hashCode() {
		final int prime = 31; 
		int result = 1;
		result = prime * result + bacode;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bacode != other.bacode)
			return false;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
		
	
	
	
	
	
	
	
	
}


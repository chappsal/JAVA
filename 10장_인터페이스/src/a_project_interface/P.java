package a_project_interface;
/*
 * 인터페이스 : 클라이언트 프로그램에 '어떤 메서드를 제공하는지' 미리 알려주는 명세 또는 약속
 */


/*
 * [추상클래스와 인터페이스의 공통점]
 * 
 * 1. 자식에서 반드시 재정의해야 할 미완성된 추상 메서드가 존재. 안 하면 오류
 * 2. 객체 생성 불가
 * 3. 그러나 부모 역할 가능
 * 	-추상클래스의 예
 * 		ex 1) void method(Electronics e) { // Electronics의 자식 객체(TV, VCR, TVCR)
 * 										 -> 자동으로 Electronics로 형변환되어 받아들임 
 * 			  }
 * 		ex 2) Electronics e = new TV();
 * 			  Electronics e = new VCR();
 * 			  Electronics e = new TVCR();
 * 	-인터페이스의 예
 * 		ex 1) void method(P p) { // PI : P 인터페이스를 구현한 PI객체
 * 										=> 자동으로 P로 형변환되어 받아들임
 * 			  }
 * 		ex 2) P p = new PI(); // PI : P 인터페이스를 구현한 클래스
 * 
 * [추상클래스만의 특징]
 * 
 * 1. 여러 메서드 중 단 1개라도 미완성된 추상 메서드가 있으면 추상 클래스가 됨 
 * 
 * 
 * [인터페이스만의 특징]
 * 
 * 1. 모든 멤버변수가 '상수'
 *    public static final int A = 1; //(모든 멤변에 public static final이 자동으로 붙어있음, 생략 가능)
 *    접근방법 : 인터페이스명.멤버변수명   ex) P.A
 *    
 * 2. 모든 메서드가 추상 메서드 : 구현하는 자식 클래스에서 반드시 재정의 
 * 	  void a();  // public abstract 생략 가능
 * 
 * 	  *예외-1 : static 메서드() - 자체로 완성된 메서드로서 바로 메모리에 올라감 => 클래스 생성과 무관하게 사용 가능
 * 							   => 구현한 자식 클래스에서 재정의 X
 * 							   ex) static void 이름표시() {"스마트폰"}
 * 								   100개의 구현한 자식 클래스에서 재정의하지 않고 '인터페이스 이름으로 접근'하여 사용하면 됨
 * 
 * 	  *예외-2 : default 메서드() - 자체로 완성된 메서드
 * 							   => 구현한 자식 클래스에서 필요하면 재정의하여 사용하면 됨
 * 							   ex 1) default void 접는 기능(){}
 * 							   		 100개의 구현한 자식 클래스 중 필요한 클래스만 재정의하면 됨
 * 
 * 							   ex 2) default void 전화를 받는 기능() {"사람이 전화를 받는다"}
 * 							   		 100개의 구현한 자식 클래스 중 99개는 이 기능을 그대로 사용하지만 
 * 									 1개 클래스는 자기 클래스에 맞게 재정의하면 됨
 * 									 ex) default void 전화를 받는 기능() {"AI가 전화를 받는다."}
 * 
 *	  *예외-3 : private 메서드 ('JDK 1.9 = JAVA9' 부터 사용 가능)
 *			  - 인터페이스 내부에서만 기능을 제공하기 위해 구현하는 메서드
 *			  => 구현한 자식 클래스에서 사용하거나 재정의 불가 
 * 
 */

/*
 * 홍 대표가 
 * a회사에 2개의 메서드를 완성해달라고 의뢰
 * '인터페이스'에 담아서 의뢰
 */
public interface P {
	int INPUT = 1, SEARCH = 2, EXIT = 3;
	
	//1. 이름, 주민등록번호, 전화번호 저장
	void input();
	
	
	//2. 주민등록번호를 기반으로 고객의 이름과 전화번호를 검색
	void search();
	
	/*****************************************************/
	
	//예외-1 : 인터페이스를 구현한 모든 클래스에서 "클래스 생성과 무관하게 사용 가능"
	public static int add(int...arr) { //P.add(10,20,30); 호출하면  arr->[10,20,30] 배열 객체 생성
		int hap=0;
		for(int item:arr) {
			hap += item;
		}
		//p2();
		return hap;
	}
	
	
	//예외-2 : 그대로 사용하기 싫은 자식 클래스만 재정의하면 됨
	public default void show() {
		System.out.println("정보 출력");
		//p1();
	}
	
	/*
	//예외-3 : 자바9부터 사용하므로 오류
	private void p1() {
		System.out.println("~~~~~");
	}
	
	private void p2() {
		System.out.println("합을 구합니다");
	}
	
	*/
	
	
	
	
	
	
	
}

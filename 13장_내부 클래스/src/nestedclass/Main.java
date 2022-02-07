package nestedclass;

public class Main {

	public static void main(String[] args) {
		
		A a = new A(); //외부 클래스
		System.out.println();
		
		/**----- 1. 멤버 클래스  -----------------**/
		/** 1-1. 인스턴스 멤버 클래스 **/
		//1. 외부 클래스 객체 생성 후 -> 인스턴스 멤버 클래스 객체 생성 가능
		A.B b = a.new B(); //★★ 외부 객체의 참조변수.new 내부();
		//A.B b = new A.B(); //오류
		
		b.field1 = 6;
		b.method1();
		
		System.out.println();
		
		/** 1-2. 정적 멤버 클래스 1 **/
		//외부 클래스 객체 생성하지 않고 -> 정적 멤버 클래스 객체 생성 가능
		A.C c = new A.C(); // 외부.내부 참조변수= new 외부.내부();
		c.field1 = 7;
		c.field2 = 8; 	//경고
		A.C.field2 = 9; //권장
		
		c.method1();
		c.method2();	//경고
		A.C.method2();	//권장
		
		System.out.println();
		
		/** 1-2. private 정적 멤버 클래스 2 **/		
		//외부에서 private 정적 멤버 클래스 객체 생성 불가
		//A.D d = new A.D(); //불가, A 안에서만 가능
		
		
		/**----- 2. 로컬 클래스  -----------------**/
		//로컬 클래스 객체 생성을 위한 메서드 호출
		a.method();
		
		
		
		
		
		
		
	} //main

}
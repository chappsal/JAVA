package polymorphism;

public class M {
	//기본생성자
	
	
	static void w(A a) { // A객체와 A자식객체를 받아들임(단, A자식객체(b,c)는 A타입으로 자동 형변환되어 받아들임)
		a.a(); //컴파일러 입장 : 모든 객체(A,B,C)를 A타입으로 인식. 따라서 A클래스에 정의된 멤버만 접근
		
		//((B)a).b(); //강제형변환 . but, 자동형변환은 안되는이유 : 자식에게는 부모의 것이 있지만 부모에게는 자식의 것이 없을수도 있음(자식에서 추가한것들)
		/* ↑ 컴파일 오류 없으나 실행 시 예외객체 발생 -> 프로그램 종료
			이유? 실질적인 A객체에는 b()메서드가 존재하지 않으므로
		*/
	}
	
	
	//★★w()메서드의 문제점을 해결한 메서드 : 실질적인 객체 분류 (정확히 누구인지 찾기)
	static void w2(A a) { //모두 A타입으로 받음
		if(a instanceof C) { //instanceof : a가 참조하는 객체가 C객체이거나 C자식객체이면 true , 가장 마지막 자식부터 실행
			a.a(); //재정의된 메서드 호출
			((C) a).b(); // a.b 하면 자동으로 강제형변환되어 입력
			((C) a).c();
		} else if(a instanceof B) { 
			a.a(); //재정의된 메서드 호출
			((B) a).b();
		} else a.a();
	} //모두 A타입으로 받았지만 출력시 A,B,C 나옴
	
	
	
	
	public static void main(String[] args) {
		A a = new A();
		w2(a); //w(a);
		System.out.println("*****************");
	
		B b = new B();
		w2(b); //w(a);
		System.out.println("*****************");
		
		C c = new C();
		w2(c); //w(a);
		System.out.println("*****************");

		System.out.println("****** [다형성] *******");
		
		/* [자동 형 변환]
		 * 1. 자식 객체 -> 부모 타입으로 자동 형 변환 가능
		 * 		ex) w(A a), w2(A a)
		 * 
		 * [강제 형 변환]
		 * 1. 자식 객체 		 -> 부모 타입으로 강제 형 변환 가능
		 * 2. 부모 객체 (실제 부모) -> 자식 타입으로 강제 형 변환 가능하지만(=컴파일 오류는 없음) 
		 * 						'실행 시 예외 발생'하여 프로그램이 강제 종료 
		 * 3. 실제 자식 객체  -> 부모 타입으로 자동 형 변환 -> 실제 자식 타입으로 강제 형 변환
		 */
	
		System.out.println("[자동-1 예]");
		B b2 = new C(); //[자동-1 예] 부모 = 자식 (자식 객체가 부모 타입으로 자동 형 변환되어 대입)
		b2.a(); b2.b();

		System.out.println("[강제-1 예]");
		((A)b2).a(); //[강제-1 예] 자식 객체 -> 부모 타입으로 강제 형 변환 가능
		// 출력시 C클래스의 재정의 된 a() 호출
	
		
		System.out.println("[강제-2 예]");
			
		A a2 = new B(); //[자동-1 예] 부모 = 자식 (자식 객체가 부모 타입으로 자동 형 변환되어 대입)
		a2.a();
		//((C)a2).b(); //[강제-2 예] 2. 부모 객체 -> 자식 타입으로 강제 형 변환 가능하지만(=컴파일 오류는 없음) 
		  			   //   '실행 시 예외 발생'하여 프로그램이 강제 종료 
	
		
		if(a2 instanceof C) { //new B() : 거짓
			System.out.println("C타입으로 강제 형 변환?");
			((C)a2).b();
		}else if(a2 instanceof B) { //new B() : 참
			System.out.println("B타입으로 강제 형 변환?");
			((B)a2).b();
		}
		
		
		System.out.println("[강제-3 예]");
		
		A a3 = new C(); //[자동-1 예] 부모 = 자식 (자식 객체가 부모 타입으로 자동 형 변환되어 대입)
		a3.a();
	
		((C)a3).b(); //[강제-3 예] 실제 자식 객체  -> 부모 타입으로 자동 형 변환 -> 실제 자식 타입으로 강제 형 변환
		a3.a(); // ★주의: a3는 여전히 A타입임
		
		if(a3 instanceof C) { //new C() : 참
			System.out.println("C타입으로 강제 형 변환?");
			((C)a3).b();
		}else if(a3 instanceof B) { //new C() : 거짓
			System.out.println("B타입으로 강제 형 변환?");
			((B)a3).b();
		}
		
	
	
	} // main

}
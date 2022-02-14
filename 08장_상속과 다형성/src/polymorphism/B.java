package polymorphism;

public class B extends A {
	//기본생성자
	
	
	@Override //감시자 역할 
	void a() {
		System.out.println("B에서 a() 재정의");
		//super.a(); //부모의 것을 그대로 쓰는것. super.부모의주소
	} //부모 클래스 A로 설정
	
	
	//추가
	void b() {
		System.out.println("B에서 b() 정의");
	}

	
	
	
	
}//class B

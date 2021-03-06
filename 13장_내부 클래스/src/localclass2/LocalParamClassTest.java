package localclass2;

interface Readable {
	//미완성된 추상 메서드
	void read(); //public abstract 생략
}


class Outer { //외부 클래스
	private String myName;

	Outer(String myName) {
		super();
		this.myName = myName;
	}
	
	
	/** [★★ 로컬 클래스 ★★]
	 1. 메서드가 실행할 때만 사용 가능
	 2. ★★ 메서드 내에서만 객체를 생성하고 사용
	 3. 접근제한자 (public, private) 및 static 붙일 수 없음
	 	why? 메서드 내에서만 사용되므로 접근을 제한할 필요 없음
	 4. Outer$1Local.class 바이트 코드 파일 생성됨	 
	 */
	
	/* 
	 * int ID => final int ID : Local 클래스를 가진 메서드의 매개변수에는 컴파일러가 자동으로 final 붙여줌 
	 * 
	 * method() 호출 결과 객체가 생성되어 그 주소값이 전달되면 지역변수나 매개변수는 메모리에서 사라짐.
	 * 그러나, final 키워드를 붙이면 지역변수나 매개변수의 복사본을 객체가 생성될 때 
	 * 항상 접근 가능한 메모리에 두고 값을 변경하지 못하게 함 (원본과 복사본 일치하도록)
	 * => read() 호출하면 사라지지 않은 매개변수의 복사본 값이 출력
	 * 
	 */
	//Readable method(final int ID) { 
	Readable method(int ID) { // 주의: 리턴 타입으로 Local 사용 불가
		
		
		class Local implements Readable {

			@Override
			public void read() {
				//외부 클래스의 private 멤버(멤버변수)에도 접근 가능
				System.out.println("외부 객체 name : " + myName); 	
				//메서드의 매개변수 출력
				System.out.println("로컬 객체 ID : " + ID);
			}
			
		} //Local class
	
		return new Local();
	
	} //method
	
} //Outer class


public class LocalParamClassTest {

	public static void main(String[] args) {
		
		Outer out1 = new Outer("첫 째");
		Readable local1 = out1.method(111);
		local1.read(); 

		Outer out2 = new Outer("둘 째");
		Readable local2 = out2.method(222);
		local2.read(); 
	}

}

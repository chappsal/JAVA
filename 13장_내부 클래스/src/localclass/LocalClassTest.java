package localclass;

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
	 1. 메서드가 실행할 떄만 사용 가능
	 2. ★★ 메서드 내에서만 객체를 생성하고 사용
	 3. 접근제한자 (public, private) 및 static 붙일 수 없음
	 	why? 메서드 내에서만 사용되므로 접근을 제한할 필요 없음
	 4. Outer$1Local.class 바이트 코드 파일 생성됨
	 
	 */
	
	Readable method() { // 리턴 타입으로 Local 사용 불가. why? 로컬 클래스이므로 밖에서 사용 불가
	//메서드를 호출하는 입장에서는 Local의 존재를 모르지만 Readable로 주소를 받기 때문에 read()메서드 사용 가능
		
		//로컬 클래스 : 메서드 내에 선언
		class Local implements Readable {

			@Override
			public void read() {
				//외부 클래스의 private 멤버에도 접근 가능
				System.out.println("외부 객체 name : " + myName); 		
			}
			
		} //Local class
	
		return new Local();
	
	} //method
	
} //Outer class


public class LocalClassTest {

	public static void main(String[] args) {
		
		Outer out1 = new Outer("첫 째");
		Readable local1 = out1.method();
		local1.read(); 

		Outer out2 = new Outer("둘 째");
		Readable local2 = out2.method();
		local2.read(); 
		
	}

}

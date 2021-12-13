/* 라이브러리용 : main()없는 클래스
 * 
 * [접근제한자] 범위) public > protected > default > private
 * 1. public : 어디서든지(패키지) 접근 가능
 * 2. protected : 같은 패키지는 접근 가능(단, 자식은 어디서든지 접근 가능)
 * 3. 아무것도 없는 것(=default) :같은 패키지에서만 접근 가능
 * 4. private : 같은 클래스에서만 접근 가능(=다른 클래스에서 접근 불가)
 * 
 * [static 메서드가 되는 (붙일 수 있는) 조건]
 * 1. 조건 : 메서드()가 static 없는 멤버 변수(instance변수)를 필요로 하지 않고
 *         "static 있는 멤버 변수 또는 매개 변수(매개값)"를 필요로 한다.
 *         이 조건을 만족해야 메서드 앞에 static을 붙일 수 있음.    
 *         
 * static 있는 멤버 변수나 메서드는 해당 클래스(Math.class)가 메모리에 올라갈 때 메모리에 올라옴
 */



package math;

public class Math { // public 떼면 같은 패키지에서만 사용 가능 => 메서드에 public을 붙여도 효과x, public이 있으면 다른 패키지에서도 사용 가능
	//1. 멤버변수(=필드 field):속성
	public final double E = 2.71; //static 없는 멤버 변수=>생성자를 다른 클래스에서 호출할 수 없으므로(=객체를 만들 수 없음) static없는 멤버 변수 사용 불가
	
	public static final double PI = 3.14; // final강조하기위해 변수 이름 대문자 // static을 붙여서 처음부터 다 공유해 어디든지 사용할 수 있도록?(메서드 영역(메모리)에 올라가게)(노트에 그림 참조)
	
	
	//2. 기본생성자 public Math(){super();}
	private Math(){} // <=생성자. 생성자가 있으면 기본생성자 없음 , 없으면 윗줄의 기본생성자를 컴파일러가 자동으로 만들어줌 // private붙으면 같은 패키지 다른 클래스에서 접근 불가, 호출 불가 
	                 // 같은 패키지에서는 public 없어도 사용 가능 // 객체를 생성하지 않기 위해 , 모든게 static이기 때문에 만들 필요 없음
	
	//3. 메서드(소문자로 시작~()):기능
	
	
	//원의 넓이를 구하는 메서드 생성
	static double circleArea(int r){ // r=반지름  // static 없으면 객체를 생성해야 메모리에 올라옴 
		return r*r*PI; // 원의 넓이 = 반지름*반지름*3.14
	}
	
	static double circleArea(double r){ // r=반지름 // 실수 정수 다 받을 수 있지만 위 메서드를 삭제하지 않음 : 다양하게 만들어 효율을 높임
		return r*r*PI; // 원의 넓이 = 반지름*반지름*3.14
	}
	
	// 원의 둘레 구하는 메서드 = 2*반지름*3.14
	static double circleLength(int r){
		return 2*r*3.14;
	}
	
	static double circleLength(double r){
		return 2*r*3.14;
	}
	
	// 두 정수를 더하여 결과를 리턴하는 메서드
	static int add(int a, int b){ // 매개변수로 매개값을 입력받아 
		return a+b;               // 결과를 리턴
	}
		
	// 두 정수를 곱하여 결과를 리턴하는 메서드
	static int mul(int a, int b){
		return a*b;
	}
	
	// ★★  ... 가변인수 : 여러 매개값들을 "배열"로 처리(매개값은 매개변수로 받음)(main에서 던져주는 매개값)(매개변수=인수=argument) 
	public static double add(double...n){// Math.add(10,20,30) 호출시 배열객체 생성됨[10.0,20.0,30.0] //연속된 배열 객체가 생성되고 index번호는 0부터// 배열은 for문과 세트
		double hap=0;                    // 매개인수를 int => double로 바꾸면 ... => [] 로 바뀜
		
		int i; // index번호: 0부터 시작
		for(i=0;i<n.length;i++) { // length: 배열에 존재하는 멤버변수(길이, 읽기 전용)
			hap+=n[i];
		}
		return hap;
	}
	
	
	public static int mul(int...n) {
		int result=1;
		int i;
		for(i=0;i<n.length;i++) {
			result*=n[i]; 
		}
		return result;
	}
	
	
	public static double mul(double...n){
		double result=1;
		int i;
		for(i=0;i<n.length;i++) {
			result*=n[i]; 
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
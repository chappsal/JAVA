/*
 *  상속 ? 기존의 클래스를 재사용하여 새로운 클래스를 작성
 *     	   코드의 재사용성을 높이고 코드의 중복을 제거하여
 *  	   프로그램의 생산성과 유지보수에 크게 기여
 *  
 *  1. 부모 - 자식   ex. 포유류는 사람이다(x) 사람(자식)은 포유류(부모)다(o)
 *  2. 클래스 간의 포함 관계  ex. 계산기는 더하기 기능을 가지고 있다
 *  
 *  
 */

package cal;

class Add{//더하기 클래스
	private int cntAdd = 0; //메서드가 호출될 때마다 1씩 증가하는 카운터 변수
	
	//기본생성자
	int getCntAdd() {
		return cntAdd;
	}
	
	//실질적인 기능
	int add(int n1, int n2) {
		cntAdd++;
		return n1+n2;
	}

	double add(double n1, double n2) {
		cntAdd++;
		return n1+n2;
	}
}


class Sub{//빼기 클래스
	private int cntSub = 0; //메서드가 호출될 때마다 1씩 증가하는 카운터 변수
	
	//기본생성자
	int getCntSub() {
		return cntSub;
	}
	
	//실질적인 기능
	int sud(int n1, int n2) {
		cntSub++;
		return n1-n2;
	}
	
	double sub(double n1, double n2) {
		cntSub++;
		return n1-n2;
	}
}


class Mul{//곱하기 클래스
	private int cntMul = 0; //메서드가 호출될 때마다 1씩 증가하는 카운터 변수
	
	//기본생성자
	
	int getCntMul() {
		return cntMul;
	}

	//실질적인 기능
	int mul(int n1, int n2) {
		cntMul++;
		return n1*n2;
	}
	
	double mul(double n1, double n2) {
		cntMul++;
		return n1*n2;
	}
}


class Div{//나누기 클래스
	private int cntDiv = 0; //메서드가 호출될 때마다 1씩 증가하는 카운터 변수
	
	//기본생성자
	
	int getCntDiv() {
		return cntDiv;
	}

	//실질적인 기능
	double div(int n1, int n2) {
		cntDiv++;
		return (double)n1/n2;
	}
	
	double div(double n1, double n2) {
		cntDiv++;
		return n1/2;
	}
}


/*
 * 1개의 소스 파일(=Calculator.java)에 여러 클래스를 설계할 때
 * public은 반드시 1개의 클래스에만 붙일 수 있다
 * 파일이름 = public 붙은 클래스 이름
 * 
 * 만약 main() 클래스가 같이 있다면
 * public은 무조건 main() 클래스에만 붙일 수 있다.
 * 
 */

public class Calculator {
	//[포함 관계 만드는 순서]  
	// 1. 멤버 변수로 선언
	private Add a;  // 6. private으로 정보 은닉시켜 "캡슐화"함
	private Sub s;
	private Mul m;
	private Div d;

	/* 잘못된 생성자
	public Calculator(Add a, Sub s, Mul m, Div d) {
		this.a = a;
		this.s = s;
		this.m = m;
		this.d = d;
	}
	*/
	
	public Calculator() { // 2. 매개변수가 없는 생성자 호출
		super();          // 3. 부모 객체 생성
		a = new Add();    // 4. 더하기 부품 생성
		s = new Sub();    //    빼기 부품 생성
		m = new Mul();    //    곱하기 부품 생성
		d = new Div();    //    나누기 부품 생성
	} // 5. 최종적으로 계산기 객체 생성
	
	
	// 7. 외부에 노출된 기능을 가진 버튼(+ - * /)
	
	/*
	public void add(double n1, double n2) {
		System.out.println(a.add(n1, n2));     //바로 출력할 수도 있음
	}
	*/
	
	public double add(double n1, double n2) {
		return a.add(n1, n2);
	}
	public double sub(double n1, double n2) {
		return s.sub(n1, n2);
	}
	public double mul(double n1, double n2) {
		return m.mul(n1, n2);
	}
	public double div(double n1, double n2) {
		return d.div(n1, n2);
	}
	
	//실행횟수 출력
	public void showOperatingTimes(){
		System.out.println("덧셈 횟수 : " + a.getCntAdd());
		System.out.println("뺄셈 횟수 : " + s.getCntSub());
		System.out.println("곱셈 횟수 : " + m.getCntMul());
		System.out.println("나눗셈 횟수 : " + d.getCntDiv());
	}
	
	
	
}

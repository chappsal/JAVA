package runtime.divide;

import java.util.Scanner;

public class DivideByZero {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("두 개의 정수 입력: ");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		try {
			//ArithmeticException 예외 객체 생성될 가능성
			System.out.println("나눗셈 결과의 몫: " + (num1/num2));		
			System.out.println("나눗셈 결과의 나머지: " + (num1%num2));
		} catch (Exception e) {
			//e.printStackTrace(); // '예외 객체 종류 + e.getMessage()를 호출한 결과 + 예외 발생 전달 경로' 출력
			//System.out.println(e); // '예외 객체 종류 + e.getMessage()를 호출한 결과' 출력
			//System.out.println(e.getMessage()); // 'e.getMessage()를 호출한 결과 ' 출력
			System.out.println("0으로 나눗셈이 불가합니다.");
			//return;  //메서드 종료(finally는 실행됨)
		} finally { //try{}영역에 진입하면 무조건 실행
			System.out.println("예외 발생 유무에 관계없이 무조건 처리");
		}
		
		System.out.println("** 정수 나누기 연산 끝 **");
		System.out.println();
		
		/*
		 * ArithmeticException은 RunTimeException(실행 오류 예외)의 자식 클래스로
		 * 프로그래머의 실수로 발생하는 예외이므로 
		 * try~catch()로 처리하는 것보다 실수를 수정하는 방법으로 해결하는 것이 더 좋다
		 * 
		 * ==> DivideByZero2.java
		 */
		
		
		//-------------------------------------------------------------------
		
		
		System.out.println("두 개의 실수 입력: ");
		
		double num3 = sc.nextDouble();
		double num4 = sc.nextDouble(); // 0-> 0.0자동 형 변환
		
		/*
		System.out.println("나눗셈 결과의 몫: " + (num3/num4)); //Infinity = 무한대
		System.out.println("나눗셈 결과의 나머지: " + (num3%num4)); //NaN (= Not a Number)
		*/
		
		double result1 = num3/num4;
		double result2 = num3%num4;
		
		System.out.println(result1+10000); //Infinity
		System.out.println(result2+10000); //NaN
		
		//Infinity , NaN 값은 더 이상 연산을 진행하면 안되므로 아래와 같은 확인 절차를 거친다
		
		if(Double.isFinite(result1) || Double.isNaN(result1)) { //is~() 로 시작하는 메서드 : ~이냐고 질문, boolean
			System.out.println("연산 결과 값으로 불가합니다.");
		} else System.out.println(result1+10000);
			
		if(Double.isFinite(result2) || Double.isNaN(result2)) { 
			System.out.println("연산 결과 값으로 불가합니다.");
		} else System.out.println(result2+10000);
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
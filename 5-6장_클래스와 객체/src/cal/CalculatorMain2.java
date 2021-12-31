package cal;

import java.util.Scanner;

public class CalculatorMain2 {

	public static void main(String[] args) {
		/* 잘못된 방법
		//부품 생성
		Add a = new Add();
		Sub s = new Sub();
		Mul m = new Mul();
		Div d = new Div();

		new Calculator(a,s,m,d);
		*/
		
		// 계산기 생성
		Calculator cal = new Calculator();

		// 12-30 과제 1
		// 스캐너 객체 생성하여 두 수와 연산자를 입력 받아 결과 출력 => 반복하여 사용하다가
		// stop 입력받으면 계산 종료 후 실행 횟수 출력
		
		//스캐너 객체 생성
		Scanner sc = new Scanner (System.in);
		
		boolean flag = true;
		//String tmp = null;
		int totalCnt = 0; //연산한 총 횟수
		
		while(flag) {
			System.out.print("계산할 두 수 입력(단, stop 입력시 계산 종료) >");
			String tmp = sc.next(); // 수, 문자(stop, stop이외)
			
			if(tmp.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			double n1;
			try {
				n1 = Double.parseDouble(tmp); // "10" -> 10.0 , "문자(stop이외)" -> 예외발생
			} catch (Exception e) { //예외객체 잡아서 처리
				System.out.println("잘못된 수를 입력하셨습니다.");
				continue;
			} finally { //예외 발생 여부에 관계 없이 무조건 실행
				//System.out.println("계산 중입니다.");
			}
			
			//수(정수,실수) -> 실수
			String tmp2 = sc.next();
			
			if(tmp2.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			double n2;
			try {
				n2 = Double.parseDouble(tmp2); // "10" -> 10.0 , "문자(stop이외)" -> 예외발생
			} catch (Exception e) { //예외객체 잡아서 처리
				System.out.println("잘못된 수를 입력하셨습니다.");
				continue;
			} finally { //예외 발생 여부에 관계 없이 무조건 실행
				//System.out.println("계산 중입니다.");
			}
			
			//n2 : 수 -> 실수
			
			System.out.print("연산자 입력(+ - x /) >");
			String opr = sc.next();
			
			switch(opr.trim().toUpperCase()) { //앞뒤 공백 제거 -> 대문자로 변환
			case "+":
				System.out.println(n1 + "+" + n2 + "=" + cal.add(n1, n2));
				totalCnt++;
				break;
			case "-" :
				System.out.println(n1 + "-" + n2 + "=" + cal.sub(n1, n2) );
				totalCnt++;
				break;
			case "*" :
				System.out.println( n1 + "X" + n2 + "=" + cal.mul(n1, n2) );
				totalCnt++;
				break;
			case "/" :
				System.out.println( n1 + "/" + n2 + "=" + cal.div(n1, n2) );
				totalCnt++;
				break;
			default : 
				System.out.println("계산기에 없거나 잘못된 연산자입니다.");
			}
			
		}//while
		
		System.out.println("----------계산종료---------");
		
		cal.showOperatingTimes();
		System.out.println();
		System.out.println("총 실행 횟수:" + totalCnt);
		
		
	}//main

}

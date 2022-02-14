package cal;

import java.util.Scanner;

public class CalculatorMain {

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
		
		Scanner sc = new Scanner (System.in);
		int cntAdd=0, cntSub = 0, cntMul=0, cntDiv=0;
		
		while(true) {
			System.out.print("첫번째 수를 입력하세요(종료:stop) >");
			String tmp = sc.next();
			
			if(tmp.equalsIgnoreCase("stop")) {
				System.out.println("종료되었습니다.");
				break;
			}
			
			try {
				Double.parseDouble(tmp);
			} catch (NumberFormatException e) {
								
				System.out.println("다시 입력해주세요.");
				continue;
			}
			double num1 = Double.parseDouble(tmp);
			
			
			System.out.print("두번째 수를 입력하세요(종료:stop) >");
			tmp = sc.next();
			
			if(tmp.equalsIgnoreCase("stop")) {
				System.out.println("종료되었습니다.");
				break;
			}
			
			try {
				Double.parseDouble(tmp);
			} catch (NumberFormatException e) {
				
				System.out.println("다시 입력해주세요.");
				continue;
			}
			double num2 = Double.parseDouble(tmp);
			
			
			System.out.print("연산자를 입력하세요(+,-,*,/)(종료:stop) >");
			String c = sc.next();
			
			if(c.equalsIgnoreCase("stop")) {
				break;
			}
			
			switch(c) {
			case "+" :
				cntAdd++;
				System.out.println( num1 + "+" + num2 + "=" + cal.add(num1, num2) );
				break;
			case "-" :
				cntSub++;
				System.out.println( num1 + "-" + num2 + "=" + cal.sub(num1, num2) );
				break;
			case "*" :
				cntMul++;
				System.out.println( num1 + "X" + num2 + "=" + cal.mul(num1, num2) );
				break;
			case "/" :
				cntDiv++;
				System.out.println( num1 + "/" + num2 + "=" + cal.div(num1, num2) );
				break;
			default : System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
			}
			
		} 	
		System.out.println("-------------------------");
		cal.showOperatingTimes();

		
		System.out.println();
		
		System.out.println("10+20="+cal.add(10, 20));
		System.out.println("10-20="+cal.sub(10, 20));
		System.out.println("10*20="+cal.mul(10, 20));
		System.out.println("10/20="+cal.div(10, 20));
		
		
		
		
	}

}

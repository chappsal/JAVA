package cal;

import java.util.Scanner;

public class CalculatorMain3 {

	public static void main(String[] args) {
		
		// 계산기 생성
		Calculator cal = new Calculator();
		
		Scanner sc = new Scanner(System.in);

		int totalCnt = 0;
		boolean flag = true;
		
		while(flag) {
			double n1;
			double n2;
			//연산자
			char operation;
			//연산자의 위치
			int index;
			
			System.out.println("계산식(1+1, 1*1..)을 입력해주세요.(종료:stop)");//  " 1+2 " 
			//String temp = sc.nextLine().trim(); //엔터까지 읽어들임 => 엔터 버리고 문자열 객체 생성 => 앞뒤공백 제거
			//next(),nextInt(), nextDouble() 셋은 구분자가 같음. 이 셋을 사용하다가 nextLine()사용 시 버퍼 앞 엔터를 따로 처리해줘야한다.
			
			String temp = sc.next(); //버퍼에 엔터가 남아 있어도 구분자로 무시함
		
			if(temp.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			//찾고자하는 문자의 index번호를 리턴   != -1 (-1:해당 문자가 없을때 리턴됨) 
			if(temp.indexOf('+') != -1) {
				index = temp.indexOf('+');
				operation = '+';				
			}
			else if(temp.indexOf('-') != -1) {
				index = temp.indexOf('-');
				operation = '-';
			}
			else if(temp.indexOf('*') != -1) {
				index = temp.indexOf('*');
				operation = '*';
			}
			else if(temp.indexOf('/') != -1) {
				index = temp.indexOf('/');
				operation = '/';
			}
			else {
				System.out.println("잘못입력했습니다. 다시 입력해주세요.");
				sc.nextLine();
				continue;
			}
			
			try {
				n1 = Double.parseDouble(temp.substring(0, index));// 1+2에서 1만 -> 1.0
				n2 = Double.parseDouble(temp.substring(index + 1, temp.length())); // 1+2에서 2만 -> 2.0
			} catch (NumberFormatException e) { //수가 아닌  stop 이외의 문자 처리
				//e.printStackTrace();
				System.out.println("잘못입력했습니다. 다시 입력해주세요.");
				sc.nextLine(); // ★★연산자 없이 "1 2 3 엔터" 를 입력했을때 1만 읽어들이고(temp에 저장) 버퍼에 남은 " 2 3엔터" 를 없애기 위해 nextLine()사용
				continue;
			}
			
			switch(operation) {
			case '+' :
				System.out.println(n1 + " + " + n2 + " = " + cal.add(n1, n2));
				totalCnt++;
				break;
			case '-' :
				System.out.println(n1 + " - " + n2 + " = " + cal.sub(n1, n2));
				totalCnt++;
				break;
			case '*' :
				System.out.println(n1 + " * " + n2 + " = " + cal.mul(n1, n2));
				totalCnt++;
				break;
			case '/' :
				System.out.println(n1 + " / " + n2 + " = " + cal.div(n1, n2));
				totalCnt++;
				break;
			}
		}

		cal.showOperatingTimes();
		System.out.println("총 실행 횟수:" + totalCnt);
		
	}//main

}


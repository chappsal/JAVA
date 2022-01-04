package cal;

import java.util.Scanner;

public class CalculatorMain4 {

	public static void main(String[] args) {
		
		//[과제 1]

		// 계산기 생성
		Calculator cal = new Calculator();
		
		Scanner sc = new Scanner(System.in);

		String[] tmpArr;
		String opr = null;

		int totalCnt = 0;
		boolean flag = true;
		
		while(flag) {
			
			String regex;
			double d1, d2;
			
			
			System.out.println("계산식(1+1, 1*1..)을 입력해주세요.(종료:stop)");//  " 1+2 " 
			
			String tmp = sc.nextLine().trim(); 
			
			if(tmp.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			/* 문자열 안에 찾고자하는 문자열이 있는지 확인하는 방법 (많이 사용) / 정리 StringMethod.java에
			 * 1. contains("찾는 문자열")  => true / false 리턴
			 * 
			 * 2. indexOf("찾는 문자열") != -1
			 * 		ex) "행복사랑".indexOf("사랑") => 2(찾는 문자열의 시작 index번호 리턴)
			 */
			
			if(tmp.contains("+")) {
				opr = "+";
			} else if(tmp.contains("-")) {
				opr = "-";
			} else if(tmp.contains("*")) {
				opr = "*";
			} else if(tmp.contains("/")) {
				opr = "/";
			} else System.out.println("잘못된 연산자");
			
			
			try {
				regex = null;
				
				if(opr.equals("+") || opr.equals("*")) {
					regex = "\\" + opr;
				}
				else {regex = opr;}
				
				tmpArr = tmp.split(regex);
				d1 = Double.parseDouble(tmpArr[0]);
				d2 = Double.parseDouble(tmpArr[1]); 
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("다시 입력해주세요");
				sc.nextLine();
				continue;				
			}
			
			switch(opr) {
			case "+":
				System.out.println(d1+ "+" + d2 + "=" + cal.add(d1, d2));
				break;
			
			case "-":
				System.out.println(d1+ "-" + d2 + "=" + cal.sub(d1, d2));
				break;
				
			case "*":
				System.out.println(d1+ "*" + d2 + "=" + cal.mul(d1, d2));
				break;
				
			case "/":
				System.out.println(d1+ "/" + d2 + "=" + cal.div(d1, d2));
				break;
				
			}
		}

		cal.showOperatingTimes();
		System.out.println("총 실행 횟수:" + totalCnt);
		
	}//main

}

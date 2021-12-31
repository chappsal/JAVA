package cal;

import java.util.Scanner;

public class CalculatorMain4 {

	public static void main(String[] args) {
		
		// 계산기 생성
		Calculator cal = new Calculator();
		
		Scanner sc = new Scanner(System.in);

		int totalCnt = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("계산식(1+1, 1*1..)을 입력해주세요.(종료:stop)");//  " 1+2 " 
			
			String tmp = sc.next(); 
			tmp = tmp.trim();
			
			if(tmp.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			String[] tmpArr;
			String opr = null;
			
			if(tmp.indexOf("+") != -1) {
				opr = "+";
			} else if(tmp.indexOf("-") != -1) {
				opr = "-";
			} else if(tmp.indexOf("*") != -1) {
				opr = "*";
			} else if(tmp.indexOf("/") != -1) {
				opr = "/";
			} else System.out.println("잘못된 연산자");
			
			String regex = null;
			if(opr.equals("+") || opr.equals("*")) {
				regex = "\\" + opr;
			}
			else {
				regex = opr;
			}
			tmpArr = tmp.split(regex);
			double d1 = Double.parseDouble(tmpArr[0]); // "1" -> 1.0
			double d2 = Double.parseDouble(tmpArr[1]); // "2" -> 2.0
			
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


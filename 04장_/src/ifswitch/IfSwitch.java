/*
 * 클래스 종류 3가지 : 모든 클래스에는 생성자가 존재한다.
 * 1. 라이브러리용(=설계도) : main() 없음.
 *                      옵션:멤버변수(=필드),메서드들()
 * 2. 실행용 : main() 있음.
 * 3. 라이브러리용 + 실행용: main()도 있고 
 *                     + 필요한 멤버변수(필드)와 메서드들()을 추가하면
 *                     이 실행용 클래스도 라이브러리용으로도 사용 가능
 *                     
 * public class 클래스명 : public 붙으면 모든 패키지에서 import 가능        
 *                             없으면 같은 패키지에서만 import 가능 
 *                             
 * static 멤버변수/메서드() : static 붙으면 해당 클래스가 import 될 때 메모리에 올라감 => 바로 사용 가능
 *                       없으면 new 생성자(); 호출하여 heap 메모리에 올라옴(이 때, 생성된 객체 안에 존재) => 객체 생성 후 사용 가능
 *                       
 * 모든 클래스에는 생성자가 존재.
 * 생성자 역할 : 멤버 변수에 값을 채워 객체를 생성하며 heap 메모리에 올림
 *                                       
 *                     
 *                     
 *                     
 * */

package ifswitch;

import java.util.Scanner;

public class IfSwitch {
	// 멤버변수(=filed)

	// 기본생성자 : 생성자가 없으면 컴파일러가 컴파일하기 전에 기본생성자 자동 삽입
	// public IfSwitch(){super();}

	// super(); 부모클래스 생성자를 호출하여 부모객체 생성

	// 메서드들

	public static void main(String[] args) {// 메서드(=함수):소문자로 시작~()

		Scanner sc = new Scanner(System.in); // 키보드에서 값을 입력 받으려면 스캐너 생성
		System.out.println("점수 입력(0~100>");
		int n1 = sc.nextInt();

		// 단독 if문-서로 독립적
		if (n1 >= 90)
			System.out.print("A"); // 90~100

		if (n1 >= 80 && n1 < 90)
			System.out.print("B");

		if (n1 >= 70 && n1 < 80)
			System.out.print("C");

		if (n1 >= 60 && n1 < 70)
			System.out.print("D");

		if (n1 < 60)
			System.out.print("F");

		System.out.println("학점");// 무조건 실행

		// if~else if.......else문 : 한 덩어리 - 여러 조건문 중 반드시 하나만 참

		if (n1 >= 90)
			System.out.print("A"); // 90~100
		else if (n1 >= 80)
			System.out.print("B"); // else 의미:n1<90
		else if (n1 >= 70)
			System.out.print("C"); // else 의미:n1<80
		else if (n1 >= 60)
			System.out.print("D"); // else 의미:n1<70
		else
			System.out.print("F");

		System.out.println("학점");// 무조건 실행

		// 중첩 if문 : 95~100 => A+ , 90~94 => A

		if (n1 >= 90) {
			if (n1 >= 95)
				System.out.print("A+");
			else
				System.out.println("A");// n1>=90 && n1<95
		} else if (n1 >= 80) {
			if (n1 >= 85)
				System.out.print("B+");
			else
				System.out.println("B");
		} else if (n1 >= 70) {
			if (n1 >= 75)
				System.out.print("C+");
			else
				System.out.println("C");
		} else if (n1 >= 60) {
			if (n1 >= 65)
				System.out.print("D+");
			else
				System.out.println("D");
		} else
			System.out.print("F");

		System.out.println("학점");// 무조건 실행

		// ******************************************************************

		/*
		 * switch()문 : 여러 개 중 하나만 선택하여 실행(if ~ else if ... else문과 호환, switch문으로 해결할 수 없는
		 * 것까지 if문은 해결 가능) switch문 sql에서는 decode(), if문 sql에서는 case~end ()안에 들어갈 수 있는 내용
		 * : 정수, '문자', "문자열"을 결과로 가지는 것 (실수 안됨) case 정수,'문자',"문자열" 상수만 올 수 있다.
		 */

		switch (add(10, 20)) {// switch(IfSwitch.add(10,20))
		case 10:
			System.out.println("10");
			break;
		case 20:
			System.out.println("20");
			break;
		case 30:
			System.out.println("30");
			break;
		default:
			System.out.println("그 이외"); // break 생략 가능 // ex) -123, 0, 78 등등
		}

		// 객체를 생성한 후 주소 접근하여 static 없는 instance 메서드 호출 (instance=객체)
		IfSwitch is = new IfSwitch();
		is.add(10.2, 9);

		int result = add(3, 7);
		System.out.println(result + 10);

		// ex 1. switch(정수)

		System.out.println("----------switch문의 정수 테스트-----------------------");
		switch ((int) is.add(10.2, 10.2)) {
		case 10:
			System.out.println("10");
			break;
		case 20:
			System.out.println("20");
			break;
		case 30:
			System.out.println("30");
			break;
		default:
			System.out.println("그 이외");
		}

		// ex 2. switch('문자')------------------------------------------------------

		System.out.println("----------switch문의 문자 테스트-----------------------");
		switch ('a') {// '0'=>48, 'a'=>97
		case '0':
			System.out.println("문자 0입니다.");
			break;
		case 97:
			System.out.println("문자 a입니다.");
			break;
		default:
			System.out.println("문자 0,a 이외입니다.");
		}

		System.out.println("65~90사이의 정수 입력>");
		int num = sc.nextInt();// 65입력
		System.out.print("당신이 입력한 정수에 해당하는 문자는 ");
		switch (parseChar(num)) { // 65:'A', 65+32:'a'
		case 'A':
			System.out.println("A입니다.");
			break;
		case 'B':
			System.out.println("B입니다.");
			break;
		case 'C':
			System.out.println("C입니다.");
			break;
		default:
			System.out.println("A,B,C 이외 대문자입니다.");
		}

		System.out.print("당신이 입력한 정수에 해당하는 문자를 소문자로 표현하면 ");
		switch (parseChar(num) + 32) { // 65:'A', 65+32:'a'
		case 'a':
			System.out.println("a입니다.");
			break;
		case 'b':
			System.out.println("b입니다.");
			break;
		case 'c':
			System.out.println("c입니다.");
			break;
		default:
			System.out.println("a,b,c 이외 소문자입니다.");
		}

		// ex 3. switch("문자열")

		System.out.println("----------switch문의 문자열 테스트-----------------------");
		switch ("행복") {
		case "행복":
			System.out.println("행복하세요");
			break;
		case "사랑":
			System.out.println("사랑하세요");
			break;
		case "건강":
			System.out.println("건강하세요");
			break;
		default:
			System.out.println("그외문자열");
		}

		switch ("행복") {
		case "행복": // break를 만나기 전까지 실행되기 때문에
		case "사랑":
			System.out.println("행복 또는 사랑하세요");
			break;
		case "건강":
			System.out.println("건강하세요");
			break;
		default:
			System.out.println("그외문자열");
		}

		System.out.print("두 글자로 된 단어 입력>");
		String word = sc.next(); // 엔터 전까지 읽어들임, 엔터처리 필요없음
		switch (word) {
		case "행복":
			System.out.println("행복하세요");
			break;
		case "사랑":
			System.out.println("사랑하세요");
			break;
		case "건강":
			System.out.println("건강하세요");
			break;
		default:
			System.out.println(word + "하세요");
		}

		// 문제)
		System.out.println("점수 입력(0~100)>");
		n1 = sc.nextInt();
		System.out.print("당신의 학점은 ");
		switch (n1 / 10) { // 입력받은 정수/10=>몫
		case 10:
			System.out.println("A입니다.");
			break;
		case 9:
			System.out.println("B입니다");
			break;
		case 8:
			System.out.println("C입니다");
			break;
		case 7:
			System.out.println("D입니다");
			break;
		default:
			System.out.println("F입니다");
		}

		// 반복문 사용: 카페에서 주문(손님 주문:입력)->switch문으로 처리->결과 출력

		// 주문을 3번만 함(반드시 메뉴에 있는 것 3번 주문)

		System.out.println("주문을 3번만 함(반드시 메뉴에 있는 것 3가지)");

		for (int i = 1; i <= 3;) {
			System.out.print("메뉴(아메리카노,카페라떼,카푸치노)중에서 주문(단,주문안함 또는 stop)");
			String order = sc.next();

			switch (order) {
			case "아메리카노":
			case "카페라떼":
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				i++;
				break;
			default:
				System.out.println("메뉴에 없습니다.");
			}

		}

		// --------------------------------------------------------

		System.out.println("주문을 3번만 함");
		for (int i = 1; i <= 3; i++) {
			System.out.print("메뉴(아메리카노,카페라떼,카푸치노)중에서 주문(단,주문안함 또는 stop)");
			String order = sc.next();

			switch (order) {
			case "아메리카노":
			case "카페라떼":
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				break;
			default:
				System.out.println("메뉴에 없습니다.");
			}
		}

		System.out.println("----1.do~while문 카페 주문 처리 시작------------");

		int i = 1;
		do {
			System.out.print("메뉴(아메리카노,카페라떼,카푸치노)중에서 주문(단,주문안함 또는 stop)");
			String order = sc.next(); // 주문안함

			if (order.equals("주문안함")) {
				break;// 가장 가까운 반복문을 빠져나감
			}

			switch (order) {
			case "아메리카노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				break;
			case "카페라떼":
				System.out.println(order + "를(을) 주문하셨습니다.");
				break;
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				break;
			case "stop":
				System.out.println("그만 주문하겠습니다.");
				i++;
				break;
			default:
				System.out.println("메뉴에 없습니다.");
			}
			//
			// [과제-1] stop을 제외한 4가지 경우는 조건문이 참, stop만 거짓
		} while (i <= 1);
		System.out.println("1.do~while문 카페 주문 처리 끝");

		/*
		 * 풀이 2
		 * 
		 * String order; do{
		 * System.out.print("메뉴(아메리카노,카페라떼,카푸치노)중에서 주문(단,주문안함 또는 stop)"); order =
		 * sc.next(); //주문안함
		 * 
		 * if(order.equals("주문안함")) { break;//가장 가까운 반복문을 빠져나감 }
		 * 
		 * 
		 * 
		 * switch(order) { case "아메리카노" : System.out.println( order +"를(을) 주문하셨습니다.");
		 * break; case "카페라떼" : System.out.println( order +"를(을) 주문하셨습니다."); break; case
		 * "카푸치노" : System.out.println( order +"를(을) 주문하셨습니다."); break; case "stop" :
		 * System.out.println("그만 주문하겠습니다."); break; default: System.out.println(
		 * "메뉴에 없습니다."); } // //[과제-1] stop을 제외한 4가지 경우는 조건문이 참, stop만 거짓
		 * }while(!order.equalsIgnoreCase("stop"));
		 * }while(!order.equalsIgnoreCase("stop")!=true);
		 * 
		 */
		// System.out.println("do~while문 카페 주문 처리 끝");

		// 12-03 과제1 stop입력시 order한잔, order한잔 총 n잔, 총 가격은 n원입니다 (n잔,n잔 할 때 마지막 콤마 없음 주의
		// 스트링메소드에 있음)
		System.out.println("----2.do~while문 카페 주문 처리 시작------------");

		int amCnt = 0, cfCnt = 0, cpCnt = 0; // 각 메뉴 count 변수 선언 , 아메 카페 카푸
		int price = 0;

		String order; // 위에서 선언됨

		do {
			System.out.print("메뉴(아메리카노:3000원,카페라떼:4000원,카푸치노:3500원)중에서 주문(단,주문안함 또는 stop)");
			order = sc.next(); // 주문안함

			if (order.equals("주문안함")) {
				break;
			}

			switch (order) {
			case "아메리카노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				amCnt++;
				price += 3000;
				break;
			case "카페라떼":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cfCnt++;
				price += 4000;
				break;
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cpCnt++;
				price += 3500;
				break;
			case "stop":
				System.out.println("그만 주문하겠습니다.");
				break;
			default:
				System.out.println("메뉴에 없습니다.");
			}

		} while (!order.equalsIgnoreCase("stop"));
		if (amCnt + cfCnt + cpCnt != 0) {
			System.out.println(

					"아메리카노" + amCnt + "잔, " + "카페라떼 " + cfCnt + "잔, 카푸치노 " + cpCnt + "잔 총 " + (amCnt + cfCnt + cpCnt)
							+ "잔 가격은 " + price + "원 입니다.");

		}
		System.out.println("2.do~while문 카페 주문 처리 끝");

		// 풀이 subString, temp 사용
		// -----------------------------------------------------------------------------------------------

		System.out.println("----2.do~while문 카페 주문 처리 시작------------");

		amCnt = 0;
		cfCnt = 0;
		cpCnt = 0; // 각 메뉴 count 변수 선언 , 아메 카페 카푸
		price = 0;
		int amPrice = 0, cfPrice = 0, cpPrice = 0, totalCnt = 0;

		// String order; // 위에서 선언됨

		cafe: do {
			System.out.print("메뉴(Americano:3000원,카페라떼:4000원,카푸치노:3500원)중에서 주문(단,주문안함(=NoOrder) 또는 stop)");
			order = sc.next(); // 주문안함

			if (order.equalsIgnoreCase("주문안함") || order.equalsIgnoreCase("NoOrder")) {
				break;
			}

			switch (order.toUpperCase()) { // 영어가 대문자로 변환 , 경우의 수 줄이기, order가 참조하는 것은 대문자가 아니라 입력한 값 그 자체임(대입연산자를 사용하지
											// 않는 이상)
			case "AMERICANO":
				System.out.println(order + "를(을) 주문하셨습니다.");
				amCnt++;
				amPrice += 3000;
				break;
			case "카페라떼":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cfCnt++;
				cfPrice += 4000;
				break;
			case "카푸치노":
				System.out.println(order + "를(을) 주문하셨습니다.");
				cpCnt++;
				cpPrice += 3500;
				break;
			case "STOP":
				System.out.println("그만 주문하겠습니다.");

				String tempOrder = "";
				if (amCnt > 0)
					tempOrder += "아메리카노" + amCnt + "잔에" + amPrice + "원, ";
				if (cfCnt > 0)
					tempOrder += "카페라떼" + cfCnt + "잔에" + cfPrice + "원, ";
				if (cpCnt > 0)
					tempOrder += "카푸치노" + cpCnt + "잔에" + cpPrice + "원, ";

				tempOrder = tempOrder.substring(0, tempOrder.length() - 2);

				totalCnt = amCnt + cfCnt + cpCnt;
				price = amPrice + cfPrice + cpPrice;

				if (totalCnt > 0)
					System.out.println(tempOrder + "\n총" + totalCnt + "잔, 총 가격은 " + price + "입니다.");
				break cafe; // cafe (do~while)레이블 빠져나감
			default:
				System.out.println("메뉴에 없습니다.");
			}

		} while (!order.equalsIgnoreCase("stop")); // 위에서 대문자만 참조하고 있기 때문에 IgnoreCase 떼도 됨
		if (amCnt + cfCnt + cpCnt != 0) {
			System.out.println(

					"아메리카노" + amCnt + "잔, " + "카페라떼 " + cfCnt + "잔, 카푸치노 " + cpCnt + "잔 총 " + (amCnt + cfCnt + cpCnt)
							+ "잔 가격은 " + price + "원 입니다.");

		}
		System.out.println("2.do~while문 카페 주문 처리 끝");

		// ------------------------------------------------------------------------------------

		System.out.println("--메서드 호출하여 사용하는 방법-------------------------------");
		System.out.println("1. 같은 클래스 안에 존재하는 static 메서드 호출");

		int hap = add(3, 7);// add야~ // 클래스명 생략 가능(이유? 같은 클래스 안에 존재하므로), add위에 커서 두면 뜨는 창 맨 앞에 타입 뜸 int
		System.out.println("결과의 10배=" + hap * 10);
		// IfSwitch.add(3,7);//같은반add야

		System.out.println("2. 같은 클래스 안에 존재하는 static 없는 메서드(=instance 메서드) 호출");
		IfSwitch ifswitch = new IfSwitch(); // new 클래스명(); <= 생성자, 생성자를 호출하여 객체 생성하면 그 안에 instance 메서드가 존재
		double hap2 = ifswitch.add(3, 7.0); // 3->3.0 , 7->7.0 자동형변환되어 변수 안에 들어감
		System.out.println("3+7.0=+" + hap2);

		ifswitch.add(3.0, 7);

		sc.close();
	}// main()끝

	/*
	 * 메서드 오버로딩 : 같은 이름의 메서드(단, 매개변수의 수나 타입이 달라야 한다)
	 */

	/*
	 * [메서드 만드는 법] 결과를 돌려주는 타입(돌려주는 결과가 없으면 void) + 메서드명(매개변수 선언){ return 돌려줄 결과 }
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	static int add(int n1, int n2) { // 매개변수 = 인수 = 인자 = argument (매개변수는 '지역변수=로컬변수'이다.)
		return n1 + n2; // int+int => int => 결과로 돌려줄 때 double 타입으로 자동형변환
	}

	static double add(int n1) { // static int add 일 때 => 위와 메서드 이름이 같지만 매개변수 수가 달라서 허용
		return n1; // int n1이 double n1으로 자동형변환되어 결과 리턴
	}

	double add(double n1, double n2) {
		return n1 + n2;

	}

	void add(double n1, int n2) {
		System.out.println(n1 + "+" + n2 + "=" + (n1 + n2)); // 19.2 결과를 출력만하고 리턴하지 않음
	}

	// 같은 이름의 add 를 만드는 것은 목적에 따라 add를 호출하기 위해

	// void이지만 return 있을 수 있는 예
	void add(int n1, int n2, int n3) {
		if (n1 == 0)
			return; // return => 메서드 종료 시킴
		System.out.println(n1 + n2 + n3);
	}

	static char parseChar(int n) {
		return (char) n;

	}

}// class 끝, 커서 올려두면 뭔지 나옴

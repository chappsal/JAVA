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
	//멤버변수(=filed)
	
	//기본생성자 : 생성자가 없으면 컴파일러가 컴파일하기 전에 기본생성자 자동 삽입
	//public IfSwitch(){super();}
	
	
	// super(); 부모클래스 생성자를 호출하여 부모객체 생성 
	
	//메서드들
	
	public static void main(String[] args) {//메서드(=함수):소문자로 시작~() 
		
		Scanner sc = new Scanner(System.in); // 키보드에서 값을 입력 받으려면 스캐너 생성
		System.out.println("점수 입력(0~100>");
		int n1 = sc.nextInt();
		
		//단독 if문-서로 독립적
		if(n1>=90) System.out.print("A"); //90~100

		if(n1>=80 && n1<90) System.out.print("B");	
		
		if(n1>=70 && n1<80) System.out.print("C");
		
		if(n1>=60 && n1<70) System.out.print("D");		
		
		if(n1<60) System.out.print("F");
		
		System.out.println("학점");//무조건 실행
		
		
		//if~else if.......else문 : 한 덩어리 - 여러 조건문 중 반드시 하나만 참
		
		if(n1>=90) System.out.print("A"); //90~100
		else if(n1>=80) System.out.print("B"); //else 의미:n1<90
		else if(n1>=70 ) System.out.print("C"); //else 의미:n1<80	
		else if(n1>=60 ) System.out.print("D");	//else 의미:n1<70	
		else System.out.print("F");
		
		System.out.println("학점");//무조건 실행
		
		
		
		// 중첩 if문 : 95~100 => A+ , 90~94 => A
		
		if(n1>=90) {
			if(n1>=95) System.out.print("A+"); 
			else System.out.println("A");// n1>=90 && n1<95
		}
		else if(n1>=80) {
			if(n1>=85) System.out.print("B+");
			else System.out.println("B");
		}
		else if(n1>=70 ) {
			if(n1>=75) System.out.print("C+");
			else System.out.println("C");
		}
		else if(n1>=60 ) {
			if(n1>=65)System.out.print("D+");
			else System.out.println("D");
		}
		else System.out.print("F");
		
		System.out.println("학점");//무조건 실행
		
		
		//******************************************************************
		
		/* switch()문 : 여러 개 중 하나만 선택하여 실행(if ~ else if ... else문과 호환)
		* ()안에 들어갈 수 있는 내용 : 정수, '문자', "문자열"을 결과로 가지는 것 (실수 안됨)
		* case 정수,'문자',"문자열" 상수만 올 수 있다.
		*/
		
	
		
		
		switch(add(10,20)) {//switch(IfSwitch.add(10,20))
		case 10 : System.out.println("10"); break;
		case 20 : System.out.println("20"); break;
		case 30 : System.out.println("30"); break;
		default : System.out.println("그 이외"); // break 생략 가능 // ex) -123, 0, 78 등등
		}
		
		
		// 객체를 생성한 후 주소 접근하여 static 없는 instance 메서드 호출 (instance=객체)
		IfSwitch is = new IfSwitch(); 
		is.add(10.2, 9);
		
		
		int result = add(3, 7);
		System.out.println(result+10); 
		
		
		
		// ex 1. switch(정수)
		
		
		
		System.out.println("----------switch문의 정수 테스트-----------------------");
		switch((int)is.add(10.2, 10.2)) {
			case 10 : System.out.println("10"); break;
			case 20 : System.out.println("20"); break;
			case 30 : System.out.println("30"); break;
			default : System.out.println("그 이외");
		}
		
	
		
		// ex 2. switch('문자')------------------------------------------------------
		
		System.out.println("----------switch문의 문자 테스트-----------------------");
		switch('a') {// '0'=>48, 'a'=>97
		case '0':System.out.println("문자 0입니다."); break;
		case 97:System.out.println("문자 a입니다."); break;
		default : System.out.println("문자 0,a 이외입니다.");
		}
		
		
		System.out.println("65~90사이의 정수 입력>");
		int num = sc.nextInt();//65입력
		System.out.print("당신이 입력한 정수에 해당하는 문자는 ");
		switch(parseChar(num)) { // 65:'A', 65+32:'a'
		case 'A':System.out.println("A입니다."); break;
		case 'B':System.out.println("B입니다."); break;
		case 'C':System.out.println("C입니다."); break;
		default :System.out.println("A,B,C 이외 대문자입니다.");
		}
	
		System.out.print("당신이 입력한 정수에 해당하는 문자를 소문자로 표현하면 ");
		switch(parseChar(num)+32) { // 65:'A', 65+32:'a'
		case 'a':System.out.println("a입니다."); break;
		case 'b':System.out.println("b입니다."); break;
		case 'c':System.out.println("c입니다."); break;
		default :System.out.println("a,b,c 이외 소문자입니다.");
		}
		
		
		// ex 3. switch("문자열")
		
		System.out.println("----------switch문의 문자열 테스트-----------------------");
		switch("행복") {
		case "행복":System.out.println("행복하세요"); break;
		case "사랑":System.out.println("사랑하세요"); break;
		case "건강":System.out.println("건강하세요"); break;		
		default   :System.out.println("그외문자열");
		}
	
		
		switch("행복") {
		case "행복":                                             // break를 만나기 전까지 실행되기 때문에
		case "사랑":System.out.println("행복 또는 사랑하세요"); break;
		case "건강":System.out.println("건강하세요"); break;		
		default   :System.out.println("그외문자열");
		}
	
		
		
		System.out.print("두 글자로 된 단어 입력>");
		String word = sc.next(); // 엔터 전까지 읽어들임, 엔터처리 필요없음
		switch(word) {
		case "행복":System.out.println("행복하세요"); break;
		case "사랑":System.out.println("사랑하세요"); break;
		case "건강":System.out.println("건강하세요"); break;		
		default   :System.out.println(word+"하세요");
		}
		
		
		// 문제)
		System.out.println("점수 입력(0~100)>");
		n1 = sc.nextInt();
		System.out.print("당신의 학점은 ");
		switch(n1/10) {
		case 10: System.out.println("A입니다."); break;
		case 9: System.out.println("B입니다"); break;
		case 8: System.out.println("C입니다"); break;
		case 7: System.out.println("D입니다"); break;
		default  :System.out.println("F입니다");
		}
		
		
		
		
		
	}//main()끝
		
	
	
	//결과를 돌려주는 타입 + 메서드명(매개변수 선언){}
	static int add(int n1, int n2){ // 매개변수 = 인수 = 인자 = argument (매개변수는 '지역변수=로컬변수'이다.)
		return n1+n2; // int+int => int => 결과로 돌려줄 때 double 타입으로 자동형변환
	}
		
	
	double add(double n1, double n2){
		return n1+n2;
		
	}
	
	
	void add(double n1, int n2) { 
		System.out.println(n1+n2); // 19.2 결과를 출력만하고 리턴하지 않음
	}   

	// 같은 이름의 add 를 만드는 것은 목적에 따라 add를 호출하기 위해
	
	
	static char parseChar(int n){
		return (char)n;
		
	}
	
	
	
	
}// class 끝, 커서 올려두면 뭔지 나옴
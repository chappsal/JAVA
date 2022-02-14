package scannerstring;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class StringMethod {

	public static void main(String[] args) {
		String s1 = ""; // 값이 없는 문자열 객체 생성. length():문자의 길이,수 => 값 0 나옴
		String s2 = null; // s2가 참조하는 문자열 객체가 없다.
		
		// String 객체 생성 2가지 방법
		
		String str1 = "문자열 상수"; // 1. "문자열 상수"로 객체 생성 -> "공유 상수 풀"에 등록(static영역에 있음)
		String str2 = "문자열 상수"; 
		String str3 = new String("문자열 상수"); // 2. new 생성자();로 호출하여 객체 생성
	
		
		System.out.println(str1); // str1 : String 객체의 주소 => 결과로 "문자열 상수" 출력
		//Object의 toString()메서드를 대부분의 라이브러리 클래스에서는 재정의하여 우리에게 제공함
		System.out.println(str1.toString()); // 결과로 "문자열 상수" 출력

		
		//s1주소 == s2 주소
		if(str1 == str2) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
				
		if(str1 == str3) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
				
		
		System.out.println(); //구분용 빈 줄
		
		
		/*
		 * 주소를 비교하는 것은 중요하지 않다.
		 * 주소가 참조하는 객체의 값을 비교하는 것이 중요.
		 * equals(Object타입 변수) : 두 문자열의 값을 비교하여 같으면 true, 다르면 false
		 * Object 타입 변수: 모든 클래스 타입 변수 다 가능
		 * 
		 * 
		 * equalsIgnoreCase() : 대소문자 구분 없이 '값을 비교'하여 같으면 true, 다르면 false
		 *  
		 */
		
		if(str1.equals(str2)) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다.");
	

		if(str1.equals(str3)) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다.");
	
		
		if("AB".equalsIgnoreCase("ab")) System.out.println("대소문자 구분 없이 같은 문자열이다.");
		else System.out.println("대소문자 구문하여 다른 문자열이다.");	
		
		
		if("AB".equals("ab")) System.out.println("대소문자 구분하여 같은 문자열이다.");
		else System.out.println("대소문자 구문하여 다른 문자열이다.");


		System.out.println(); //구분용 빈 줄
		
		
		/* 
		 * compareTO() : 문자열의 값을 비교하여 int 정수(0또는 0이 아닌 값)를 결과로 리턴
		 * compareToIgnoreCase() : 영어의 대소문자 구분없이 값을 비교하여 int 정수(0또는 0이 아닌 값)를 결과로 리턴
		 */
		
		
		s1 = "AB"; // '65'의 2진수, '66'의 2진수
		s2 = "AC"; // '65' '67'
		if(s1.compareTo(s2) == 0) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다."); // s1.compareTo(s1) != 0

		
		if(s1.compareTo(s2) > 0) System.out.println("뒤의 문자열이 앞선다.");
		else if(s1.compareTo(s2) < 0)System.out.println("앞의 문자열이 앞선다.");
		else System.out.println("두 문자열이 같다."); // s1.compareTo(s2) == 0

		
		// '97' '98'  -  '65' '66' = 양수
		if("ab".compareToIgnoreCase("AB") != 0) System.out.println("대소문자 구분없이 다른 문자열이다." ); 
		else System.out.println("대소문자 구분 없이 같은 문자열이다.");


		System.out.println(); //구분용 빈 줄
		
		
		/*
		 * concat() : 두 문자열 연결(=결합)하여 "하나의 새로운 문자열 객체" 생성 , 기존 값 변경 x
		 *            cat: cateneate 연결하다 뜻
		 * 
		 * */
		
		s1 = "여러분~";
		s1 = s1.concat("조금만 더 힘내세요~"); // "여러분~조금만 더 힘내세요~"
		System.out.println(s1); // s1 이 참조하는 문자열 객체의 값이 출력	
		System.out.println(s1.toString()); //윗줄과 같은 뜻

		
		s2 = "여러분~";
		s2 = s2 + "조금만 더 힘내세요~"; // 문자열+문자열 => 두 문자열을 연결하여 하나의 새로운 문자열 객체 생성, 기존 값 변경 x
		
		System.out.println(s2); // s1 이 참조하는 문자열 객체의 값이 출력	
		System.out.println(s2.toString()); //윗줄과 같은 뜻
	
		
		
		/*
		 * length() : 문자열의 길이(=문자의 수)
		 * ex) "홍 길 동" 5 , 스페이스바 포함
		 * 
		 * 
		 * */
		
		System.out.println("\"신나는 점심시간!\""
				+ "의 문자열 길이="+"신나는 점심시간!".length());
		
		/*
		 * indexOf() : 찾고자 하는 해당 문자열이 있으면
		 *             해당 문자열의 시작 index 번호를 결과로 돌려줌(없으면 -1 리턴)
		 *             JAVA에서는 index번호는 0부터 시작
		 *             sql에서는 index번호는 1부터 시작 
		 * */
		
		System.out.println(s2.indexOf("조금만")); // "여러분~조금만 더 힘내세요~"
		System.out.println(s2.indexOf("최고")); // -1 출력
		
		if(s2.indexOf("조금만") != -1) System.out.println("해당 문자열이 속해있군요");
		else System.out.println("해당 문자열이 없군요");
		
		/*
		 * replace() : 다른 문자열로 대체하여 "하나의 새로운 문자열 객체" 생성, 기존 값 변경 x
		 * */
		
		s2=s2.replace("조금만 더", "짱"); // "여러분~짱 더 힘내세요~" 기존의 값을 변경하는 것이 아니라 새롭게 만듦
		System.out.println(s2);
		
		System.out.println(); // 구분 공백
	
		/* trim : 앞뒤 공백 제거하여 "하나의 새로운 문자열 객체" 생성, 기존 값 변경 x
		 * 
		 * */
		String tel1 ="         010";
		String tel2 ="1234        ";
		String tel3 ="   5678     ";
		
		String tel = tel1.trim() + "-" + tel2.trim() + "-" + tel3.trim();
		System.out.println(tel);
		System.out.println(tel1);
		System.out.println(tel2);
		System.out.println(tel3);
		
		/** toLower : 소문자로 변환
		 *  toUpper : 대문자로 변환
		 * 
		 * 
		 */
		String str4 = "java"; //"문자열 상수 "객체 생성하면 '공유산수풀'에 등록
		String str5 = "JAVA"; //"문자열 상수 "객체 생성하면 '공유산수풀'에 등록
		System.out.println(str4.toUpperCase());
		System.out.println(str4);
		
		if(str4.equals(str5)) System.out.println("같은 문자열");
		else System.out.println("다른 문자열");
		
		if(str4.equalsIgnoreCase(str5))
			System.out.println("대소문자 구분없이 같은 문자열");
		else System.out.println("대소문자 구분없이 다른 문자열");

		str4 = "java";
		if(str4.toUpperCase().equals(str5)) System.out.println("대문자로 같은 문자열");
		
		System.out.println(str4); // "java");
		
		if(str5.toLowerCase().equalsIgnoreCase(str4))
				System.out.println("대소문자 구분없이 같은 문자열");
		
		
		
		// 기본 타입(int, double, char, boolean..)을 문자열로 변환하는 방법 - 2가지
	
		// 방법 1. valueOf() : 기본타입 값 -> 문자열로 변환 static 메서드
	
		int i = 10; 
		String str6 = String.valueOf(i); // 10 -> '1''0', 메서드, 필드(=멤버 변수)
		char ch = str6.charAt(0); // '1'
		System.out.println("ch="+ch+",ch의 정수="+(int)ch);
		
		ch = String.valueOf(12.3).charAt(2); // 12.3 -> '1' '2' '.' '3', 메서드, 필드(멤버 변수)
		System.out.println("ch="+ch+",ch의 정수="+(int)ch);
		
		ch = "12.3".charAt(2);
		System.out.println("ch="+ch+",ch의 정수="+(int)ch);
		
		
		boolean b = true; //0123
		// true -> 't' 'r' 'u' 'e', 메서드, 필드(멤버 변수)
		str6 = String.valueOf(b).substring(1); // "rue"
		System.out.println("str6의 부분 문자열=" + str6);

		str6 = String.valueOf(b).substring(1, 2+1); // "ru"
		System.out.println("str6의 부분 문자열=" + str6);
		
		ch = String.valueOf(b).substring(1).charAt(1); // "rue" -> 'u'
		System.out.println("ch="+ch);
		
		
		// 방법 2. (더 심플) 두 문자열을 하나로 연결+ : 기본타입의 값(value)->"문자열"변환
		
		int i2 = 10;
		String str7 = i2+""; // "10" + ""
		str7 = ""+12.3;  // "" + "12.3"  => "12.3
		str7 = false+""; // "false" + "" => "false" 01234
		
		str7 = str7.substring(1, 3+1);   // "als" 012
		String str8 = str7.substring(2);       // "s"
		System.out.println("str8=" + str8);
		str7 = str7.substring(0,0+1);    // "a"
		System.out.println("str7=" + str7);
		
		
		
		/*************************************************************************** 
		 * 
		 * "문자열"을 기본 타입(int, double, char, boolean...) 으로 변환하는 방법
		 *
		 * ex) 문자열 " '1' '2' '3'은 연산할 수 없다. 연산을 하려면 기본 타입으로 변환
		 * 
		 * 모든 기본 타입에는 1:1로 대응하는 wrapper 클래스가 있다.
		 *
		 * ex) int: Integer, double:Double, char:Character, boolean:Boolean...
		 */
	
		
		// 정수 or 실수 문자열에 공백이 있으면 자동 공백 제거 후 기본 타입으로 변환
			
		double d3 = Double.valueOf("  12.3  ");
		System.out.println("d3+10="+(d3+10));
		
		// d3 = Double.parseDouble("  12.3  ".trim());
	    d3 = Double.parseDouble("  12.3  ");//자동 공백 제거"12.3"->12.3
		System.out.println("d3+10="+(d3+10));
		
		
	
		
		// 방법 1 . 각 wrapper 클래스의 valueOf(): "문자열" -> 기본 타입 값으로 변환
		
		String str9 = "10";
		System.out.println(str9+12); // "10"+"12" => "1012"
		
		// "10" -> Integer 10 -> auto unboxing되어 int 타입 10
		int i3 = Integer.valueOf(str9); // "10" -> Integer 10 -> auto unboxing 자동 언박싱되어 int 타입 10을 얻음
		System.out.println(i3+12);      // 10+12=22
		
		double d = Integer.valueOf("10");
		System.out.println(d+12); // 10.0+12=22.0
		
		boolean b2 = Boolean.valueOf("true");
		if(b2) System.out.println("정답");
		else System.out.println("오답");

		
		// 방법 2.(자주 사용) 각 wrapper 클래스의 parse~()메서드 이용 : "문자열" -> 기본 타입의 값으로 변환
		
		i3 = Integer.parseInt("10"); // "10" -> 10
		d= Double.parseDouble("12.3"); // "12.3" -> false
		b2 = Boolean.parseBoolean("true");
		
		System.out.println(i3+","+d+","+b2); // "10" + "," + "12.3" + "," + "false"
		
		
		
		
		/* 주의: Character에는 문자열을 문자 하나로 변경하는 메서드가 존재하지 않는다
		 * 
		 * 왜? 문자열을 문자 1개로 변환(추출) 불가
		 * 
		 * 문자열을 문자 1개로 변경하는 해결법 : String의 charAt() 사용하여 문자 1개 추출
		 * 
		 * */
		
		char ch2 = Character.valueOf('a'); // 사용 할 필요 없음
		System.out.println("ch2="+ch2+", ch2의 코드값="+(int)ch2);
		char ch3 = 'a';
		System.out.println("ch2="+ch3+", ch2의 코드값="+(int)ch3);
		
		
		// ch2 = Character.valueOf("abc"); 문자열 "abc" -> 문자 하나로 변경 불가
		// ch2 = Character.parseCharacter("abc"); // 문자열 "abc" -> 문자 하나로 변경 x
		
		
		/* 
		 * substring() : 문자열에서 원하는 부분을 문자열로 가져와 "부분 문자열" 생성
		 * substring(시작index) : '시작 index~끝까지' 가져와 "부분 문자열" 생성
		 * substring(시작index, 끝index+1) : '시작 index~끝index까지' 가져와 "부분 문자열" 생성
		 * ★★ 자바의 메서드에서 (시작index, 끝index) 나오면 반드시 "끝index+1" 해줘야 원하는 결과
		 * 
		 * 
		 * index 번호 : 자바는 0부터 시작, sql은 1부터 시작
		 * 
		 * */
		
		String substr = "행복, 건강, 소망".substring(4); // "건강, 소망" 
		System.out.println(substr);
	
	
		substr = "행복, 건강, 소망".substring(4, 5+1); // "건강" 
		System.out.println(substr);
	
		/*
		 * split(): 문자열 분리. 즉, "구분자"로 문자열을 "여러 부분 문자열"로 분리
		 */
		String animals = "dog, cat, rabbit";
		String[] aniSplit = animals.split(", ");
		
		for( String s : aniSplit) { //"dog"
			System.out.println(s);
		}
		
		//CalculatorMain.java에서 참조 ------------------------------------------
		String tmp = "  1+2  ";
		tmp = tmp.trim(); // "1+2"
		//String[] tmpArr = tmp.split("+"); // "1" "2"
		
		String[] tmpArr;
		double d1; //= Double.parseDouble(tmpArr[0]); // "1" -> 1.0
		double d2; //= Double.parseDouble(tmpArr[1]); // "2" -> 2.0
		String opr = null;
		
		/* 문자열 안에 찾고자하는 문자열이 있는지 확인하는 방법 (많이 사용)
		 * 1. contains("찾는 문자열")  => true / false 리턴
		 * 
		 * 2. indexOf("찾는 문자열") != -1
		 * 		ex) "행복사랑".indexOf("사랑") => 2(찾는 문자열의 시작 index번호 리턴)
		 */
		
		
		// contains 와 indexOf 둘 다 사용 가능
		if(tmp.contains("+")) { //if(tmp.indexOf("+") != -1) { 
			opr = "+";
			//tmpArr = tmp.split("+"); => 예외발생(오류) : + , * , ^ 등은 특별한 의미로 사용되기 때문에 구분자로 만들기 위해 \\ 넣어줌
			tmpArr = tmp.split("\\+");
			d1 = Double.parseDouble(tmpArr[0]); 
			d2 = Double.parseDouble(tmpArr[1]);
		} else if(tmp.contains("-")) { // } else if(tmp.indexOf("-") != -1) {
			opr = "-";
			tmpArr = tmp.split("-");
			d1 = Double.parseDouble(tmpArr[0]); 
			d2 = Double.parseDouble(tmpArr[1]);
		} else if(tmp.contains("*")) { // } else if(tmp.indexOf("*") != -1) {
			opr = "*";
			tmpArr = tmp.split("\\*"); 
			d1 = Double.parseDouble(tmpArr[0]); 
			d2 = Double.parseDouble(tmpArr[1]);
		} else if(tmp.contains("/")) { // } else if(tmp.indexOf("/") != -1) {
			opr = "/";
			tmpArr = tmp.split("/");
			d1 = Double.parseDouble(tmpArr[0]); 
			d2 = Double.parseDouble(tmpArr[1]);
		} else System.out.println("잘못된 연산자");
		
		String regex = null;
		if(opr.equals("+") || opr.equals("*")) regex = "\\" + opr;
		else regex = opr;
		tmpArr = tmp.split(regex);
		d1 = Double.parseDouble(tmpArr[0]); // "1" -> 1.0
		d2 = Double.parseDouble(tmpArr[1]); // "2" -> 2.0
		
		switch(opr) {
			//CalculatorMain4.java
		}
		
		
		
		//-------------------------------------------------------------------------
		
		/* ★★  ... 가변인수 : 여러 매개값들을 "배열"로 처리 (매개변수=인수=argument)
		 * join( , 가변인수) : 여러 문자열 사이에 "구분자"를 넣어서 하나의 문자열로 결합
		 * 			static 메서드
		 * 
		 */
		String aniJoin = String.join("#", aniSplit); // "dog" "cat" "rabbit"
		System.out.println("연결된 하나의 문자열=" + aniJoin); // "dog#cat#rabbit"
		
		aniJoin = String.join("#", aniSplit).toUpperCase();
		System.out.println("연결된 하나의 문자열=" + aniJoin); // 
		
		/**************** 테스트 문제 [과제 2] (Gender.java 참고)**********************************/ 
		//당신의 생일은 2001년 06월 22일에 태어난 남성입니다. (split 사용해서 출력)
		
		String gender;
		String tmp2;

		String year;
		String month;
		String day;
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("주민등록번호 입력 (ex. 010622-1234567)(중단:stop)>");
			
			//주민등록번호 입력
			tmp = sc.next(); // 000123-1234567
			
			if(tmp.equalsIgnoreCase("stop")) {
				flag = false;
				break;
			}
			
			if(!(tmp.contains("-") && tmp.length()==14)) { // 문자열 안에 속해있는지 확인하는 메서드, boolean 타입
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			tmpArr =  tmp.trim().split("-"); // 0:000123 / 1:1234567
			
			if(tmpArr[0].length() != 6 || tmpArr[1].length() != 6) {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			year = tmpArr[0].substring(0, 1+1); // 00
			month = tmpArr[0].substring(2, 3+1); // 01
			day = tmpArr[0].substring(4, 5+1); //23
			
			// 1,3 남자 / 2,4여자
			tmp2 = tmpArr[1].substring(0, 1);		
			switch(tmp2) {
			case "1": 
				year = "19" + year;
				gender = "남성";
				break;
			case "3":
				year = "20" + year;
				gender = "남성";
				break;
			case "2":
				year = "19" + year;
				gender = "여성";
				break;
			case "4":
				year = "20" + year;
				gender = "여성";
				break;
			default:
				System.out.println("다시 입력해주세요.");
				continue;
			} // switch
		
			
			/* switch문 대신 if문 사용
			 
			 if(tmpArr[1].charAt(0) == '1' || tmpArr[1].charAt(0) == '2') {
			 	gender = "남성";
			 	
			 	if(tmpArr[1].charAt(0) == '1') {
			 		year = "19" + year; 
			 	} else {
			 		year = "20" + year;
			 	}
			 	
			 } else if(tmpArr[1].charAt(0) == '2' || tmpArr[1].charAt(0) == '4') {
				 gender = "여성";
				 
				 if(tmpArr[1].charAt(0) == '2') {
					 	year = "19" + year;
				 	} else {
				 		year = "20" + year;
				 	}
			 }
			 
			 */
			
			System.out.println("당신은 " + year + "년 " + month + "월 " + day + "일에 태어난 " + gender + "입니다.");
			
		} // while문
		System.out.println("종료되었습니다.");

		
		
		
		
		
		
		
		
		
		
	}
}





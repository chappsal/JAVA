import java.lang.*; // 이클립스가 컴파일 전에 자동 삽입해줌
public class UseVariable { //클래스명:대문자로 시작

	public static void main(String[] args) { //소문자로 시작~():메서드-메서드 안에 선언한 변수를 지역변수
		//논리형-참
		System.out.println("--논리형-----------------------------------");
		
		boolean b=true; // 자료형 변수명=리터럴
//		System.out.println(b);
//		if(true) System.out.println("참이면실행");
//		if(false) System.out.println("거짓이면 실행안함");
	
		
		if(b) System.out.println("참이면 실행");
		else System.out.println("거짓이면 실행안함");
		
		if(85>70) System.out.println("예");
		else System.out.println("아니오");

		if(85<70) System.out.println("예");
		else System.out.println("아니오");

		if('a'<70) System.out.println("예"); // 'a' 메모리에 97의 2진수로 들어가 있기 때문에 비교 가능 (97>70)
		else System.out.println("아니오");

		System.out.println("--정수-----------------------------------");
		
		int i; // 변수 선언
		i=7; //변수 초기화
		
		int i2=12; //변수 선언과 동시에 초기화
		
		int i3=15,i4=17; // 같은 타입(정수) 동시에 선언 가능
		
//		short s=10;
//				
//		int s2=10000000000000;
//		
		
	/*
	 * 자료형 변수명=리터럴
	 * 
	 * */
		long s2=10000000000000L;
		System.out.println(s2);
		
		int s3=(int) 100000000000L; //강제형변환
		System.out.println(s3);
		
		long s4=100000000000L;
		System.out.println(s4);
		
		float s5=100000000000L; // 실수형=정수:정수가 실수로 자동형변환되어 저장됨(64p 참조)
		
		System.out.println(s5);
		
		//double s5=100000000000L;
		System.out.println(s5);
		
		//정수연산
		/*
		 * 정수는 cpu의 연산장치 4바이트(int)에 담겨 연산됨, 따라서 연산결과도 4바이트
		 */
		short sh1=12, sh2=7;
		short sh3= (short) (sh1 + sh2); // sh3(2바이트)=12+7(4바이트)
		System.out.println(sh3);

		sh1 += sh2; // [자동형변환 규칙 예외] 복합대입연산자를 사용하면 자동으로 형변환되어 대입함 (int =>short)
		
		short sh4=30000, sh5=30000; 
		int sh6= sh4 + sh5; // 연산결과 int->long 으로 자동형변환되어 저장
		System.out.println(sh6);
		
		
		
		long lo = 123; //8=4 
		System.out.println("--실수---------------------------");
		float f=10.37f; //자료형 변수명=리터럴 4=8 이라서 f붙임

		
		double d=10; // 실수=정수 : 정수는 실수로 자동형변환되어 저장
		System.out.println(d);
		
		//실수연산 연산결과 오차 발생 가능성 있음
		
		double d1=0.0000001;
		System.out.println(d1);
		
		double d2=1.0000001;
		System.out.println(d2);
		
		System.out.println(d1+d2);
		
		System.out.println("------문자:아스키코드(c언어), 유니코드(java) 참조----------");
		
		char c1; //변수 선언 
		c1='a'; //변수 초기화 (97의 2진수)
		
		char c2='b', c3='c' , c4=' ';
		System.out.println(c1+c2+c3); // 메모리 안에는 수로 존재하므로 더한 값이 나옴
		System.out.println(c1+""+c2+""+c3);
		System.out.println(c1+","+c2+","+c3);
		
		System.out.println((int)c1+","+c2+","+c3);
		
		System.out.println(c4);
		System.out.println((int)c4);
		
		System.out.println((int)'가');
		System.out.println((char)44032);
		
		char c5='A'; //65의 2진수
		System.out.println(c5); //A
		System.out.println((int)c5); //65
		System.out.println(c5+1); //66
		
		c5=(char) (c5+1); // B
		System.out.println(c5); 
		
		// 대문자+32 = 소문자
		System.out.println('A'+32); // 97+32= 정수
		System.out.println((char)('A'+32)); //정수-> 문자 'a'
		System.out.println((char)(c5+32)); // b
		
		/*
		 * 정수 0~65535
		 */
		int i5=97; //로컬=지역변수
		System.out.println(i5); //97
		System.out.println((char)i5); //'a'
		
		/* 자바는 유니코드 : 문자 2바이트=16bit(16로 표현가능한 정보의 수:65536
		정수 0~65535
		*/
		i5 = 0xAC00;// 0x16진수(hex=16진수:0~9ABCDEF) 헥사
		System.out.println("16진수"+i5); //44032
		System.out.println("(char)16진수AC00="+(char)i5); //'가'
		
		char ch1='\uAC00'; // '\\u16진수'(\\u=유니코드)
		System.out.println("16진수"+ch1); //44032
		System.out.println("(char)16진수AC00="+(int)ch1); //'가'
		
		int i6=077;// 0 : 8진수(9진수:0~7)
		System.out.println("8진수77+i6"); // 정수출력은 10진수로 출력
		
		i6 = 0B1010; //0B : 2진수(2진수:0,1);
		System.out.println("2진수1010"+i6);
		
		i6 = 0x1010; //0x16진수 (16진수:0~9abcdef)
		System.out.println("16진수1010="+i6);
		
		
		/* printformat() */  //별로 안 중요
		
		i6 = 0xac00; //%d(decimal):10진수, 5%x(hex):16진수, %o(octal:8진수), %b:true(값이 있으면(모든 수,문자,true))/false
		System.out.printf("[정수]10진수=%15d, 16진수=%x, 8진수=%o, [boolean타입]=%b \n",i6, i6, i6, i6,'a', false); // f사용후에 \n으로 줄 바꿈 필수
		System.out.printf("[실수]=%.1f", 12.34); // %f(float)  .1 => 소수 첫째 자리까지 출력
		
		String str = "문자열 출력2";
		System.out.printf("[문자열]=%s, %s \n", "문자열 출력1", str);
		
		
		//교재 55p
		int a = 65; // 65의 2진수
		char ch = 65; // 65의 2진수
		
		System.out.println("a="+a); //65
		System.out.println("ch="+ch); //'A'
		
		a = -65;
		// ch = -65; // 2바이트(=16bit => 정보의 수 2의 16승=65536:0~65535) char는 음수 안 나옴
		System.out.println("a="+a); // -65
		System.out.println((char)a); // 65에 대한 문자 출력하면? 알 수 없는 문자 출력
		
		
		
		//교재68p
		double num1= 1.2;
		float num2 = 0.9f;//실수형 =리터럴
				
		float num3 = (int) (num1 + num2); // 2.1 -> 2 (강제형변환) -> 2.0 (자동형변환)
		System.out.println(num3);
		
		//정수와 실수가 연산을 할 때 같은 타입으로 연산(이 때, 정수->실수로 변환되어 연산됨)
		int i7 =12;
		double d3 = 10.3;
		double i8 = 12 + 10.3;//12.0+10.3=>22.3
		System.out.println(i8);
		
		
		/* 자동 형변환 주의 사항 : 정수가 실수로 자동형변환 시
		교재 57p 참조
		
		실수 = 부호비트+(1)지수부+가수부
		float = 부호비트(1)+지수부(8)+가수부(23)
		double = 부호(1)+지수부(11)+가수부(52)
		
		*/
		
		
		int n1 = 123456780;
		int n2 = 123456780;
		
		float n3 = n2; // 123456780.0 자동형변환되어(소수점) 대입 (오차발생-가수부가 담기에 큰 수이므로)
		n2 = (int)n3; // 정수 =/= 실수  -> 정수 =(정수)실수 , 123456780로 강제형변환하여 대입
		
		System.out.println(n1-n2); // 0이 아니라 -4가 출력
		
		// 아래로 해결 ----------------------------------------

		n1 = 123456780;
		n2 = 123456780;
		
		double n4 = n2; // double 로 변경 (오차발생안함-가수부가 담기에 충분한 크기)
		n2 = (int)n4; // 정수 =/= 실수  -> 정수 =(정수)실수 , 123456780로 강제형변환하여 대입
		
		System.out.println(n1-n2); // 0
		
		
		
	}
}

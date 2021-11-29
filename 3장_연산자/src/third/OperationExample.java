package third;

//이클립스가 컴파일(바이트 코드로 변환)하기 전에 자동으로 삽입
import java.lang.*; // java.lang 패키지 안의 모든 클래스를 import , 시스템에서 알아서 넣어주기 때문에 노란줄 경고 뜸
import java.util.Scanner;


class OperationExample { // public 이 없으면 third 패키지 안에서만 사용 가능
	//생성자
	public static void main(String[] args) {//프로그램의 시작
		
		// 산술 연산자 +-*/
		int iv1=10;
		int iv2=3;
		
		System.out.println(iv1+iv2);  // 대문자로 시작하는 것들은 모두 class
		System.out.println(iv1-iv2);
		System.out.println(iv1*iv2);
		System.out.println(iv1/iv2); // 3
		System.out.println(iv1%iv2); // 1
	
		System.out.println((double)iv1/iv2); // iv1을 강제로 실수로 만듦 10.0 /자동으로 3.0=>3.333
		System.out.println((double)(iv1/iv2)); // 주의: 몫 3->3.0
		
		/* 강제로 형변환하면 데이터 손실 발생 가능성 있음
		=> 데이터 손실이 발생하기 전 점검
		*/
		
		byte b1 = (byte)1234;
		System.out.println(b1);//데이터 손실
		
		
		int i = 300;
		System.out.println("그냥 i="+1);
		
		/*
		 * 비교(=관계)연산자 : 수와 수를 비교 > < >= <= ==(같다) !=(같지않다. 다르다.)
		 *                     65     >      97       -> 결과가 false
		 *               'A'(65의 2진수) > 'a'(97의 2진수) -> 결과가 true
		 *               
		 *
		 * 논리 연산자(우선순위 : NOT > AND > OR) :  
		 *           !(NOT)_단항연산자 : (예) !(65 > 97)   -> !(false) -> true
		 *                               !('A' > 'a') -> !(true) -> false
		 *           &&(AND) : 둘다 참일때만 참이다.
		 *                    (예) (65 > 97) && ('A' > 'a') -> false && true -> false               
		 *           ||(OR) : 둘중 하나만 참이면 참이다.
		 *                    (예) (65 > 97) || ('A' > 'a') -> false || true -> true
		 *                    
		 * 따라서, 비교연산자와 논리연산자는 '결과가 무조건 참 또는 거짓'이므로  "조건문" 에서 많이 활용
		 * 
		 * 조건문은 무조건 결과가 참 또는 거짓이 나와야 함
		 *   if(조건문) {조건이 참이면 실행}
		 *   else {조건이 거짓이면 실행}
		 */
		
		
		
		// 방법-1 : 100<-128(거짓) || 100>127(거짓)
		if(i<Byte.MIN_VALUE || i>Byte.MAX_VALUE) {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요");
		} else System.out.println("byte로 강제형변환된 i="+(byte)i);
		
		
		// 방법-2 : !(300>=-128 참 && 300<=127거짓=>거짓) => 참
		if(!(i>=Byte.MIN_VALUE && i<=Byte.MAX_VALUE)) {
			System.out.println("byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요");
		} else System.out.println("byte로 강제형변환된 i="+(byte)i);
		
		
			
		// 방법-3 : 300>=-128(참) && 300<=127(거짓) => 거짓
		
		if(i>=Byte.MIN_VALUE && i<=Byte.MAX_VALUE) {
			System.out.println("byte로 강제형변환된 i="+(byte)i);
		} else {
			System.out.println("값을 다시 확인해 주세요");
			System.out.println("byte 타입으로 변환할 수 없습니다.");
		}
		
		
		// 방법-4 :!(300 < -128 (거짓) || 300 > 127 (참)) -> !(참) -> 거짓 

		if(!(i<Byte.MIN_VALUE || i>Byte.MAX_VALUE)) {
			System.out.println("byte로 강제형변환된 i="+(byte)i);
		} else {
			System.out.println("값을 다시 확인해 주세요");
			System.out.println("byte 타입으로 변환할 수 없습니다.");
		}
		
		
		
		//-----&& || 에 대한 부작용 발생 가능성과 해결방법------------------------------------------
		
		
		
		
		int i1=10, i2=2;
		// 20<10 거짓 -> && 실행안함 , 무조건 거짓
		boolean value = (i1=i1+10)<10 && (i2=2+i2)<10;		
		System.out.println("value="+value); //false
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 2 (부작용 발생 - && 때문에 뒷부분이 실행 안 됨)
				
		
		System.out.println(); // 구분위한 빈 줄

		
		i1=10; i2=2; // int로 선언할 때는 콤마 가능한데 값만 바꿀때 는 ;로 나눠줘야 함
		// 20>10 참 -> || 실행안함 ,
		value = (i1=i1+10)<10 || (i2=2+i2)<10; 		
		System.out.println("value="+value);  // true
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 2 (부작용 발생)

		
		System.out.println(); // 구분위한 빈 줄
		
		
		i1=10; i2=2; 
		// 20>10 참 -> || 실행함 4<10 참 -> 참
		value = (i1=i1+10)<10 && (i2=2+i2)<10; 		
		System.out.println("value="+value);  // true
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 4

		
		System.out.println(); // 구분위한 빈 줄
		
		
		i1=10; i2=2; 
		// 20>10 참 -> || 실행함 4<10 참 -> 참
		value = (i1=i1+10)<10 || (i2=2+i2)<10; 		
		System.out.println("value="+value);  // true
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 4

		
		System.out.println(); // 구분위한 빈 줄
		
		
		//----부작용 해결방법------------------------------------------------
		
		
		i1 = 10; i2 = 2;
		i2 = i2+2; // 반드시 실행
		// 20<10 거짓 -> && 실행안함 , 무조건 거짓
		value = (i1=i1+10)<10 && i2<10;		
		System.out.println("value="+value); //false
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 4(부작용 사라짐)
				
		
		System.out.println(); // 구분위한 빈 줄

		
		i1=10; i2=2; 
		i2 = i2+2; // 반드시 실행
		// 20>10 참 -> || 실행안함 ,
		value = (i1=i1+10)<10 || i2<10; 		
		System.out.println("value="+value);  // true
		System.out.println("i1="+i1); // 20
		System.out.println("i2="+i2); // 4(부작용 사라짐)
		
		
		System.out.println(); // 구분위한 빈 줄
		
		
		/* 자료형(정수) 값은 사이클을 돈다. 최대값+1 = 최소값 */
		
		byte b = 126;
		System.out.println(b+1); //127
		System.out.println(b); // 126
		
		System.out.println(++b); // 127, b의 값 1증가 후 출력
		System.out.println(b++); // 127, b값 출력 후! 1증가 (최종 b의 값은 -128,최대값이 넘었기 때문에 최소값으로)
		System.out.println(b); // -128
		
		// 단항연산자 ++
		
		/*
		 * 단항연산자   ++b    b = b+1
		 *         b++    b = b+1
		 *  ++이 단독일때는 자신의 값을 1증가
		 *  
		 *  
		 *  단항연산자   --b    b = b-1
		 *          b--    b = b-1
		 *  --이 단독일때는 자신의 값을 1감소       
		 */
		
		int a1=10, a2=20, a3;
		a1++; // a1=a1+1
		++a1; // 
		System.out.println(a1+","+a2); //수+수=더한 결과여서 문자열 , 콤마를 넣어준다 
		System.out.println(a1+", "+(++a2)); // a2=21 -> 출력
		System.out.println(a1+", "+a2++); // 출력 -> a2=22 
		// 단항 연산자에 ()는 가독성을 높일 뿐 우선순위를 바꿀 수 없음.
		
		
		/*
		 * ++이 단독이 아닐 때, ++ 앞에 있으면 가장 먼저 실행
		 *                ++ 뒤에 있으면 가장 마지막에 실행
		 */
		
		
		a1=10; a2=20;
		a3 = ++a1 + a2--;
		//a1=11 -> 11+20=>31를 a3에 대입 -> a2=19
		System.out.println(a1+","+a2+","+a3);
		
		// 부호(+,-)도 연산자이다. -1,+1
		
		int n1=5;
		System.out.println(+n1); //5
		System.out.println(-n1); //-5
		
		short n2=7;
		short n3= (short) +n2; /* short에 대입 안 됨, 연산은 cpu에서만 가능한데 cpu에서는 int형 사용 
		                            -> 강제형변환하여 대입(데이터 손실 발생 가능) */
		int n4= +n2;
		
		
		
		// 복합 대입 연산자 : 교재 80p
		
		i = 1; // 대입연산자
		i++; // i=i+1, i값은 2
		
		i+=1; // i=i+1; 복합대입연산자, i는 3
		i+=3; // i=i+3; i 값은 6
		i-=3; // i=i-3; i 값은 3
		i*=3; // i=i*3; i 값은 9
		i/=2; // i=i/2; i 값은 4
		i%=2; // i=i%2; i 값은 0
		
		System.out.println(i); // 0
		
		
		/*
		 * 단항연산자 : !, ++, --, ~
		 * 
		 * 논리연산자 ! : 참 <-> 거짓
		 *        && : 둘 다 참이면 참
		 *        || : 둘 중 하나만 참이면 참
		 *         
		 *        
		 * 비트연산자 ~ : 이진수 1 <-> 이진수 0 // 자주 사용 x
		 *         & : 둘 다 1이면 1 
		 *         | : 둘 다 하나만 1이면 1
		 *         ^ : 둘 다 다르면 1
		 *         
		 * 
		 * ex) 이진수 ~1010 => 0101  ,  ~1000 => 0111
		 * ex) 1 & 1 => 1
		 * ex) 1 | 0 => 1
		 * ex) 1 ^ 0 => 1,   1 ^ 1 => 0  , 0 ^ 0 => 0
		 * 
		 * 
		 * 비트연산자로 '산술연산'을 할 수 있다
		 * << : 곱하기
		 * >> : 나누기 (몫)
		 * >>> : 잘 사용 x
		 * 
		 * 
		 * */
		
		// bin = 2진수 , toBinaryString 2진수로 된 문자열로 변경
		
		int num1= 5;
		int num2= 3;
		
		
		
		System.out.println(Integer.toBinaryString(num1)); // 5의 "2진수"
		System.out.println(Integer.toBinaryString(num2)); // 3의 "2진수"
		
		System.out.println("5&3="+(num1&num2)); // 1
		System.out.println("5|3="+(num1|num2)); // 7
		System.out.println("5^3="+(num1^num2)); // 6
		
		System.out.println("~5=" + ~num1); // -6
		System.out.println("~5=" + (~num1+1)); // -5
		
		System.out.println(~7+1); //-7출력, 7의 음수값 구하는법 ~붙이고 1을 더하기
		System.out.println(~(-7)+1); //7
		
		
		/* 비트 이동 연산자 
		 * 
		 * << : 곱하기 2
		 * >> : 2로 나눈 몫
		 * 
		 * */
		
		System.out.println(2<<1); // 수 2*2=4
		System.out.println(2<<2); // 수 2*2*2=8
		System.out.println(2<<3); // 수 2*2*2*2=16
		

		System.out.println(3<<1); // 수 3*2=6
		System.out.println(3<<2); // 수 3*2*2=12
		System.out.println(3<<3); // 수 3*2*2*2=24
		
		System.out.println(16>>2); // 16/2/2 로 나눈 몫 = 4
		System.out.println(16>>3); // 16/2/2/2=2
		
		
		// [문제] 음수(0보다 작다)를 양수로 바꾸기
		
		int x = 10, x2;     // 주의 : x2에 대입했을 뿐 x 의 값은 그대로임, 아래 방법이 진짜 변경된 것 (잘못된 방법)
		
		// if문
		
		if(x>=0) {
			x2=x;                                   // 실행 문구가 if, else 한줄씩일땐 중괄호 없어도 됨, 2줄 이상에 사용
			// System.out.println(x+"=>"+x2);
		} else { // x<0
			x2= -x; 
			// System.out.println(x+"=>"+x2);
		}
		System.out.println(x+"=>"+x2); // 참,거짓 둘 다 중복되게 실행되는 문장은 마지막에 실행 시키기
		
		
		
		/*
		 * Scanner 객체 생성하여 키보드로부터 입력받은 값을 x, y, z 에 대입
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		x = sc.nextInt();
		
		// x의 값이 음수이면 양수로 변경됨
		//x = 10;  
		if(x >= 0) x = x;
		else x = -x;
		System.out.println(x); // 참, 거짓에 관계없이 무조건 실행
		
		// y의 값이 음수이면 양수로 변경됨
		//int y = -5;
		System.out.print("정수 입력 : ");
		int y = sc.nextInt();
		if(y >= 0) y = y;
		else y = -y;
		System.out.println(y); // 참, 거짓에 관계없이 무조건 실행
		
		//int z = 0;
		System.out.print("정수 입력 : ");
		int z = sc.nextInt();
		if(z >= 0) z = z; // 0
		else z = -z;
		System.out.println(z);
		
		
		
		/* 조건 연산자 : (조건문)?참:거짓 */
		
		// (1) 
		x=10; y=-5; z=0;  
		
		x=(x>=0)?x:-x;
		System.out.println(x);
		
		// (2)
		y=(y>=0)?y:-y;
		System.out.println(y);
		
		// (3)
		z=(z>=0)?z:-z;
		System.out.println(z);
		
		// System.out.println("x=>"+x+,"y=>"+y+,"z=>"+z);  //-----고치기
		
		System.out.println(Integer.MAX_VALUE);  // int형의 최대값
		int num3 = 1000;
		
		System.out.println(Long.MAX_VALUE);
		
		
	} // 프로그램의 실행 끝

	
	
} // class 끝
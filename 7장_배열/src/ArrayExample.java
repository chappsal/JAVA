import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) {
		/** 배열을 사용하지 않았을 때**/
		System.out.println("/** 배열을 사용하지 않았을 때**/");
		
		int s1 = 83;
		int s2 = 88;
		int s3 = 95;
		int s4 = 87;

		//더한 합=?
		int sum = s1+s2+s3+s4;
		System.out.println("합="+sum);
	
	
		/* 값 사이에 일정한 규칙이 없어서 반복문 사용 불가
		int i;
		for(i=1;i<=4;i++) {
			sum+=si;//오류:변수 이름으로는 x
		}
		*/
		
		
		/** 배열 선언, 생성(heap메모리)과 동시에 값 목록 대입 **/ 
		
		//배열 사용 시 반복문 사용 가능
		
		
		// 1. int 타입 배열 ------------------------------------------------------
		
		
		
		System.out.println("/** 배열을 사용했을 때: 같은 데이터만 저장 가능, 크기 고정  **/");
		
		int[] scores = {83, 88, 95, 87}; // 배열의 길이(읽기전용:변경 불가) length==4 (마지막 index번호 + 1)
				//index 0   1   2   3
	
		scores[0] = 93; // 첫번째 값 변경
		System.out.print(scores[0]+" ");
		System.out.print(scores[1]+" ");
		System.out.print(scores[2]+" ");
		System.out.print(scores[3]+" "); // 규칙성이 있기 때문에 for문 사용 가능
		System.out.println(); // 커서 아래로
		
		
		System.out.println("/** 반복문 사용 **/");
		
		int i;
		for(i=0; i<scores.length; i++) {
			System.out.print(scores[i]+" ");
		}
		System.out.println(); // 커서 아래로
				
		sum=0;
		for(i=0;i<scores.length;i++) {
			sum += scores[i];
		}
		System.out.println("합="+sum);
	

		// 평균
		System.out.println("평균=" + sum/scores.length); // 정수/정수=결과가 정수(몫)

		System.out.println("평균=" + (double)sum/scores.length); // 실수/자동실수=결과가 실수
	
		System.out.println("int 배열="+scores); // int타입 배열객체의 주소  => [I@6276ae34 (배열객체의 주소로 만든 16진수 hashcode) I:integer
		System.out.println("int 배열="+scores.toString()); // 결과로 [I@6276ae34 (Obㅓect 의 toString()메서드 그대로 사용)
		
		System.out.println("int 배열="+Arrays.toString(scores));
		
		
		// 2. char 타입 배열 ------------------------------------------------------------------------
		
		
		char[] ch = {'a', 'b', 'c'};
		
		// 탭 크기만큼 띄워서 옆으로 출력
		for(i=0; i<ch.length; i++) {
			System.out.print(ch[i]+"\t");
		}
		System.out.println(); //커서 아래로
		System.out.println("char 배열="+ch); // char 타입 배열 객체의 주소 => abc
		System.out.println("char 배열="+ch.toString()); // => [C@7946e1f4
		
		
		System.out.println((int)'A'); // 65
		System.out.println((int)'a'); // 65+32=97
		
		//소문자  'a' 'b' 'c' => 대문자 'A' 'B' 'C' 로 변경
		
		for(i=0;i<ch.length;i++) {
			// 방법-1 : 연산한 결과는 수인데 char 타입 배열에 대입하려면 char 타입으로 형 변환
			// ch[i]+=(char)(ch[i]-32); 
 		
			// 방법-2 : 복합대입연산자 사용하면 자동으로 형변환되어 저장됨(편리)
			ch[i]-=32;
		}
		
		for(i=0;i<ch.length;i++) {
			System.out.print(ch[i]+", "); // A, B, C, 마지막 콤마도 출력 됨
		}
		System.out.println();//커서 아래
		
		
		// 12/13 과제 1
		// A,B,C, 에서 마지막 콤마 제외하고 [A, B, C] 출력 : 반복문 for 이용 + 조건연산자(조건문)?참:거짓  또는 다른 방법들 이용
		System.out.println("과제1");
		String temp="";
		
		for(i=0;i<ch.length;i++) {
			if(i==ch.length-1) {
				temp += ch[i];
			}
			else {
			temp += ch[i]+", ";
			}
			
			
		}
		System.out.println("["+temp+"]");
		
		
		
		
		System.out.println("과제1 끝");
		
		/*
		 * java.util.Arrays 클래스 : 배열을 조작하기 위해 만들어진 클래스
		 */
		
		System.out.println(Arrays.toString(ch)); // [A, B, C] 배열 출력 시 사용 (for문보다 간편)
		
		/* 
		 * ArrayIndexOutOfBoundsException 예외발생=예외객체 생성
		 * :예외객체를 처리(try~catch)하지 않고 프로그래머가 알아서 논리적으로 처리함
		 * (잘못된 코드 삭제)
		 * 
		 * try{예외 발생 가능성 있는 부분
		 * } catch (Exception e) { 
		 *   예외처리=예외가 발생했을 때만 실행
		 * }
		 * 코드 블럭설정 > 우클릭 > 둘러싸기 > try~catch 로도 실행 가능
		 * 
		 */

		
		try {
			System.out.println(ch[3]);
		} catch (Exception e) {  //Exception : 모든 예외객체의 부모
			// 예외 발생시 실행 = 예외처리
			//e.printStackTrace();
			System.out.println("해당 배열값은 존재하지 않습니다");
			
		}
		
		
		/*** 배열 선언 후 배열 목록 생성 방법-1 ***/
		
		int[] sco1 = null; //배열 선언 (null:참조하는 배열객체 없음)
		
		/*
		 * 객체는 반드시 기본값이 존재
		 * 
		 * 기본타입: int[0], double(0.0), char('\0') (= null) , boolean(false)
		 * String과 같은 클래스타입: null
		 *  
		 * 
		 */
		
		
		sco1 = new int[3]; // 3의 의미=length int타입 배열객체 [0,0,0] 
		System.out.println(Arrays.toString(sco1));
		
		
		boolean[] scoBoolean = null;
		scoBoolean = new boolean[4];
		System.out.println(Arrays.toString(scoBoolean));
		
		
		// sco1가 참조하는 값들을 10씩 증가한 값으로 변경
		
		
		for(i=0; i<sco1.length; i++) {
			sco1[i]+=10;
			
		} System.out.println(Arrays.toString(sco1));
		
		
		// 12/13 과제 2
		// sco1가 참조하는 값들을 0으로 변경 후 [0, 10, 20]
		System.out.println("과제2");

		int c;
		for(c=0,i=1; i<sco1.length;c++) {
			if(sco1[2]==0) {
			sco1[i]= sco1[i-1]+10;
			i++;
			} else
			sco1[c]-=10;
		} System.out.println(Arrays.toString(sco1));
		
		
		

		// 12/13 과제 3
		/*
		 *  키보드로부터 학생 수를 입력받아 sco2가 참조하는 배열객체 생성 후
		 *  학생들의 점수를 하나씩 입력받아 배열객체에 저장 (반복문 사용)
		 *  합과 평균 구하기
		 *  
		 */
		
		i=0;
		int hap=0;
		
		Scanner sc = new Scanner(System.in);
		
		int[] sco2 = null;
		
		System.out.println("학생 수 입력:");
		i = sc.nextInt();
		sco2 = new int[i];
		
		for(i=0; i<sco2.length; i++) {
			System.out.print((i+1)+"번 점수 입력:");
			sco2[i]= sc.nextInt();
			hap+=sco2[i];
		}
		System.out.println("합="+hap+" 평균="+(double)hap/sco2.length);
		
		
		
		
	
	}//main

}

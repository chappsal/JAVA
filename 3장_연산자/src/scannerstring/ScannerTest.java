package scannerstring;


import java.util.Scanner; // import 해와야 아래에서 객체 생성 가능 , 클래스는 설계도
public class ScannerTest {

	public static void main(String[] args) { // 메서드 안에 선언된 변수 => 지역변수(기본타입:값, 클래스타입:주소)
		// 키보드(System.in)로부터 값을 입력 받기 위해 Scanner 객체 생성
		Scanner sc=new Scanner(System.in);//Scanner 참조변수(주소)=Scanner 객체 생성
	
		
		// int i1=10; // 객체 생성 전
		// System.out.println(i1); // 10 출력
		
		
		// i1=sc.nextInt(); // 키보드로부터 읽어들인 값으로 변경
		// System.out.println(i1); //출력하면 입력할 수 있게 커서 나옴
		//----------------------------------------------------
		
		
		/* nextInt(), nextDouble(), next() : 구분자(엔터,스페이스,탭) 무시
		 * 		
		 */
		
		System.out.println("문장 입력"); // 빈 버퍼
		sc.nextLine(); // 쓸모 없음
		String str = sc.nextLine(); // ★ 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성
		System.out.println("문장 출력:"+str);

		
		
	
		
		System.out.print("두 정수 입력:");  // 콘솔 창에서 입력해도 제일 아래에 커서가 자동으로 위치하는 것은 println 에서 ln 때문
		int i1=sc.nextInt(); // static 없는 메서드
		int i2=sc.nextInt();
		//System.out.println("두 정수의 합="+i1+i2); //"두 정수의 합=" + "10" + "20" 앞의 문자열 때문에 뒤가 문자열이 됨 => 1020 출력 
		System.out.println(i1+"+"+i2+"="+(i1+i2));
		System.out.println(i1+"-"+i2+"="+(i1-i2));
		System.out.println(i1+"*"+i2+"="+(i1*i2));
		System.out.println(i1+"/"+i2+"="+((double)i1/i2)); // 실수 출력
		
		//-------------------------------------
		System.out.println("문장 입력"); // 엔터
		sc.nextLine(); 
		str = sc.nextLine(); // ★ 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성
		System.out.println("문장 출력:"+str);
		
		
		
		
		System.out.print("두 실수 입력:");
		double d1=sc.nextDouble();
		double d2=sc.nextDouble();
		
		
		System.out.println(d1+"+"+d2+"="+(d1+d2));
		System.out.println(d1+"-"+d2+"="+(d1-d2));
		System.out.println(d1+"*"+d2+"="+(d1*d2));
		System.out.println(d1+"/"+d2+"="+((double)d1/d2)); // 실수 출력
		
	
		System.out.println("문장 입력"); // 엔터
		sc.nextLine(); 
		str = sc.nextLine(); // ★ 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성
		System.out.println("문장 출력:"+str);
		
		
		System.out.print("두 단어 입력:"); //엔터행복엔터 => 구분자무시, 행복엔터
		String s1 = sc.next(); // 구분자 전까지 읽어들여 문자열(=String) 객체 생성 "행복" 
		String s2 = sc.next(); // "평화" + 많은 메서드 + 필드(=멤버변수) 가 포함되어 있음
		System.out.println(s1+s2); // 주소가 참조하는 문자열 객체의 값이 출력
		
		
		
		System.out.println("문장 입력"); // 엔터 "" , 값이 없는 문자열 객체가 만들어져버림 => 쓰레기 객체가 계속 쌓이면 다운됨(가비지 컬렉터 GC 가 삭제해줌) 
		                              //        => 엔터를 어떻게 해결할까? => 엔터를 쓰레기 객체로 만들어버리기
		sc.nextLine(); // ""값이 없는 문자열 객체 , 쓰레기 객체로 만들어 버퍼 제일 앞에 남은 엔터 없애버림, 참조하지 않으면 쓰레기 객체
		str = sc.nextLine(); // ★ 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성
		System.out.println("문장 출력:"+str);

		System.out.println("문장 입력"); // 빈 버퍼
		str = sc.nextLine(); // ★ 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성
		System.out.println("문장 출력:"+str);
	
	}

}

import java.util.Scanner;

public class MainStringArray {
	//1. 멤버변수=필드(field) (옵션)
	//int a=1; //명시적인 값
	//String s; //null(기본값)
	
	//기본 생성자 (필수) : 멤버변수에 값을 채워 객체 생성
	
	//2. 메서드 (옵션)
	
	// JVM이 main() 호출할 때 "length가 0 인 String[]배열객체" 생성하여 호출 함
	public static void main(String[] args) {
		
		if(args.length != 4) {
		
			System.out.println("실행할 때 4개의 숫자를 입력하세요.(정수 2개, 실수 2개)");
			return;// 해당 메서드(main()) 종료 => 프로그램 종료
			//System.exit(0); // 프로그램 강제 종료
		}
		
		String s1 = args[0]; // String 객체 "10"을 참조하는 객체의 주소		
		String s2 = args[1]; // String 객체 "20"을 참조하는 객체의 주소
		String s3 = args[2]; // String 객체 "1.23"을 참조하는 객체의 주소
		String s4 = args[3]; // String 객체 "2.5"을 참조하는 객체의 주소
		
		// String 객체 => 정수나 실수 변화
		//int i1 = Integer.parseInt(s1); // "10" -> 10
		int i1 = Integer.parseInt(args[0]); // "10" -> 10
		int i2 = Integer.parseInt(s2); // "20" -> 20
		
		double d1 = Double.parseDouble(s3); // "1.23" -> 1.23
		double d2 = Double.parseDouble(s4); // "2.5" -> 2.5
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 연산자 입력(+-*/) > ");
		String opr = sc.next();
		
		
		MainStringArray msa1 = new MainStringArray(); // 생성자: 멤버변수에 값을 넣어서 객체를 생성  / new+컨트롤스페이스하면 자동으로 뜸
		MainStringArray msa2 = new MainStringArray();
		
		switch(opr) {
		
			case "+" : msa1.add(i1, i2); // 객체 안에 존재
					   break;
			case "-" : msa2.add(i1, i2);
					   break;
			case "*" : MainStringArray.mul(i1, i2); // 클래스명.static메서드();
					   break;
			case "/" : div(i1, i2); // 같은 클래스 안이므로 생략가능
					   break;
			default  : System.out.println("잘못된 연산자입니다.");
		}
		
		//---------------------------------------------------------------------------------------
		
		System.out.print("2. 연산자 입력(+-*/) > ");
		opr = sc.next();
		switch(opr) {
		
		case "+" : System.out.println(d1 + "+" + d2 + "=" + msa1.add(d1, d2));
				   break;
		case "-" : System.out.println(d1 + "-" + d2 + "=" + msa1.sub(d1, d2));
				   break;
		case "*" : System.out.println(d1 + "x" + d2 + "=" + mul(d1, d2));
				   break;
		case "/" : System.out.println(d1 + "/" + d2 + "=" + div(d1, d2));
				   break;
		default  : System.out.println("잘못된 연산자입니다.");
		}
	
		
		
		
		

	


	} // main

	
	/************ 두 정수 연산 **************/
	
	void add(int i1, int i2) {
		System.out.println(i1 + "+" + i2 + "=" + (i1+i2));
	}

	void sub(int i1, int i2) {
		System.out.println(i1 + "-" + i2 + "=" + (i1-i2));
	}
	
	static void mul(int i1, int i2) {
		System.out.println(i1 + "x" + i2 + "=" + (i1*i2));;
	}
 		
	static void div(int i1, int i2) {
		System.out.println(i1 + "x" + i2 + "=" + ((double)(i1*i2)));;
	}
	
	
	
	/************ 두 실수 연산 **************/
	
	double add(double d1, double d2) {
		return d1+d2;
	}
	
	double sub(double d1, double d2) {
		return d1-d2;
	}
	
	static double mul(double d1, double d2) {
		return d1*d2;
	}
	
	static double div(double d1, double d2) {
		return d1/d2;
	}
	
	
	
	
	
	
	
}
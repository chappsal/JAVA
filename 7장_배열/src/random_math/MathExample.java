package random_math;
import java.lang.*;
import java.util.Arrays;
public class MathExample {

	public static void main(String[] args) {
		//절대값 : 음수/양수 -> 무조건 양수
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1="+v1);
		System.out.println("v2="+v2);
		
		//ceil() : 보다 큰 정수를 double형으로 리턴
		System.out.println(Math.ceil(5.3)); // 6.0
		System.out.println(Math.ceil(-5.3)); // -5.0

		//floor() : 보다 작은 정수를 double형으로 리턴
		System.out.println(Math.floor(5.3)); // 5.0
		System.out.println(Math.floor(-5.3)); // -6.0

		//rint() : 가까운 정수의 실수 값을 리턴
		System.out.println(Math.rint(5.3)); // 5.0
		System.out.println(Math.rint(5.7)); // 6.0
		
		//round() : 반올림하여 long형으로 리턴
		System.out.println(Math.round(5.3)); // 5
		System.out.println(Math.round(-5.3)); // -5
		
		//max() : 두 수 중 큰 값을 반환
		System.out.println(Math.max(5, 9)); // 9
		System.out.println(Math.max(5.3, 6.4)); // 6.4
		
		//min() : 두 수 중 작은 값을 반환
		System.out.println(Math.min(5, 9)); // 5
		System.out.println(Math.min(5.3, 6.4)); // 5.3
		
		//pow(a, b) : a의 b승
		System.out.println(Math.pow(5, 2)); //25.0
		
		//sqrt() : 루트
		System.out.println(Math.sqrt(25)); // 5.0
		
		//random() : 난수 생성 
		//0.0 <= Math.random() < 1.0 : 범위의 실수 값  (ex. 0.000123 , 0.1등)
		System.out.println(Math.random());
		
		//88~110난수 생성 (int)(Math.random()*(끝정수-시작정수+1)+시작정수)
		System.out.println( (int)(Math.random()*(110-88+1))+88 );
		
		//알파벳을 랜덤하게 발생 (대문자 A(65)~Z까지 26개, 소문자 a(97)~z까지 26개)
		int i;
		char[] arr1 = new char[10];
		char[] arr2 = new char[10];
		
		for(i=0; i<arr1.length; i++) {
			double dvalue = Math.random();
			char cvalue1 = (char)((dvalue*26)+65); //대문자
			arr1[i] = cvalue1;
			char cvalue2 = (char)((dvalue*26)+97); //소문자
			arr2[i] = cvalue2;
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
		
		
		
		
	}//main

}

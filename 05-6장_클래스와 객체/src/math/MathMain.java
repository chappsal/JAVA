//실행용 : main() 있는 class

package math;

import java.util.Scanner;

//같은 패키지 안에 있는 클래스는 자동 import됨
//import java.lang.*; 도 자동 import됨
import static java.lang.Math.*;

public class MathMain {

	//기본생성자 public MathMain(){super();}
	
	public static void main(String[] args) {
		//Math m = new Math(); 오류: private 생성 => 다른 클래스에서 접근불가
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("[원의 넓이] 반지름 입력:");
		double r = sc.nextDouble();
		System.out.println("반지름 "+r+"인 원 넓이="+Math.circleArea(r));
	
		
		System.out.println("[원의 둘레] 반지름 입력:");
		double r2 = sc.nextDouble();
		System.out.println("반지름 "+r2+"인 원 둘레="+Math.circleLength(r2));
		
		System.out.println("********** 가변인수 이용하지 않음 **********");
		System.out.print("더할 첫번째 정수 입력>");
		int num1 = sc.nextInt();
		System.out.print("더할 두번째 정수 입력>");
		int num2 = sc.nextInt();
		
		
		//입력받은 매개값을 가지고 add() 호출
		int result = Math.add(num1, num2); // (괄호 속=매개값)을 가지고 add()호출 => 결과를 담을 곳이 필요하기 때문에 변수 필요
		System.out.println(num1+"+"+num2+"="+result);
	
		
		
		System.out.println("********** 가변인수 이용한 더하기 메서드 **********");
		System.out.println("10="+Math.add(10));
		System.out.println("10+20="+Math.add(10, 20));
		System.out.println("10+20+30="+Math.add(10, 20, 30));
		System.out.println("10+20+30+40="+Math.add(10, 20, 30, 40));
		System.out.println("10+20+30+40+50="+Math.add(10, 20, 30, 40, 50));
		
		
		// 12.10[과제] 가변인수 이용한 곱하기 메서드 작성
		System.out.println("********** 가변인수 이용한 곱하기 메서드 **********");
		System.out.println("10="+Math.mul(10));
		System.out.println("10x20="+Math.mul(10, 20));
		System.out.println("10x20x30="+Math.mul(10, 20, 30));
		System.out.println("10x20x30x40="+Math.mul(10, 20, 30, 40));
		System.out.println("10x20x30x40x50="+Math.mul(10, 20, 30, 40, 50));
		
		
		System.out.println("** java.lang.Math의 메서드 호출 **");
		System.out.println(" |-3|= " + abs(-3)); // 위에서 import해오면 java.lang.Math. 생략가능
		//java.lang.Math안의 모든 필드와 메서드는 static이다(단, 생성자 제외: private)
		
		
		System.out.println("2와 8중 큰 수="+java.lang.Math.max(2, 8));
		
		
		
		
		
		
		
	
	}


}

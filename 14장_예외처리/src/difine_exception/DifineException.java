package difine_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//사용자정의 예외클래스
class AgeInputException extends Exception{
	AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}


public class DifineException {

	public static void main(String[] args) {
		System.out.println("나이를 입력하세요 > ");
		int age;
		try {
			age = readAge();
			System.out.println("당신은 " + age + "세입니다.");
		} catch (AgeInputException | InputMismatchException e) {
			if(e instanceof AgeInputException) System.out.println(e);
			else if(e instanceof InputMismatchException) System.out.println("실수는 나이로 적합하지 않습니다");
		}
		
		System.out.println("** 프로그램 종료 **");
		
	}
	
	//사용자가 입력한 나이를 리턴
	static int readAge() throws AgeInputException {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		if(age < 0) throw new AgeInputException(); //수동으로 예약객체 생성
		
		return age;
	}

}
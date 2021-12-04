package mathtest;

import java.util.Scanner;

public class MathTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		mathTestEnd: while (true) {
			System.out.println("(1) 제곱");
			System.out.println("(2) 루트"); // 음수 입력 시 NaN 결과(not a number) 루트 안에는 음수 못 들어감
			System.out.println("(3) 로그");

			System.out.print("원하는 메뉴(1~3)를 선택하세요.(전체종료:stop)>");
			// int menu = sc.nextInt(); // nextInt는 정수만 가능한데 전체종료는 문자열이기 때문에 읽어들이지 못 함
			// (1) 1->"1" 2->"2" 3->"3" /(2) 4->"4" a->"a" ab->"ab" 가나->"가나" /(3) "stop"
			// "Stop" // 입력되는 모든 경우의 수를 따져서 처리할 방법 만들어야 함
			// 처리순위 3 =>

			String tmp = sc.next(); // tmp:임시변수

			// 1. stop 처리
			if (tmp.equalsIgnoreCase("stop"))
				// System.out.println("-- 프로그램을 종료합니다. --"); // 마지막에 종료해도 되고 여기서 종료해도 됨
				break mathTestEnd; // stop처리 완료 // =바깥 while문 나감
	
			
			// 2.(2) 4->"4" a->"a" ab->"ab" 가나->"가나" 처리

			if (!(tmp.equals("1") || tmp.equals("2") || tmp.equals("3"))) {
				System.out.println("다시 입력하세요.");
				continue; // 아래 내용을 실행하지 않고 위로 올라감
			}

			
			// 3. String -> 정수 변환 ("1" "2" "3"만 여기까지 옴)

			int menu = Integer.parseInt(tmp); // 주의 : "10진수로 된 문자열" -> int로 변환 가능

			while (true) { // true는 무한루프
				System.out.println("계산할 값을 입력하세요.(계산종료:0,전체종료:stop)");
				tmp = sc.next();

				// 1. stop 처리
				if (tmp.equalsIgnoreCase("stop"))
					// System.out.println("-- 프로그램을 종료합니다. --"); // 마지막에 종료해도 되고 여기서 종료해도 됨
					break mathTestEnd; // stop처리 완료 // =바깥 while문 나감

				// 3. String -> 정수 변환
				int num = Integer.parseInt(tmp);

				if (num == 0) {
					System.out.println("--------계산종료--------");
					break; // 안쪽 while문 빠져나감
				}

				switch (menu) {
				case 1:
					System.out.println(num + "의 제곱 결과=" + num * num);
					break;
				case 2:
					System.out.println(num + "의 루트 결과=" + Math.sqrt(num));
					break;
				case 3:
					System.out.println(num + "의 로그 결과=" + Math.log(num));
					break;
				default:
					System.out.println("메뉴에 없습니다.");
				}

			} // 안 while
		} // 밖 while

		System.out.println("------ 프로그램을 종료합니다. ------");

	}// main

}
package a_project_interface3_delete2;

import java.util.Scanner;

public class MenuViewer {
	//멤버변수
	public static Scanner sc = new Scanner(System.in);
	
	//메서드
	public static void showMenu(){
		System.out.println("선택하세요...");
		System.out.println("1. 고객 데이터 [입력]");
		System.out.println("2. 주민번호로 이름과 전화번호 또는 주소 [검색]");
		System.out.println("3. 주민번호로 고객 데이터 [삭제]");
		System.out.println("4. 프로그램 [종료]");
		System.out.println("선택 > ");
	}
}

package a_project_interface;

import java.util.Scanner;

/*
 * 홍대표는 기다리지 않고 프로젝트를 수행해나간다.
 */
public class PersonMain {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		
		System.out.println("저장할 고객 수 >");
		//int personNum = sc.nextInt();
		int personNum = MenuViewer.sc.nextInt();
		
		/*
		 * 홍대표는 a회사에서 알려준 '매니저 클래스'만 알면 된다
		 * 
		 * 부모 인터페이스 = 구현한 자식 클래스 객체
		 * 매니저 클래스로 객체 생성 -> 인터페이스 P로 대입
		 * (PI객체 -> P타입으로 자동형변환)
		 */
		
		P p = new PI(personNum); 
		
		boolean flag = true;
		while(flag) {
			MenuViewer.showMenu();
			
			//정상값 1 2 3 /비정상값  4 -1 /  1.23 ㅁ
			String temp = MenuViewer.sc.next();
			Integer.parseInt(temp);
			int choice = Integer.parseInt(temp);
			
			switch(choice) {
			case P.INPUT : p.input(); break;
			case P.SEARCH : p.search(); break;
			case P.EXIT : System.out.println("프로그램을 종료합니다.");
							return; //방법 1 : 해당(main) 메서드 종료 -> 프로그램이 종료
							//System.exit(0); //방법 2 : 시스템 종료
			
			default : System.out.println("1~3 사이의 정수를 입력해주세요.");//1 2 3 이외의 정수수수 
					//break;
			}
	
		
		} //while
		
		
	} //main

}
package a_project_interface_test;

import java.util.Scanner;

/*
 * 홍대표는 기다리지 않고 프로젝트를 수행해나간다.
 */
public class PersonMain {
	
	public static void main(String[] args) {		
		
		System.out.print("저장할 고객 수 > ");
		
		int personNum = MenuViewer.sc.nextInt();
		
		/*
		 * 홍대표는 a회사에서 알려준 '매너저 클래스'만 알면 된다.
		 * 
		 * 부모 인터페이스 = 구현한 자식클래스객체
		 * '매너저 클래스'로 객체 생성하고 인터페이스 P로 대입받음
		 * (PI객체가 자동으로 P타입으로 형변환되어 받아들임)
		 */
		 P p = new PI(personNum);
		 
		 boolean flag = true;
		 while(flag) {
			 /*
			 System.out.println("선택하세요...");
			 System.out.println("1. 고객 데이터 [입력]");
			 System.out.println("2. 주민번호로 이름과 전화번호 또는 주소 [검색]");
			 System.out.println("3. 프로그램 [종료]");
			 System.out.print("선택 > ");
			 */
			 MenuViewer.showMenu();
			 
			 
			
			try {
					//정상값 1 2 3 /비정상값 4 -1,    1.23 ㅁ(NumberFormatException)
					 String temp = MenuViewer.sc.next();
					 int choice = Integer.parseInt(temp);
					 
					 switch(choice) {
					 case P.INPUT  :p.input();	break;
					 case P.SEARCH :p.search(); break;
					 case P.EXIT   :System.out.println("프로그램을 종료합니다."); return;
										            
					 default       :System.out.println("1~3 사이의 정수를 입력해주세요.");// 1 2 3이외 정수
										            //break;
					 }
				} catch (NumberFormatException | PersonSizeException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
			
		 }//while문끝
		 
		 
	}//main()끝

}

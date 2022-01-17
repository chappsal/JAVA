package a_project_interface3_delete2;

import java.util.Scanner;

/*
 * 홍대표는 기다리지 않고 프로젝트를 수행해나간다.
 */
public class PersonMain {

	//JVM이 처리하도록 던지면 e.printStackTrace(); 호출한 결과로 처리 후 프로그램 종료
	//public static void main(String[] args) throws PersonSizeException { 
	
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
			MenuViewer.showMenu(); //class로 접근 : static메서드
			
			try {
				//정상값 1 2 3 /비정상값  4 -1 /  1.23 ㅁ (NumberFormatException)
				String temp = MenuViewer.sc.next();
				Integer.parseInt(temp);
				int choice = Integer.parseInt(temp); //parseInt에서 F2누르면 NumberFormatException예외발생할수 있다고 나옴. throws: 호출한 곳에서 오류 처리하라
				
				switch(choice) {
				case P.INPUT : p.input(); break;
				case P.SEARCH : p.search(); break;
				case P.DELETE : p.delete(); break;
				case P.EXIT : System.out.println("프로그램을 종료합니다.");
								return; //방법 1 : 해당(main) 메서드 종료 -> 프로그램이 종료
								//System.exit(0); //방법 2 : 시스템 종료
				
				default : System.out.println("1~3 사이의 정수를 입력해주세요.");//1 2 3 이외의 정수
						//break;
				}
			} catch (NumberFormatException | PersonSizeException e) { 
				//e.printStackTrace(); 
				if(e instanceof NumberFormatException)
					System.out.println("잘못된 값 입니다. 1~3 사이의 정수를 입력하세요");
				else if (e instanceof PersonSizeException)
					System.out.println(e.getMessage());
			} catch (Exception e) { //NumberFormatException, PersonSizeException 이외의 예외 잡음 // 순서주의, 위에 자식이 먼저 catch하고 부모가 해야 함. 부모가 먼저하면 내려오는 게 없음
				//e.printStackTrace();
				System.out.println(e); //예외 클래스 종류 + 예외 메세지 출력
			} finally {
				System.out.println("고객님~ 복 많이 받으세요~~ \n");
			}
	
		
		} //while
		
		
	} //main

}

/*
 * 주민등록번호를 입력받아 아래 4가지 중 하나를 콘솔에 출력
 * "2000년 이전에 출생한 남성입니다."
 * "2000년 이후에 출생한 남성입니다."
 * 
 * "2000년 이전에 출생한 여성입니다."
 * "2000년 이후에 출생한 여성입니다."
 * 
 * switch() 사용
 */

package ifswitch;

import java.util.Scanner;

public class Gender {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
			System.out.print("주민등록번호 입력(예:123456-3******)(단,stop 입력 시 멈춤)>");
			/* '1' '2' '3'..'-''3'... 하나하나가 다 문자
			 *  0   1   2 .. 6  7 ... index 번호  
			 * 
			 * */
			String str = sc.nextLine(); //엔터까지 읽은 후 엔터 버리고 나머지 문자들로 문자열 객체 생성
			//String str = sc.next(); 둘다 사용 가능
			if(str.equalsIgnoreCase("stop")) break;
			//입력받은 주민등록번호 중 index 7에 해당하는 문자 1개 추출
			char gender = str.charAt(7); // '1' '3'
			
			
			
			switch(gender) {
			case '1': 
			case '3': switch(gender) {
						case 1: System.out.print("2000년 이전에 출생한 "); break;
						case 3: System.out.print("2000년 이전에 출생한 "); 
					} 
					System.out.println("남성입니다."); break;
			
			
			case '2':
			case '4': switch(gender) {
						case 2: System.out.print("2000년 이전에 출생한 "); break;
						case 4: System.out.print("2000년 이전에 출생한 "); 
					} 
					System.out.println("여성입니다."); break;
			default : System.out.println("잘못된 주민등록번호입니다");		
			
			}//switch문 끝
		}//while문 끝
		
		System.out.println("------------주민등록번호 판별 끝------------");
		
		
		
		
		
	}//main끝

}

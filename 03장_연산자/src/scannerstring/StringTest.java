package scannerstring;

public class StringTest {
	

	public static void main(String[] args) {
		/*
		 * 객체 생성하는 방법
		 * new 생성자();
		 * 
		 * 단, String만 객체 생성하는 방법 1가지 더 있음 = "문자열 상수"로 객체 생성 됨
		 * */
		
		String s1= "문자열 상수"; // "문자열상수"로 객체 생성하면 '공유 상수 풀'에 등록
		String s2= "문자열 상수"; // '공유 상수 풀'에 등록된 객체를 참조
		String s3= new String("문자열 상수");
		
		//s1주소 == s2 주소
		if(s1 == s2) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
		
		if(s1 == s3) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
		
		
		/*
		 * 주소를 비교하는 것은 중요하지 않다.
		 * 주소가 참조하는 객체의 값을 비교하는 것이 중요.
		 * equals(Object타입 변수)
		 * Object 타입 변수: 모든 클래스 타입 변수 다 가능
		 * 
		 */
		
		if(s1.equals(s2)) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다.");
		

		if(s1.equals(s3)) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다.");
		
		
	}

}
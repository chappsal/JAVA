package difine_exception;

/* [사용자 정의 '예외 클래스']
 * '예외 클래스' 만드는 방법
 */


// 1. 반드시 Exception을 부모로 상속받는다.
class IDFormatException extends Exception{
	//멤버변수
	
	//생성자
	IDFormatException(String message) {
		super(message);
	}
	
	
	//메서드
}


//라이브러리용 + 실행용 
public class IDFormatTest {
	private String userID; //사용자 아이디 : 8자 이상~20자 이하
	
	//기본생성자
	
	//메서드
	public String getUserID() {
		return userID;
	}

	
	/*
	 * ★ 예외 처리 방법 2 : 호출한 메서드에서 처리하도록 던져서 처리 
	 * throws 예외 클래스명
	 * 
	 * 아래에서 호출한 곳 : main
	 * 
	 */
	
	
	public void setUserID(String userID) throws IDFormatException {
		if(userID == null) {
			//System.out.println("아이디는 null일 수 없습니다.");
			//사용자 정의 예외 객체(수동 생성)
			throw new IDFormatException("아이디는 null일 수 없습니다.");
		} else if(!(8 <= userID.length() && userID.length() <= 20)) {
			//System.out.println("아이디는 8자 이상 20자 이하로 쓰세요.");
			throw new IDFormatException("아이디는 8자 이상 20자 이하로 쓰세요.");
		}
		
		this.userID = userID;
	}
	
	
	//main호출한 JVM이 처리하도록 던짐 => 프로그램 종료
	public static void main(String[] args) {
		IDFormatTest test = new IDFormatTest(); //기본생성자
		
		String userID;
		try {
			userID = null;
			test.setUserID(userID);
		} catch (IDFormatException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		userID = "1234567";
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		//방법 1. try~catch로 묶거나
		//   2. 묶지않고 예외 선언하기 (클래스명 옆에 throws~)
	}



}

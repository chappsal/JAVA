package a_project_interface_test;
/*
 * '예외 클래스' 만드는 방법
 */
public class PersonSizeException extends Exception{
	//1. 반드시 Exception을 부모로 상속받는다.
	
	//멤버변수 추가
	
	//2. 생성자
	public PersonSizeException(){
		super("더 이상 고객 정보를 저장할 공간이 없습니다.~");//예외발생시 출력하고 싶은 예외메서지
		//Exception()생성자한테 전달되어 e.getMseeage()메서드 호출하면 리턴되는 문자열
	}
	
	//메서드 추가

}

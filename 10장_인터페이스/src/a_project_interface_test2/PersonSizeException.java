package a_project_interface_test2;
/*
 * '예외 클래스' 만드는 방법
 */
public class PersonSizeException extends Exception{
	//1. 반드시 Exception을 부모로 상속받는다.
	
	//멤버변수 추가
	
	//2. 생성자
	public PersonSizeException() {
		super("더 이상 저장할 공간이 없습니다.");
	}
	
	//메서드 추가

}

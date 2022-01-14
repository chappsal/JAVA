package a_project_interface_test;

/*
 * 홍 대표가
 * a회사에 2개의 메서드를 완성해달라고 의뢰
 * '인터페이스'에 담아서 의뢰
 */
public interface P {
	int INPUT = 1, SEARCH = 2, EXIT = 3;//public static final 생략 가능
	
	//1. 이름, 주민등록번호, 전화번호, 주소를 입력
	void input() throws PersonSizeException;
	
	//2. 주민등록번호를 기반으로 고객의 이름이나 정보를 검색
	void search();
	
	/*****************************************************/
	//예외-1 : 인터페이스를 구현한 모든 클래스에서 "클래스 생성과 무관하게 사용가능"
	public static int add(int...arr) {//P.add(10,20,30);호출하면 arr->[10,20,30](length가 3인 배열객체)
		
		int hap=0;
		for(int item:arr) {
			hap += item;
		}
		//p2();
		return hap;
	}
	
	//예외-2 : 그대로 사용하기 싫은 자식클래스만 재정의하면 됨
	public default void show() {
		System.out.println("정보 출력");
		//p1();
	}
	
	//예외-3 : 자바9부터 사용하므로 오류
	/*
	private void p1() {
		System.out.println("~~~~~~~^^~~~~~~~~~");
	}
	
	private void p2() {
		System.out.println("합을 구합니다.");
	}
	*/
	
}









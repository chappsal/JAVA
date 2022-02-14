package inheritance;

public class GoldCustomer extends Customer{
	/* 
	 * 부모의 멤버(멤버변수, 메서드) 상속. 단, 생성자, private, 초기화 블럭 상속 불가
	 * + 자식만의 속성이나 기능 추가
	 */
	
	//1. 멤버변수 = 부모(5개) + 자식 추가 (1개)
	public double saleRatio; //세일 비율 : gold부터 물건 구매시 할인

	
	//2. 생성자 - 매개변수가 있는 부모 생성자 호출
	//소스-수퍼클래스로부터~
	public GoldCustomer(int customerID, String customerName) {
		//1.매개값을 가지고 부모생성자를 호출 -> 부모객체 생성 
		super(customerID, customerName); //값을 부모에게 전달 -> 생성되는 값 그대로 받음 , 그 후 아래에서 값 바꿈
		//2.상속받아 자식에서 값 변경
		customerGrade = "GOLD"; //silver -> gold
		bonusRatio = 0.02; // 0.01 -> 0.02
		
		saleRatio = 0.05; // 5% 할인
	}

	//재정의 : 소스-메소드 대체/구현 (super. 은 주소를 참조)
	@Override
	public int calPrice(int productPrice) {
		bonusPoint += productPrice*bonusRatio; //100*0.02=2
		return productPrice - (int)(productPrice*saleRatio); //100-(100*0.05)=95 / saleRatio가 실수이기 때문에 결과가 실수가 되지 않게 정수로 바꿔줌 (int)

		
	}
	
	//showCustomerInfo()는 그대로 상속
	/*
	public String showCustomerInfo(){ //고객 기본 정보
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}
	*/
	
	
	//자식에만 추가한 메서드
	void showSaleRatio(){
		System.out.println(customerName + "님의 세일 비율은 " + saleRatio + "입니다." );
	}
	
	
	
	
	
	
	
	
	
	
	
}
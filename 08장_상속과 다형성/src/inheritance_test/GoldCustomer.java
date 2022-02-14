	/* 
	 * 부모의 멤버(멤버변수, 메서드) 상속. 단, 생성자, private, 초기화 블럭 상속 불가
	 * + 자식만의 속성이나 기능 추가
	 */

package inheritance_test;

public class GoldCustomer extends Customer{
	//멤버변수
	/*
	public int customerID; //고객 아이디
	public String customerName; //고객 이름
	
	String customerGrade; //고객 등급
	 
	int bonusPoint=0; //보너스 포인트
	double bonusRatio; //포인트 적립 비율
	 */
	double saleRatio; //할인 비율
	
	
	//생성자
	



	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "gold";
		bonusRatio = 0.02;
		saleRatio = 0.01;
	}

	
	//메서드
	
	
	@Override
	public String showCustomerInfo() {
		return customerGrade + "등급의 적립 비율은" + bonusRatio + "입니다.";
	}

	@Override
	public int calPrice(int productPrice) {
		bonusPoint += (productPrice*bonusRatio);
		return productPrice-(int)(productPrice*saleRatio);
		
	}
	
	

	
	
	
	
	
	
}
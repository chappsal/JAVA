/*
 *  [접근제한자] 범위) public > protected > default > private
 * 1. public : 어디서든지(패키지) 접근 가능
 * 2. protected : 같은 패키지는 접근 가능(단, 자식은 어디서든지 접근 가능(=다른 패키지의 자식이라도 접근 가능))
 * 3. 아무것도 없는 것(=default) :같은 패키지에서만 접근 가능
 * 4. private : 같은 클래스에서만 접근 가능(=다른 클래스에서 접근 불가)
 * 
 * - private 멤버 변수는 접근 가능한 메서드를 통해 간접 접근할 수 있음.
 * - private 멤버는 상속 불가
 * 
 * - class 앞에 public 있으면 어디서든지 import 가능
 * 					  없으면 같은 패키지에서만 import 가능
 */


package inheritance_test;


public class Customer { 
	//멤버변수
	public int customerID; //고객 아이디
	public String customerName; //고객 이름
	
	String customerGrade; //고객 등급
	 
	int bonusPoint=0; //보너스 포인트
	double bonusRatio; //포인트 적립 퍼센트
	
	
	
	//생성자
	public Customer() {
		super();
		
		customerGrade = "silver";
		bonusRatio = 0.01;
	}
	
	
	
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		
		customerGrade = "silver";
		bonusRatio = 0.01;
		
	}


	
	
	//메서드	
	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerGrade() {
		return customerGrade;
	}



	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}



	public int getBonusPoint() {
		return bonusPoint;
	}



	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}



	public double getBonusRatio() {
		return bonusRatio;
	}



	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}


	public String showCustomerInfo() {
		return customerName +"님의 등급은 "+ customerGrade + ", 현재 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	public int calPrice(int productPrice) {
		bonusPoint += (productPrice*bonusRatio);
		return productPrice;
	}



	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	
}
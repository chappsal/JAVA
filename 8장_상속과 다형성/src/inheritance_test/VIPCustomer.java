package inheritance_test;

public class VIPCustomer extends Customer{
	//멤버변수
	/*
	public int customerID; //고객 아이디
	public String customerName; //고객 이름
	
	String customerGrade; //고객 등급
	 
	int bonusPoint=0; //보너스 포인트
	double bonusRatio; //포인트 적립 비율
	 */
	double saleRatio; //할인 비율
	int agentID; //상담원 아이디
	
	
	
	//생성자
	
	public VIPCustomer() {
		super();
		
		customerGrade = "vip";
		bonusRatio = 0.05;
		saleRatio = 0.02;
		
	}
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		
		this.agentID = agentID;
		
		customerGrade = "vip";
		bonusRatio = 0.05;
		saleRatio = 0.02;
	}
	
	
	
	//메서드
	
	
	
	
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	
	
	@Override
	public int calPrice(int productPrice) {
		bonusPoint += (productPrice*bonusRatio);
		return productPrice-(int)(productPrice*saleRatio);
	}

	
	@Override
	public String showCustomerInfo() {
		return customerGrade + "등급의 적립 비율은" + bonusRatio + "입니다.";
	}
	@Override
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", agentID=" + agentID + ", customerID=" + customerID
				+ ", customerName=" + customerName + ", customerGrade=" + customerGrade + ", bonusPoint=" + bonusPoint
				+ ", bonusRatio=" + bonusRatio + "]";
	}
	
	
}
package inheritance2;

public class VIPCustomer extends Customer{
	/* 
	 * 부모의 멤버(멤버변수, 메서드) 상속. 단, 생성자, private, 초기화 블럭 상속 불가
	 * + 자식만의 속성이나 기능 추가
	 */
	

	//1. 멤버변수 = 부모(5개) + 자식 추가 (2개)
	public double saleRatio;//세일 비율
	private int agentID;//VIP 고객 상담원 id 추가
	
	
	//2. 생성자
	public VIPCustomer() {
		super(); //부모의 매개변수가 없는 생성자 호출 - Customer()
		customerGrade = "VIP";
		bonusRatio = 0.05; //5% 적립
		saleRatio = 0.1; //10% 세일
		//agentID는 기본값으로 0; => 향후 set~(agentID)로 값 변경해야함
	}


	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05; //5% 적립
		saleRatio = 0.1; //10% 세일
		
		this.agentID = agentID;
	}


	
	@Override
	public int calPrice(int productPrice) {
		bonusPoint += productPrice*bonusRatio; //100*0.05=5
		return productPrice - (int)(productPrice*saleRatio); //100-(100*0.1)=90
	}
	
	
	
	@Override
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", agentID=" + agentID + ", customerID=" + customerID
				+ ", customerName=" + customerName + ", customerGrade=" + customerGrade + ", bonusPoint=" + bonusPoint
				+ ", bonusRatio=" + bonusRatio + "]";
	}


	
	
	@Override
	void showSaleRatio(){
		System.out.println(customerName + "님의 세일 비율은 " + saleRatio + "입니다." );
	}


	
	/*** get~(), set~() ***/
	public final int getAgentID() {
		return agentID;
	}


	public final void setAgentID(int agentID) {
		this.agentID = agentID;
	}


	public final double getSaleRatio() {
		return saleRatio;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
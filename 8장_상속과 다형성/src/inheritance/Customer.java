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


package inheritance;
/*
 * 부모 : 자식의 공통된 특징 (속성, 기능)
 */

public class Customer { //고객  : 부모
	// 1. 멤버변수(속성) : 자식들의 공통된 속성
	protected int customerID;// 고객 아이디
	protected String customerName;// 고객 이름
	protected String customerGrade;// 고객 등급
	
	public int bonusPoint=0;// 보너스 포인트
	public double bonusRatio;// 적립 비율
	
	
	// 2. 생성자 (소스-필드를 사용하여 생성자 생성 
	// 매개변수가 적은 것을 위로
	public Customer() {
		super();
		//나머지는(정의하지 않은 것들) 기본 값으로 채워짐
		
		initCustomer(); //아래 기능을 메서드로 만들어 호출
		/*
		customerGrade = "SILVER"; // 처음 고객 등록시 기본 등급
		bonusRatio = 0.01; // 처음 고객 등록시 기본 적리 비율 1%
		 */
	}
	
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		
		
		initCustomer(); //아래 기능을 메서드로 만들어 호출
		/*
		customerGrade = "SILVER"; // 처음 고객 등록시 기본 등급
		bonusRatio = 0.01; // 처음 고객 등록시 기본 적리 비율 1%
		*/
	}
	
	
	// 3. 메서드 : 자식의 공통된 기능만 가짐 -> 자식이 재정의해서 사용 가능
	
	//private 메서드는 상속 불가. 외부 클래스에서 접근 불가
	private void initCustomer() {  
		customerGrade = "SILVER"; // 처음 고객 등록시 기본 등급
		bonusRatio = 0.01; // 처음 고객 등록시 기본 적리 비율 1%		
	}
	
	/* ※ 부모의 메서드를 상속받아 자식이 재정의해서 사용 가능
	 * 
	 * 제품에 대해 지불해야 하는 금액을 계산하여 반환
	 * (반환 전, 보너스 포인트 계산하여 누적)
	 */
	public int calPrice(int productPrice){ //제품 가격 100
		bonusPoint += productPrice*bonusRatio; //100*0.01=1
		return productPrice;
	}
	
	//메서드 작성시 리턴타입으로 작성할지 여부 고민
	//void -> sysout OR string -> return ""
	public String showCustomerInfo(){
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}


	//호출하는 측에서 '주소'만으로 '고객 정보'를 리턴 받아 출력하고 싶다면?
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}

	
	
	
	/*** get~():값을 얻을 때, set~(매개변수):값을 변경할 때 ***/
	//final 붙이면 재정의 불가
	
	public final int getCustomerID() {
		return customerID;
	}

	public final void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public final String getCustomerGrade() {
		return customerGrade;
	}

	//주석처리는 개발자의 설계에 따라 달라짐
	public final void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	

	public final int getBonusPoint() {
		return bonusPoint;
	}

	/*
	public final void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	*/

	public final double getBonusRatio() {
		return bonusRatio;
	}

	/*
	public final void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	*/

	
	void showNOSaleRatio(){
		System.out.println(customerGrade + "등급의 세일 비율은 0% 입니다." );
	}	
	
	
	
	
	
	
	
	
	
	
}
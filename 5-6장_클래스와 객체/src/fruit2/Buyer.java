package fruit2;
//구매자
public class Buyer {
	//1.속성 : 멤버변수 = 필드 (field) (기본값->명시적값->생성자)
	private int firstMoney; //원금 
	private int money;   //현재잔액 
	//final int money;   // final은 기본값이 없음
	int numOfApple; 	 // 현재 사과수 
	int firstNumOfApple; //기존 사과수
	
	
	//기본생성자 public Buyer(){super();} 보이지 않지만 생성, 클래스 앞에 public 붙으면 생성자 앞에도 붙음
	Buyer(){super();}
	
	
	//2. 생성자 : 멤버변수(필드)에 값을 넣어 객체 생성(생성자는 객체 안에 존재하지 않음, 객체에는 멤버변수 메서드 뿐)
	

	public Buyer(int money) {
		super();
		this.money = money;
		firstMoney = money;
		//numOfApple : 기본값 0으로 채워짐
	}

	
	                           //매개변수
	public Buyer(int money2, int numOfApple) {
		super();
		//this.money = money; // 매개값을 멤버변수에 넣음
		money = money2;
		firstMoney = money2;  // this 생략 가능(이유: 같은 클래스 안에 있으므로, 멤버변수와 매개변수 이름이 달라서 구분되므로)
		
		firstNumOfApple = numOfApple;
		this.numOfApple = numOfApple;
		//this. : 자기자신의 주소로 해당 객체 안에 존재 (붙인 이유: 멤버변수와 매개변수를 구분하기 위해. static이 없는 멤버변수에 this로 접근)
	}
	
	


	//3. 기능 : 메서드 - ★구매자가 구체
	//판매자에게 사과가격 묻기
	void askApplePrice(Seller s){
		System.out.println("[" +s.NAME+ "]"+"사과 한개 가격이 얼마인가요?");
		s.answer(); //방법1
		//System.out.println(getAPPLE_PRICE()+"원입니다."); //방법2
	
	}
	
	//판매자의 사과수 묻기
	void askNumOfApple(Seller s){
		System.out.println("[" +s.NAME+ "]"+"사과 몇 개가 남았어요?");
		s.getNumOfApple();
	}
		
	
	
	//해당 판매자에게 돈을 주고 사과를 산다.
	void buy(Seller s, int money) { //판매자1, 돈 5000)
		numOfApple += s.sale(money); //증가:구매자의 사과바구니에, 판매자에게 돈을 주고 받은 사과를 추가
		money = firstMoney - money;  //감소:구매자의 기존 돈-판매자에게 사과를 구매한만큼의 돈 = 현재잔액
	}
	
	
	//구매자의 현황
	void showBuy() {
		System.out.println("구매한 사과 수:" +(numOfApple-firstNumOfApple)); //변수만들기
		System.out.println("구매자 원금:" + firstMoney);
		System.out.println("구매자가 사과를 구매한 돈:" + (firstMoney-money)); // 원금-현재잔액
		System.out.println("현재 잔액:" + money); //현재잔액 = 원금-구매한 돈
	}


		
	
	//get~()와 set~() 메서드 : 멤버변수에 접근
	int getMoney() { //money값을 얻을 때
		return money;
	}


	void setMoney(int money) { //money값을 변경할 때
		this.money = money;
	}


	int getNumOfApple() {
		return numOfApple;
	}


	void setNumOfApple(int numOfApple) {
		this.numOfApple = numOfApple;
	}
	
	
}
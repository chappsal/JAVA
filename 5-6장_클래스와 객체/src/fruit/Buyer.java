package fruit;
//구매자
public class Buyer {
	//1.속성 : 멤버변수 = 필드 (field) (기본값->명시적값->생성자)
	int money; 		//돈 
	//final int money; // final은 기본값x  
	int numOfApple; //사과바구니
	
	
	//기본생성자 public Buyer(){super();} 보이지 않지만 생성, 클래스 앞에 public 붙으면 생성자 앞에도 붙음
	Buyer(){super();}
	
	
	//2. 생성자 : 멤버변수(필드)에 값을 넣어 객체 생성(생성자는 객체 안에 존재하지 않음, 객체에는 멤버변수 메서드 뿐)
	

	public Buyer(int money) {
		super();
		this.money = money;
		//numOfApple : 기본값 0으로 채워짐
	}

	
	                           //매개변수
	public Buyer(int money2, int numOfApple) {
		super();
		//this.money = money; // 매개값을 멤버변수에 넣음
		money = money2;  // this 생략 가능(이유: 같은 클래스 안에 있으므로, 멤버변수와 매개변수 이름이 달라서 구분되므로)
		this.numOfApple = numOfApple;
		//this. : 자기자신의 주소로 해당 객체 안에 존재 (붙인 이유: 멤버변수와 매개변수를 구분하기 위해. static이 없는 멤버변수에 this로 접근)
	}
	
	


	//3. 기능 : 메서드 - ★구매자가 구체
	void buy(Seller s, int money) { //판매자1, 돈 5000)
		numOfApple += s.sale(money); //증가:구매자의 사과바구니에, 판매자에게 돈을 주고 받은 사과를 추가
		this.money -= money; 		 //감소:구매자의 기존 돈-판매자에게 사과를 구매한만큼의 돈
	}
	
	
	void showBuy() {
		System.out.println("가진 사과 수:" + numOfApple);
		System.out.println("현재 잔액:" + money);
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
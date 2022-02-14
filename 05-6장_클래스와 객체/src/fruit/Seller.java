package fruit;

public class Seller {
	//1.멤버변수
	int money; 		//돈
	int numOfApple; //사과 수
	static final int APPLE_PRICE= 1000; // 사과가격
	int apple_price;
	//기본생성자 public Seller(){super();} 멤버변수에 값을 넣어서 생성하는 역할
	
	//2.생성자 (우클릭-소스-필드를 사용하여 생성자 생성                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	public Seller(int numOfApple, int money, int applePrice) {
		this.money = money;
		this.numOfApple = numOfApple;
		this.apple_price = apple_price;
	}
	
	
	
	//3.기능:메서드
	public int sale(int money) { // 돈을 받아 사과를 돌려준다
		int numOfSale = money/APPLE_PRICE; //5000/1000=5(몫)
		numOfApple -= numOfSale; // 판매자의 사과 수-판매한 사과 수
		this.money += money; //판매한 돈 만큼 판매자의 돈 증가
		return numOfSale; // 구매자에게 사과 수를 리턴
	}

	
	
	void showSale() {
		System.out.println("판매 후 사과 수:" + numOfApple);
		System.out.println("판매자가 가진 전체 돈:" + money);
	}
	
	
	
	
	
}

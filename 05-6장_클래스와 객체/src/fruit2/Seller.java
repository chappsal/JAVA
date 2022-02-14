package fruit2;

public class Seller { /**
	 * @param numOfApple
	 * @param aPPLE_PRICE
	 */
	

// Math 클래스의 static fianl double PI = 3.14;
	//1.속성:멤버변수
	static String NAME; 	//간판이름 / final 붙이면 기본 값이 없음 , 값을 넣으려면 = 을 이용해 명시적인 값(동일)을 넣거나 생성자를 통해 최초의 한번은 반드시 초기화 시켜야 함
						//값이 없기 때문에 static 못 붙임. static은 값이 있는 상태로 메모리에 올라가야함

	private int numOfSale = 0; 	//판매한 사과 수
	private int firstMoney; 	//원금
	private int money;			//원금 + 수익
	//private int numOfApple; 	//사과 수 , private : 정보 보안
	//static final int APPLE_PRICE= 1000; // 사과가격
	int numOfApple; 
	final int APPLE_PRICE; 		//사과 가격
	//기본생성자 public Seller(){super();} 멤버변수에 값을 넣어서 생성하는 역할
	
	
	//2.생성자 (우클릭-소스-필드를 사용하여 생성자 생성                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	public Seller(String nAME, int money, int numOfApple, int aPPLE_PRICE) {
		super(); //자동으로 들어감 //Object() 생성자 호출
		
		NAME = nAME;
		
		this.money = money; 
		firstMoney = money;
		
		this.numOfApple = numOfApple;
		APPLE_PRICE = aPPLE_PRICE;
	}
	//static 붙으면 클래스이름으로 접근, 없으면 주소로 접근

	
	//3.기능:메서드
	public int sale(int money) { // 돈을 받아 사과를 돌려준다
		int numOfSale = money/APPLE_PRICE; //5000/1000=5(몫)
		numOfApple -= numOfSale; // 판매자의 사과 수-판매한 사과 수
		this.money += money; //판매한 돈 만큼 판매자의 돈 증가
		this.numOfSale += numOfSale; //판매한 사과 수 누적
		return numOfSale; // 구매자에게 사과 수를 리턴
	}

	
	
	void showSale() {
		System.out.println("판매 후 사과 수:" + numOfApple);
		System.out.println("판매자가 가진 원금:" + firstMoney);
		System.out.println("판매자의 수익[방법1]:" + (money-firstMoney));
		System.out.println("판매자의 수익[방법2]:" + (numOfSale*APPLE_PRICE));
		System.out.println("판매자가 가진 전체 돈:" + money);
	}
	
	
	void answer() {
		System.out.println(APPLE_PRICE+"원 입니다");
	}
	
	void getNumOfApple() {
		System.out.println(numOfApple+"개 남았습니다.");
	}
	
	//protected : 같은 패키지에서는 접근 가능, 다른 패키지에서는 자식만 접근 가능
	//사과수를 다른 값으로 변경 허용하는 이 메서드도 없는 것이 낫다(사과수 100개 -> 0개로 변경하면 x)
	protected void setNumOfApple(int numOfApple) {
		this.numOfApple = numOfApple;
	}
	
	int getAPPLE_PRICE() {
		return APPLE_PRICE;
	}
	
	
}

